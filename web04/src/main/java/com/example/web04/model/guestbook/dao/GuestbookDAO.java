package com.example.web04.model.guestbook.dao;

import java.util.List;

import com.example.web04.model.guestbook.dto.GuestbookDTO;

public interface GuestbookDAO {

	public List<GuestbookDTO> gbList();
	public int gbInsert(GuestbookDTO dto);
	public int pwdCheck(int idx, String passwd);
	public GuestbookDTO gbDetail(int idx);
	public int gbUpdate(GuestbookDTO dto);
	public int gbDelete(int idx);
}
