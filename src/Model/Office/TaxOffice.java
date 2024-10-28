package Model.Office;

import Model.Bank;
import Model.BankAccount;
import Model.ObserverPattern.Observer;

public class TaxOffice implements Observer {
    private BankAccount bankAccount;
    private double amount;

    public void raport(BankAccount bankAccount,double amount){
        System.out.println("Wire transfer over 10k!");

    }
    @Override
    public void update(BankAccount bankAccount, double amount) {
        this.raport(bankAccount,amount);

    }

}
