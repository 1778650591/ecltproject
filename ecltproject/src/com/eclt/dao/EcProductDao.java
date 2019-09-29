package com.eclt.dao;

import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;
import com.eclt.entity.EcProduct;

@Repository
public class EcProductDao extends HibernateDao<EcProduct, Integer> {

}
