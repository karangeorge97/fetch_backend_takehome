package com.fetch.model;

import java.util.HashMap;
import java.util.List;

public class User {

    private HashMap<String,Integer> payerMap;
    private List<Transaction> transactions;

    public User(HashMap<String, Integer> payerMap, List<Transaction> transactions) {
        this.payerMap = payerMap;
        this.transactions = transactions;
        for(Transaction transaction : transactions) {
            String payer = transaction.getPayer();
            int points = transaction.getPoints();
            payerMap.put(payer, payerMap.getOrDefault(payer, 0) + points);
        }
    }

    public HashMap<String, Integer> getPayerMap() {
        return payerMap;
    }

    public void setPayerMap(HashMap<String, Integer> payerMap) {
        this.payerMap = payerMap;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    public int spendPoints(int pointsToSpend) {
        int remainingPoints = pointsToSpend;
        for (Transaction transaction : transactions) {
            if (remainingPoints <= 0) {
                break;
            }

            String payer = transaction.getPayer();
            int currentBalance = payerMap.get(payer);
            int points = Math.min(transaction.getPoints(), remainingPoints);
            if (currentBalance - points < 0) {
                points = currentBalance;
            }
            remainingPoints -= points;
            payerMap.put(payer, currentBalance - points);
        }
        return remainingPoints;
    }
}
