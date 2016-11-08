package com.job.dao;
import java.util.List;

import com.job.bean.AddressTown;

public interface TownDao {
	/**
	 * 通过区县的名字返回区县对象
	 * @param name
	 * @return
	 */
	public AddressTown getTownByName(String townName);
	/**
	 * 通过区县的编号返回区县对象
	 * @param townCode
	 * @return
	 */
	public AddressTown getTownByCode(int townCode );
	/**
	 * 通过城市的编码返回所属的区县的集合
	 * @param cityCode
	 * @return
	 */
	public List<AddressTown> getTownListByCity(int cityCode);
}
