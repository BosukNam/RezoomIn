package com.omazing.resume.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.ActivityDTO;
import com.omazing.resume.dto.AwardDTO;
/**
 * 대외활동 DAO
 * @author Jun Seop
 *
 */

@Repository
public class ActivityDAO implements Serializable {
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	private SqlSession session;
	/**
	 * 기본 생성자
	 */
	public ActivityDAO() {
	}
	/**
	 * DB에 대외 활동 추가하는 메서드
	 * @param activityDTO(DB에 저장할 데이터 전송 VO)
	 * @return 저장 성패 여부(boolean)
	 */
	public boolean insertActivity(ActivityDTO activityDTO){
		System.out.println(activityDTO);
		session.insert("ActivityMapper.insertActivity", activityDTO);
		boolean res = true;
		return res;
	}
	/**
	 * DB에 새로 저장한 대외 활동의 등록 번호 가져오는 메서드
	 * @return 가장 최근 저장된 등록번호(int)
	 */
	public int getNewRegisterNo(){
		int registerNo = session.selectOne("ActivityMapper.nextActivityNo");
		return registerNo;
	}
	/**
	 * DB에서 수정할 대외 활동의 데이터 수정 메서드
	 * @param activityDTO(DB에서 수정할 대상의 수정 내용 데이터 VO)
	 * @return 수정 성패 여부(boolean)
	 */
	public boolean updateActivity(ActivityDTO activityDTO){
		boolean res = false;
		session.update("ActivityMapper.updateActivity", activityDTO);
		res = true;
		return res;
	}
	/**
	 * DB에서 대외 활동 삭제하는 메서드
	 * @param memberID (삭제할 대외 활동 정보 가진 사용자 식별 정보)
	 * @param registerNo (삭제할 대외 활동의 등록 번호)
	 * @return 삭제 성패 여부(boolean)
	 */
	public boolean deleteActivity(String memberID, int registerNo){
		Map target = new HashMap();
		target.put("id", memberID);
		target.put("registerNo", registerNo);
		
		boolean res = false;
		session.delete("ActivityMapper.deleteActivity", target);
		res = true;
		return res;
	}
	/**
	 * 사용자 식별 정보에 따른 전체 대외 활동 정보 가져오는 메서드
	 * @param memberID(대외 활동 정보 가져올 사용자 식별 정보)
	 * @return ActivityDTO[](사용자의 전체 대외 활동 정보)
	 */
	public ActivityDTO[] selectActivityAll(String memberID){
		List<ActivityDTO>list =  session.selectList(
				"ActivityMapper.selectActivityAll", memberID);
		ActivityDTO[] res = new ActivityDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new ActivityDTO(list.get(i).getCategory(), 
					list.get(i).getStartDate(), 
					list.get(i).getEndDate(),
					list.get(i).getContent(),
					list.get(i).getRegisterNo(), memberID);
		}
		return res;
	}


}
