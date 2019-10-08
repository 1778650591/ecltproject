package com.eclt.service;
import org.hibernate.criterion.Restrictions;
import org.hibernate.annotations.common.util.StringHelper;
import com.bstek.dorado.web.DoradoContext;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.eclt.dao.EcUserDao;
import com.eclt.entity.EcUser;

import org.hibernate.criterion.DetachedCriteria;
@Component
public class EcUserService {

	@Resource
	private EcUserDao ecUserDao;
	
	//登陆
	@Expose
    public Map<String, Object> doLogin(String username, String password) {
    Map<String, Object> result = new HashMap();
    if (isValid(username,password)) {
        result.put("url", "com.eclt.view.main.main.d");
        result.put("result", true);
        return result;
    } else {
        String errormsg = "用户名密码错误！";
        result.put("errormsg", errormsg);
        result.put("result", false);
        return result;
    }
}
	
	 //判定用户名密码
    public boolean isValid(String username, String password) {
        DetachedCriteria dc = DetachedCriteria.forClass(EcUser.class);
        if (username != null && !"".equals(username)) {
            dc.add(Restrictions.eq("username", username.toUpperCase()));
        }
        List<EcUser> users = ecUserDao.find(dc);
        if (users.size() > 0) {
        	EcUser user = users.get(0);
            if (password.equals(user.getPassword())) {
                //存入session
                DoradoContext ctx = DoradoContext.getCurrent();
                HttpServletRequest request = ctx.getRequest();
                request.getSession().setAttribute("user", user);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    //查询用户
    @DataProvider
    public void queryForCondition(Page<EcUser> page, Map<String, Object> params) {
        if (null != params) {
            String userId = (String)params.get("userId");
            String username = (String) params.get("username");
            
             
            String whereCase = "";
            if (StringHelper.isNotEmpty(userId)) {
                whereCase += " AND userId like '%" + userId + "%' ";
            }
             
            if (StringHelper.isNotEmpty(username)) {
                whereCase += " AND username like '%" + username + "%' ";
            }
             
            
            
            ecUserDao.find(page, " from EcUser where 1=1 " + whereCase);
        } else
        	ecUserDao.getAll(page);
    }
    
    //保存
    @DataResolver
    @Transactional
    public void saveAll(Collection<EcUser> user) throws ParseException{
    	Collection<EcUser> co=user;
    	for(EcUser u:user){
    		if(u.getCreateTime() != null){
    			u.setUpdateTime(new Date());
    		}else{
    			u.setCreateTime(new Date());
    			u.setUpdateTime(new Date());
    		}
    	}
    	ecUserDao.persistEntities(co);
    }
    
    //退出
    @Expose
    public Map<String, Object> doLogout() {
        DoradoContext ctx = DoradoContext.getCurrent();
        HttpServletRequest request = ctx.getRequest();
        request.getSession().setAttribute("user", null);
        Map<String, Object> result = new HashMap();
        result.put("url",
                "com.eclt.view.login.Login.d");
        result.put("result", true);
        return result;
    }
}



























