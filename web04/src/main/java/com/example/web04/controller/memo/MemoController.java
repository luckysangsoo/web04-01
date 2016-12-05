package com.example.web04.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web04.model.memo.dao.MemoDAO;
import com.example.web04.model.memo.dto.MemoDTO;

@Controller
public class MemoController {
    //Repository로 등록된 MemoDAOImpl 객체를 스프링에서 생성하어 주입시킴.
	@Inject
	MemoDAO memoDao;
		
	@RequestMapping("memo/list")
	public String list(Model model){
		//WEB-INF/views/memo/memo.jsp 로 이동
		return "memo/memo1";
	}
	
	@RequestMapping("memo/memo_list")
	public String memo_list(Model model){
		// dao 호출
		List<MemoDTO> items=memoDao.memoList();
		// 모델에 자료 저장
		model.addAttribute("list", items);
		// memo_list.jsp로 포워딩하여 결과가 출력됨
		// 출력된 결과는 memo.jsp의 success function으로 리턴 됨.
		return "memo/memo_list";
	}
	
	@RequestMapping("/memo/memo_add")
	public String memo_add(@ModelAttribute MemoDTO dto, Model model){
		// 사용자가 입력한 데이터가 ModelAttribute에  자동으로  저장됨
		// request.getParameter()를 호출하지 않아도 됨.
		// dao에 insert요청
		System.out.println("입력" + dto);
		memoDao.memoInsert(dto);
		
		return "redirect:/memo/list";
	}
	
}
