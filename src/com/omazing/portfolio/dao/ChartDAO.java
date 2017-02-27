package com.omazing.portfolio.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.ChartDTO;

@Repository
public class ChartDAO {
	
	@Autowired
	private SqlSession session;
	
	public ChartDTO selectChartByProgramContentNo(int programContentNo){
		ChartDTO chart=session.selectOne("PortfolioProjectMapper.selectChartByProgramContentNo", programContentNo);
		System.out.println(chart.toString());
		return chart;
	}
	
/*	
	public boolean insertChart(ChartDTO chartDTO){
		String[] data=chartDTO.getAll();
		Connection conn=null;
		Statement stmt=null;
		int check=0;
		try {			
			conn=base.getConnection();
			stmt = conn.createStatement();
			check = stmt.executeUpdate("insert into chart_tb values(chart_seq.nextval, "
							+data[1]+",'"+ data[2]+"','"+data[3]+"')");
			if(check != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);
		}
		return false;
	}
	public int selectLatestRegisterNo(int programContentNo){
		int num=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;	
		try {		
			conn=base.getConnection();
			stmt = conn.createStatement();
			rs=stmt.executeQuery("select *from (select * from(select rownum rnum, register_no, program_content_no"
                  + "from (select * from chart_tb order by register_no desc)) where rnum <=1) where rnum >=1");
			if(rs.next()){
				num=rs.getInt("register_no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			base.closeDBObjects(rs, stmt, conn);
		}
		return num;
	}
	public ChartDTO selectChartByProgramContentNo(int programContentNo){
		Connection conn=null;
		Statement stmt=null;
		ChartDTO chartDTO=null;
		ResultSet rs=null;
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select register_no, chart_type, chart_path, category"
					+ " from chart_tb ct"
					+ " join chart_category_tb cc"
					+ " on ct.chart_type=cc.code"
					+ " where program_content_no="+programContentNo);
			
			if(rs.next()){
				int registerNo=rs.getInt("register_no");
				String chartType=rs.getString("chart_type");
				String chartPath=rs.getString("chart_path");
				String category=rs.getString("category");
				chartDTO=new ChartDTO(registerNo, programContentNo, new ChartCategoryDTO(chartType, category), chartPath);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chartDTO;
	}	
	public ChartDTO selectChartByRegisterNo(int registerNo){
		Connection conn=null;
		Statement stmt=null;
		ChartDTO chartDTO=null;
		ResultSet rs=null;
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select program_content_no, chart_type, chart_path, category"
					+ " from chart_tb ct"
					+ " join chart_category_tb cc"
					+ " on ct.chart_type=cc.code"
					+ " where register_no="+registerNo);
			
			if(rs.next()){
				int programContentNo=rs.getInt("program_content_no");
				String chartType=rs.getString("chart_type");
				String chartPath=rs.getString("chart_path");
				String category=rs.getString("category");
				chartDTO=new ChartDTO(registerNo, programContentNo, new ChartCategoryDTO(chartType, category), chartPath);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chartDTO;
	}
	public boolean updateChart(ChartDTO chartDTO){
		Connection conn=null;
		Statement stmt=null;
		String[] data=chartDTO.getAll();
		int result=0;
		String sql="update chart_tb set chart_type='"+data[2]+"', chart_path='"+data[3]+"'"
							+ " where register_no="+data[0]+"and program_content_no="+data[1];
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);
		}
		if(result!=0)
			return true;
		return false;
	}
	public boolean deleteChartByRegisterNo(int registerNo){
		Connection conn=null;
		Statement stmt=null;
		int result=0;
		String sql="delete from chart_tb where register_no="+registerNo;
		try {
			conn=base.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result!=0)
			return true;
		return false;
	}
	public boolean deleteChartByProgramContentNo(int programContentNo){
		Connection conn=null;
		Statement stmt=null;
		int result=0;
		String sql="delete from chart_tb where program_content_no="+programContentNo;
		try {
			conn=base.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result!=0)
			return true;
		else
			return false;
	}
	*/

	public ChartDTO selectChartVOByRegitserNO(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
