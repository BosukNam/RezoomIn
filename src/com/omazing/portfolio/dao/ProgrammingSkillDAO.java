package com.omazing.portfolio.dao;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.omazing.company.SearchMemberVO;
import com.omazing.portfolio.dto.PortfolioDTO;
import com.omazing.portfolio.dto.ProgrammingSkillDTO;

/**
 * 포트폴리오의 보유기술(보유기술언어, 개발가능 툴)을 관리하는 DAO
 * @author YJ
 *
 */
@Repository
public class ProgrammingSkillDAO implements Serializable{
	
	/**
	 * Spring mybatis를 사용하기 위한 변수
	 */
	@Autowired
	private SqlSession sqlSession;

	
	private static final long serialVersionUID = 1L;
	/**
	 * N개의 보유기술을 관리하기 위한 Map 변수
	 */
	private Map<Integer, ProgrammingSkillDTO> dtoManager;
	
	/**
	 * Spring mybatis의 DI를 위한 default 생성자
	 * Map 객체를 초기화 시켜준다.
	 */
	public ProgrammingSkillDAO() {
		dtoManager = Collections.synchronizedMap(new HashMap<Integer, ProgrammingSkillDTO>());
	}
	
	/**
	 * 보유 기술을 추가하는 insert 구문
	 * @param dto 보유기술언어의 데이터를 저장할 DTO 객체
	 * @return 보유 기술 추가 여부
	 * @throws Exception 보유기술 중복 등록 Exception
	 */
	public boolean insertProgrammingSkill(ProgrammingSkillDTO dto) throws Exception{
		try {
			 sqlSession.insert("PortfolioProfileMapper.insertProgrammingSkill" ,dto );
		//sqlSession.commit();
		}catch(DuplicateKeyException e){
			throw new Exception("이미존재하는 보유 기술입니다.");
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		
		return false;
	}
	
	/**
	 * 보유기술을 사용자 ID로 검색하는 select 구문
	 * @param memberID 현재 로그인한 memberID
	 * @return VIew에 사용할 데이터를 저장한 Map 객체
	 */
	public Map<Integer, PortfolioDTO> selectProgrammingSkillByID(String memberID){
		try {
			Map<Integer, PortfolioDTO> manager = Collections.synchronizedMap(new HashMap<Integer, PortfolioDTO>());
//			manager = sqlSession.selectMap("PortfolioProfileMapper.selectProgrammingSkillByID",memberID, "register_no");
			
			return manager;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			//sqlSession.rollback();
		}finally{
			
		}
		return null;
		
	}

	/**
	 * 사용 영역으로 보유기술을 검색하는 select 구문
	 * @param dto 사용자 ID와 검색할 Field를 포함한 DTO
	 * @return 해당 Field의 보유기술 데이터를 저장한 list
	 */
	public List<ProgrammingSkillDTO> selectProgrammingSkillByField(ProgrammingSkillDTO dto){
		try {
			return sqlSession.selectList("PortfolioProfileMapper.selectProgrammingSkillByField",dto);
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		return null;
	}
	
	/**
	 * 보유 기술명으로 기술을 검색하는 select 구문
	 * @param memberID 검색할 사용자 ID
	 * @param name 검색할 보유기술 명
	 * @return 검색된 보유 기술 DTO
	 */
	public ProgrammingSkillDTO selectProgrammingSkillByName(String memberID, String name){
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberID", memberID);
			map.put("name", name);
			ProgrammingSkillDTO pdto =
			sqlSession.selectOne("PortfolioProfileMapper.selectProgrammingSkillByName",map);
			return pdto;
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		return null;
	}

	/**
	 * 보유기술 등록정보로 검색하는 select 구문
	 * @param registerNo 보유기술 등록 번호
	 * @return View에 사용할 데이터를 저장한 DTo
	 */
	public PortfolioDTO selectProgrammingSkillByRegisterNo(int registerNo){
		try {
			PortfolioDTO pdto =
			sqlSession.selectOne("PortfolioProfileMapper.selectProgrammingSkillByRegisterNo",registerNo);
					
			return pdto;
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		return null;
	}
	
	/**
	 * 보유 기술을 수정할 update 구문
	 * @param dto 수정할 보유기술 data를 담은 DTO
	 * @return 수정 여부
	 */
	public boolean updateProgrammingSkillUnit(ProgrammingSkillDTO dto){
		try {
		
			int update = sqlSession.update("PortfolioProfileMapper.updateProgrammingSkillUnit", dto);
			if(update!=0){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 보유기술 등록 번호로 삭제하는 delete 구문
	 * @param registerNo 해당 보유기술의 등록 번호
	 * @return 삭제 여부
	 */
	public boolean deleteProgrammingSkill(int registerNo){
		try {
			int delete = sqlSession.delete("PortfolioProfileMapper.deleteProgrammingSkill", registerNo);
			if(delete!=0){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * 기술 분야와 기술 명으로 검색하는 select 구문
	 * @param type 검색할 기술 분야
	 * @param name 검색할 기술 명
	 * @return 해당 명령어로 검색된 보유기술 list
	 */
	public List<SearchMemberVO> selectProgrammingSkillBySkill(String type, String name){
		List<SearchMemberVO> list = null;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("type", type);
			map.put("name", name);
			
			list = sqlSession.selectList("PortfolioProfileMapper.selectProgrammingSkills", map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Spring mybatis 변수를 반환하는 getter
	 * @return mybatis 변수
	 */
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	/**
	 * Spring mybatis 변수를 지정하는 setter
	 * @param sqlSession 
	 */
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * N개의 보유기술 DTO를 관리하는 Map 객체 반환 getter
	 * @return N개의 보유기술 DTO를 관리하는 Map
	 */
	public Map<Integer, ProgrammingSkillDTO> getDtoManager() {
		return dtoManager;
	}

	/**
	 * N개의 보유기술 DTO를 관리하는 Map 객체 반환 setter
	 * @param dtoManager N개의 보유기술 DTO를 관리하는 Map
	 */
	public void setDtoManager(Map<Integer, ProgrammingSkillDTO> dtoManager) {
		this.dtoManager = dtoManager;
	}
	
}
