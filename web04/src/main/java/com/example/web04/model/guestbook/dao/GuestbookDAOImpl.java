package com.example.web04.model.guestbook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web04.model.guestbook.dto.GuestbookDTO;

// 저장소, DAO - 데이터베이스 연동 관련 작업
@Repository
public class GuestbookDAOImpl implements GuestbookDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<GuestbookDTO> gbList() {
		List<GuestbookDTO> list=null;
		try {
			list=sqlSession.selectList("gbList");
			//줄 바꿈 처리
			for(GuestbookDTO dto : list){
			String content=dto.getContent();
			//문자열.replace(A,B) 문자열 내부의 A를 B로 변경
			content=content.replace("\n", "<br>");
			// 공백문자 2칸 처리
			content=content.replace("  ", "&nbsp;&nbsp");
			// 태그 방지 처리
			// <xmp> 태그, 해석 시도
			content=content.replace("<", "&lt"); //Less Than
			content=content.replace(">", "&gt"); //Greater Than
			dto.setContent(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int gbInsert(GuestbookDTO dto) {
		int result=0;
		try {
			//insert 가 성공하면 affected rows가 리턴 됨
			//affected rows : insert query의 영향을 받은 레코드의 수
			result=sqlSession.insert("gbInsert", dto);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int pwdCheck(int idx, String passwd) {
		int result=0;
		try {
			//mybatis 에 전달한 값이 2개 이상인 경우 dto 또는 map으로 전달
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("idx", idx);
			map.put("passwd", passwd);
			result=sqlSession.selectOne("pwdCheck", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public GuestbookDTO gbDetail(int idx) {
		GuestbookDTO dto=null;
		try {
			dto=sqlSession.selectOne("gbDetail", idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int gbUpdate(GuestbookDTO dto) {
		int result=0;
		//affected rows(영향을 받은 행의 수)가 리턴 됨.
		try {
			result=sqlSession.update("gbUpdate", dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int gbDelete(int idx) {
		int result=0;
		try {
			result=sqlSession.delete("gbDelete", idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
