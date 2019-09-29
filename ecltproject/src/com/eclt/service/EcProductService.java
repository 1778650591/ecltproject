package com.eclt.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.eclt.dao.EcCaseDao;
import com.eclt.dao.EcProductDao;
import com.eclt.entity.EcCase;
import com.eclt.entity.EcProduct;

@Component
@Transactional
public class EcProductService {

	@Resource
	private EcProductDao ecProductDao;
	
	@DataProvider
	public Collection<EcProduct> getTopProduct(){
		return ecProductDao.find("from EcProduct where ecProduct.productId is null");
	}  
	
	@DataProvider
	public Collection<EcProduct> getProductByParentId(Integer parentId){
		if(null != parentId){
            String hql = "from EcProduct where ecProduct.productId = :productId";
            Map<String, Object> param = new HashMap();
            param.put("productId", parentId);
            return ecProductDao.find(hql, param);
        }else{
            return null;
        }
    }
	
	@DataResolver
	public void saveAll(Collection<EcProduct> products){
		for(EcProduct product:products){
			ecProductDao.persistEntity(product);
            Collection<EcProduct> childs = product.getEcProductSet();
            if(!(childs ==  null)){
                for(EcProduct child:childs){
                    child.setEcProduct(product);
                }
                ecProductDao.persistEntities(childs);
                saveAll(childs);
            }
        }
	}
	//获取五类
	public Collection<EcProduct> findAll(){
		return ecProductDao.getAll();
	}
}






















