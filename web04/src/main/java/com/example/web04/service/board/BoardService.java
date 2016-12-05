package com.example.web04.service.board;

import java.util.List;

import com.example.web04.model.board.dto.BoardDTO;

public interface BoardService {

	public List<BoardDTO> boardList();
	public void boardInsert(BoardDTO dto);
	public String getFilename(int idx);
	public void downUp(int idx);
	
	
}
