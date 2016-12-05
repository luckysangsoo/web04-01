package com.example.web04.model.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web04.model.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> boardlist() {
		List<BoardDTO> list=null;
		try {
			list=sqlSession.selectList("boardlist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void boardInsert(BoardDTO dto) {
		try {
			sqlSession.insert("boardInsert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String getFilename(int idx) {
		String filename="";
		try {
			filename=sqlSession.selectOne("getFilename", idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}

	@Override
	public void downUp(int idx) {
		try {
			sqlSession.update("downUp", idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
