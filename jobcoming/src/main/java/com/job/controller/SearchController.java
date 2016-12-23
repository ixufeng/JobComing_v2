package com.job.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.bean.AddressCity;
import com.job.bean.AddressProvince;
import com.job.bean.AddressTown;
import com.job.bean.JobKind;
import com.job.service.JobService;
import com.job.serviceImpl.AddressServiceImpI;

@Controller
@RequestMapping("/searchJob")
public class SearchController {
	@Autowired
	private JobService jobService;
	@Autowired
	private AddressServiceImpI add;
	@RequestMapping("/search")
	@ResponseBody
	public String getSearchList(@RequestParam("searchName") String searchName){
		List<String> keylist = new ArrayList<String>();
		List<String> implist=new ArrayList<String>();
		List<AddressProvince> plist=add.getAllProvince();
		for(int i=0;i<plist.size();i++){
			keylist.add(plist.get(i).getProvinceName());
		}
		List<AddressTown> tlist =add.getAllTown();
		for(int i=0;i<tlist.size();i++){
			keylist.add(tlist.get(i).getTownName());
		}
		List<AddressCity> clist= add.getAllCity();
		for(int i=0;i<clist.size();i++){
			keylist.add(clist.get(i).getCityName());
		}
		List<JobKind> jlist = jobService.getJobKinds();
		for(int i=0;i<jlist.size();i++){
			keylist.add(jlist.get(i).getJobKindName());
		}
		for(int i=0;i<keylist.size();i++){
			if(keylist.get(i).indexOf(searchName)!=-1&&searchName.trim()!=""){
				implist.add(keylist.get(i));
			}
		}
		return implist.toString();
	}
}
