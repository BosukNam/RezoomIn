package com.omazing.introduce.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.introduce.dto.IconURLCategoryDTO;

/**
 * 아이콘 카테고리 DAO
 * @author nam
 */
@Repository
public class IconURLCategoryDAO {

	/**
	 * 아이콘 카테고리를 저장할 맵
	 */
	private Map<String, IconURLCategoryDTO> map;
	/**
	 * SQL세션객체
	 */
	@Autowired
	private SqlSession sqlSession;
	/**
	 * 기본생성자
	 */
	public IconURLCategoryDAO() {
		super();
	}
	/**
	 * 아이콘 코드에 해당하는 아이콘 주소를 불러오는 메소드
	 * @param iconCode 아이콘 코드
	 * @return 아이콘 주소
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public String selectIconURLByCode(String iconCode) throws SQLException{
		String url = sqlSession.selectOne("IconCategoryMapper.selectIconURLByCode",iconCode);
		System.out.println("아이콘URL : "+url);
		
		return url;
	}
	/**
	 * 아이콘 주소에 해당하는 아이콘 코드를 불러오는 메소드
	 * @param iconURL 아이콘 주소
	 * @param type 취미특기종류
	 * @return 아이콘 코드
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public String selectIconCodeByURL(String iconURL, String type) throws SQLException{
		String code = sqlSession.selectOne("IconCategoryMapper.selectIconCodeByURL",
				new IconURLCategoryDTO(null, type, iconURL));
		System.out.println("아이콘code : "+code);
		
		return code;
	}
	
	/**
	 * 취미특기 종류에 해당하는 저장된 모든 아이콘 카테고리객체를 불러오는 메소드 
	 * @param type 취미특기종류
	 * @return Map<String,IconURLCategoryDTO>
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Map<String,IconURLCategoryDTO> selectIconURLByType(String type) throws SQLException{
		List<IconURLCategoryDTO> list = sqlSession.selectList("IconCategoryMapper.selectIconURLByType",type);
		if(list==null){
			return null;
		}
		
		this.map = new HashMap<>();
		for(IconURLCategoryDTO dto : list){
			map.put(dto.getIconCode(), dto);
		}
		return map;
	}
	
	/**
	 * 저장된 모든 아이콘 카테고리객체를 불러오는 메소드 
	 * @return Map<String,IconURLCategoryDTO>
	 * @throws SQLException SQL구문이 실패했을 때 발생하는 익셉션
	 */
	public Map<String,IconURLCategoryDTO> selectIconURL() throws SQLException{
		List<IconURLCategoryDTO> list = sqlSession.selectList("IconCategoryMapper.selectIconURL");
		if(list==null){
			return null;
		}
		
		this.map = new HashMap<>();
		for(IconURLCategoryDTO dto : list){
			map.put(dto.getIconCode(), dto);
		}
		return map;
	}
	
	/**
	 * toString메소드 재정의
	 */
	@Override
	public String toString() {
		return "IconURLCategoryDAO [map=" + map + ", sqlSession=" + sqlSession + "]";
	}
}
