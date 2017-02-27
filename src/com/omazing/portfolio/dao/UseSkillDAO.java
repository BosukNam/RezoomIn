package com.omazing.portfolio.dao;
import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.UseSkillDTO;


/**
 * 사용 기술을 관리하는 DAO
 * @author YJ
 *
 */
@Repository
public class UseSkillDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Spring mybatis를 사용하기 위한 변수
	 */
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Spring mybatis의 DI를 위한 default 생성자
	 */
	public UseSkillDAO() {
		
	}
	/**
	 * 사용 기술을 추가하는 insert 구문
	 * @param dto 사용 기술의 data를 저장한 dto
	 * @return 사용기술 추가 여부
	 * @throws Exception 사용기술 중복 등록 Exception
	 */
	public boolean insertUseSkill(UseSkillDTO dto) throws Exception{
		try {
			 sqlSession.insert("UseSkillMapper.insertUseSkill" ,dto );
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
	 * 사용 기술을 프로젝트 등록 번호로 검색하는 select 구문
	 * @param projectNo 사용기술을 검색할 해당 프로젝트 등록 번호
	 * @return 해당 프로젝트 등록번호로 검색된 사용 기술 List
	 */
	public List<UseSkillDTO> selectUseSkill(int projectNo){
		try {
			return sqlSession.selectList("UseSkillMapper.selectUseSkill", projectNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 사용 기술을 프로젝트 등록 번호로 기술 이름과 프로젝트 등록 번호 검색하는 select 구문
	 * @param projectNo 사용기술을 검색할 해당 프로젝트 등록 번호
	 * @return 해당 프로젝트 등록번호로 검색된 사용 기술 List
	 */
	public List<UseSkillDTO> selectUseSkillName(int projectNo){
		try {
			return sqlSession.selectList("UseSkillMapper.selectUseSkillName", projectNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 사용 기술을 프로젝트 등록 번호로 삭제하는 delete 구문
	 * @param projectNo 사용기술을 삭제할 해당 프로젝트 등록 번호
	 * @return 삭제 여부
	 */
	public boolean deleteUseSkillByProjectNo(int projectNo){
		try {
			int delete = sqlSession.delete("UseSkillMapper.deleteUseSkillByProjectNo", projectNo);
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
	
}
