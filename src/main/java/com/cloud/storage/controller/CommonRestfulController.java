package com.cloud.storage.controller;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommonRestfulController {
    @Autowired
    private ObservationService observationService;
    @Autowired
    private SportsDataService sportsDataService;
    @Autowired
    private SportsDataHbaseService sportsDataHbaseService;
    @Autowired
    private PatientService patientService;

    private static Logger log = Logger.getLogger(CommonRestfulController.class);

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/businessDataReceive")
    public void businessDataReceive(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info(" the start of businessDataReceive");
        Map result = new HashMap();
        log.info("收到网关DispatchServer 发来数据＊ * . .. \r\n ");
        String jsonData = "";
        try {
            jsonData = new String((request.getParameter("data").getBytes("iso-8859-1")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("receive data occur exception :" + e.getMessage());
        }
        JSONObject jo = JSONObject.fromObject(jsonData);
//        数据参数校验
        String validateinfo = ""
                + ValidateUtil.checkAppType(JsonUtil.getJsonParamterString(jo, "appType"))
                + (ValidateUtil.isValid(JsonUtil.getJsonParamterString(jo, "dataType")) == true ? "" : "false")
                + ValidateUtil.checkDateTime(JsonUtil.getJsonParamterString(jo, "collectDate"))
                + (ValidateUtil.isValid(JsonUtil.getJsonParamterString(jo, "phone")) == true ? "" : "flase");
//        校验通过
        if ("".equals(validateinfo)) {
            String isMongo = PropertiesReader.getProp("mongodb");
            String isMysql = PropertiesReader.getProp("mysql");
            String isHbase = PropertiesReader.getProp("hbase");
            Map<String, Class> classMap = new HashMap<>();
            classMap.put("dataValue ", HashMap.class);
//            入库mongodbJSONObject
            SportsData sportsData = (SportsData) JSONObject.toBean(JSONObject.fromObject(jsonData), SportsData.class, classMap);
            if ("true".equals(isMongo)) {
//                入库mongodb
                sportsDataService.saveSportsData(sportsData);
            } else if ("true".equals(isMysql)) {
//                入库mysql
                new Context(request, response, observationService, patientService).request();
            } else if ("true".equals(isHbase)) {
//                入Hbase 库
                sportsDataHbaseService.saveData(sportsData);
            }
        } else {
            response.setStatus(412);
            result.put("status", " 数据验证失败！" + validateinfo);
            log.info(" the end of businessDataReceive has invalidate param include " + validateinfo);
        }
        response.setStatus(200);
        ResponseUtil.writeinfo(response, JSONObject.fromObject(result).toString());
    }

}
