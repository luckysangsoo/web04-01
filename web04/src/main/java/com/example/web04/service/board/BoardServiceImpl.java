package com.example.web04.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.web04.model.board.dao.BoardDAO;
import com.example.web04.model.board.dto.BoardDTO;

@Service // 현재 클래스를 스프링 서비스 빈으로 등록시킴
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao; //BoardDAOImpl 인스턴스를 생성하여 주입시킴
	
	@Override
	public List<BoardDTO> boardList() {
		return boardDao.boardlist();
	}

	@Override
	public void boardInsert(BoardDTO dto) {
		boardDao.boardInsert(dto);
		
	}

	@Override
	public String getFilename(int idx) {
		return boardDao.getFilename(idx);
		
	}

	@Override
	public void downUp(int idx) {
		boardDao.downUp(idx);
		
	}

	
}
