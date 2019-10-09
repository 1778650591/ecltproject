package com.eclt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclt.entity.EcCompany;
import com.eclt.service.EcCompanyService;

@Controller
public class CompanyController {

	@Resource
	private EcCompanyService companyService;
	
	@RequestMapping("/getCompanyById")
	@ResponseBody
	public EcCompany getCompanyById(Integer id){
		return companyService.getCompanyById(id);
	}
}
