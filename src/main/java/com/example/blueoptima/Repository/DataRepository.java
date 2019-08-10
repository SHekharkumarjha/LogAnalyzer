package com.example.blueoptima.Repository;

import com.example.blueoptima.Data.LogData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends MongoRepository<LogData,String> {
	public List<LogData> getAllByApi(String api);
	public List<LogData> getAllByIpAddress(String ip);
	public List<LogData> getAllByStatusCode(String statusCode);
}
