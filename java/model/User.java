package model;

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


    public void spendPoints(int points) {
        for (Transaction transaction : transactions) {
            if (transaction.getPoints() <= points) {
                points -= transaction.getPoints();
                payerMap.put(transaction.getPayer(), payerMap.get(transaction.getPayer()) - transaction.getPoints());
                if (points == 0) {
                    return ;
                }
            } else {
                payerMap.put(transaction.getPayer(), payerMap.get(transaction.getPayer()) - points);
                return ;
            }
        }
    }
}
