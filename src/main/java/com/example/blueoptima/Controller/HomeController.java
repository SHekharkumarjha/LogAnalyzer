package com.example.blueoptima.Controller;


import com.example.blueoptima.CsvReader.Csv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class HomeController {


    @Autowired
    private GridFsOperations gridFsOperations;


    @GetMapping("/")
    public String HomePage(){
        try {
            String filePath="C:\\Users\\sekha\\Documents\\Data.csv";
            Csv.readAllDataAtOnce(filePath);
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

                String fileId = gridFsOperations.store(inputStream, UUID.randomUUID().toString() + ".txt", "image/png").toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "result";
    }
}
