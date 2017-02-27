package com.omazing.portfolio.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProgramContentCategoryDAO {

	@Autowired
	private SqlSession session;
/*	public static void main(String[] args) {
	}
	private BaseDAO base=null;
	public ProgramContentCategoryDAO() {
		super();
		base=new BaseDAO();
	}
	public boolean insertProgramContentCategory(ProgramContentCategoryDTO category){
		return false;
	}
	public ProgramContentCategoryDTO selectProgramContentCategoryByCode(String code){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    ProgramContentCategoryDTO ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from program_content_category_tb where code='"+code+"'");
	    	if(rs.next()){
	    		String contentCategory=rs.getString("content_category");
	    		ccDTO=new ProgramContentCategoryDTO(code, contentCategory);
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally{
	        base.closeDBObjects(rs, stmt, conn);
	    }
	    return ccDTO;
	}
	public ProgramContentCategoryDTO selectProgramContenCodeByCategory(String contentCategory){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    ProgramContentCategoryDTO ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from program_content_category_tb where content_category='"+contentCategory+"'");
	    	if(rs.next()){
	    		String code=rs.getString("code");
	    		ccDTO=new ProgramContentCategoryDTO(code, contentCategory);
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally{
	        base.closeDBObjects(rs, stmt, conn);
	    }
	    return ccDTO;
	}
	public Map<String, String> selectProgramContentCategory(){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    Map<String, String> ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from program_content_category_tb");
	    	if(rs.next()){
	    		ccDTO=new HashMap<String, String>();
	    		do{
	    			String code=rs.getString("code");
	    			String contentCategory=rs.getString("content_category");
	    			ccDTO.put(code, contentCategory);
	    		}while(rs.next());
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally{
	        base.closeDBObjects(rs, stmt, conn);
	    }
	    return ccDTO;
	}
	public boolean deleteProgramContentCategoryByCode(String code){
		return false;
	}
	public boolean deleteProgramContentCategoryByCategory(String contentCategory){
		return false;
	}
	public boolean updateProgramContentCategory(ProgramContentCategoryDTO ccDTO){
		return false;
	}
	public BaseDAO getBase() {
		return base;
	}
	public void setBase(BaseDAO base) {
		this.base = base;
	}
	@Override
	public String toString() {
		return "ProgramContentCategoryDAO [base=" + base + "]";
	}*/
}
