package com.eclt.dao;

import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;
import com.eclt.entity.EcCompany;

@Repository
public class EcCompanyDao extends HibernateDao<EcCompany, Integer> {

}
