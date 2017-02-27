package com.omazing.introduce.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.introduce.dto.ExperienceReportDTO;

/**
 * 극복과정 DAO
 * @author nam
 */
@Repository
public class ExperienceReportDAO {
	/**
	 * 극복과정을 저장할 맵
	 */
	private Map<Integer, ExperienceReportDTO> experienceReportList;
	/**
	 * SQL세션 객체
	 */
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 기본생성자
	 */
	public ExperienceReportDAO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param experienceReportList 극복과정이 저장된 맵
	 */
	public ExperienceReportDAO(Map<Integer, ExperienceReportDTO> experienceReportList) {
		super();
		this.experienceReportList = experienceReportList;
	}
	/**
	 * 극복과정 맵을 가져오는 메소드
	 * @return experienceReportList
	 */
	public Map<Integer, ExperienceReportDTO> getExperienceReportList() {
		return experienceReportList;
	}
	/**
	 * 극복과정 맵을 설정하는 메소드
	 * @param experienceReportList
	 */
	public void setExperienceReportList(Map<Integer, ExperienceReportDTO> experienceReportList) {
		this.experienceReportList = experienceReportList;
	}
	
	/**
	 * 극복과정을 등록하는 메소드
	 * @param experienceReportDTO 극복과정 DTO
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean insertExperienceReport(ExperienceReportDTO experienceReportDTO) throws SQLException{
		if(experienceReportDTO==null){
			System.out.println("experience report 등록 실패!");
			return false;
		}
		
		int res = sqlSession.insert("ExperienceReportMapper.insertExperienceReport",experienceReportDTO);
		int seq = sqlSession.selectOne("ExperienceReportMapper.selectExperienceReportSeq");
		System.out.println("시퀀스번호: " + seq);
		experienceReportDTO.setRegisterNo(seq);
		
		if(res>0){
			System.out.println("experience report 등록 성공!");
			return true;
		}
		System.out.println("experience report 등록 실패!");
		return false;
	}
	/**
	 * 극복과정을 수정하는 메소드
	 * @param experienceReportDTO 극복과정 DTO
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updateExperienceReport(ExperienceReportDTO experienceReportDTO) throws SQLException{
		if(experienceReportDTO==null){
			System.out.println("극복과정 수정 실패!");
			return false;
		}
		
		int res = sqlSession.update("ExperienceReportMapper.updateExperienceReport",experienceReportDTO);
		
		if(res>0){
			System.out.println("극복과정 수정 성공!");
			return true;
		}
		System.out.println("극복과정 수정 실패!");
		return false;
	}
	/**
	 * 극복과정을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @param title 문제및난관
	 * @param content 극복과정
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updateExperienceReport(String memberID,int registerNo,String title,String content) throws SQLException{
		if(memberID.equals("") || registerNo <= 0 || title.equals("") || content.equals("")){
			System.out.println("극복과정 수정 실패!");
			return false;
		}
		int res = sqlSession.update("ExperienceReportMapper.updateExperienceReport",
				new ExperienceReportDTO(memberID, registerNo, title, content));
		
		if(res>0){
			System.out.println("극복과정 수정 성공!");
			return true;
		}
		System.out.println("극복과정 수정 실패!");
		return false;
	}
	/**
	 * 극복과정 중 문제및난관(제목)을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @param title 문제및난관
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updateExperienceReportTitle(String memberID,int registerNo,String title) throws SQLException{
		if(memberID.equals("") || registerNo <= 0 || title.equals("")){
			System.out.println("문제및난관 수정 실패!");
			return false;
		}
		int res = sqlSession.update("ExperienceReportMapper.updateExperienceReportTitle",
				new ExperienceReportDTO(memberID, registerNo, title, null));
		
		if(res>0){
			System.out.println("문제및난관 수정 성공!");
			return true;
		}
		System.out.println("문제및난관 수정 실패!");
		return false;
	}
	/**
	 * 극복과정 중 극복과정(내용)을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @param content 극복과정
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updateExperienceReportContent(String memberID,int registerNo,String content) throws SQLException{
		if(memberID.equals("") || registerNo <= 0 || content.equals("")){
			System.out.println("극복과정 내용 수정 실패!");
			return false;
		}
		int res = sqlSession.update("ExperienceReportMapper.updateExperienceReportTitle",
				new ExperienceReportDTO(memberID, registerNo, null, content));
		
		if(res>0){
			System.out.println("문제및난관 수정 성공!");
			return true;
		}
		System.out.println("문제및난관 수정 실패!");
		return false;
	}
	/**
	 * 극복과정을 삭제하는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @return boolean
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deleteExperienceReport(String memberID,int registerNo) throws SQLException{
		if(memberID.equals("")||registerNo<=0){
			System.out.println("극복과정 삭제 실패!");
			return false;
		}
		int res = sqlSession.delete("ExperienceReportMapper.deleteExperienceReport",
				new ExperienceReportDTO(memberID, registerNo, null, null));
		
		if(res>0){
			System.out.println("극복과정 삭제 성공!");
			return true;
		}
		System.out.println("극복과정 삭제 실패!");
		return false;
	}
	/**
	 * 등록된 모든 극복과정을 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return 삭제한 극복과정 갯수
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public int deleteExperienceReportAll(String memberID) throws SQLException{
		if(memberID.equals("")){
			System.out.println("극복과정 삭제 실패!");
			return 0;
		}
		int res = sqlSession.delete("ExperienceReportMapper.deleteExperienceReportAll",memberID);
		
		if(res>0){
			System.out.println("극복과정 "+res+"개 삭제 성공!");
		}
		else{
			System.out.println("극복과정 삭제 실패!");
		}
		
		return res;
	}
	/**
	 * 저장된 극복과정을 불러오는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @return ExperienceReportDTO
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public ExperienceReportDTO selectExperienceReport(String memberID,int registerNo) throws SQLException{
		ExperienceReportDTO dto = sqlSession.selectOne("ExperienceReportMapper.selectExperienceReport",
				new ExperienceReportDTO(memberID, registerNo, null, null));
		System.out.println(dto);
		return dto;
	}
	/**
	 * 저장된 모든 극복과정을 iterator로 불러오는 메소드
	 * @param memberID 회원ID
	 * @return Iterator<ExperienceReportDTO>
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Iterator<ExperienceReportDTO> selectExperienceReportAll(String memberID) throws SQLException{
		List<ExperienceReportDTO> list = 
				sqlSession.selectList("ExperienceReportMapper.selectExperienceReportAll",memberID);
		System.out.println("극복과정 selectall"+list);
		if(list.size()!=0){
			return list.iterator();
		}
		return null;
	}
	/**
	 * 저장된 모든 극복과정을 Map으로 불러오는 메소드
	 * @param memberID 회원ID
	 * @return Map<Integer,ExperienceReportDTO>
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Map<Integer,ExperienceReportDTO> selectExperienceReportAlltoMap(String memberID) throws SQLException{
		List<ExperienceReportDTO> list = 
				sqlSession.selectList("ExperienceReportMapper.selectExperienceReportAll",memberID);
		
		this.experienceReportList = new HashMap<>();
		for(ExperienceReportDTO dto : list){
			this.experienceReportList.put(dto.getRegisterNo(), dto);
		}
		
		return this.experienceReportList;
	}
	/**
	 * 저장된 극복과정 맵을 ArrayList로 반환하는 메소드 
	 * @return ArrayList<ExperienceReportDTO>
	 */
	public ArrayList<ExperienceReportDTO> getExperienceReportListToArray(){
		return new ArrayList<ExperienceReportDTO>(this.experienceReportList.values());
	}
	/**
	 * toString메소드 재정의
	 */
	public String toString() {
		return "ExperienceReportDAO [experienceReportList=" + experienceReportList + "]";
	}
}
