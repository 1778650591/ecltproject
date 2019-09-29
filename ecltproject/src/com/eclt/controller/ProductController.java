package com.eclt.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclt.entity.EcProduct;
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
	
	
	@RequestMapping("/find")
	@ResponseBody
	public Collection<EcProduct> find(){
		return productService.findAll();
	}
}
