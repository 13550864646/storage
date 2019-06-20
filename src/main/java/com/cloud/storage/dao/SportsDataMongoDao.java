package com.cloud.storage.dao;

import com.cloud.storage.base.Domain.SportsData;

public interface SportsDataMongoDao {
    /**
     * 保存智能终端运动信息数据入Mongodb 库
     * @param data
     */
    public void saveOne(SportsData data);
}
