package com.cloud.storage.pattern.chain;

import com.cloud.storage.base.Domain.SportsData;
import com.cloud.storage.pattern.state.Context;
import com.cloud.storage.util.Log;
import com.cloud.storage.util.PropertiesReader;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * unitA 1 号数据包和3 号数据包业务处理责任类
 */
public class StepCountChainHandler extends Handler {
    @Override
    public boolean HandleRequest(Context context) {
        String dataType = context.getData().getDataType();
//        判断是否是简要步数
        if (PropertiesReader.getProp("DATATYPE_STEPCOUNT").equalsIgnoreCase(dataType)) {
            SportsData data = context.getData();
            Log.info(" data deal by StepCountChainHandler !");
            if (data.getDataValue() != null && data.getDataValue().size() != 0) {
                Map<String, Object> map = new HashMap<>();
                String measureTime = data.getDataValue().get(11).get(" measureTime ");
                map.put("stepCount ", data.getDataValue());
//               insert into database
                boolean bool = context.getObservationService().insertOrUpdateData(data.getPhone(), measureTime,
                        PropertiesReader.getProp("DATATYPE STEPCOUNT"),
                        PropertiesReader.getProp("APPTYPE_AppA"),
                        JSONObject.fromObject(map).toString(), data.getCollectDate());
                if (!bool)
                    Log.error("StepCountChainHandler save data into db error ! ");
                return bool;
            } else {
                Log.error(" StepCountChainHandler datavalue is null !");
                return false;
            }
        }else {
            if (successor != null)
                return successor.HandleRequest(context);
            else
                return false;
        }
    }
}
