package com.omazing.portfolio.dao;
import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.SkillRankDTO;

@Repository
public class SkillRankDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SqlSession sqlSession;
	
	public SkillRankDAO() {
		
	}
	
	public List<SkillRankDTO> selectSkillRankCategory(){
		try {
			return sqlSession.selectList("SkillRankMapper.selectSkillRankCategory");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
