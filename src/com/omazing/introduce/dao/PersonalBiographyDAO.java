package com.omazing.introduce.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.introduce.dto.PersonalBiographyDTO;
import com.omazing.introduce.dto.PersonalSpecialtyDTO;

/**
 * 성장과정 DAO
 * @author nam
 */
@Repository
public class PersonalBiographyDAO {
	/**
	 * 성장과정 DTO
	 */
	private PersonalBiographyDTO personalBiography;
	/**
	 * 취미특기를 저장할 맵
	 */
	private Map<Integer,PersonalSpecialtyDTO> specialtyList;
	/**
	 * SQL세션객체
	 */
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 기본생성자
	 */
	public PersonalBiographyDAO() {
		super();
	}
	/**
	 * 오버로딩 생성자
	 * @param personalBiograph 성장과정 DTO
	 */
	public PersonalBiographyDAO(PersonalBiographyDTO personalBiography) {
		super();
		this.personalBiography = personalBiography;
	}
	/**
	 * 성장과정 DTO를 가져오는 메소드
	 * @return
	 */
	public PersonalBiographyDTO getPersonalBiography() {
		return personalBiography;
	}
	/**
	 * 성장과정 DTO를 설정하는 메소드
	 * @param personalBiography
	 */
	public void setPersonalBiography(PersonalBiographyDTO personalBiography) {
		this.personalBiography = personalBiography;
	}
	/**
	 * 내용이 비어있는 성장과정을 등록하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean insertPersonalBiography(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("personal biography 등록 실패!");
			return false;
		}
		
			int res = sqlSession.insert("PersonalBiographyMapper.insertPersonalBiograpyOnlyID",memberID);
			if(res>0){
				System.out.println("personal biography 등록 성공!");
				return true;
			}
			System.out.println("personal biography 등록 실패!");
			return false;
			
		
	}
	/**
	 * 성장과정을 등록하는 메소드
	 * @param personalBiographyDTO 성장과정 DTO
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean insertPersonalBiography(PersonalBiographyDTO personalBiographyDTO) throws Exception{
		if(personalBiographyDTO==null){
			System.out.println("personal biography 등록 실패!");
			return false;
		}
		
			int res = sqlSession.insert("PersonalBiographyMapper.insertPersonalBiograpy", personalBiographyDTO);
			
			Set<Integer> keys = specialtyList.keySet();
			for(Integer key : keys){
				PersonalSpecialtyDTO sdto = specialtyList.get(key);
				this.insertPersonalSpecialty(sdto);
			}
			
			if(res>0){
				System.out.println("personal biography 등록 성공!");
				return true;
			}
			System.out.println("personal biography 등록 실패!");
			return false;
			
	}
	/**
	 * 성장과정을 수정하는 메소드
	 * @param personalBiography 성장과정 DTO
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalBiography(PersonalBiographyDTO personalBiography) throws Exception{
		if(personalBiography==null){
			System.out.println("성장과정 수정 실패!");
			return false;
		}
		
		String[] all = personalBiography.getAll();
		String id = all[0];
		String childhood = all[1];
		String student = all[2];
		String univ = all[3];
		String company = all[4];
		String keyword = all[5];
		specialtyList = personalBiography.getSpecialtyMap();
		
			if(childhood!=null){
				this.updatePersonalBiographyChildhood(id, childhood);
			}
			else if(student!=null){
				this.updatePersonalBiographyStudent(id, student);
			}
			else if(univ!=null){
				this.updatePersonalBiographyUniv(id, univ);
			}
			else if(company!=null){
				this.updatePersonalBiographyCompany(id, company);
			}
			else if(keyword!=null){
				this.updatePersonalBiographyKeyword(id, keyword);
			}
			else if(specialtyList!=null){
				Set<Integer> keys = specialtyList.keySet();
				for(Integer key : keys){
					PersonalSpecialtyDTO sdto = specialtyList.get(key);
					this.updatePersonalSpecialty(sdto);
				}
			}
			
			return true;
			
		
	}
	/**
	 * 성장과정 중 유년기를 수정하는 메소드
	 * @param memberID 회원ID
	 * @param childhood 유년기
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalBiographyChildhood(String memberID, String childhood) throws Exception{
		if(memberID.equals("") || childhood.equals("")){
			System.out.println("유년기 수정 실패!");
			return false;
		}
		
			int res = sqlSession.update("PersonalBiographyMapper.updatePersonalChildhood",
					new PersonalBiographyDTO(memberID, childhood, null, null, null, null, null));
			
			if(res>0){
				System.out.println("유년기 수정 성공!");
				return true;
			}
			System.out.println("유년기 수정 실패!");
			return false;
			
	}
	/**
	 * 성장과정 중 청소년기를 수정하는 메소드
	 * @param memberID 회원ID
	 * @param student 청소년기
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalBiographyStudent(String memberID, String student) throws Exception{
		if(memberID.equals("") || student.equals("")){
			System.out.println("청소년기 수정 실패!");
			return false;
		}
			int res = sqlSession.update("PersonalBiographyMapper.updatePersonalStudent",
					new PersonalBiographyDTO(memberID, null, student, null, null, null, null));
			
			if(res>0){
				System.out.println("청소년기 수정 성공!");
				return true;
			}
			System.out.println("청소년기 수정 실패!");
			return false;
			
	}
	/**
	 * 성장과정 중 대학생활을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param univ 대학생활
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalBiographyUniv(String memberID, String univ) throws Exception{
		if(memberID.equals("") || univ.equals("")){
			System.out.println("대학생활 수정 실패!");
			return false;
		}
			int res = sqlSession.update("PersonalBiographyMapper.updatePersonalUniv",
					new PersonalBiographyDTO(memberID, null, null, univ, null, null, null));
			
			if(res>0){
				System.out.println("대학생활 수정 성공!");
				return true;
			}
			System.out.println("대학생활 수정 실패!");
			return false;
			
	}
	/**
	 * 성장과정 중 회사생활을 수정하는 메소드
	 * @param memberID 회원ID
	 * @param company 회사생활
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalBiographyCompany(String memberID, String company) throws Exception{
		if(memberID.equals("") || company.equals("")){
			System.out.println("회사생활 수정 실패!");
			return false;
		}
			int res = sqlSession.update("PersonalBiographyMapper.updatePersonalCompany",
					new PersonalBiographyDTO(memberID, null, null, null, company, null, null));
			
			if(res>0){
				System.out.println("회사생활 수정 성공!");
				return true;
			}
			System.out.println("회사생활 수정 실패!");
			return false;
			
	}
	/**
	 * 성장과정 중 대표키워드를 수정하는 메소드
	 * @param memberID 회원ID
	 * @param keyword 대표키워드
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalBiographyKeyword(String memberID, String keyword) throws Exception{
		if(memberID.equals("") || keyword.equals("")){
			System.out.println("대표키워드 수정 실패!");
			return false;
		}
			int res = sqlSession.update("PersonalBiographyMapper.updatePersonalKeyword",
					new PersonalBiographyDTO(memberID, null, null, null, null, keyword, null));
			
			if(res>0){
				System.out.println("대표키워드 수정 성공!");
				return true;
			}
			System.out.println("대표키워드 수정 실패!");
			return false;
			
	}
	/**
	 * 성장과정을 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalBiography(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("personal biography 삭제 실패!");
			return false;
		}
		
		// 자식 먼저 지우고 부모 지우기
		this.deletePersonalSpecialtyAll(memberID); // 자체적으로 성공실패 메시지 출력함
		
		
			int res = sqlSession.delete("PersonalBiographyMapper.deletePersonalBiograpy",memberID);
			
			if(res>0){
				System.out.println("personal biography 삭제 성공!");
				return true;
			}
			System.out.println("personal biography 삭제 실패!");
			return false;
			
	}
	/**
	 * 성장과정 중 유년기를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalBiographyChildhood(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("유년기 삭제 실패!");
			return false;
		}
		
		if(!this.updatePersonalBiographyChildhood(memberID, "")){
			System.out.println("유년기 삭제 실패!");
			return false;
		}
		
		System.out.println("유년기 삭제 성공!");
		return true;
	}
	/**
	 * 성장과정 중 청소년기를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalBiographyStudent(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("청소년기 삭제 실패!");
			return false;
		}
		
		if(!this.updatePersonalBiographyStudent(memberID, "")){
			System.out.println("청소년기 삭제 실패!");
			return false;
		}
		
		System.out.println("청소년기 삭제 성공!");
		return true;
	}
	/**
	 * 성장과정 중 대학생활을 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalBiographyUniv(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("대학생활 삭제 실패!");
			return false;
		}
		
		if(!this.updatePersonalBiographyUniv(memberID, "")){
			System.out.println("대학생활 삭제 실패!");
			return false;
		}
		
		System.out.println("대학생활 삭제 성공!");
		return true;
	}
	/**
	 * 성장과정 중 회사생활을 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalBiographyCompany(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("회사생활 삭제 실패!");
			return false;
		}
		
		if(!this.updatePersonalBiographyCompany(memberID, "")){
			System.out.println("회사생활 삭제 실패!");
			return false;
		}
		
		System.out.println("회사생활 삭제 성공!");
		return true;
	}
	/**
	 * 성장과정 중 대표키워드를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalBiographyKeyword(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("대표키워드 삭제 실패!");
			return false;
		}
		
		if(!this.updatePersonalBiographyKeyword(memberID, "")){
			System.out.println("대표키워드 삭제 실패!");
			return false;
		}
		
		System.out.println("대표키워드 삭제 성공!");
		return true;
	}
	/**
	 * 저장된 성장과정을 불러오는 메소드
	 * @param memberID 회원ID
	 * @return 성장과정 DTO
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public PersonalBiographyDTO selectPersonalBiography(String memberID) throws Exception{
		
		PersonalBiographyDTO dto = sqlSession.selectOne("PersonalBiographyMapper.selectPersonalBiograpy",memberID);
		
		if(dto != null){
			this.specialtyList = this.selectPersonalSpecialtyAll(memberID);
			if(this.specialtyList != null){
				dto.setSpecialtyMap(specialtyList);
			}
			System.out.println("찍어봅새:"+dto);
			return dto;
		}
		else{
			return null;
		}
		
			
		
	}
	
	/**
	 * 취미특기를 등록하는 메소드
	 * @param personalSpecialtyDTO 취미특기 DTO
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean insertPersonalSpecialty(PersonalSpecialtyDTO personalSpecialtyDTO) throws Exception{
		if(personalSpecialtyDTO==null){
			System.out.println("personal specialty 등록 실패!");
			return false;
		}
		
			int res = sqlSession.insert("PersonalBiographyMapper.insertPersonalSpecialty",personalSpecialtyDTO);
			int seq = sqlSession.selectOne("PersonalBiographyMapper.selectPersonalSpecialtySeq");
			System.out.println("시퀀스번호: " + seq);
			personalSpecialtyDTO.setRegisterNo(seq);
			
			
			if(res>0){
				System.out.println("personal specialty 등록 성공!");
				return true;
			}
			System.out.println("personal specialty 등록 실패!");
			return false;
			
	}
	/**
	 * 취미특기를 수정하는 메소드
	 * @param personalSpecialtyDTO 취미특기 DTO
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalSpecialty(PersonalSpecialtyDTO personalSpecialtyDTO) throws Exception{
		if(personalSpecialtyDTO==null){
			System.out.println("취미특기 수정 실패!");
			return false;
		}
		
		
			int res = sqlSession.update("PersonalBiographyMapper.updatePersonalSpecialty",personalSpecialtyDTO);
			
			
			if(res>0){
				System.out.println("취미특기 이름 수정 성공!");
				return true;
			}
			System.out.println("취미특기 이름 수정 실패!");
			return false;
			
	}
	/**
	 * 취미특기를 수정하는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @param name 취미특기명
	 * @param iconCode 아이콘 코드
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean updatePersonalSpecialty(String memberID,int registerNo,String name,String iconCode) throws Exception{
		if(memberID.equals("") || registerNo <= 0 || name.equals("") || iconCode.equals("")){
			System.out.println("취미특기 수정 실패!");
			return false;
		}
		
		
			int res = sqlSession.update("PersonalBiographyMapper.updatePersonalSpecialty",
					 new PersonalSpecialtyDTO(memberID, null, registerNo, name, iconCode));
			
			
			if(res>0){
				System.out.println("취미특기 이름 수정 성공!");
				return true;
			}
			System.out.println("취미특기 이름 수정 실패!");
			return false;
			
	}
	/**
	 * 취미특기를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @return boolean
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public boolean deletePersonalSpecialty(String memberID,int registerNo) throws Exception{
		if(memberID.equals("")||registerNo<=0){
			System.out.println("취미특기 삭제 실패!");
			return false;
		}
		
		
		
			int res = sqlSession.delete("PersonalBiographyMapper.deletePersonalSpecialty",
					 new PersonalSpecialtyDTO(memberID, null, registerNo, null, null));
			
			
			if(res>0){
				System.out.println("취미특기 삭제 성공!");
				return true;
			}
			System.out.println("취미특기 삭제 실패!");
			return false;
			
	}
	/**
	 * 등록된 모든 취미특기를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return 삭제한 취미특기 갯수
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public int deletePersonalSpecialtyAll(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("취미특기 삭제 실패!");
			return 0;
		}
		
		
			int res = sqlSession.delete("PersonalBiographyMapper.deletePersonalSpecialtyAll",memberID);
			
			
			if(res>0){
				System.out.println("취미특기"+res+"개 삭제 성공!");
				return res;
			}
			System.out.println("취미특기 삭제 실패!");
			return 0;
			
	}
	/**
	 * 등록된 모든 취미를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return 삭제한 취미 갯수
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public int deleteHobbyAll(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("취미 삭제 실패!");
			return 0;
		}
		
			int res = sqlSession.delete("PersonalBiographyMapper.deletePersonalHobbyAll",memberID);
			
			
			if(res>0){
				System.out.println("취미"+res+"개 삭제 성공!");
				return res;
			}
			System.out.println("취미 삭제 실패!");
			return 0;
			
	}
	/**
	 * 등록된 모든 특기를 삭제하는 메소드
	 * @param memberID 회원ID
	 * @return 삭제한 특기 갯수
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public int deleteSkillAll(String memberID) throws Exception{
		if(memberID.equals("")){
			System.out.println("특기 삭제 실패!");
			return 0;
		}
		
		
			int res = sqlSession.delete("PersonalBiographyMapper.deletePersonalSkillAll",memberID);
			
			
			if(res>0){
				System.out.println("특기"+res+"개 삭제 성공!");
				return res;
			}
			System.out.println("특기 삭제 실패!");
			return 0;
			
	}
	/**
	 * 저장된 모든 취미특기를 iterator로 불러오는 메소드
	 * @param memberID 회원ID
	 * @return Iterator<PersonalSpecialtyDTO>
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Iterator<PersonalSpecialtyDTO> selectPersonalSpecialtyAlltoIter(String memberID) throws Exception{
			List<PersonalSpecialtyDTO> list = sqlSession.selectList("PersonalBiographyMapper.selectPersonalSpecialtyAll",memberID);
			System.out.println("취미특기 리스트 :"+list);
			
			if(list.size()!=0){
				return list.iterator();
			}
			return null;
	}
	/**
	 * 저장된 모든 취미를 iterator로 불러오는 메소드
	 * @param memberID 회원ID
	 * @return Iterator<PersonalSpecialtyDTO>
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Iterator<PersonalSpecialtyDTO> selectPersonalHobbyAll(String memberID) throws Exception{
		List<PersonalSpecialtyDTO> list = sqlSession.selectList("PersonalBiographyMapper.selectPersonalHobbyAll",memberID);
		System.out.println("취미 리스트 :"+list);
		
		if(list.size()!=0){
			return list.iterator();
		}
		return null;
	}
	/**
	 * 저장된 모든 특기를 iterator로 불러오는 메소드
	 * @param memberID 회원ID
	 * @return Iterator<PersonalSpecialtyDTO>
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Iterator<PersonalSpecialtyDTO> selectPersonalSkillAll(String memberID) throws Exception{
		List<PersonalSpecialtyDTO> list = sqlSession.selectList("PersonalBiographyMapper.selectPersonalSkillAll",memberID);
		System.out.println("특기 리스트 :"+list);
		
		if(list.size()!=0){
			return list.iterator();
		}
		return null;
	}
	/**
	 * 저장된 모든 취미특기를 Map으로 불러오는 메소드
	 * @param memberID 회원ID
	 * @return Map<Integer,PersonalSpecialtyDTO>
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Map<Integer,PersonalSpecialtyDTO> selectPersonalSpecialtyAll(String memberID) throws Exception{
			
			List<PersonalSpecialtyDTO> list = sqlSession.selectList("PersonalBiographyMapper.selectPersonalSpecialtyAll",memberID);
			
			Map<Integer,PersonalSpecialtyDTO>  map = new HashMap<>();
			for(PersonalSpecialtyDTO dto : list){
				map.put(dto.getRegisterNo(), dto);
			}
			return map;
	}
	/**
	 * 저장된 취미특기 DTO를 불러오는 메소드
	 * @param memberID 회원ID
	 * @param registerNo 등록번호
	 * @return 취미특기 DTO
	 * @throws Exception SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public PersonalSpecialtyDTO selectPersonalSpecialty(String memberID, int registerNo) throws Exception{
			PersonalSpecialtyDTO dto = sqlSession.selectOne("PersonalBiographyMapper.selectPersonalSpecialty",
					new PersonalSpecialtyDTO(memberID, null, registerNo, null, null));
			
			
			return dto;
			
	}
	
	/**
	 * toString메소드 재정의
	 */
	public String toString() {
		return "PersonalBiographyDAO [PersonalBiography=" + personalBiography + "]";
	}
}
