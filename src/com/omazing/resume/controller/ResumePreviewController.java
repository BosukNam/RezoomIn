package com.omazing.resume.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.omazing.resume.bean.ActivityBean;
import com.omazing.resume.bean.ActivityCategoryBean;
import com.omazing.resume.bean.AwardBean;
import com.omazing.resume.bean.AwardCategoryBean;
import com.omazing.resume.bean.AwardFieldBean;
import com.omazing.resume.bean.CareerBean;
import com.omazing.resume.bean.CertificateBean;
import com.omazing.resume.bean.LanguageExamBean;
import com.omazing.resume.bean.MilitaryBean;
import com.omazing.resume.bean.MilitaryCategoryBean;
import com.omazing.resume.bean.MilitaryRankCategoryBean;
import com.omazing.resume.bean.PersonalInfoBean;
import com.omazing.resume.bean.SchoolBean;
import com.omazing.resume.bean.SchoolCategoryBean;
import com.omazing.resume.bean.SchoolDegreeCategoryBean;
import com.omazing.resume.bean.SchoolStateCategoryBean;
import com.omazing.resume.bean.SchoolTotalGradeCategoryBean;
import com.omazing.resume.bean.SchoolTrackCategoryBean;
import com.omazing.resume.bean.UnusualBean;
import com.omazing.resume.bean.UnusualCategoryBean;
import com.omazing.resume.dao.ActivityCategoryDAO;
import com.omazing.resume.dao.ActivityDAO;
import com.omazing.resume.dao.AwardCategoryDAO;
import com.omazing.resume.dao.AwardDAO;
import com.omazing.resume.dao.AwardFieldDAO;
import com.omazing.resume.dao.CareerDAO;
import com.omazing.resume.dao.CertificateDAO;
import com.omazing.resume.dao.LanguageExamDAO;
import com.omazing.resume.dao.MilitaryCategoryDAO;
import com.omazing.resume.dao.MilitaryDAO;
import com.omazing.resume.dao.MilitaryRankCategoryDAO;
import com.omazing.resume.dao.PersonalInfoDAO;
import com.omazing.resume.dao.SchoolCategoryDAO;
import com.omazing.resume.dao.SchoolDAO;
import com.omazing.resume.dao.SchoolDegreeCategoryDAO;
import com.omazing.resume.dao.SchoolStateCategoryDAO;
import com.omazing.resume.dao.SchoolTotalGradeCategoryDAO;
import com.omazing.resume.dao.SchoolTrackCategoryDAO;
import com.omazing.resume.dao.UnusualCategoryDAO;
import com.omazing.resume.dao.UnusualDAO;
import com.omazing.resume.dto.ActivityCategoryDTO;
import com.omazing.resume.dto.ActivityDTO;
import com.omazing.resume.dto.AwardCategoryDTO;
import com.omazing.resume.dto.AwardDTO;
import com.omazing.resume.dto.AwardFieldDTO;
import com.omazing.resume.dto.CareerDTO;
import com.omazing.resume.dto.CertificateDTO;
import com.omazing.resume.dto.LanguageExamDTO;
import com.omazing.resume.dto.MilitaryCategoryDTO;
import com.omazing.resume.dto.MilitaryDTO;
import com.omazing.resume.dto.MilitaryRankCategoryDTO;
import com.omazing.resume.dto.PersonalInfoDTO;
import com.omazing.resume.dto.SchoolCategoryDTO;
import com.omazing.resume.dto.SchoolDTO;
import com.omazing.resume.dto.SchoolDegreeCategoryDTO;
import com.omazing.resume.dto.SchoolStateCategoryDTO;
import com.omazing.resume.dto.SchoolTotalGradeCategoryDTO;
import com.omazing.resume.dto.SchoolTrackCategoryDTO;
import com.omazing.resume.dto.UnusualCategoryDTO;
import com.omazing.resume.dto.UnusualDTO;
import com.omazing.resume.vo.ActivityVO;
import com.omazing.resume.vo.AwardVO;

