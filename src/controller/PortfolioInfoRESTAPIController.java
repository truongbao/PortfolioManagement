package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Course;
import entity.CourseWrapper;
import entity.PortfolioCourseUnit;
import entity.PortfolioCourseUnitLevel;
import entity.QuestionAttribute;
import entity.ServicePortfolioCourse;
import mappings.CourseMapperDao;
import mappings.PortfolioCourseUnitLevelMapperDao;
import mappings.PortfolioCourseUnitMapperDao;
import mappings.QuestionAttributeMapperDao;
import mappings.ServicePortfolioCourseMapperDao;;

@RestController
public class PortfolioInfoRESTAPIController {
	@Autowired
	CourseMapperDao courseDao;
	@Autowired
	PortfolioCourseUnitLevelMapperDao pculDao;
	@Autowired
	PortfolioCourseUnitMapperDao pcuDao;
	@Autowired
	ServicePortfolioCourseMapperDao spcDao;
	@Autowired
	QuestionAttributeMapperDao qaDao;

	@RequestMapping(value = "/showListCouses", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CourseWrapper showListCourseRest(Model model, @RequestBody CourseWrapper courseWrap) throws IOException {

		CourseWrapper courseWrapper = new CourseWrapper();
		ArrayList<Course> listCourse = new ArrayList<>();

		for (Course one_course : courseWrap.getCourses()) {
			one_course=courseDao.selectCourseById(one_course.getId());
			List<ServicePortfolioCourse> servicePortfolioCourse = spcDao
					.selectServicePortfolioCourseByCourseId(one_course.getId());

			for (ServicePortfolioCourse spc : servicePortfolioCourse) {

				List<PortfolioCourseUnitLevel> portfolioCourseUnitLevel = pculDao
						.selectPortfolioCourseUnitLevelBySPCourseId(spc.getCourse_id());

				one_course.setLevel_list(portfolioCourseUnitLevel);

				for (PortfolioCourseUnitLevel pcul : portfolioCourseUnitLevel) {
					List<PortfolioCourseUnit> portfolioCourseUnits = pcuDao
							.selectPortfolioCourseUnitByPCULId(pcul.getId());

					pcul.setQuestion_attribute_list(portfolioCourseUnits);

					for (PortfolioCourseUnit pcu : portfolioCourseUnits) {
						QuestionAttribute qa = qaDao.selectQuestionAttributeById(pcu.getQuestion_attribute_id());
						pcu.setQuestion_attribute_name(qa.getQuestion_attribute_name());
					}

				}
			}
			listCourse.add(one_course);
		}
		courseWrapper.setCourses(listCourse);
		return courseWrapper;
	}

}
