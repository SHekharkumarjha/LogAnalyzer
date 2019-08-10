package com.example.blueoptima.CsvReader;

import com.example.blueoptima.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Service
public class LogReader {

	@Autowired
	private DataService service;
	/**
	 * @param stream
	 * @return
	 */
	public void parseLog(InputStream stream) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
			String line = null;
			while((line = reader.readLine())!=null){
				int indexPartOne = line.indexOf(")");
				String partOne = line.substring(0, indexPartOne + 1);
				String[] partOneSubParts = partOne.split(" ");
				String partTwo = line.substring((indexPartOne + 2));
				String[] partTwoSubParts = partTwo.split(",");

				Map<String, String> values = new HashMap<>();
				values.put("date", partOneSubParts[0]);
				values.put("time", partOneSubParts[1]);
				values.put("logLevel", partOneSubParts[2]);
				values.put("threadName", partOneSubParts[3].replace("(", "").replace(")", ""));

				for (String part : partTwoSubParts) {
					String[] split = part.split("=");
					if (split.length == 2) {
						String key = split[0];
						String value = split[1];
						if (key.charAt(0) == '!')
							key = key.substring(1);

						if (value.charAt(value.length() - 1) == '#')
							value = value.substring(0, value.length() - 1);

						values.put(key, value);
					}
				}
				//service.saveData(values);
				System.out.println(values);
			}
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}

	/**
	 *
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	public void parseLog(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		parseLog(fileInputStream);
		return;
	}

	public static void main(String[] args) throws FileNotFoundException {
		long time = System.currentTimeMillis();
		LogReader reader = new LogReader();
		reader.parseLog("/Users/amajha/Desktop/Data.txt");
		System.out.println("Total Time : " + (System.currentTimeMillis() - time));
	}
}
