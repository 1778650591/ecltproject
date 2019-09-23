package com.eclt.dao;

import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;
import com.eclt.entity.EcCase;

@Repository
public class EcCaseDao extends HibernateDao<EcCase, Long> {

}
