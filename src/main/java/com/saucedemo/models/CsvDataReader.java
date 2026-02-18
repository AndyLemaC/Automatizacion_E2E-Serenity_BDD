package com.saucedemo.models;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReader {

    private static final String CSV_FILE_PATH = "testdata/Purchase_Data.csv";


    public static Customer loadPurchaseData() {
        List<Customer> customers = loadAllPurchaseData();
        if (customers.isEmpty()) {
            throw new RuntimeException("No data found in CSV file: " + CSV_FILE_PATH);
        }
        return customers.get(0);
    }


    public static List<Customer> loadAllPurchaseData() {
        List<Customer> customers = new ArrayList<>();

        try (InputStream inputStream = CsvDataReader.class.getClassLoader().getResourceAsStream(CSV_FILE_PATH)) {
            if (inputStream == null) {
                throw new RuntimeException("CSV file not found at: " + CSV_FILE_PATH
                        + "\nMake sure the file exists in: src/test/resources/testdata/");
            }

            try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 CSVParser csvParser = CSVFormat.DEFAULT.builder()
                         .setHeader()
                         .setSkipHeaderRecord(true)
                         .setIgnoreHeaderCase(true)
                         .setTrim(true)
                         .build()
                         .parse(reader)) {

                for (CSVRecord record : csvParser) {
                    Customer customer = new Customer(
                            record.get("username"),
                            record.get("password"),
                            record.get("product1"),
                            record.get("product2"),
                            record.get("firstName"),
                            record.get("lastName"),
                            record.get("postalCode")
                    );
                    customers.add(customer);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + CSV_FILE_PATH, e);
        }

        return customers;
    }
}
