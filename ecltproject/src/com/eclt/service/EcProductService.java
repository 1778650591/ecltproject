package com.eclt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.hibernate.HibernateUtil;

import org.hibernate.SQLQuery;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.hibernate.HibernateUtils;
import com.eclt.dao.EcCaseDao;
import com.eclt.dao.EcProductDao;
import com.eclt.entity.EcCase;
import com.eclt.entity.EcProduct;
import com.eclt.entity.Product;

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
	
	public List<Product> getProductListById(Integer id){
		String sql = "select * from ec_product WHERE parent_id = ?";
		SQLQuery query = ecProductDao.getSession().createSQLQuery(sql).addEntity(EcProduct.class);
		query.setInteger(0, id);
		List<EcProduct> list = query.list();
//		System.out.println(list);
		List<Product> products = new ArrayList<Product>();
		for(EcProduct product : list){
			Product pro = new Product();
			pro.setProductId(product.getProductId());
			pro.setProductName(product.getProductName());
			pro.setProductImg(product.getProductImg());
			pro.setProductInfo(product.getProductInfo());
			pro.setProductMaxname(product.getProductMaxname());
			pro.setProductMinimg(product.getProductMinimg());
			pro.setProductMinname(product.getProductMinname());
			pro.setpPreset(product.getPPreset());
			products.add(pro);
		}
		//System.out.println(products);
		return products;
	}
	
	
	public Product getProductById(Integer id){
		EcProduct ecProduct = ecProductDao.get(id);
		Product pro = new Product();
		pro.setProductId(ecProduct.getProductId());
		pro.setProductName(ecProduct.getProductName());
		pro.setProductImg(ecProduct.getProductImg());
		pro.setProductInfo(ecProduct.getProductInfo());
		pro.setProductMaxname(ecProduct.getProductMaxname());
		pro.setProductMinimg(ecProduct.getProductMinimg());
		pro.setProductMinname(ecProduct.getProductMinname());
		pro.setpPreset(ecProduct.getPPreset());
		Collection<EcProduct> products;
		return pro;
	}
	
	
}






















