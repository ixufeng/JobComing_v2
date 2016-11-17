package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.Evaluate;
import com.job.dao.EvaluateDao;
import com.job.service.EvaluateService;
@Service
public class EvaluateImpI implements EvaluateService {
	@Autowired
	private EvaluateDao eva;
	@Override
	public boolean insert(Evaluate evaluate) {
		if(evaluate!=null){
			eva.insert(evaluate);
			return true;
		}else{
			return false;
		}

	}

}
