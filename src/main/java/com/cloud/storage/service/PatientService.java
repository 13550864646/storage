package com.cloud.storage.service;

import com.cloud.storage.base.Domain.Patient;

public interface PatientService {
    public void savePatient2Mongo(Patient patient);
}
