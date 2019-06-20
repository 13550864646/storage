package com.cloud.storage.service;

import com.cloud.storage.base.Domain.SportsData;

/**
 * 智能终端运动信息的service 层
 */
public interface SportsDataService {
    /**
     * 智能终端运动数据保存入库接口
     * @param sportsData
     */
    public void saveSportsData(SportsData sportsData);
}
