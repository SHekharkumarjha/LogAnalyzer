package com.example.blueoptima.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class LogData {

	private static ObjectMapper mapper = new ObjectMapper();

	@Id
	private String id;
	private String jsonData;
	@JsonIgnore
	private String ipAddress;
	@JsonIgnore
	private String userAgent;
	@JsonIgnore
	private String statusCode;
	@JsonIgnore
	private String api;
	@JsonIgnore
	private String userName;
	@JsonIgnore
	private String enterpriseId;
	@JsonIgnore
	private String enterpriseName;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Map<String, String> getData() throws IOException {
        return mapper.readValue(jsonData, new TypeReference<Map<String,String>>(){});
    }

    public void setData(Map<String, String> data) throws JsonProcessingException {
		ipAddress = data.get("IP-Address");
		userAgent = data.get("User-Agent");
		statusCode = data.get("Status-Code");
		api = data.get("API");
		userName = data.get("User-Name");
		enterpriseId = data.get("EnterpriseId");
		enterpriseName = data.get("EnterpriseName");
        this.jsonData = mapper.writeValueAsString(data);;
    }

	public String getIpAddress() {
		return ipAddress;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getApi() {
		return api;
	}

	public String getUserName() {
		return userName;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LogData)) return false;
		LogData logData = (LogData) o;
		return Objects.equals(id, logData.id) &&
				Objects.equals(jsonData, logData.jsonData) &&
				Objects.equals(ipAddress, logData.ipAddress) &&
				Objects.equals(userAgent, logData.userAgent) &&
				Objects.equals(statusCode, logData.statusCode) &&
				Objects.equals(api, logData.api) &&
				Objects.equals(userName, logData.userName) &&
				Objects.equals(enterpriseId, logData.enterpriseId) &&
				Objects.equals(enterpriseName, logData.enterpriseName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, jsonData, ipAddress, userAgent, statusCode, api, userName, enterpriseId, enterpriseName);
	}

	@Override
	public String toString() {
		return "LogData{" +
				"id='" + id + '\'' +
				", ipAddress='" + ipAddress + '\'' +
				", userAgent='" + userAgent + '\'' +
				", statusCode='" + statusCode + '\'' +
				", api='" + api + '\'' +
				", userName='" + userName + '\'' +
				", enterpriseId='" + enterpriseId + '\'' +
				", enterpriseName='" + enterpriseName + '\'' +
				'}';
	}
}
