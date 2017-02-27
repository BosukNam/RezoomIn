	package com.omazing.portfolio.dao;

import java.io.Serializable;
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
public class RoleAndTaskDAO implements Serializable{
	
	
	@Autowired
	private SqlSession session;
/*
	private BaseDAO base=null;
	//private Map<Integer, RoleAndTaskDTO>roleAndTask;
	public RoleAndTaskDAO() {
		super();
		base=new BaseDAO();
		//roleAndTask=new HashMap<Integer, RoleAndTaskDTO>();
	}
	public boolean insertRoleAndTask(RoleAndTaskDTO roleAndTask){
		Connection conn=null;
		Statement stmt = null;
		String[] data=roleAndTask.getAll();
		int check=0;
		try{
			conn=base.getConnection();
			stmt=conn.createStatement();
			check=stmt.executeUpdate("insert into role_and_task_tb values(role_and_task_seq.NEXTVAL, '"+data[1]
					+"','"+data[2]+"','"+data[2]+"')");			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			base.closeDBObjects(null, stmt, conn);
		}
	    if(check!=0)
	    	return true;
	    return false;
	}
	public int selectLatestRegisterNo(int projectNo){
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs=null;
		int num=0;
		try{
			conn=base.getConnection();
			stmt = conn.createStatement();
			rs=stmt.executeQuery("select *from (select * from(select rownum rnum, register_no, project_no "
		                   + "from (select * from role_and_task_tb order by register_no desc)) where rnum <=1) where rnum >=1");   
	        if(rs.next()){
	        	num = rs.getInt("register_no");
	        }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			base.closeDBObjects(rs, stmt, conn);
		}
		return num;
	}
	public boolean deleteRoleAndTaskByRegisterNo(int registerNo){
		Statement stmt=null;
		Connection conn=null;
		int result=0;
		String sql="delete from role_and_task_tb where register_no="+registerNo;
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);
		}
		if(result!=0)	
			return true;
		return false;
	}
	public boolean deleteRoleAndTaskByProjectNo(int projectNo){
		Statement stmt=null;
		Connection conn=null;
		int result=0;
		String sql="delete from role_and_task_tb where project_no="+projectNo;
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);
		}
		if(result!=0)	
			return true;
		return false;
	}
	public boolean updateRoleAndTask(RoleAndTaskDTO roleAndTask){
		Statement stmt=null;
		Connection conn=null;
		String[] data=roleAndTask.getAll();
		int result=0;
		String sql="update role_and_task_tb set role='"+data[2]
				+"', task='"+data[3]+"' where register_no="+data[0]
				+" and project_no"+data[1];
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);
		}
		if(result !=0)		
			return true;
		return false;
	}
	public RoleAndTaskDTO selectRoleAndTaskByProjectNo(int projectNo){
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		RoleAndTaskDTO roleAndTask=null;
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from role_and_task_tb where project_no="+projectNo);
			if(rs.next()){				
				int registerNo = rs.getInt("register_no");
				String role =rs.getString("role");
				String task =rs.getString("task");
					
				roleAndTask=new RoleAndTaskDTO(registerNo, projectNo, role, task);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{			
			base.closeDBObjects(rs, stmt, conn);
		}
		return roleAndTask;
	}
	public Map<Integer,RoleAndTaskDTO> selectRoleAndTaskByRegisterNo(int registerNo){
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		Map<Integer, RoleAndTaskDTO> roleAndTask=null;
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from role_and_task_tb where register_no="+registerNo);
			if(rs.next()){
				roleAndTask=new HashMap<Integer, RoleAndTaskDTO>();
				do{					
					int projectNo = rs.getInt("project_no");
					String role =rs.getString("role");
					String task =rs.getString("task");
					
					roleAndTask.put(registerNo,new RoleAndTaskDTO(registerNo, projectNo, role, task));	
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{			
			base.closeDBObjects(rs, stmt, conn);
		}
		return roleAndTask;
	}
	public BaseDAO getBase() {
		return base;
	}
	public void setBase(BaseDAO base) {
		this.base = base;
	}
	@Override
	public String toString() {
		return "RoleAndTaskDAO [base=" + base + "]";
	}*/
}
