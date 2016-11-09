package com.job.serviceImpI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.dao.AgreementDao;
import com.job.dao.JobDao;

@Service
public class AgreementServiceImpI {
	@Autowired
	private AgreementDao agreementDao;
	@Autowired JobDao jobDao;
}
