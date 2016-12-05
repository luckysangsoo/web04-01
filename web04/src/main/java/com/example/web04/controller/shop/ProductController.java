package com.example.web04.controller.shop;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web04.model.shop.dao.ProductDAO;
import com.example.web04.model.shop.dto.ProductDTO;

//@Controller를 붙여야만 스프링에서 관리하는 bean으로 등록 됨
@Controller
public class ProductController {

	@Inject
	ProductDAO productDao;
	
	@RequestMapping("shop/product_write")
	public String product_write(@ModelAttribute ProductDTO dto, Model model){
		//입력값이 없을 때
		if(dto.getProduct_name() == null){
			return "/shop/product_write";	
		}else{
			
			//파일업로드 처리
			String filename="";
			//업로드할 파일이 존재하면
			if(!dto.getFile1().isEmpty()){
				//업로드할 파일 원본이름
				filename=dto.getFile1().getOriginalFilename();
				System.out.println(filename);
				/*String path="업로드할 파일의 경로";*/
				//String path="E:\\sooJSP\\web04\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				//E:\sooJSP\web04\src\main\webapp\WEB-INF\views\images
				String path="E:\\workspace-sts-3.8.2.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\web04\\WEB-INF\\views\\images\\";
				try {
					//존재하지 않는 디렉토리인 경우 생성
					new File(path).mkdir();
					//임시파일을 지정된 디렉토리로 이동
					dto.getFile1().transferTo(new File(path+filename));
					System.out.println(dto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} //if
			//테이블에 insert
			//이미지 파일 이름 저장
			dto.setPicture_url(filename);
			System.out.println("product insert 00 를 호출.....");
			// dao애 insert 처리 
			productDao.productInsert(dto);
			System.out.println("product insert 01 를 호출.....");
			// 상품 목록 갱신을 위해 컨트롤러로 이동
			return "redirect:/shop/product_list";
		} //else
		
	}
	
	
	@RequestMapping("shop/product_list")
	public String product_list(Model model){
		System.out.println("product_list를 호출 했습니다.");
		List<ProductDTO> items=productDao.productList();
		// 모델에 저장
		model.addAttribute("list", items);
		// WEB-INF/views/shop/product_list.jsp로 포워딩
		return "shop/product_list";
	}
	
	
	@RequestMapping("shop/product_detail")
	public String product_detail(@RequestParam int product_id, Model model){
		// product_code에 상품코드가 저장 됨
		// dao 자료 요청
		ProductDTO dto=productDao.productDetail(product_id);
		model.addAttribute("dto", dto);
		
		// WEB-INF/views/shop/product_detail.jsp로 포워딩
		return "shop/product_detail";
	}
	
}
