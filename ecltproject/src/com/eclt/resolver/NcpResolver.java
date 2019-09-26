package com.eclt.resolver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 认证提供服务类
 * @author hkd
 *
 */
public class NcpResolver extends AbstractController{

	//Ncp服务层
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		System.out.println("请求到了");
		
		
		Map map = new HashMap();
		map.put("data", "aaa");
		return new ModelAndView(new MappingJackson2JsonView(),map);
	}

}
