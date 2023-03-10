package com.qiluhospital.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.qiluhospital.mapper.PacsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@DS("IMPAX")
@Service
public class PacsService {

    @Autowired
    PacsMapper pacsMapper;

    public JSONObject systemAnalysis() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("annualVerifyAmount", pacsMapper.annualReportAmount());
        jsonObject.put("totalAmount", pacsMapper.totalAmount());
        return jsonObject;
    }

    @DS("ris")
    public JSONObject todaySystemData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("todayReportAmount", pacsMapper.todayReportAmount());
        jsonObject.put("todayVerifyAmount", pacsMapper.todayVerifyAmount());
        jsonObject.put("todayMaxReport", pacsMapper.todayMaxReport());
        jsonObject.put("todayMaxVerify", pacsMapper.todayMaxVerify());
        return jsonObject;
    }

    public JSONObject serverMonitor() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("serverMonitor",pacsMapper.serverMonitor());
        return jsonObject;
    }
}
