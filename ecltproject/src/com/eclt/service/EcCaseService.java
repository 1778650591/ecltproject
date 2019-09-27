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
import com.eclt.dao.EcCaseDao;
import com.eclt.entity.EcCase;
import org.hibernate.annotations.common.util.StringHelper;
@Component
@Transactional
public class EcCaseService {

	@Resource
	private EcCaseDao ecCaseDao;
	
	@DataProvider
    public void queryForCondition(Page<EcCase> page, Map<String, Object> params) {
        if (null != params) {
            String caseName = (String)params.get("caseName");
            String caseInfo = (String) params.get("caseInfo");
            String caseImg = (String)params.get("caseImg");
            
             
            String whereCase = "";
            if (StringHelper.isNotEmpty(caseName)) {
                whereCase += " AND caseName like '%" + caseName + "%' ";
            }
             
            if (StringHelper.isNotEmpty(caseInfo)) {
                whereCase += " AND caseInfo like '%" + caseInfo + "%' ";
            }
             
            if (StringHelper.isNotEmpty(caseImg)) {
                whereCase += " AND caseImg like '%" + caseImg + "%' ";
            }
            
            ecCaseDao.find(page, " from EcCase where 1=1 " + whereCase);
        } else
        	ecCaseDao.getAll(page);
    }
	
	@DataResolver
	public void saveAll(Collection<EcCase> cases){
		ecCaseDao.persistEntities(cases);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<EcCase> findCaseAll(){
		return ecCaseDao.getAll();
	}
}




