@Controller
public class ResumePreviewController {
	@Autowired
	private PersonalInfoDAO personalInfoDAO;
	@Autowired
	private MilitaryDAO militaryDAO;
	@Autowired
	private MilitaryCategoryDAO militaryCategoryDAO;
	@Autowired
	private MilitaryRankCategoryDAO militaryRankCategoryDAO;
	@Autowired
	private UnusualDAO unusualDAO;
	@Autowired
	private UnusualCategoryDAO unusualCategoryDAO;
	@Autowired
	private SchoolDAO schoolDAO;
	@Autowired
	private SchoolCategoryDAO schoolCategoryDAO;
	@Autowired
	private SchoolTrackCategoryDAO schoolTrackCategoryDAO;
	@Autowired
	private SchoolDegreeCategoryDAO schoolDegreeCategoryDAO;
	@Autowired
	private SchoolTotalGradeCategoryDAO schoolTotalGradeCategoryDAO;
	@Autowired
	private SchoolStateCategoryDAO schoolStateCategoryDAO;
	
	@Autowired
	private ActivityDAO activityDAO;
	@Autowired
	private AwardDAO awardDAO;
	@Autowired
	private CareerDAO careerDAO;
	@Autowired
	private CertificateDAO certificateDAO;
	@Autowired
	private LanguageExamDAO languageExamDAO;
	@Autowired
	private ActivityCategoryDAO activityCategoryDAO;
	@Autowired
	private AwardCategoryDAO awardCategoryDAO;
	@Autowired
	private AwardFieldDAO awardFieldDAO;
	public ResumePreviewController(){
		System.out.println("ResumePreviewController()");
	}
	
