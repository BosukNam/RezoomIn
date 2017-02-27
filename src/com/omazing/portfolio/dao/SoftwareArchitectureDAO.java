package com.omazing.portfolio.dao;

import java.io.Serializable;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.SoftwareArchitectureDTO;
import com.omazing.portfolio.dto.UsecaseDTO;

/**
 * 소프트 웨어 환경을 관리하는 DAO
 * @author YJ
 *
 */
@Repository
public class SoftwareArchitectureDAO implements Serializable{
	
	/**
	 * Spring mybatis를 사용하기 위한 변수
	 */
	@Autowired
	private SqlSession sqlSession;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Spring mybatis의 DI를 위한 default 생성자
	 */
	public SoftwareArchitectureDAO() {
	}

	/**
	 * 소프트웨어 환경을 추가하는 insert 구문
	 * @param dto 소프트웨어 환경의 데이터를 저장할 DTO 객체
	 * @return 소프트웨어 환경 추가 여부
	 * @throws Exception 소프트웨어 환경 중복 등록 Exception
	 */
	public boolean insertSoftwareArchitecture(SoftwareArchitectureDTO dto) throws Exception{
		try {
			 sqlSession.insert("SoftwareArchitectureMapper.insertSoftwareArchitecture" ,dto );
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
	 * 소프트웨어 환경을 프로젝트 등록번호로 검색하는 select 구문
	 * @param project_no 현재 등록한 프로젝트 등록번호
	 * @return VIew에 사용할 데이터를 저장한 소프트웨어 환경 DTO
	 */
	public SoftwareArchitectureDTO searchSoftwareArchitecture(int project_no) throws Exception{
		try {
			 return sqlSession.selectOne("SoftwareArchitectureMapper.searchSoftwareArchitecture" ,project_no );
		//sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		return null;
	}
	
	/**
	 * 소프트웨어 환경의 다이어그램을 소프트웨어 환경 등록 번호로 검색하는 select 구문
	 * @param register_no 현재 등록한 소프트웨어 환경 등록 번호
	 * @return 서버에 저장된 해당 다이어그램 파일의 파일경로
	 */
	public String searchSoftwareArchitectureAtDiagram(int register_no) throws Exception{
		try {
			 return sqlSession.selectOne("SoftwareArchitectureMapper.searchSoftwareArchitectureAtDiagram" ,register_no);
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		return null;
	}
	/**
	 * 소프트웨어 환경의 다이어그램을 소프트웨어 환경 등록 번호로 삭제하는 delete 구문
	 * @param register_no 현재 등록한 소프트웨어 환경 등록 번호
	 * @return 파일 삭제 여부
	 */
	public boolean deleteSoftwareArchitectureAtDiagram(int register_no) throws Exception{
		try {
			if(sqlSession.delete("SoftwareArchitectureMapper.deleteSoftwareArchitecture" ,register_no)!=0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		return false;
	}
	/**
	 * 소프트웨어 환경 전체를 수정하는 update 구문
	 * @param dto 현재 수정할 소프트웨어 DTO
	 * @return 수정 여부
	 */
	public boolean updateSoftwareArchitectureAtDiagram(SoftwareArchitectureDTO dto) throws Exception{
		try {
			  if(sqlSession.update("SoftwareArchitectureMapper.updateSoftwareArchitectureAtDiagram" ,dto)!=0)
				  return true;
		}catch(Exception e){
			e.printStackTrace();
			//sqlSession.rollback();
		}finally{
			
		}
		return false;
	}
	/*public SoftwareArchitectureDTO searchSoftwareArchitecture(int project_no){
		SoftwareArchitectureDTO dto = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet select = stmt.executeQuery("select register_no, project_no, usercase_, usecase_image "
					+ "from software_architecture_tb sa "
					+ "inner join project_info_tb pi "
					+ "on pi.register_no = sa.project_no "
					+ "inner join tier_category_tb tc "
					+ "on sa.tier_category = tc.tier_code "
					+ "where project_no="+project_no);
			while(select.next()){
				dto = new SoftwareArchitectureDTO(select.getInt("register_no"), select.getInt("project_no"), 
						select.getString("tier_name"), select.getString("client"), select.getString("server"), select.getString("middle_ware"));
			}
			return dto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}*/
	

}
