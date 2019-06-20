package com.cloud.storage.serviceImpl;

import com.cloud.storage.base.Domain.Patient;
import com.cloud.storage.dao.PatientMongoDao;
import com.cloud.storage.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMongoDao patientMongoDao;

    @Override
    public void savePatient2Mongo(Patient patient) {
        patientMongoDao.savePatient(patient);
    }
}
