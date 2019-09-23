package com.eclt.service;
import org.hibernate.criterion.Restrictions;
import org.hibernate.annotations.common.util.StringHelper;
import com.bstek.dorado.web.DoradoContext;

import java.util.Collection;
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
	
	//��½����
	@Expose
    public Map<String, Object> doLogin(String username, String password) {
    Map<String, Object> result = new HashMap();
    if (isValid(username,password)) {
        //������֤�ɹ���Ҫ��ת��ҳ��
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
	
	 //��֤�û�����
    public boolean isValid(String username, String password) {
        DetachedCriteria dc = DetachedCriteria.forClass(EcUser.class);
        if (username != null && !"".equals(username)) {
            dc.add(Restrictions.eq("username", username.toUpperCase()));
        }
        List<EcUser> users = ecUserDao.find(dc);
        if (users.size() > 0) {
        	EcUser user = users.get(0);
            if (password.equals(user.getPassword())) {
                // ��֤�ɹ����û���Ϣ����session��
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
    //��ѯ�û���Ϣ
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
    
    //�����û���Ϣ
    @DataResolver
    @Transactional
    public void saveAll(Collection<EcUser> user){
    	ecUserDao.persistEntities(user);
    }
    
    //�ǳ�����
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



























