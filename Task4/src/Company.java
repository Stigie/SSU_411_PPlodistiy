import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stig on 11.02.2016.
 */
public class Company {
    public String getNameComp() {
        return nameComp;
    }

    public int getCountId() {
        return countId;
    }

    public int getMoneyAll() {
        return moneyAll;
    }

    public void setMoneyAll(int moneyAll) {
        if (this.moneyAll + moneyAll >= 0)
            this.moneyAll += moneyAll;
        else System.out.println("Error! Недостаточно средств!");
    }

    public boolean checkMoneyAll(int moneyAll) {
        if (this.moneyAll + moneyAll + moneyAllCash >= 0)
            return true;
        else return false;
    }

    private String nameComp;
    private int countId;
    private int moneyAll;

    public int getMoneyAllCash() {
        return moneyAllCash;
    }

    public void setMoneyAllCash(int moneyAllCash) {
        this.moneyAllCash = moneyAllCash;
    }

    private int moneyAllCash;
    public void makeTransaction() {
        moneyAll+=moneyAllCash;
        moneyAllCash=0;
    }
    public Company(String name, int count, int balance) {
        nameComp = name;
        countId = count;
        moneyAll = balance;
        moneyAllCash = 0;
    }
}
