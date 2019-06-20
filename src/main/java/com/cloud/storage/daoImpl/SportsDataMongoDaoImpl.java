package com.cloud.storage.daoImpl;

import com.cloud.storage.base.Domain.SportsData;
import com.cloud.storage.dao.MongodbBaseDao;
import com.cloud.storage.dao.SportsDataMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SportsDataMongoDaoImpl extends MongodbBaseDao<SportsData> implements SportsDataMongoDao {
    //    通知父类该dao 层是操作哪个实体类
    @Override
    protected Class getEntityClass() {
        return SportsData.class;
    }

    //    从Spring 容器中取出mongoTemplate 赋值给父类的mongoTemplate 属性
    @Autowired
    @Override
    protected void setMongoTemplate(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate) {
        super.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveOne(SportsData data) {
        this.save(data);
    }
}
