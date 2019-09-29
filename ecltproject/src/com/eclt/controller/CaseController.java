package com.eclt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclt.entity.EcCase;
import com.eclt.service.EcCaseService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 案例
 * @author hkd
 *
 */
@Controller
public class CaseController {

	@Resource
	private EcCaseService caseService;
	
	@RequestMapping("/findCaseAll")
	@ResponseBody
	public List<EcCase> findCaseAll(){
		return caseService.findCaseAll();
	}
	
	@RequestMapping("/getCaseById")
	@ResponseBody
	public EcCase getCaseById(Integer id){
		return caseService.getCaseById(id);
	}
	
}
