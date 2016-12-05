package com.example.web04.model.member.dao;

import com.example.web04.model.member.dto.MemberDTO;

public interface MemberDAO {

	public MemberDTO login(String id, String passwd);
}
