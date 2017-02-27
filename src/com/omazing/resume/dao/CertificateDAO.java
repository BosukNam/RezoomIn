package com.omazing.resume.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.CertificateDTO;
import com.omazing.resume.dto.CertificateDTO;
/**
 * 자격증 DAO
 * @author Jun Seop
 *
 */
@Repository
public class CertificateDAO implements Serializable{
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	private SqlSession session;
	/**
	 * 기본 생성자
	 */
	public CertificateDAO() {
	}
	/**
	 * DB에 자격증 추가하는 메서드
	 * @param CertificateDTO(DB에 저장할 데이터 전송 VO)
	 * @return 저장 성패 여부(boolean)
	 */
	public boolean insertCertificate(CertificateDTO certificateDTO){
		System.out.println(certificateDTO);
		session.insert("CertificateMapper.insertCertificate", certificateDTO);
		boolean res = true;
		return res;
	}
	/**
	 * DB에 새로 저장한 자격증의 등록 번호 가져오는 메서드
	 * @return 가장 최근 저장된 등록번호(int)
	 */
	public int getNewRegisterNo(){
		int registerNo = session.selectOne("CertificateMapper.nextCertificateNo");
		return registerNo;
	}
	/**
	 * DB에서 수정할 자격증의 데이터 수정 메서드
	 * @param CertificateDTO(DB에서 수정할 대상의 수정 내용 데이터 VO)
	 * @return 수정 성패 여부(boolean)
	 */
	public boolean updateCertificate(CertificateDTO certificateDTO){
		boolean res = false;
		session.update("CertificateMapper.updateCertificate", certificateDTO);
		res = true;
		return res;
	}
	/**
	 * DB에서 자격증 삭제하는 메서드
	 * @param memberID (삭제할 자격증 정보 가진 사용자 식별 정보)
	 * @param registerNo (삭제할 자격증의 등록 번호)
	 * @return 삭제 성패 여부(boolean)
	 */
	public boolean deleteCertificate(String memberID, int registerNo){
		Map target = new HashMap();
		target.put("id", memberID);
		target.put("registerNo", registerNo);
		
		boolean res = false;
		session.delete("CertificateMapper.deleteCertificate", target);
		res = true;
		return res;
	}
	/**
	 * 사용자 식별 정보에 따른 전체 자격증 정보 가져오는 메서드
	 * @param memberID(자격증 정보 가져올 사용자 식별 정보)
	 * @return ActivityDTO[](사용자의 전체 자격증 정보)
	 */
	public CertificateDTO[] selectCertificateAll(String memberID){
		List<CertificateDTO>list =  session.selectList(
				"CertificateMapper.selectCertificateAll", memberID);
		CertificateDTO[] res = new CertificateDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new CertificateDTO(list.get(i).getName(), 
					list.get(i).getDate(), 
					list.get(i).getPublication(),  
					list.get(i).getRegisterNo(), memberID);
		}
		return res;
	}
}
