package com.example.web04.controller.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.web04.model.board.dto.BoardDTO;
import com.example.web04.service.board.BoardService;

@Controller
public class BoardController {

	@Inject
	BoardService boardService;  // BoardServiceImpl을 주입시킴
	
	@RequestMapping("board/board_list.do")
	public String board_list(Model model){
		// service 호출
		List<BoardDTO> items=boardService.boardList();
		// 모델에 자료저장
		model.addAttribute("list", items);
		//board_list.jsp로 포워딩되어 출력 됨
		return "board/board_list";
	}
	
	@RequestMapping("board/write.do")
	public String write(@ModelAttribute BoardDTO dto,
			HttpSession session, Model model){
		//입력 값이 없을 경우 write.jsp 로 이동
		if(dto.getSubject() == null){
			return "board/write";
		}else{
			// 입력 값이 있을 경우 
			// 파일 업로드
			String filename="";
		    long filesize=0;
		    MultipartFile file1=dto.getFile1();
		    
		    if(!dto.getFile1().isEmpty()){ //첨부 파일이 빈게 아니면, 즉 첨부 파일이 존재하면
		    	filename=file1.getOriginalFilename(); // 첨부파일 파일명
		        filesize=file1.getSize();             // 첨부파일 사이즈
		        
		        // 실제 파일이 저장 될 위치, 웹 경로는 사용하지 않는다. 누구나 접근 가능하기에...(중요)
		        String uploadDir="e:\\upload\\";     
		        try {
					new File(uploadDir).mkdir();
					// 임시디렉토리에 저장된 첨부파일을 지정된 디렉토리로 옮긴다.
					file1.transferTo(new File(uploadDir+filename));
				} catch (Exception e) {
					e.printStackTrace();
				}
		        
		    }
		    //사용자 아이디 입력
		    String id=(String)session.getAttribute("id");
		    dto.setUserid(id);
		    
		    dto.setFilename(filename);
		    dto.setFilesize(filesize);
		    // service 에 insert 요청
		    boardService.boardInsert(dto);
		    //list.do
			return "redirect:/board/board_list.do";
		}
	}
	
	@RequestMapping("board/down.do")
	public void down(@RequestParam int idx,
			HttpServletResponse response) throws Exception{
		// 다운로드 할 파일 이름 조회
		String filename=boardService.getFilename(idx);
		System.out.println("첨부파일 이름 : "+ filename);
		
		// 스트림을 이용하여 서버의 파일을 클라이언트에게 전송
		File file = new File("e:\\upload\\" + filename);
		
		// 파일의 header 정보 -- 지금부터 보내는 파일의 타입 정의
		response.setContentType("application/octet-stream");
		response.setContentLength((int) file.length());
		
		// 파일이름은 인코딩을 해야 함(한글파일명-한글처리)
		response.setHeader("Content-Disposition", 
				"attachment; fileName='"
				+ URLEncoder.encode(filename, "utf-8") + "';");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 실제 첨부 파일 전송
		OutputStream out=response.getOutputStream();
		FileInputStream fis=null;
		try {
			// 서버의 파일을 읽음
			fis=new FileInputStream(file);
			// 서버의 파일을 클라이언트로 전송
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis !=null){
				try {
					fis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		out.flush(); // 버퍼 비우기(다운로드 완료)
		
		// 다운로드 횟수 즉시 증가 처리 안됨
		boardService.downUp(idx);
		
		// download 하고 나서 down 횟수는 바로 증가하게끔 처리가 안됨.
		// request와 reponse 는 1:1
		// return "redirect:/board/board_list.do"
		// 클라이언트가 다운로드 해주세요 요청에 대해서 응답을 이미 해줬기 때문에
		// 요청 하나에 대해서 응답을 2개 해 줄 수 없다.
		//  
		// Cannot call sendRedirect() after the reponse has been committed
		// return "redirect:/board/board_list.do"
		
		// model.addAttribute("list", boardService.boardList());
		// return "board/board_list";
		// getOutputStream() has already been called for this response
		
	}
	
	
	
	
}
