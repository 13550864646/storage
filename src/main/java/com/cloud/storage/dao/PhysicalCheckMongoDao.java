package com.cloud.storage.dao;

import com.cloud.storage.base.Domain.PhysicalCheckData;

import java.util.Map;

/**
 * 体检信息的dao 层接口
 */
public interface PhysicalCheckMongoDao {
    /**
     * 保存体检信息、
     * @param physicalCheckData
     */
    public void savePhyCheckData (PhysicalCheckData physicalCheckData );

    /**
     * 根据用户id 查询其体检信息
     * @param userid
     * @return
     */
    public Map<String, Object> getPhyCheckDataByUserId (Integer userid) ;
}
