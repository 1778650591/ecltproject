package com.eclt.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import com.eclt.dao.EcNpcDao;
import com.eclt.entity.EcNcp;
import org.hibernate.annotations.common.util.StringHelper;
@Component
public class EcNcpService {

	@Resource
	private EcNpcDao ecNcpDao;
	
	@DataProvider
    public void queryForCondition(Page<EcNcp> page, Map<String, Object> params) {
        if (null != params) {
            String ncpName = (String)params.get("ncpName");
            String ncpImg = (String) params.get("ncpImg");
            String ncpSort = (String)params.get("ncpSort");
            
             
            String whereCase = "";
            if (StringHelper.isNotEmpty(ncpName)) {
                whereCase += " AND ncpName like '%" + ncpName + "%' ";
            }
             
            if (StringHelper.isNotEmpty(ncpImg)) {
                whereCase += " AND ncpImg like '%" + ncpImg + "%' ";
            }
             
            if (StringHelper.isNotEmpty(ncpSort)) {
                whereCase += " AND ncpSort like '%" + ncpSort + "%' ";
            }
           
            ecNcpDao.find(page, " from EcNcp where 1=1 " + whereCase);
        } else
        	ecNcpDao.getAll(page);
    }
	
	@DataResolver
	@Transactional
	public void saveAll(Collection<EcNcp> ecncp){
		ecNcpDao.persistEntities(ecncp);
	}
	
	//查询所有认证
	public List<EcNcp> findNcpAll(){
		List<EcNcp> list = ecNcpDao.getAll();
		return list;
	}
}


















