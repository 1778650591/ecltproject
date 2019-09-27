package com.eclt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eclt.entity.EcNcp;
import com.eclt.service.EcNcpService;

/**
 * 认证controller
 * @author hkd
 *
 */
@Controller
public class NcpController {

	@Resource
	private EcNcpService ecNcpService;
	
	/**
	 * 查询认证列表
	 * @return
	 */
	@RequestMapping("/findNcpAll.do")
	@ResponseBody
	public List<EcNcp> findNcpAll(){
		return ecNcpService.findNcpAll();
	}
	
	
}
