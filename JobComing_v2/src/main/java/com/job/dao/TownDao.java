package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.AddressTown;

public interface TownDao {


	public AddressTown getTownByTownCode(@Param("townCode") int townCode);
	
	
	
	public List<AddressTown> getTownByTownName(@Param("townName") String townCode);
	
	
	
}
