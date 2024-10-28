package Model.ObserverPattern;

import Model.BankAccount;

import java.util.ArrayList;

public interface Observable {

    public void addObserver(Observer o);
    public void deleteObserver(Observer o);
    public void notifyObserver(BankAccount bankAccount,double amount);
}
