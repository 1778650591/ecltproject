package com.eclt.resolver;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.eclt.dao.EcNpcDao;
import com.eclt.service.EcNcpService;

/**
 * 认证提供服务类
 * @author hkd
 *
 */
public class NcpResolver extends AbstractController{

	//Ncp服务层
//	@Autowired
//	@Re
//	private EcNcpService ecNcpService = new EcNcpService();
	@Resource
	private EcNpcDao ecNcpDao;
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		System.out.println("请求到了");
		//查询所有分类
		Map map = new HashMap();
		try{
			map.put("data", ecNcpDao.getAll());
			map.put("status",200);
			map.put("msg","查询成功！");
		}catch(Exception e){
			e.printStackTrace();
			map.put("status",500);
			map.put("msg","查询失败！");
		}
		return new ModelAndView(new MappingJackson2JsonView(),map);
	}

}
