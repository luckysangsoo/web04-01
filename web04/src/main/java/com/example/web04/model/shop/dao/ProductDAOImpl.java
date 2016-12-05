package com.example.web04.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.web04.model.shop.dto.ProductDTO;

//스프링 dao bean 으로 등록
@Repository
public class ProductDAOImpl implements ProductDAO {

	//mybatis bean을 주입(Inject)
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> productList() {
		List<ProductDTO> list=null;
		try {
			list=sqlSession.selectList("productList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProductDTO productDetail(int product_id) {
		ProductDTO dto=null;
		try {
			dto=sqlSession.selectOne("product_detail", product_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void productInsert(ProductDTO dto) {
		try {
			sqlSession.insert("productInsert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
