package com.juntil.test;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.job.bean.Agreement;
import com.job.bean.Chat;
import com.job.bean.Evaluate;
import com.job.dao.AgreementDao;
import com.job.dao.ChatDao;
import com.job.dao.EvaluateDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:configs/spring-mybatis.xml"})
public class Test {
	@Resource
	private EvaluateDao evaluateDao;
	@org.junit.Test
	public void test(){
		System.out.println(evaluateDao.getEvaluateByJobUserId(3).size());
	
	}
}
