package com.juntil.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.job.bean.Agreement;
import com.job.dao.AgreementDao;
import com.job.dao.CityDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:configs/spring-mybatis.xml"})
public class Test {
	@Resource
	private AgreementDao agreementDao;
	private Agreement agreement=new Agreement(2, 1, 1, 1, new Date());
	@org.junit.Test
	public void test(){
		agreementDao.insert(agreement);
	}
}
