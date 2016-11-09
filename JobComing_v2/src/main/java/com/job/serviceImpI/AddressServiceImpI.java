package com.job.serviceImpI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.bean.AddressCity;
import com.job.bean.AddressProvince;
import com.job.bean.AddressTown;
import com.job.dao.CityDao;
import com.job.dao.ProvinceDao;
import com.job.dao.TownDao;

@Service
public class AddressServiceImpI {
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private TownDao townDao;
	/**
	 * 获得所有的省份集合
	 * @return
	 */
	public List<AddressProvince> getAllProvince(){
		List<AddressProvince>list=new ArrayList<AddressProvince>();
		list=provinceDao.getAllProvince();
		return list;
	}
	/**
	 * 获得所有的城市集合
	 * @return
	 */
	public List<AddressCity> getAllCity(){
		List<AddressCity> list=new ArrayList<AddressCity>();
		list=cityDao.getAllCity();
		return list;
	}
	/**
	 * 获得所有的区县集合
	 * @return
	 */
	public List<AddressTown> getAllTown(){
		List<AddressTown> list =new ArrayList<AddressTown>();
		list=townDao.getAllTown();
		return list;
	}
	/**
	 * 根据城市名称返回城市对象
	 * @param cityName
	 * @return
	 */
	public AddressCity getCityByName(String cityName){
		AddressCity addressCity = new AddressCity();
		addressCity = cityDao.getCityByName(cityName);
		return addressCity;
	}
	/**
	 * 根据城市编码返回城市对象
	 * @param cityCode
	 * @return
	 */
	public AddressCity getCityByCode(int cityCode){
		AddressCity addressCity = new AddressCity();
		addressCity = cityDao.getCityByCode(cityCode);
		return addressCity;
	}
}
