package com.cloud.storage.service;

import com.cloud.storage.base.Domain.Message;
import com.cloud.storage.base.Domain.PhysicalCheckData;

import java.util.Map;

/**
 * 体检报告的service 层
 */
public interface PhysicalCheckDataService {

    /**
     * 保存体检报告数据
     *
     * @param physicalCheckData
     * @return
     */
    public Message savePhyCheckData(PhysicalCheckData physicalCheckData);

    /**
     * 根据用户id 查询用户基本信息以及体检信息
     *
     * @param userId
     * @return
     */
    public Map<String, Object> getPhyCheckDataByUserid(Integer userId);
}
