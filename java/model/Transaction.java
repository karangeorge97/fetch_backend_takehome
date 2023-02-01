package model;

import java.util.Date;


public class Transaction {
    private String payer;
    private int points;
    private Date transactionTimeStamp;

    public Transaction(String payer, int points, Date transactionTimeStamp) {
        this.payer = payer;
        this.points = points;
        this.transactionTimeStamp = transactionTimeStamp;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getTransactionTimeStamp() {
        return transactionTimeStamp;
    }

    public void setTransactionTimeStamp(Date transactionTimeStamp) {
        this.transactionTimeStamp = transactionTimeStamp;
    }
}
