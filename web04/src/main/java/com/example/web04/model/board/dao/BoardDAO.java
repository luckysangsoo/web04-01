package com.example.web04.model.board.dao;

import java.util.List;

import com.example.web04.model.board.dto.BoardDTO;

public interface BoardDAO {

	public List<BoardDTO> boardlist();
	public void boardInsert(BoardDTO dto);
	// 첨부 파일 이름 조회
	public String getFilename(int idx);
	
	//다운로드 횟수 증가
	public void downUp(int idx);
	
	
}
