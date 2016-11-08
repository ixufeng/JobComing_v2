package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.AddressTown;

public interface TownDao {

	/**
	 * 通过城镇的编码来查询城镇
	 * @param townCode
	 * @return
	 */
	public AddressTown getTownByTownCode(@Param("townCode") int townCode);
	
	
	/**
	 * 通过名字来查询
	 * @param townCode
	 * @return
	 */
	public List<AddressTown> getTownByTownName(@Param("townName") String townCode);
	
	
	
}
