package com.example.blueoptima.Service.impl;

import com.example.blueoptima.Data.LogData;
import com.example.blueoptima.Repository.DataRepository;
import com.example.blueoptima.Service.DataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DataServiceImpl implements DataService {

    @Autowired
    DataRepository dataRepository;

    @Override
    public LogData saveData(Map<String, String> values) throws JsonProcessingException {
        LogData logData=new LogData();
        logData.setId(UUID.randomUUID().toString());
        logData.setData(values);
        return dataRepository.save(logData);
    }

    @Override
    public List<LogData> getLogDataByIpAddress(String ip){
        return dataRepository.getAllByIpAddress(ip);
    }
}
