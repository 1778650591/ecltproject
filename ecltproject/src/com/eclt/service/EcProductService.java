package com.eclt.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.eclt.dao.EcProductDao;
import com.eclt.entity.EcProduct;

@Component
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
	@Transactional
	public void saveAll(Collection<EcProduct> products){
		for(EcProduct product:products){
			ecProductDao.persistEntity(product);
            Collection<EcProduct> childs = product.getEcProductSet();
            if(!(childs ==  null)){
                for(EcProduct child:childs){
                    //ά��������ϵ
                    child.setEcProduct(product);
                }
                ecProductDao.persistEntities(childs);
                saveAll(childs);
            }
        }
	}
}
