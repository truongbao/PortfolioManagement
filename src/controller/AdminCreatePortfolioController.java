package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.Course;
import entity.Group;
import entity.GroupSecern;
import entity.PortfolioConfigurationCourse;
import entity.PortfolioCourseUnit;
import entity.PortfolioCourseUnitLevel;
import entity.QuestionAttribute;
import entity.ServicePortfolioConfiguration;
import entity.ServicePortfolioConfigurationWrapper;
import entity.ServicePortfolioCourse;
import mappings.CourseMapperDao;
import mappings.GroupMapperDao;
import mappings.GroupSecernMapperDao;
import mappings.PortfolioConfigurationCourseMapperDao;
import mappings.PortfolioCourseUnitLevelMapperDao;
import mappings.PortfolioCourseUnitMapperDao;
import mappings.PortfolioGroupMapperDao;
import mappings.QuestionAttributeMapperDao;
import mappings.ServicePortfolioConfigurationMapperDao;
import mappings.ServicePortfolioCourseMapperDao;
import utility.FileWriterUtils;
import utility.LibraryConstant;
import utility.MessengeUtils;

@Controller
@RequestMapping("admin/portfolio")
public class AdminCreatePortfolioController {

	@Autowired
	private GroupSecernMapperDao gsmDao;
	@Autowired
	private GroupMapperDao groupDao;
	@Autowired
	private CourseMapperDao courseDao;
	@Autowired
	private ServicePortfolioConfigurationMapperDao spcfDao;
	@Autowired
	private PortfolioGroupMapperDao pgDao;
	@Autowired
	private PortfolioConfigurationCourseMapperDao pccDao;
	@Autowired
	private ServicePortfolioCourseMapperDao spcDao;
	@Autowired
	private PortfolioCourseUnitMapperDao pcuDao;
	@Autowired
	private PortfolioCourseUnitLevelMapperDao pculDao;
	@Autowired
	private QuestionAttributeMapperDao qaDao;

	// Show form Create
	/**
	 * load dữ liệu từ database đưa lên view, bao gồm ServicePortfolioCourse,
	 * Groups thuộc về GroupSecerns
	 * 
	 * @param modelMap
	 * @param ra
	 *            sử dụng lưu và gửi thông báo
	 * @return trả về view để hiện thị thông tin
	 * @throws IOException
	 */
	@RequestMapping("/create")
	public String show_form_create(ModelMap modelMap, RedirectAttributes ra) throws IOException {
		try {

			// object bing to view
			ServicePortfolioConfigurationWrapper spcw = new ServicePortfolioConfigurationWrapper();

			// load dữ liệu chọn các group học phần đi kèm các group học phần
			// tương ứng
			List<GroupSecern> listGroupSecern = gsmDao.selectAllGroupSecern();
			int gs_length = listGroupSecern.size();
			for (int gs_index = 0; gs_index < gs_length; gs_index++) {
				GroupSecern groupSecern = listGroupSecern.get(gs_index);
				List<Group> groupList = groupDao.selectGroupByGroupSecernId(groupSecern.getId());
				// add default value to group
				groupList.add(0, new Group(-1, "設定されていない"));
				// load group include groupSecern
				groupSecern.setGroups(groupList);
			}
			// wrap object spcw coverlistGroupSecern
			spcw.setGss(listGroupSecern);

			// load dữ liệu các khóa học thuộc về service 3
			List<ServicePortfolioCourse> servicePortfolioCourses = spcDao
					.selectServicePortfolioCourseByServiceID(LibraryConstant.SERVER_ID);
			int spc_lenght = servicePortfolioCourses.size();
			for (int spc_index = 0; spc_index < spc_lenght; spc_index++) {
				ServicePortfolioCourse one_spc = servicePortfolioCourses.get(spc_index);
				// add course name for spc
				Course course = courseDao.selectCourseById(one_spc.getCourse_id());
				one_spc.setCourse_name(course.getCourse_name());
			}
			// wrap object spcw cover servicePortfolioCourses
			spcw.setSpcs(servicePortfolioCourses);

			// add attribute prepare load into view
			modelMap.addAttribute("spcwoutput", spcw);
		} catch (Exception e) {
			// ghi lại log lỗi
			FileWriterUtils.writeFile("CreatPortfolioController_Show_form_create", e.getMessage());

			// thông báo lỗi
			MessengeUtils utils = new MessengeUtils();
			utils.new_error_message(" サーバーに問題がある ");

			ra.addFlashAttribute("msg", utils);

			return "redirect:/admin/portfolio/index";
		}
		return "admin.portfolio.create";

	}

