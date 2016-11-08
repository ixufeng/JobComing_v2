package com.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.job.bean.AddressCity;

public interface CityDao {
	/**
	 * 通过城市名称返回一个城市对象 
	 * @param cityName
	 * @return
	 */
	public AddressCity getCityByName(@Param("cityName")String cityName);
	/**
	 * 通过城市编号返回一个城市对象
	 * @param cityCode
	 * @return
	 */
	public AddressCity getCityByCode(int cityCode);
	/**
	 * 通过省份编号返回所属的城市的集合
	 * @param provinceCode
	 * @return
	 */
	public List<AddressCity> getCityListByProvince(int provinceCode);
}
