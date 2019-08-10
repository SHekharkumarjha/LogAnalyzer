package com.example.blueoptima.Controller;


import com.example.blueoptima.CsvReader.LogReader;
import com.example.blueoptima.Data.LogData;
import com.example.blueoptima.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private LogReader reader;

    @Autowired
    private DataService service;

    @GetMapping("/")
    public String HomePage(){
        try {
            String filePath="C:\\Users\\sekha\\Documents\\Data.csv";

        }
        catch (Exception e){

        }
        return "HomePage";
    }


    @PostMapping("/output")
    public String showResult(MultipartFile files[],ModelMap map){
        StringBuilder fileNames = new StringBuilder();

        for (MultipartFile file : files) {
            fileNames.append(file.getOriginalFilename() + " ");
            try {
                InputStream inputStream = file.getInputStream();
                reader.parseLog(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "result";
    }

    @GetMapping("/ip")
    public List<LogData> getLogsByIp(String ip){
        List<LogData> logs = service.getLogDataByIpAddress(ip);
        return logs;
    }

    @GetMapping("/parse")
    public void parse() throws FileNotFoundException {
        reader.parseLog("/Us");
    }
}
