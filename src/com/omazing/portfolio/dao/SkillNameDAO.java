package com.omazing.portfolio.dao;
import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.LibraryDTO;
import com.omazing.portfolio.dto.SkillNameDTO;

@Repository
public class SkillNameDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private SqlSession sqlSession;
	
	public SkillNameDAO() {
		
	}
	public boolean insertSkillNameCategoryETC(String name) throws Exception{
		try {
			 sqlSession.insert("SkillNameMapper.insertSkillNameCategoryETC" ,name );
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
	public List<SkillNameDTO> selectSkillNameCategory(){
		try {
			return sqlSession.selectList("SkillNameMapper.selectSkillNameCategory");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public SkillNameDTO selectSkillNameByName(String name){
		try{
			return sqlSession.selectOne("SkillNameMapper.selectSkillNameByName", name);
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteSkillNameByName(String name){
		try {
			int delete = sqlSession.delete("SkillNameMapper.deleteSkillNameByName", name);
			if(delete!=0){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean updateLibraryByRegisterNo(LibraryDTO library, int projectNo){
	
		return false;
	}
}
