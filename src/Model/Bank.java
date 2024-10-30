package Model;

import Model.Exceptions.IncorrectNumberAccountException;
import Model.Exceptions.NoMoneyException;
import Model.ObserverPattern.Observable;
import Model.ObserverPattern.Observer;

import java.util.ArrayList;

public class Bank implements BankingOperations, Observable {

    private ArrayList<BankAccount> accounts;
    private BankAccount bankAccount;
    private SavingAccount savingAccount;
    private ArrayList<Observer> observer;

    public Bank() {
        accounts = new ArrayList<>();
        observer = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public double getBankAccountBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int nrAccount, double amount) {
        this.accounts.get(nrAccount).deposit(amount);
        System.out.println("Funds have been deposited into the account" + " " + nrAccount);
    }

    @Override
    public void withdraw(int nrAccount, double amount) {

        try {
            this.accounts.get(nrAccount).withdraw(amount);
            System.out.println(("Funds have been withdrawn from the account" + " " + nrAccount));
        } catch (NoMoneyException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void transfer(int nrAccountFrom, int nrAccountTo, double amount){
        if (amount <= 0){
            System.out.println("Amount need to be positive!");
        }else{
            try {
                checkIfAccountExist(nrAccountFrom,nrAccountTo);
                this.accounts.get(nrAccountFrom).withdraw(amount);
                this.accounts.get(nrAccountTo).deposit(amount);
                System.out.println("The funds have been transferred from account: " + nrAccountFrom + " to account: " + nrAccountTo);
                if (amount> 10000){
                    this.notifyObserver(bankAccount,amount);
                }
            }catch (NoMoneyException | IncorrectNumberAccountException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


    public boolean checkIfAccountExist(int nrAccountFrom,int nrAccountTo) throws IncorrectNumberAccountException {
        if(nrAccountTo >= accounts.size() || nrAccountTo < 0){
            throw new IncorrectNumberAccountException("Account number: " + nrAccountTo + " does not exist");
        }else if(nrAccountFrom >= accounts.size() || nrAccountFrom < 0) {
            throw new IncorrectNumberAccountException("Account number: " + nrAccountFrom + " does not exist" );
    } return false;
}


    @Override
    public void addObserver(Observer o) {
        observer.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observer.remove(o);
    }

    @Override
    public void notifyObserver(BankAccount bankAccount,double amount) {
        for (int i=0;i<observer.size();i++){
            observer.get(i).update(bankAccount,amount);
        }
    }
}





