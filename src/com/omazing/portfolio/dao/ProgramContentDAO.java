package com.omazing.portfolio.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.ChartDTO;
import com.omazing.portfolio.dto.ProgramContentCategoryDTO;
import com.omazing.portfolio.dto.ProgramContentDTO;

@Repository
public class ProgramContentDAO{
	
	
	@Autowired
	private SqlSession session;
  // private Map<Integer, ProgramContentDTO> programIntro;
  // private BaseDAO base=null;
   public ProgramContentDAO() {
      //base=new BaseDAO();
      //programIntro=new HashMap<Integer, ProgramContentDTO>();
   }

   public boolean insertChart(ChartDTO chart, int programContentNo){
	
		int check=session.insert("",chart);
	    if(check!=0)
	    	return true;
		return false;
   }
   
 
   public int selectLatestRegisterNo(int projectNo, String category){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("project_no", projectNo);
		map.put("category", category);
		
		List<Integer> nums=session.selectList("PortfolioProjectMapper.selectLatestRegisterNoOfProgramContent", map);
		if(nums!=null && !nums.isEmpty()){
			System.out.println(nums.get(0));
			return nums.get(0);
		}
		return 0;

   }
   /*
   public boolean deleteProgramContentByRegisterNo(int registerNo){
      Statement stmt=null;
      Connection conn=null;
      int result=0;
      String sql="delete from program_content_tb where register_no = "+registerNo;
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
   public int deleteProgramContentByProjectNo(int projectNo){
     Statement stmt = null;
     Connection conn = null;
     int result = 0;
     String sql = "delete from program_content_tb where project_no = "+ projectNo;
     try {
        conn = base.getConnection();
        stmt = conn.createStatement();
        result = stmt.executeUpdate(sql);
     } catch (SQLException e) {
        e.printStackTrace();
     } catch (Exception e) {
        e.printStackTrace();
     } finally {
        base.closeDBObjects(null, stmt, conn);
     }
     return result;
   }
   public boolean deleteChart(int programContentNo){
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
   public boolean updateChartRegisterNo(int programContentNo, int registerNo){
	   Statement stmt=null;
	   Connection conn=null;
	   int result=0;
	   String sql="update program_content_tb set chart_no="+registerNo
			   		+"where program_content_no="+programContentNo;
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
   public boolean deleteProgramIntroContent(String memberID, int registerNo, String content){
      return true;
   }
   public boolean deleteProgramIntroPicture(String memberID, int registerNo, String picture){
      return true;
   }
   public boolean updateProgramContent(ProgramContentDTO programContentDTO){
      Statement stmt=null;
      Connection conn=null;
      String[] data=programContentDTO.getAll();
      int result=0;
      String sql="update program_content_tb set program_content_image='"+data[2]
            + "', content='"+data[3]+"', is_chart='"+data[4]+"', category='"+data[5]
            + "' where register_no="+data[0]+" and project_no="+data[1];
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
   public boolean updateProgramIntroPicture(String memberID, int registerNo, String picture){
      return true;
   }
   public boolean updateProgramIntroContent(String memberID, int registerNo, String content){
      return true;
   }
   public Map<Integer, ProgramContentDTO> selectProgramContentByProjectNo(int projectNo){
           Statement stmt=null;
         ResultSet rs=null;
         Connection conn=null;
         Map<Integer, ProgramContentDTO> pc=null;
         try {
            conn=base.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select register_no, program_content_image, content, is_chart, category, content_category"
                           + " from program_content_tb pc"
                           + " join program_content_category_tb pcc"
                           + " on pc.category=pcc.code"
                           + " where project_no="+projectNo);
            if(rs.next()){
                 pc=new HashMap<Integer, ProgramContentDTO>();
              do{
                  int registerNo =rs.getInt("register_no");
                  String programContentImage =rs.getString("program_content_image");
                  String content =rs.getString("content");
                  String isChart = rs.getString("is_chart");
                  String category=rs.getString("category");        
                  String pccCategory=rs.getString("content_category");
                  pc.put(registerNo, new ProgramContentDTO(registerNo,projectNo,programContentImage,content,isChart,new ProgramContentCategoryDTO(category,pccCategory)));
              }while(rs.next());
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
         } finally{
            base.closeDBObjects(rs, stmt, conn);
         }
         return pc; 
   }
   public Map<Integer, ProgramContentDTO> selectProgramContentByProjectNo(int projectNo, ProgramContentCategoryDTO category){
      Statement stmt=null;
      ResultSet rs=null;
      Connection conn=null;
      Map<Integer, ProgramContentDTO> pc=null;
      try {
         conn=base.getConnection();
         stmt=conn.createStatement();
         rs=stmt.executeQuery("select register_no, program_content_image, content, is_chart"
                        + " from program_content_tb pc"
                        + " join program_content_category_tb pcc"
                        + " on pc.category=pcc.code"
                        + " where project_no="+projectNo+" and category='"+category.getCode()+"'");
            if(rs.next()){
              pc=new HashMap<Integer, ProgramContentDTO>();
              do{
                  int registerNo =rs.getInt("register_no");
                  String programContentImage =rs.getString("program_content_image");
                  String content =rs.getString("content");
                  String isChart = rs.getString("is_chart");
                  //programIntro.put(registerNo, new ProgramContentDTO(registerNo,memberID, picture, content, contentCategory));         
                 pc.put(registerNo, new ProgramContentDTO(registerNo,projectNo,programContentImage,content,isChart,category));
              }while(rs.next());
            }
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally{
         base.closeDBObjects(rs, stmt, conn);
      }
      return pc;
   }
   public ProgramContentDTO selectProgramContentByRegisterNo(int registerNo){
       Statement stmt=null;
       ResultSet rs=null;
       Connection conn=null;
       ProgramContentDTO pc=null;
       try {
            conn=base.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select project_no, program_content_image, content, is_chart, category, content_category"
                           + " from program_content_tb pc"
                           + " join program_content_category_tb pcc"
                           + " on pc.category=pcc.code"
                           + " where register_no="+registerNo);
            
           if(rs.next()){
              int projectNo =rs.getInt("project_no");
               String programContentImage =rs.getString("program_content_image");
               String content =rs.getString("content");
               String isChart = rs.getString("is_chart");
               String category=rs.getString("category");
               String pccCategory=rs.getString("content_category");
              pc = new ProgramContentDTO(registerNo,projectNo,programContentImage,content,isChart,new ProgramContentCategoryDTO(category,pccCategory));
            }
         } catch (SQLException e) {
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
         } finally{
            base.closeDBObjects(rs, stmt, conn);
         }
         return pc;
   }
   
   */
}