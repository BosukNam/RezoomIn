package com.omazing.resume.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omazing.resume.dto.CareerDTO;
import com.omazing.resume.dto.CertificateDTO;
import com.omazing.resume.dto.LanguageExamDTO;
/**
 * 자격증 DAO
 * @author Jun Seop
 *
 */
@Repository
public class LanguageExamDAO {
	/**
	 * Mybatis 연동을 위한 SqlSession 객체
	 */
	@Autowired
	private SqlSession session;
	/**
	 * 기본 생성자
	 */
	public LanguageExamDAO() {
	}
	/**
	 * DB에 어학시험 추가하는 메서드
	 * @param LanguageExamDTO(DB에 저장할 데이터 전송 VO)
	 * @return 저장 성패 여부(boolean)
	 */

	public boolean insertLanguageExam(LanguageExamDTO languageExamDTO){
		System.out.println(languageExamDTO);
		session.insert("LanguageExamMapper.insertLanguageExam", languageExamDTO);
		boolean res = true;
		return res;
	}
	/**
	 * DB에 새로 저장한 어학시험의 등록 번호 가져오는 메서드
	 * @return 가장 최근 저장된 등록번호(int)
	 */
	public int getNewRegisterNo(){
		int registerNo = session.selectOne("LanguageExamMapper.nextLanguageExamNo");
		return registerNo;
	}
	/**
	 * DB에서 수정할 어학시험의 데이터 수정 메서드
	 * @param LanguageExamDTO(DB에서 수정할 대상의 수정 내용 데이터 VO)
	 * @return 수정 성패 여부(boolean)
	 */

	public boolean updateLanguageExam(LanguageExamDTO languageExamDTO){
		boolean res = false;
		session.update("LanguageExamMapper.updateLanguageExam", languageExamDTO);
		res = true;
		return res;
	}
	/**
	 * DB에서 어학시험 삭제하는 메서드
	 * @param memberID (삭제할 어학시험 정보 가진 사용자 식별 정보)
	 * @param registerNo (삭제할 어학시험의 등록 번호)
	 * @return 삭제 성패 여부(boolean)
	 */
	public boolean deleteLanguageExam(String memberID, int registerNo){
		Map target = new HashMap();
		target.put("id", memberID);
		target.put("registerNo", registerNo);
		
		boolean res = false;
		session.delete("LanguageExamMapper.deleteLanguageExam", target);
		res = true;
		return res;
	}
	/**
	 * 사용자 식별 정보에 따른 전체 어학 시험 정보 가져오는 메서드
	 * @param memberID(어학 시험 정보 가져올 사용자 식별 정보)
	 * @return LanguageExamDTO[](사용자의 전체 어학 시험 정보)
	 */
	public LanguageExamDTO[] selectLanguageExamAll(String memberID){
		List<LanguageExamDTO>list =  session.selectList(
				"LanguageExamMapper.selectLanguageExamAll", memberID);
		LanguageExamDTO[] res = new LanguageExamDTO[list.size()];
		for(int i = 0 ; i < res.length; ++i){
			res[i] = new LanguageExamDTO(list.get(i).getName(), 
					list.get(i).getDate(), 
					list.get(i).getGrade(),
					list.get(i).getRegisterNo(), memberID);
		}
		return res;
	}
	
}
