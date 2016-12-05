package com.example.web04.model.member.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web04.model.member.dto.MemberDTO;

//현재 클래스를 스프링에서 관리하는 dao bean으로 등록 됨.
@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public MemberDTO login(String id, String passwd) {
		MemberDTO dto=null;
		try {
			// mybatis애 전달되는 값은 1개만 가능하므로 map으로 포장
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("passwd", passwd);
			dto=sqlSession.selectOne("login", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
