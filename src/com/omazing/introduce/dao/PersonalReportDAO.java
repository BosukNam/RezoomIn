package com.omazing.introduce.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.introduce.dto.PersonalReportDTO;

/**
 * 장점,준비과정,비전및목표 DAO
 * @author nam
 */
@Repository
public class PersonalReportDAO {
	/**
	 * 장점,준비과정,비전및목표 DTO
	 */
	private PersonalReportDTO personalReport;
	/**
	 * SQL세션객체
	 */
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 기본생성자
	 */
	public PersonalReportDAO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param personalReport 장점,준비과정,비전및목표 DTO
	 */
	public PersonalReportDAO(PersonalReportDTO personalReport) {
		super();
		this.personalReport = personalReport;
	}
	/**
	 * 장점,준비과정,비전및목표 DTO를 가져오는 메소드
	 * @return PersonalReportDTO
	 */
	public PersonalReportDTO getPersonalReport() {
		return personalReport;
	}
	/**
	 * 장점,준비과정,비전및목표 DTO를 설정하는 메소드
	 * @param personalReport 장점,준비과정,비전및목표 DTO
	 */
	public void setPersonalReport(PersonalReportDTO personalReport) {
		this.personalReport = personalReport;
	}
	
	/**
	 * 장점,준비과정,비전및목표를 등록하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean insertPersonalReport(String memberID) throws SQLException{
		if(memberID.equals("")){
			System.out.println("personal report 등록 실패!");
			return false;
		}
		
		int res = sqlSession.insert("PersonalReportMapper.insertPersonalReportOnlyID",memberID);
		if(res>0){
			System.out.println("personal report 등록 성공!");
			return true;
		}
		System.out.println("personal report 등록 실패!");
		return false;
	}
	/**
	 * 장점,준비과정,비전및목표를 등록하는 메소드
	 * @param personalReportDTO 장점,준비과정,비전및목표 DTO
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean insertPersonalReport(PersonalReportDTO personalReportDTO) throws SQLException{
		if(personalReportDTO==null){
			System.out.println("personal report 등록 실패!");
			return false;
		}
		
		int res = sqlSession.insert("PersonalReportMapper.insertPersonalReport",personalReportDTO);
		if(res>0){
			System.out.println("personal report 등록 성공!");
			return true;
		}
		System.out.println("personal report 등록 실패!");
		return false;
	}
	/**
	 * 장점을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param strength 장점
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updateStrengthReport(String memberID,String strength) throws SQLException{
		if(memberID.equals("")){
			System.out.println("장점 수정 실패!");
			return false;
		}
		
		int res = sqlSession.update("PersonalReportMapper.updateStrengthReport",
				new PersonalReportDTO(memberID, strength, null, null));
		if(res>0){
			System.out.println("장점 수정 성공!");
			return true;
		}
		System.out.println("장점 수정 실패!");
		return false;
	}
	/**
	 * 준비과정을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param readyCondition 준비과정
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updateReadyCondition(String memberID, String readyCondition) throws SQLException{
		if(memberID.equals("")){
			System.out.println("준비과정 수정 실패!");
			return false;
		}
		int res = sqlSession.update("PersonalReportMapper.updateReadyCondition",
				new PersonalReportDTO(memberID, null, readyCondition, null));
		if(res>0){
			System.out.println("준비과정 수정 성공!");
			return true;
		}
		System.out.println("준비과정 수정 실패!");
		return false;
	}
	/**
	 * 비전및목표을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param goalReport 비전및목표
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updateGoalReport(String memberID,String goalReport) throws SQLException{
		if(memberID.equals("")){
			System.out.println("비전및목표 수정 실패!");
			return false;
		}
		int res = sqlSession.update("PersonalReportMapper.updateGoalReport",
				new PersonalReportDTO(memberID, null, null, goalReport));
		if(res>0){
			System.out.println("비전및목표 수정 성공!");
			return true;
		}
		System.out.println("비전및목표 수정 실패!");
		return false;
	}
	/**
	 * 장점,준비과정,비전및목표를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalReport(String memberID) throws SQLException{
		if(memberID.equals("")){
			System.out.println("personal report 삭제 실패!");
			return false;
		}
		
		int res = sqlSession.delete("PersonalReportMapper.deletePersonalReport",memberID);
		if(res>0){
			System.out.println("personal report 삭제 성공!");
			return true;
		}
		System.out.println("personal report 삭제 실패!");
		return false;
	}
	/**
	 * 장점을 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deleteStrengthReport(String memberID) throws SQLException{
		if(memberID.equals("")){
			System.out.println("장점 삭제 실패!");
			return false;
		}
		
		PersonalReportDTO dto = this.selectPersonalReport(memberID);
		boolean res;
		if((dto.getReadyCondition()==null||dto.getReadyCondition().equals(""))
				&&(dto.getGoal()==null||dto.getGoal().equals(""))){
			res = this.deletePersonalReport(memberID);
		}
		else{
			res = this.updateStrengthReport(memberID, "");
		}
		return res;
	}
	/**
	 * 준비과정을 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deleteReadyCondition(String memberID) throws SQLException{
		if(memberID.equals("")){
			System.out.println("준비과정 삭제 실패!");
			return false;
		}
		
		
		PersonalReportDTO dto = this.selectPersonalReport(memberID);
		boolean res;
		if((dto.getStrength()==null||dto.getStrength().equals(""))
				&&(dto.getGoal()==null||dto.getGoal().equals(""))){
			res = this.deletePersonalReport(memberID);
		}
		else{
			res = this.updateReadyCondition(memberID, "");
		}
		return res;
	}
	/**
	 * 비전및목표를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deleteGoalReport(String memberID) throws SQLException{
		if(memberID.equals("")){
			System.out.println("비전및목표 삭제 실패!");
			return false;
		}
		
		PersonalReportDTO dto = this.selectPersonalReport(memberID);
		boolean res;
		if((dto.getStrength()==null||dto.getStrength().equals(""))
				&&(dto.getReadyCondition()==null||dto.getReadyCondition().equals(""))){
			res = this.deletePersonalReport(memberID);
		}
		else{
			res = this.updateGoalReport(memberID, "");
		}
		return res;
	}
	/**
	 * 저장된 장점,준비과정,비전및목표를 불러오는 메소드
	 * @param memberID 회원ID
	 * @return PersonalReportDTO
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public PersonalReportDTO selectPersonalReport(String memberID) throws SQLException{
		this.personalReport = sqlSession.selectOne("PersonalReportMapper.selectPersonalReport",memberID);
		return personalReport;
	}
	
	/**
	 * toString메소드 재정의
	 */
	public String toString() {
		return "PersonalReportDAO [PersonalReport=" + personalReport + "]";
	}
}
