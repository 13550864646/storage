package com.cloud.storage.dao;

import com.cloud.storage.base.Domain.Patient;

/**
 * 用户的Dao 层
 */
public interface PatientMongoDao {
    void savePatient(Patient patient);
}
