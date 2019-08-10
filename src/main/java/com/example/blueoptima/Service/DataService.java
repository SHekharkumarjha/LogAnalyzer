package com.example.blueoptima.Service;

import com.example.blueoptima.Data.LogData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DataService {

    LogData saveData(Map<String, String> values) throws JsonProcessingException;

    List<LogData> getLogDataByIpAddress(String ip);
}
