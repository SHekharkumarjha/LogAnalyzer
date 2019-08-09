package com.example.blueoptima.Service;

import com.example.blueoptima.Data.LogData;
import org.springframework.stereotype.Service;

@Service
public interface DataService {

    public LogData saveData(String id,String ipAdress,String userAgent,String statusCode,String requestType,String api,String user,String enterpriseId,String enterpriseName);
}
