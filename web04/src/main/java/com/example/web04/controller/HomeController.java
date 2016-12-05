package com.example.web04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String main(Model model){
		System.out.println("main.jsp 호출입니다....");
		model.addAttribute("message", "홈페이지 방문을 환영합니다");
		// WEB-INF/views/main.jsp. 로 포워딩
		return "main";
	}
}