	@RequestMapping(value = "/preview.do")
	public ModelAndView getAll(HttpSession session, @RequestParam(required=false) String preview, ModelAndView mnv){
		System.out.println("getAll() 호출");
		String id = "yeeee4";
		try{
		/**
		 * 개인신상정보
		 */
		PersonalInfoDTO personalInfoDTO = personalInfoDAO.selectPersonalInfoByID(id);
		PersonalInfoBean personalInfoBean = null;
		System.out.println(personalInfoDTO);
		if(personalInfoDTO != null)
		{
			/*
			 * DTO를 Bean으로 바꿔준다 
			 */
			boolean isMale = personalInfoDTO.isGender();
			
			String gender = "여성";
			if(isMale)
				gender = "남성";
	
			personalInfoBean = new PersonalInfoBean(personalInfoDTO.getName(), personalInfoDTO.getBirthDate(), personalInfoDTO.getEmail(), 
					personalInfoDTO.getPhoneNo(), personalInfoDTO.getAddress(), personalInfoDTO.getEnglishName(), gender, personalInfoDTO.getPhoto());
		
		}	
		/**
		 * 병역사항
		 */
		MilitaryDTO militaryDTO = militaryDAO.selectMilitaryByID(id);
		MilitaryBean militaryBean = null;
			
		if(militaryDTO != null)
		{
			boolean isPass = militaryDTO.isPass();
			
			String pass = "미필";
			if(isPass)
			{
				pass = "필";
			
			/*
			 * DTO를 Bean으로 바꿔준다 
			 */
			militaryBean = new MilitaryBean(
					pass, militaryDTO.getStartDate(), militaryDTO.getEndDate(), 
					militaryDTO.getCategory().getCategoryCode(),militaryDTO.getCategory().getCategory(), 
					militaryDTO.getRank().getRankCode(), militaryDTO.getRank().getRank());
			}
			else
			{
				militaryBean = new MilitaryBean(pass);
			}
		}
		/**
		 * 병역사항 카테고리들
		 */
		List<MilitaryCategoryDTO> militaryCategoryList = militaryCategoryDAO.selectAll();
		List<MilitaryCategoryBean> militaryCategoryBeans = new ArrayList<MilitaryCategoryBean>();
		for(MilitaryCategoryDTO i : militaryCategoryList)
			militaryCategoryBeans.add(new MilitaryCategoryBean(i.getCategoryCode(), i.getCategory()));
			
		List<MilitaryRankCategoryDTO> militaryRankCategoryList = militaryRankCategoryDAO.selectAll();
		List<MilitaryRankCategoryBean> militaryRankCategoryBeans = new ArrayList<MilitaryRankCategoryBean>();
				for(MilitaryRankCategoryDTO i : militaryRankCategoryList)
			militaryRankCategoryBeans.add(new MilitaryRankCategoryBean(i.getRankCode(), i.getRank()));
		/**
		 * 보훈장애사항
		 */
		UnusualDTO unusualDTO = unusualDAO.selectUnusualByID(id);
		UnusualBean unusualBean = null;
		
		if(unusualDTO != null)
		{
			boolean isRewarded = unusualDTO.getIsRewarded();
			boolean isDisabled = unusualDTO.getIsDisabled();
			String rewarded = "해당사항 없음";
			String disabled = "해당사항 없음";
			
			if(isRewarded)
				rewarded = "대상";
			if(isDisabled)
			{
				disabled = "대상";
			/*
			 * DTO를 Bean으로 바꿔준다 
			 */
				unusualBean = new UnusualBean(rewarded, disabled, 
						unusualDTO.getDisability().getDisabilityCode(), 
						unusualDTO.getDisability().getDisability());
			}
			else
				unusualBean = new UnusualBean(rewarded, disabled);
		}
		/**
		 * 보훈장애사항 카테고리
		 */
		List<UnusualCategoryDTO> unusualCategoryList = unusualCategoryDAO.selectAll();
		List<UnusualCategoryBean> unusualCategoryBeans = new ArrayList<UnusualCategoryBean>();
		for(UnusualCategoryDTO i : unusualCategoryList)
			unusualCategoryBeans.add(new UnusualCategoryBean(i.getDisabilityCode(), i.getDisability()));
		
		/**
		 * 학력사항
		 */
		List<SchoolDTO> schools = schoolDAO.selectSchoolByID(id);
		List<SchoolDTO> graduatedSchools = schoolDAO.selectGraduatedSchoolByID(id);
		
		for(SchoolDTO i : graduatedSchools)
			schools.add(i);
		
		SchoolBean[] schoolBeans = new SchoolBean[3];
		System.out.println("schools : " + schools);
		System.out.println("isEmpty:" + schools.isEmpty());
		if(!schools.isEmpty())
		{
			for(int i = 0; i < schools.size(); ++i)
			{
				System.out.println("*" + schools.get(i) + "/registerNo: " + schools.get(i).getRegisterNo());
				String[] all = schools.get(i).getAll();
				System.out.println(all[3]);
			/*
			 * DTO를 Bean으로 바꿔준다 
			 */
				if("고등학교".equals(all[3]))
					schoolBeans[0] = new SchoolBean(all[1], all[2], all[3], all[4],
							 all[5], all[6], all[7], all[8], all[9]);
				else if("대학교".equals(all[3]))
					schoolBeans[1] = new SchoolBean(all[1], all[2], all[3], all[4],
							 all[5], all[6], all[7], all[8], all[9], all[10], all[11],
							 all[12], all[3], all[14], all[15], all[16], all[17]);
				else if("대학원".equals(all[3]))
					schoolBeans[2] = new SchoolBean(all[1], all[2], all[3], all[4],
							 all[5], all[6], all[7], all[8], all[9], all[10], all[11],
							 all[12], all[3], all[14], all[15], all[16], all[17]);
			}
		}
		/**
		 * 학력사항 카테고리들
		 */
		List<SchoolCategoryDTO> schoolCategoryList = schoolCategoryDAO.selectAll();
		List<SchoolCategoryBean> schoolCategoryBeans = new ArrayList<SchoolCategoryBean>();
		for(SchoolCategoryDTO i : schoolCategoryList)
			schoolCategoryBeans.add(new SchoolCategoryBean(i.getCategoryCode(), i.getCategory()));
		
		List<SchoolTrackCategoryDTO> schoolTrackCategoryList = schoolTrackCategoryDAO.selectAll();
		List<SchoolTrackCategoryBean> schoolTrackCategoryBeans = new ArrayList<SchoolTrackCategoryBean>();
		for(SchoolTrackCategoryDTO i : schoolTrackCategoryList)
			schoolTrackCategoryBeans.add(new SchoolTrackCategoryBean(i.getTrackCode(), i.getTrack()));
		
		List<SchoolDegreeCategoryDTO> schoolDegreeCategoryList = schoolDegreeCategoryDAO.selectAll();
		List<SchoolDegreeCategoryBean> schoolDegreeCategoryBeans = new ArrayList<SchoolDegreeCategoryBean>();
		for(SchoolDegreeCategoryDTO i : schoolDegreeCategoryList)
			schoolDegreeCategoryBeans.add(new SchoolDegreeCategoryBean(i.getDegreeCode(), i.getDegree()));
		
		List<SchoolTotalGradeCategoryDTO> schoolTotalGradeCategoryList = schoolTotalGradeCategoryDAO.selectAll();
		List<SchoolTotalGradeCategoryBean> schoolTotalGradeCategoryBeans = new ArrayList<SchoolTotalGradeCategoryBean>();
		for(SchoolTotalGradeCategoryDTO i : schoolTotalGradeCategoryList)
			schoolTotalGradeCategoryBeans.add(
					new SchoolTotalGradeCategoryBean(i.getTotalGradeCode(), Double.toString(i.getTotalGrade())));
		
		List<SchoolStateCategoryDTO> schoolStateCategoryList = schoolStateCategoryDAO.selectAll();
		List<SchoolStateCategoryBean> schoolStateCategoryBeans = new ArrayList<SchoolStateCategoryBean>();
		for(SchoolStateCategoryDTO i : schoolStateCategoryList)
			schoolStateCategoryBeans.add(new SchoolStateCategoryBean(i.getStateCode(), i.getState()));
		/**
		 * 해외 연수 & 대외 / 봉사 활동
		 */
		System.out.println("해외연수!!!!!!!!");
		ActivityDTO[] activityDTOs = activityDAO.selectActivityAll(id);
		// 해외 연수인 경우
		List<ActivityVO> activityVOs = new ArrayList<ActivityVO>();
		for(int i = 0 ; i < activityDTOs.length; ++i){
			activityVOs.add(new ActivityVO(activityDTOs[i].getCategory().getCategoryCode(), 
					activityDTOs[i].getCategory().getCategory(), 
					activityDTOs[i].getStartDate(), activityDTOs[i].getEndDate(), 
					activityDTOs[i].getContent(), activityDTOs[i].getRegisterNo(), 
					activityDTOs[i].getMemberID()));
		}
		ArrayList<ActivityBean> foreign = new ArrayList<ActivityBean>();
		// 봉사 / 대외 활동인 경우
		ArrayList<ActivityBean> extern = new ArrayList<ActivityBean>();
		if(activityVOs != null){
			int len = activityVOs.size();
			for(int i = 0 ; i < len ; ++i){
				/*
				 * DTO를 Bean으로 바꿔준다 
				 */
				String[] all= activityVOs.get(i).getAll();
				if("해외 연수".equals(all[1])){
					foreign.add(new ActivityBean(all[1], all[2], all[3], all[4], all[5]));
				}else{
					extern.add(new ActivityBean(all[1], all[2], all[3], all[4], all[5]));
				}
			}
		}
		/**
		 * 수상경력
		 */
		AwardDTO[] awardDTOs = awardDAO.selectAwardAll(id);
		ArrayList<AwardVO> awardVOs = new ArrayList<AwardVO>();
		for(int i = 0 ; i < awardDTOs.length; ++i){
			awardVOs.add(new AwardVO(awardDTOs[i].getCategory().getCategoryCode(),
					awardDTOs[i].getCategory().getCategory(), awardDTOs[i].getField().getFieldCode(), 
					awardDTOs[i].getField().getField(), awardDTOs[i].getTarget(), 
					awardDTOs[i].getName(), awardDTOs[i].getDate(), awardDTOs[i].getPublication(),
					awardDTOs[i].getContent(), awardDTOs[i].getRegisterNo(), awardDTOs[i].getMemberID()));
		}
		AwardBean[] awardBeans = null;
		if(awardVOs.size() != 0)
		{
			int len = awardVOs.size();
			awardBeans = new AwardBean[len];
				
			for(int i = 0; i < len; ++i)
			{
				String[] all=  awardVOs.get(i).getAll();
			/**
			 * VO를 Bean으로 바꿔준다 
			 */
				awardBeans[i] = new AwardBean(all[1], all[3], all[4], 
						all[5], all[6], all[7], all[8], all[9]);
			}
		}
		/**
		 * 경력사항
		 */
		CareerDTO[] careerDTOs = careerDAO.selectCareerAll(id);
		int len = 0;
		CareerBean[] careerBeans = null;
		if (careerDTOs != null) {
			len = careerDTOs.length;
			careerBeans = new CareerBean[len];

			for (int i = 0; i < len; ++i) {
				String[] all = careerDTOs[i].getAll();
				/*
				 * DTO를 Bean으로 바꿔준다
				 */
				careerBeans[i] = new CareerBean(all[0], all[1], all[2], all[3],
						all[4], all[5], all[6], all[7]);
				System.out.println(careerBeans[i]);
			}
		}
		/**
		 * 자격증
		 */
		CertificateDTO[] CertificateDTOs = certificateDAO
				.selectCertificateAll(id);
		CertificateBean[] certificateBeans = null;
		if (CertificateDTOs != null) {
			len = CertificateDTOs.length;
			certificateBeans = new CertificateBean[len];

			for (int i = 0; i < len; ++i) {
				String[] all = CertificateDTOs[i].getAll();
				/**
				 * DTO를 Bean으로 바꿔준다
				 */
				certificateBeans[i] = new CertificateBean(all[0], all[1],
						all[2], all[3]);
			}
		}
		/**
		 * 어학시험
		 */
		LanguageExamDTO[] languageExamDTOs = languageExamDAO
				.selectLanguageExamAll(id);
		LanguageExamBean[] languageExamBeans = null;
		if (languageExamDTOs != null) {
			len = languageExamDTOs.length;
			languageExamBeans = new LanguageExamBean[len];

			for (int i = 0; i < len; ++i) {
				String[] all = languageExamDTOs[i].getAll();
				/*
				 * DTO를 Bean으로 바꿔준다
				 */
				languageExamBeans[i] = new LanguageExamBean(all[0], all[1],
						all[2], all[3]);
			}
		}
		/**
		 * 대외활동 목록
		 */
		System.out.println("대외활동 목록!!!!!!!!");
		// 원래는 VO로 가져오지만 여기서는 임시로 DTO로 Test
		ActivityCategoryDTO[] activityCategoryDTOs = activityCategoryDAO
				.selectActivityCategoryAll();
		Map<String, ActivityCategoryBean> activityCategoryBeans = new HashMap<String, ActivityCategoryBean>();
		ActivityCategoryBean foreignStudyBean = null;
		ActivityCategoryDTO tmpDTO = null;
		ActivityCategoryBean tmpBeans = null;
		if (activityCategoryDTOs != null) {
			/*
			 * DTO를 Bean으로 바꿔준다
			 */
			len = activityCategoryDTOs.length;
			for(int i =0; i < len ; ++i){
				String[] all = activityCategoryDTOs[i].getAll();
				if ("해외 연수".equals(all[1])) {
					foreignStudyBean = new ActivityCategoryBean(all[0], all[1]);
				} else {
					// 해외 연수 제외한 나머지만 담는다.
					tmpBeans = new ActivityCategoryBean(all[0], all[1]);
					activityCategoryBeans.put(tmpBeans.getCategoryCode(),
							tmpBeans);
				}
			}
		}
		
		/**
		 * 수상분류 목록
		 */
		System.out.println("수상분류 목록!!!!!!!!");
		// 원래는 VO로 가져오지만 여기서는 임시로 DTO로 Test
		AwardCategoryDTO[] awardCategoryDTOs =
				awardCategoryDAO.selectAwardCategoryAll();
		Map<String, AwardCategoryBean> awardCategoryBeans = 
				new HashMap<String, AwardCategoryBean>();
		AwardCategoryDTO tmpACDTO = null;
		AwardCategoryBean tmpACBean = null;
		if (awardCategoryDTOs != null) {
			len = awardCategoryDTOs.length;
			for (int i = 0; i < len; ++i) {
				String[] all = awardCategoryDTOs[i].getAll();
				/*
				 * DTO를 Bean으로 바꿔준다
				 */
				tmpACBean = new AwardCategoryBean(all[0], all[1]);
				awardCategoryBeans.put(all[0], tmpACBean);
			}
		}
		/**
		 * 수상분야 목록
		 */
		System.out.println("수상분야 목록!!!!!!!!");
		// 원래는 VO로 가져오지만 여기서는 임시로 DTO로 Test
		AwardFieldDTO[] awardFieldDTOs =
				awardFieldDAO.selectAwardFieldAll();
		Map<String, AwardFieldBean> awardFieldBeans = 
				new HashMap<String, AwardFieldBean>();
		AwardFieldDTO tmpAFDTO = null;
		AwardFieldBean tmpAFBean = null;
		if (awardFieldDTOs != null) {
			len = awardFieldDTOs.length;
			for (int i = 0; i < len; ++i) {
				String[] all = awardFieldDTOs[i].getAll();
				/*
				 * DTO를 Bean으로 바꿔준다
				 */
				tmpAFBean = new AwardFieldBean(all[0], all[1], all[2]);
				awardFieldBeans.put(all[0], tmpAFBean);
			}
		}
			mnv.addObject("personalInfo", personalInfoBean);
			mnv.addObject("military", militaryBean);
			mnv.addObject("militaryCategory", militaryCategoryBeans);
			mnv.addObject("militaryRankCategory", militaryRankCategoryBeans);
			mnv.addObject("unusual", unusualBean);
			mnv.addObject("unusualCategory", unusualCategoryBeans);
			mnv.addObject("school", schoolBeans);

			
			mnv.addObject("schoolCategory", schoolCategoryBeans);
			mnv.addObject("schoolTrackCategory", schoolTrackCategoryBeans);
			mnv.addObject("schoolDegreeCategory", schoolDegreeCategoryBeans);
			mnv.addObject("schoolTotalGradeCategory", schoolTotalGradeCategoryBeans);
			mnv.addObject("schoolStateCategory", schoolStateCategoryBeans);

			mnv.addObject("foreignAct", foreign);
			mnv.addObject("externAct", extern);
			mnv.addObject("award", awardBeans);
			mnv.addObject("careerSelect", careerBeans);
			mnv.addObject("certificateSelect", certificateBeans);
			mnv.addObject("exam", languageExamBeans);
			
			mnv.addObject("activityCategory",activityCategoryBeans);
			mnv.addObject("foreignCategory", foreignStudyBean);
			mnv.addObject("awardCategory", awardCategoryBeans);
			mnv.addObject("awardField", awardFieldBeans);
			
			if("preview".equals(preview))
				mnv.setViewName("/resources/views/resume_preview.jsp");
			else
				mnv.setViewName("/resources/views/ResumeIndex.jsp");

		}catch(Exception e){
			e.printStackTrace();
		}
		return mnv;
	}		
}
