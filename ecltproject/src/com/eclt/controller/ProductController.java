package com.eclt.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclt.entity.Product;
import com.eclt.service.EcProductService;
/**
 * 
 * @author asus
 * 产品页面数据
 */
@Controller
public class ProductController {

	@Resource
	private EcProductService productService;
	
	
	@RequestMapping("/getProductById")
	@ResponseBody
	public List<Product> getProductById(Integer id){
		return productService.getProductById(id);
	}
	
	
	
}
