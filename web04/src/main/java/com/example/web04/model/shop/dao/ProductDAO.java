package com.example.web04.model.shop.dao;

import java.util.List;

import com.example.web04.model.shop.dto.ProductDTO;

public interface ProductDAO {

	public List<ProductDTO> productList(); //java.util.List
	public ProductDTO productDetail(int product_id);
	//상품등록
	public void productInsert(ProductDTO dto);
	
}
