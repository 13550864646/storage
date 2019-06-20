package com.cloud.storage.service;

/**
 * 数据插入MySQL 的接口层
 */
public interface ObservationService {
    /**
     * 通用的数据插入接口
     * @param uniqueField
     * @param dateTirne
     * @param businessType
     * @param appType
     * @param param
     * @param collectDate
     * @return
     */
    public boolean insertOrUpdateData(String uniqueField, String dateTirne,
                                      String businessType, String appType,
                                      String param, String collectDate);
}
