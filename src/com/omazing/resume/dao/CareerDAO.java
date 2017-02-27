package com.omazing.resume.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.CareerDTO;
/**
 * 직무 경력 DAO
 * @author Jun Seop
 *
 */
@Repository
public class CareerDAO implements Serializable {
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	private SqlSession session;
	/**
	 * 기본 생성자
	 */
	public CareerDAO() {
	}
	/**
	 * DB에 직무 경력 추가하는 메서드
	 * @param CareerDTO(DB에 저장할 데이터 전송 VO)
	 * @return 저장 성패 여부(boolean)
	 */
	public boolean insertCareer(CareerDTO careerDTO){
		System.out.println(careerDTO);
		session.insert("CareerMapper.insertCareer", careerDTO);
		boolean res = true;
		return res;
	}
	/**
	 * DB에 새로 저장한 직무 경력의 등록 번호 가져오는 메서드
	 * @return 가장 최근 저장된 등록번호(int)
	 */
	public int getNewRegisterNo(){
		int registerNo = session.selectOne("CareerMapper.nextCareerNo");
		return registerNo;
	}
	/**
	 * DB에서 수정할 직무 경력의 데이터 수정 메서드
	 * @param CareerDTO(DB에서 수정할 대상의 수정 내용 데이터 VO)
	 * @return 수정 성패 여부(boolean)
	 */
	public boolean updateCareer(CareerDTO careerDTO){
		boolean res = false;
		session.update("CareerMapper.updateCareer", careerDTO);
		res = true;
		return res;
	}
	/**
	 * DB에서 직무 경력 삭제하는 메서드
	 * @param memberID (삭제할 직무 경력 정보 가진 사용자 식별 정보)
	 * @param registerNo (삭제할 직무 경력의 등록 번호)
	 * @return 삭제 성패 여부(boolean)
	 */
	public boolean deleteCareer(String memberID, int registerNo){
		Map target = new HashMap();
		target.put("id", memberID);
		target.put("registerNo", registerNo);
		
		boolean res = false;
		session.delete("CareerMapper.deleteCareer", target);
		res = true;
		return res;
	}
	/**
	 * 사용자 식별 정보에 따른 전체 직무 경력 정보 가져오는 메서드
	 * @param memberID(직무 경력 정보 가져올 사용자 식별 정보)
	 * @return CareerDTO[](사용자의 전체 직무 경력 정보)
	 */
	public CareerDTO[] selectCareerAll(String memberID){
		List<CareerDTO>list =  session.selectList(
				"CareerMapper.selectCareerAll", memberID);
		CareerDTO[] res = new CareerDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new CareerDTO(list.get(i).getName(), 
					list.get(i).getStartDate(), 
					list.get(i).getEndDate(), 
					list.get(i).getPosition(), 
					list.get(i).getDepartment(), 
					list.get(i).getTask(), 
					list.get(i).getRetirementReason(), 
					list.get(i).getRegisterNo(), memberID);
		}
		return res;
	}
}
