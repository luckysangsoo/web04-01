package com.example.web04.controller.guestbook;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web04.model.guestbook.dao.GuestbookDAO;
import com.example.web04.model.guestbook.dto.GuestbookDTO;

@Controller
public class GuestbookController {

	@Inject
	GuestbookDAO guestbookDao;
	
	@RequestMapping("/guestbook/update")
	public String update(@ModelAttribute GuestbookDTO dto){
		//폼에서 입력한 자료가 dto에 저장 됨
		guestbookDao.gbUpdate(dto);
		//dao애 update 요청
		
		//
		return "redirect:/guestbook/list"; //루트 디렉토리 기준
	}
	
	@RequestMapping("/guestbook/delete")
	public String delete(@ModelAttribute GuestbookDTO dto){
		guestbookDao.gbDelete(dto.getIdx());
		return "redirect:/guestbook/list"; //루트 디렉토리 기준
	}
	
	
	@RequestMapping("/guestbook/view")
	public String view(int idx, String passwd, Model model){
		// 비밀번호가 맞는 지 체크
		int result=guestbookDao.pwdCheck(idx, passwd);
		if(result==1){
			// 맞으면 view.jsp로 이동(수정/삭제 화면)
			//모델에 dto를 저장함
			System.out.println("비밀 번호가 맞습니다.");
			model.addAttribute("dto", guestbookDao.gbDetail(idx));
			return "guestbook/view";
		}else{
			//틀리면 list.jsp로 되돌아감.
			System.out.println("비밀 번호가 틀립니다.");
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "redirect:/guestbook/list";
		}
	}
	
	
	//사용자가 입력한 내용이 @ModelAttribute GuestbookDTO dto에 저장 됨
	@RequestMapping("guestbook/write")
	public String writer(@ModelAttribute GuestbookDTO dto, Model model){
		
		if(dto.getName() == null) { 
			/*WEB-INF/views/guestbook/write.jsp로 넘어 감(초기).*/
			return "guestbook/write";
		}
		else {
			//테이블 insert
			System.out.println("방영록 write----");
			guestbookDao.gbInsert(dto);			
			//목록 갱신
			// redirect:guestbook/list 현재 디렉토리 기준
			// redirect:/guestbook/list 루트 디렉토리 기준
			return "redirect:/guestbook/list";
		}
		
	}
	
	
	@RequestMapping("/guestbook/list")
	public void list(Model model){
		List<GuestbookDTO> list;
		
		System.out.println("방명록이 호출되었습니다.");
		list=guestbookDao.gbList();
		System.out.println(list.toString());
		model.addAttribute("items", list);
		model.addAttribute("count", list.size());
		// WEB-INF/views/guestbook/list.jsp 로 호출
	}
	
	

}
