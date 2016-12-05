package com.example.web04.model.memo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web04.model.memo.dto.MemoDTO;

@Repository //스프링에서 관리하는 dao bean으로 등록 됨.
public class MemoDAOImpl implements MemoDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemoDTO> memoList() {
		List<MemoDTO> list=null;
		try {
			list=sqlSession.selectList("memoList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void memoInsert(MemoDTO dto) {
		try {
			System.out.println("MemoDAOImpl : " + dto);
			sqlSession.insert("memoInsert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
