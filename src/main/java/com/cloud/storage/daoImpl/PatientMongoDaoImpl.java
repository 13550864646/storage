package com.cloud.storage.daoImpl;

import com.cloud.storage.base.Domain.Patient;
import com.cloud.storage.base.Domain.SportsData;
import com.cloud.storage.dao.MongodbBaseDao;
import com.cloud.storage.dao.PatientMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 用户信息dao 层实现类（用于操作Mongodb)
 */
@Repository
public class PatientMongoDaoImpl extends MongodbBaseDao<Patient> implements PatientMongoDao {
    //    通知父类该dao 层是操作哪个实体类
    @Override
    protected Class getEntityClass() {
        return SportsData.class;
    }

    @Autowired
    @Override
    protected void setMongoTemplate(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate) {
        super.mongoTemplate = mongoTemplate;
    }

    @Override
    public void savePatient(Patient patient) {
        this.save(patient);
    }
}
