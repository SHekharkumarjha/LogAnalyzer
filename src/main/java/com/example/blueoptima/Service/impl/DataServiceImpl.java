package com.example.blueoptima.Service.impl;

import com.example.blueoptima.Data.LogData;
import com.example.blueoptima.Repository.DataRepository;
import com.example.blueoptima.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class DataServiceImpl implements DataService {

    @Autowired
    DataRepository dataRepository;

    @Override
    public LogData saveData(String id,String ipAdress,String userAgent,String statusCode,String requestType,String api,String user,String enterpriseId,String enterpriseName ) {
        LogData logData=new LogData();
        logData.setId(UUID.randomUUID().toString());
        logData.setIpAdress(ipAdress);
        logData.setUserAgent(userAgent);
        logData.setStatusCode(statusCode);
        logData.setRequestType(requestType);
        logData.setApi(api);
        logData.setUser(user);
        logData.setEnterpriseId(enterpriseId);
        logData.setEnterpriseName(enterpriseName);
        return dataRepository.save(logData);
    }
}
