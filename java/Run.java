
import model.Transaction;
import model.User;
import utils.CSVReader;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Run {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<Transaction> transactions = csvReader.readTransactionsFromCSV();
        User user = new User(new HashMap<String,Integer>(),transactions);
        if(user.spendPoints(5000)>0)
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
