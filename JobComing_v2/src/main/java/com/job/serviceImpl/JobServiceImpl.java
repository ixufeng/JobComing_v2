package com.job.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.bean.Job;
import com.job.dao.JobDao;
import com.job.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobDao jobDao;
	
	@Override
	public List<Job> getJobs(Map<String, Object> map) {
		
		List<Job> list = new ArrayList<Job>();
		
		if(map!=null&&map.size()>0){
			if(map.containsKey("pageIndex")){
				
				Object obj = map.get("pageIndex");
				
				Integer pageIndex = (Integer)obj;
				
				Integer beginIndex = (pageIndex-1)*10;
				Integer lastIndex  = (Integer)obj + 10;
								
				map.put("beginIndex", beginIndex);
				map.put("lastIndex", lastIndex);
				
			}else{
				//默认每个十个，暂时用常量代替
				map.put("pageSize", 10);
			}
			
			list = jobDao.searchJobs(map);
		}
		
		return list;
	}

}
