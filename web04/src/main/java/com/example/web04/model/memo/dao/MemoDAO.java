package com.example.web04.model.memo.dao;

import java.util.List;

import com.example.web04.model.memo.dto.MemoDTO;

public interface MemoDAO {

	public List<MemoDTO> memoList();
	public void memoInsert(MemoDTO dto);
	
}