	/**
	 * Nhận đối tượng lưu trữ dữ liệu được nhập từ người dùng kiểm tra điều kiện
	 * đầu vào gồm tên spc và số lượng mục học đối tượng
	 * 
	 * @param modelMap
	 * @param spcfw
	 *            đối tượng lưu trữ dữ liệu nhập từ người dùng
	 * @param result
	 *            biển điều kiện để kiểm tra lỗi của dữ liệu nhập từ form
	 * @param ra
	 *            gửi thông báo trạng thái nhập của người dùng
	 * @return view của màng hình show portfolio
	 * @throws IOException
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String processing_create(ModelMap modelMap,
			@ModelAttribute("spcw") @Valid ServicePortfolioConfigurationWrapper spcfw, BindingResult result,
			RedirectAttributes ra) throws IOException {

		try {
			// nếu có lỗi xảy ra gửi trả dữ liệu đã được chọn cho client
			if (result.hasErrors()) {
				// load lại dữ liệu người dùng đã chọn của học phần và group học
				// phần tương ứng
				List<GroupSecern> gss = spcfw.getGss();
				int gss_length = gss.size();
				for (int gss_index = 0; gss_index < gss_length; gss_index++) {
					GroupSecern one_gs = gss.get(gss_index);
					int current_select_gr = one_gs.getGroups().get(0).getId();
					// load lại dữ liệu cho one_gs
					one_gs = gsmDao.selectGroupSecernById(one_gs.getId());

					List<Group> groupList = groupDao.selectGroupByGroupSecernId(one_gs.getId());
					groupList.add(0, new Group(-1, "設定されていない"));
					if (current_select_gr != -1) {
						int g_length = groupList.size();
						for (int g_index = 0; g_index < g_length; g_index++) {
							if (groupList.get(g_index).getId() == current_select_gr) {
								// thiết lập mục người dùng đã chọn
								groupList.get(g_index).setIsSelected(1);
								break;
							}
						}
					}
					gss.get(gss_index).setGroups(groupList);
				}

				// select all spc from database
				List<ServicePortfolioCourse> spcs = spcDao
						.selectServicePortfolioCourseByServiceID(LibraryConstant.SERVER_ID);
				// select selected spc
				List<PortfolioConfigurationCourse> pccs = spcfw.getPccs();
				int pccs_lenth = spcs.size();
				for (int spc_index = 0; spc_index < pccs_lenth; spc_index++) {
					ServicePortfolioCourse one_spc = spcs.get(spc_index);
					// add course name for spc
					Course course = courseDao.selectCourseById(one_spc.getCourse_id());
					one_spc.setCourse_name(course.getCourse_name());
					if (pccs != null) {
						int pcc_length = pccs.size();
						// nạp trở lại dữ liệu level và question attritude tương
						// ứng cho màn hình view
						for (int pcc_index = 0; pcc_index < pcc_length; pcc_index++) {
							PortfolioConfigurationCourse one_pcc = pccs.get(pcc_index);
							if (one_spc.getId() == one_pcc.getService_portfolio_course_id()) {
								one_spc.setIsSelected(1);
								one_spc.setLevel_selected(one_pcc.getLevel());
								List<PortfolioCourseUnitLevel> level_list = pculDao
										.selectPortfolioCourseUnitLevelBySPCourseId(one_spc.getId());
								one_spc.setLevel_list(level_list);
								int level_list_length = level_list.size();

								// nạp question tương ứng với từng level
								for (int level_index = 0; level_index < level_list_length; level_index++) {
									PortfolioCourseUnitLevel one_lv = level_list.get(level_index);
									List<PortfolioCourseUnit> portfolioCourseUnits = pcuDao
											.selectPortfolioCourseUnitByPCULId(one_lv.getId());
									one_lv.setQuestion_attribute_list(portfolioCourseUnits);

									int pcu_length = portfolioCourseUnits.size();
									for (int pcu_index = 0; pcu_index < pcu_length; pcu_index++) {
										PortfolioCourseUnit pcu = portfolioCourseUnits.get(pcu_index);
										QuestionAttribute qa = qaDao
												.selectQuestionAttributeById(pcu.getQuestion_attribute_id());
										pcu.setQuestion_attribute_name(qa.getQuestion_attribute_name());
									}
								}
							}
						}
					}
				}
				spcfw.setSpcs(spcs);

				modelMap.addAttribute("spcwoutput", spcfw);
				ra.addFlashAttribute("spcfw", spcfw);
				// return "redirect:/admin/portfolio/create";
				return "admin.portfolio.create";
			} else {

				// spcfDao.computeNextID() // genarate new spcf id
				int spcf_id = spcfDao.computeNextID(); // get current_time
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());

				// insert new ServicePortfolioConfiguration
				ServicePortfolioConfiguration new_spcf = spcfw.getSpcf();
				new_spcf.setId(spcf_id);
				new_spcf.setCreated_at(timestamp);
				new_spcf.setService_id(LibraryConstant.SERVER_ID);
				new_spcf.setState(LibraryConstant.INCOMPLETE);

				// insert new ServicePortfolioConfiguration
				List<GroupSecern> gss = spcfw.getGss();

				List<PortfolioConfigurationCourse> pccs = spcfw.getPccs();
				// thực hiển 1 transaction inser spcf
				int ck = spcfDao.setting_new_spcf(new_spcf, gss, pccs);

				MessengeUtils messengeUtils = new MessengeUtils();
				if (ck > 0) {
					messengeUtils.new_sucess_message(" 登録が成功");
				} else {
					messengeUtils.new_error_message("登録が失敗しました。");
				}
				ra.addFlashAttribute("msg", messengeUtils);
				return "redirect:/admin/portfolio/index";
			}
		} catch (Exception e) {
			FileWriterUtils.writeFile("CreatPortfolioController_Show_form_create", e.getMessage());
			MessengeUtils utils = new MessengeUtils();
			utils.new_error_message(" サーバーに問題がある ");
			ra.addFlashAttribute("msg", utils);
			return "redirect:/admin/portfolio/index";
		}
	}
}
