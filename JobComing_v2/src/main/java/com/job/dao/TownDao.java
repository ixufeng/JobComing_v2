package com.job.dao;
import java.util.List;

import com.job.bean.AddressTown;

public interface TownDao {

	/**
	 * 
	 * @param name
	 * @return
	 */
	public AddressTown getTownByName(String townName);
	/**
	 * 
	 * @param townCode
	 * @return
	 */
	public AddressTown getTownByCode(int townCode );
	/**
	 * 
	 * @param cityCode
	 * @return
	 */
	public List<AddressTown> getTownListByCity(int cityCode);

	
	

}
