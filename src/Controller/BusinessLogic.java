package Controller;

import Model.*;
import Model.Exceptions.NoMoneyException;

import java.util.ArrayList;

public class BusinessLogic {
    private Bank model;

    public void setModel (Bank model){
        this.model = model;
    }


    public BankAccount addNewAccount(Owner owner){
        BankAccount bankAccount= new BankAccount(owner);
        model.addAccount(bankAccount);
        System.out.println("New account has been create");
        return bankAccount;
    }
    public SavingAccount addNewSavingAccount(Owner owner){
        SavingAccount savingAccount= new SavingAccount(owner);
        model.addAccount(savingAccount);
        System.out.println("New saving account has been create");
        return savingAccount;
    }

    public void deposit(double amount,int nrAccount){
        model.deposit(nrAccount,amount);
    }
    public void withdraw(double amount,int nrAccount) throws NoMoneyException {
        model.withdraw(nrAccount,amount);
    }
    public void transfer(double amount,int nrAccountFrom,int nrAccountTo) throws NoMoneyException {
        model.transfer(nrAccountFrom,nrAccountTo,amount);
    }
}
