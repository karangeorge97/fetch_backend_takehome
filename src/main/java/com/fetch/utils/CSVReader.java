package com.fetch.utils;

import com.fetch.model.Transaction;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CSVReader {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final String CSV_FILE_PATH = "/transactions.csv";

    public List<Transaction> readTransactionsFromCSV()  {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(CSV_FILE_PATH)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String payer = values[0];
                int points = Integer.parseInt(values[1]);
                Date timestamp = dateFormat.parse(values[2]);
                transactions.add(new Transaction(payer, points, timestamp));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        //Sorting the transactions based on the timestamp

        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t1.getTransactionTimeStamp().compareTo(t2.getTransactionTimeStamp());
            }
        });
        return transactions;
    }
}
