package com.eclt.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.eclt.dao.EcCompanyDao;
import com.eclt.entity.EcCompany;

@Component
public class EcCompanyService {

	@Resource
	private EcCompanyDao ecCompanyDao;
	
	@DataProvider
	public Collection<EcCompany> getAll(){
		return ecCompanyDao.getAll();
	}
	
	@DataResolver
	@Transactional
	public void saveAll(Collection<EcCompany> company){
		ecCompanyDao.persistEntities(company);
	}
	
	public EcCompany getCompanyById(Integer id){
		return ecCompanyDao.get(id);
	}
}
