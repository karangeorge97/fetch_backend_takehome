package com.fetch;

import com.fetch.model.Transaction;
import com.fetch.model.User;
import com.fetch.utils.CSVReader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Run {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<Transaction> transactions = null;
        transactions = csvReader.readTransactionsFromCSV();
        User user = new User(new HashMap<String,Integer>(),transactions);
        if(user.spendPoints(Integer.parseInt(args[0]))>0)
        {
            System.out.println("Unable to spend all the points as per specifications");
        }
        else {
            for (Map.Entry<String, Integer> entry : user.getPayerMap().entrySet()) {
                System.out.println("Payer :" + entry.getKey() + " Points: " + entry.getValue());
            }
        }

    }
}
