package com.omazing.portfolio.dao;
import java.io.Serializable;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.SystemArchitectureDTO;



/**
 * 시스템 환경을 관리하는 DAO
 * @author YJ
 *
 */
@Repository
public class SystemArchitectureDAO implements Serializable{
	
	/**
	 * Spring mybatis를 사용하기 위한 변수
	 */
	@Autowired
	private SqlSession sqlSession;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Spring mybatis의 DI를 위한 default 생성자
	 */
	public SystemArchitectureDAO() {
	}
	
	/**
	 * 시스템 환경을 추가하는 insert 구문
	 * @param dto 시스템 환경의 데이터를 저장할 DTO 객체
	 * @return 시스템 환경 추가 여부
	 * @throws Exception 시스템 환경 중복 등록 Exception
	 */
	public boolean insertSystemArchitecture(SystemArchitectureDTO dto) throws Exception{
		try {
			 sqlSession.insert("SystemArchitectureMapper.insertSystemArchitecture" ,dto );
		//sqlSession.commit();
		}catch(DuplicateKeyException e){
			throw new Exception("이미존재하는 환경입니다.");
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		
		return false;
	}
	
	/**
	 * 시스템 환경을 프로젝트 등록번호로 검색하는 select 구문
	 * @param project_no 현재 등록한 프로젝트 등록번호
	 * @return VIew에 사용할 데이터를 저장한 시스템 환경 DTO
	 */
	public SystemArchitectureDTO searchSystemArchitecture(int project_no) throws Exception{
		try {
			  return sqlSession.selectOne("SystemArchitectureMapper.searchSystemArchitecture" ,project_no );
		//sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		
		return null;
	}
	/**
	 * 시스템 환경의 다이어그램을 시스템 환경 등록 번호로 삭제하는 delete 구문
	 * @param register_no 현재 등록한 시스템 환경 등록 번호
	 * @return 파일 삭제 여부
	 */
	public boolean deleteSystemArchitecture(int project_no) throws Exception{
		try {
			 sqlSession.delete("SystemArchitectureMapper.deleteSystemArchitecture" ,project_no );
		//sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		
		return false;
	}

	/**
	 * 시스템 환경 전체를 수정하는 update 구문
	 * @param dto 현재 수정할 시스템 DTO
	 * @return 수정 여부
	 */
	public boolean updateSystemArchitecture(SystemArchitectureDTO dto) throws Exception{
		try {
			System.out.println(dto.getRegister_no()+"넘어온게 이거냐");
			 sqlSession.update("SystemArchitectureMapper.updateSystemArchitecture" ,dto );
		//sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		
		return false;
	}
	
}
