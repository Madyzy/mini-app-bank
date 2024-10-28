package Model.ObserverPattern;

import Model.BankAccount;

public interface Observer {

    public void update(BankAccount bankAccount, double amount);
}
