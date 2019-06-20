package com.cloud.storage.serviceImpl;

import com.cloud.storage.dao.JdbcDao;
import com.cloud.storage.service.ObservationService;
import com.cloud.storage.util.DateUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"all"})
@Service
public class ObservationServiceImpl implements ObservationService {
    private static Logger log = Logger.getLogger(ObservationServiceImpl.class);

    @Autowired
    private JdbcDao jdbcDao;

    @Override
    @SuppressWarnings("rawtypes")
    public boolean insertOrUpdateData(String uniqueField, String dateTime, String businessType, String appType, String param, String collectDate) {
//        find patientid
        int patientId = this.queryPatientByPhone(uniqueField, appType);
        if (0 == patientId) {
            log.debug("patient not found,param is ：" + " uniqueField -" + uniqueField + " appType-" + appType);
            return false;
        } else {
            String concept_sql = " SELECT conceptId, conceptName FROM concept WHERE conceptDescribe = '" + businessType + "'";
            List list = this.jdbcDao.getData(concept_sql);
            JSONObject jo = JSONObject.fromObject(param);
            String[] sql = new String[list == null ? 0 : list.size()];
            String check_sql = " SELECT COUNT(1) FROM observation WHERE conceptId ='%s' AND patientId ='%s' AND obsDatetime ='%s'";
            String insert_sql = " INSERT into observation('obsDatetime','value','conceptId','patientId','collectDate','receiveDateTime') " +
                    "values ('%s','%s','%s','%s''%s'，'%s')";
            String update_sql = " UPDATE observation set value = '%s'， collectDate = '%s'， receiveDateTime = '%s' " +
                    "WHERE conceptId = '%s' AND patientId = '%s' AND obsDatetime = '%s'";
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                int count = this.jdbcDao.queryForint(String.format(check_sql, map.get("conceptId").toString(), patientId, dateTime));
                sql[i] = String.format(insert_sql, dateTime, jo.getString(map.get(" conceptName").toString()), map.get(" concept Id").toString(), patientId, collectDate, DateUtil.getCurrentTime());
            }
            if (sql.length > 0) {
                try {
                    int[] batchUpdate = this.jdbcDao.batchUpdate(sql);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    log.debug(" batchUpdate data error !\r\n" + e.getMessage());
                    return false;
                }
            } else {
                log.debug(" can't find concept data error ! ");
                return false;
            }
        }
    }

    /**
     * find the patient by unique field
     *
     * @param phone
     * @param appType
     * @return
     */
    public int queryPatientByPhone(String phone, String appType) {
        String query_sql = "select patientId from patient p where l=l and p.appType = '" + appType + "'" + " and p.phone ='" + phone + "'";
        return this.jdbcDao.queryForint(query_sql);
    }
}
