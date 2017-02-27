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
public class ChartCategoryDAO {
	
	@Autowired
	private SqlSession session;
/*	private BaseDAO base=null;
	public ChartCategoryDAO() {
		super();
		base=new BaseDAO();
	}
	public boolean insertChartCategoryDAO(ChartCategoryDTO ccDTO){
		Connection conn=null;
		Statement stmt=null;
		String[] data=ccDTO.getAll();
		int check=0;
		try{
			conn=base.getConnection();
	        stmt=conn.createStatement();
	        check=stmt.executeUpdate("insert into program_content_category_tb values('"+data[0]
	        						+"','"+data[1]+"')");
		} catch (SQLException e1) {
			e1.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        base.closeDBObjects(null, stmt, conn);
	    }
		if(check!=0)
			return true;
		return false;
	}
	public ChartCategoryDTO selectChartCategoryByCode(String code){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    ChartCategoryDTO ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from chart_category_tb where code='"+code+"'");
	    	if(rs.next()){
	    		String category=rs.getString("category");
	    		ccDTO=new ChartCategoryDTO(code, category);
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
	public ChartCategoryDTO selectChartCodeByCategory(String category){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    ChartCategoryDTO ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from chart_category_tb where category='"+category+"'");
	    	if(rs.next()){
	    		String code=rs.getString("code");
	    		ccDTO=new ChartCategoryDTO(code, category);
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
	public Map<String, String> selectChartCode(){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    Map<String, String> ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from chart_category_tb");
	    	if(rs.next()){
	    		ccDTO=new HashMap<String, String>();
	    		do{
	    			String code=rs.getString("code");
	    			String category=rs.getString("category");
	    			
	    			ccDTO.put(code, category);
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
	public boolean deleteChartCategoryByCode(String code){
		return false;
	}
	public boolean deleteChartCategoryByCategory(String category){
		return false;
	}
	public boolean updateChartCategory(ChartCategoryDTO ccDTO){
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
		return "ChartCategoryDAO [base=" + base + "]";
	}*/
	
}

/*package com.omazing.yj.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ChartCategoryDAO {
	private BaseDAO base=null;
	public ChartCategoryDAO() {
		super();
		base=new BaseDAO();
	}
	public boolean insertChartCategoryDAO(ChartCategoryDTO ccDTO){
		Connection conn=null;
		Statement stmt=null;
		String[] data=ccDTO.getAll();
		int check=0;
		try{
			conn=base.getConnection();
	        stmt=conn.createStatement();
	        check=stmt.executeUpdate("insert into program_content_category_tb values('"+data[0]
	        						+"','"+data[1]+"')");
		} catch (SQLException e1) {
			e1.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        base.closeDBObjects(null, stmt, conn);
	    }
		if(check!=0)
			return true;
		return false;
	}
	public ChartCategoryDTO selectChartCategoryByCode(String code){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    ChartCategoryDTO ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from chart_category_tb where code='"+code+"'");
	    	if(rs.next()){
	    		String category=rs.getString("category");
	    		ccDTO=new ChartCategoryDTO(code, category);
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
	public ChartCategoryDTO selectChartCodeByCategory(String category){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    ChartCategoryDTO ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from chart_category_tb where category='"+category+"'");
	    	if(rs.next()){
	    		String code=rs.getString("code");
	    		ccDTO=new ChartCategoryDTO(code, category);
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
	public Map<String, String> selectChartCode(){
	    Statement stmt=null;
	    ResultSet rs=null;
	    Connection conn=null;
	    Map<String, String> ccDTO=null;
	    try{
	    	conn=base.getConnection();
	    	stmt=conn.createStatement();
	    	rs=stmt.executeQuery("select * from chart_category_tb");
	    	if(rs.next()){
	    		ccDTO=new HashMap<String, String>();
	    		do{
	    			String code=rs.getString("code");
	    			String category=rs.getString("category");
	    			
	    			ccDTO.put(code, category);
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
	public boolean deleteChartCategoryByCode(String code){
		return false;
	}
	public boolean deleteChartCategoryByCategory(String category){
		return false;
	}
	public boolean updateChartCategory(ChartCategoryDTO ccDTO){
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
		return "ChartCategoryDAO [base=" + base + "]";
	}
	
}*/

