package com.eclt.dao;

import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;
import com.eclt.entity.EcUser;

@Repository
public class EcUserDao extends HibernateDao<EcUser, Long> {

}
