package com.example.web04.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web04.model.member.dao.MemberDAO;
import com.example.web04.model.member.dto.MemberDTO;

@Controller
public class MemberController {

	@Inject
	MemberDAO memberDao;
	
	@RequestMapping("member/login")
	public String login(String id, String passwd, Model model, HttpSession session){
		//입력 값이 없으면 login.jsp로 이동시킴
		if(id==null) return "member/login";
		
		//로그인 폼에 입력한 id,passwd가 @RequestParam 에 저장 됨
		System.out.println("login 호출.........");
		MemberDTO dto=memberDao.login(id, passwd);
		System.out.println(dto);
		if(dto==null){ //로그인 실패
			model.addAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "member/login";
		}else{ //로그인 성공
			//세션 저장
			session.setAttribute("id", id);
			session.setAttribute("name", dto.getName());
			//main.jsp 로 이동
			model.addAttribute("message", dto.getName()+"님 환영합니다.");
			return "main";
		}
		
	}
	
	@RequestMapping("member/logout")
	public String logout(HttpSession session, Model model){
		// 세션변수를 초기화 시킴
		session.invalidate();
		model.addAttribute("message", "로그아웃 되었습니다.");
		return "member/login";
	}
	
	
}
