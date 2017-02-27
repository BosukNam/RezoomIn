package com.omazing.resume.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.AwardDTO;
import com.omazing.resume.dto.LanguageExamDTO;
/**
 * 수상경력 DAO
 * @author Jun Seop
 *
 */
@Repository
public class AwardDAO implements Serializable{
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	private SqlSession session;
	/**
	 * 기본 생성자
	 * 
	 */
	public AwardDAO() {
	}
	/**
	 * DB에 수상경력 추가하는 메서드
	 * @param awardDTO(DB에 저장할 데이터 전송 VO)
	 * @return 저장 성패 여부(boolean)
	 */
	public boolean insertAward(AwardDTO awardDTO){
		System.out.println(awardDTO);
		session.insert("AwardMapper.insertAward", awardDTO);
		boolean res = true;
		return res;
	}
	/**
	 * DB에 가장 최근 등록된 수상 경력의 등록 번호 가져오는 메서드
	 * @return 가장 최근 저장된 등록번호(int)
	 */
	public int getNewRegisterNo(){
		int registerNo = session.selectOne("AwardMapper.nextAwardNo");
		return registerNo;
	}
	/**
	 * DB에서 수정할 수상 경력의 데이터 수정 메서드
	 * @param awardDTO(DB에서 수정할 대상의 수정 내용 데이터 VO)
	 * @return 수정 성패 여부(boolean)
	 */
	public boolean updateAward(AwardDTO awardDTO){
		boolean res = false;
		session.update("AwardMapper.updateAward", awardDTO);
		res = true;
		return res;
	}
	/**
	 * DB에서 수상 경력 삭제하는 메서드
	 * @param memberID (삭제할 수상 경력 정보 가진 사용자 식별 정보)
	 * @param registerNo (삭제할 수상 경력의 등록 번호)
	 * @return 삭제 성패 여부(boolean)
	 */
	public boolean deleteAward(String memberID, int registerNo){
		Map target = new HashMap();
		target.put("id", memberID);
		target.put("registerNo", registerNo);
		
		boolean res = false;
		session.delete("AwardMapper.deleteAward", target);
		res = true;
		return res;
	}
	/**
	 * 사용자 식별 정보에 따른 전체 수상 경력 정보 가져오는 메서드
	 * @param memberID(수상 경력 정보 가져올 사용자 식별 정보)
	 * @return AwardDTO[](사용자의 전체 수상 경력 정보)
	 */
	public AwardDTO[] selectAwardAll(String memberID){
		List<AwardDTO>list =  session.selectList(
				"AwardMapper.selectAwardAll", memberID);
		AwardDTO[] res = new AwardDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new AwardDTO(list.get(i).getCategory(), 
					list.get(i).getField(), 
					list.get(i).getTarget(),
					list.get(i).getName(),
					list.get(i).getDate(),
					list.get(i).getPublication(),
					list.get(i).getContent(),
					list.get(i).getRegisterNo(), memberID);
		}
		return res;
	}
	
}
