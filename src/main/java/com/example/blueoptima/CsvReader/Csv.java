package com.example.blueoptima.CsvReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Csv {

     public static void readAllDataAtOnce(String file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVParser parser = new CSVParserBuilder().withSeparator('\n').build();
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(0)
//                    .withCSVParser(parser)
                    .build();
            List<String[]> allData = csvReader.readAll();
            String str = "";

            // print Data
            HashMap<String,String> values=new HashMap<>();
            for (String[] row : allData) {
                for (String cell : row) {
                    int l=cell.indexOf('=');
                    String key="",value = "";
                    if(l >= 0 && l+1 != cell.length()) {
                        key = cell.substring(1, l);
                        value = cell.substring(l + 1, cell.length()-1);
                        values.put(key, value);
//                        System.out.print(cell + " ");
                        str = str + cell + " ";
                    }
                }
                System.out.println();
//                str += '\n';
            }
            System.out.println(values);
//            System.out.println("##################"+str);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
