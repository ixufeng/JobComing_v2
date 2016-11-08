package com.job.dao;

import com.job.bean.AddressProvince;

public interface ProvinceDao {
  /**
   * 通过省份名称返回一个省份对象
   * @param name
   * @return
  */
  public AddressProvince getProvinceByName(String name);
  /**
   * 通过省份编号返回一个省份对象
   * @param code
   * @return
   */
  public AddressProvince getProvinceByCode(int code);
}
