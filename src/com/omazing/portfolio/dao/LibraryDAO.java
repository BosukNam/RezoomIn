package com.omazing.portfolio.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.portfolio.dto.LibraryDTO;

@Repository
public class LibraryDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Autowired
	private SqlSession sqlSession;

	public LibraryDAO() {
	}
	
/*	
	public int insertLibrary(LibraryDTO libraryDTO){
		try{
			sqlSession "insert into library_tb values(library_seq.NEXTVAL, '"+
						data[1]+"','"+data[2]+"','"+data[3]+"')";
			check=stmt.executeUpdate(sql);
			if(check!=0){
				rs=stmt.executeQuery("select *from (select * from(select rownum rnum, register_no, member_id "
	                   + "from (select * from library_tb order by register_no desc)) where rnum <=1) where rnum >=1");   
	            rs.next();
	            num = rs.getInt("register_no");
	            System.out.println(num);
	         }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			base.closeDBObjects(null, stmt, conn);
		}
		return num;
	}
	public boolean deleteLibrary(int registerNo){
		Statement stmt=null;
		Connection conn=null;
		int result=0;
		String order="delete from library_tb where register_no = "+registerNo+"";
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(order);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);
		}
		if(result!=0){	
			return true;
		}
		return false;
	}
	public String selectPictureByID(String memberID){
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		//�뀒�씠釉� 議댁옱�븯吏� �븡�뒗寃쎌슦
		String picture = null;
		//�뀒�씠釉� 議댁옱�븷 寃쎌슦
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select picture from library_tb where member_id="+"'"+memberID+"'");
			
			rs.next();
			picture =rs.getString("picture");		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			base.closeDBObjects(rs, stmt, conn);
		}
		return picture;
	}
	public boolean updateLibrary(LibraryDTO libraryDTO){
		Statement stmt=null;
		Connection conn=null;
		int result=0;
		String order="update library_tb set content='"+libraryDTO.getContent()+"', picture='"+libraryDTO.getPicture()+"'"
				+ "where register_no="+libraryDTO.getRegisterNo()+" and member_id='"+libraryDTO.getMemberID()+"'";
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(order);	
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);;
		}
		if(result !=0){			
			return true;
		}
		return false;
	}
	public boolean updateContent(LibraryDTO libraryDTO){
		Statement stmt=null;
		Connection conn=null;
		int result=0;
		String order="update library_tb set content='"+libraryDTO.getContent()+"'"
				+ "where register_no="+libraryDTO.getRegisterNo()+" and member_id='"+libraryDTO.getMemberID()+"'";
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(order);	
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			base.closeDBObjects(null, stmt, conn);;
		}
		if(result !=0){			
			return true;
		}
		return false;
	}
	
	public LibraryDTO selectLibraryByID(String memberID){
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		//�뀒�씠釉� 議댁옱�븯吏� �븡�뒗寃쎌슦
		
		//�뀒�씠釉� 議댁옱�븷 寃쎌슦
		try {
			conn=base.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from library_tb where member_id="+"'"+memberID+"'");
			
			rs.next();
			int registerNo =rs.getInt("register_no");
			String content =rs.getString("content");
			String picture =rs.getString("picture");
			return new LibraryDTO(registerNo,memberID,picture,content);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			base.closeDBObjects(rs, stmt, conn);
		}
		return null;
	}
	*/
}
