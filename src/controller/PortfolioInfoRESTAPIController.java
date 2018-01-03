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
import entity.PortfolioCourseUnit;
import entity.PortfolioCourseUnitLevel;
import entity.QuestionAttribute;
import entity.ServicePortfolioCourse;
import entity.ServicePortfolioCourseWrapper;
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
	public ServicePortfolioCourseWrapper showListCourseRest(Model model,
			@RequestBody ServicePortfolioCourseWrapper spcWrap) throws IOException {
		ArrayList<ServicePortfolioCourse> spCourses = new ArrayList<>();

		for (ServicePortfolioCourse one_spc : spcWrap.getSpcourses()) {

			// load info to spc
			one_spc = spcDao.selectServicePortfolioCourseById(one_spc.getId());

			// get course_name
			Course one_course = courseDao.selectCourseById(one_spc.getCourse_id());
			one_spc.setCourse_name(one_course.getCourse_name());
			// get level_list
			List<PortfolioCourseUnitLevel> portfolioCourseUnitLevel = pculDao
					.selectPortfolioCourseUnitLevelBySPCourseId(one_spc.getId());

			one_spc.setLevel_list(portfolioCourseUnitLevel);

			// get question atribute
			for (PortfolioCourseUnitLevel pcul : portfolioCourseUnitLevel) {
				List<PortfolioCourseUnit> portfolioCourseUnits = pcuDao.selectPortfolioCourseUnitByPCULId(pcul.getId());

				pcul.setQuestion_attribute_list(portfolioCourseUnits);

				for (PortfolioCourseUnit pcu : portfolioCourseUnits) {
					QuestionAttribute qa = qaDao.selectQuestionAttributeById(pcu.getQuestion_attribute_id());
					pcu.setQuestion_attribute_name(qa.getQuestion_attribute_name());
				}

			}
			spCourses.add(one_spc);
		}
		spcWrap.getSpcourses().clear();
		spcWrap.setSpcourses(spCourses);
		return spcWrap;
	}

}
