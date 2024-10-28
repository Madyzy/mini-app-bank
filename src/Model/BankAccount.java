package Model;

import Model.Exceptions.NoMoneyException;

public class BankAccount implements Account {
    private double balance;
    private Owner owner;

    public BankAccount (Owner owner){
        this.owner = owner;
        this.balance=balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws NoMoneyException {
            if (balance >= amount) {
                balance -= amount;
            } else{
                NoMoneyException noMoneyException = new NoMoneyException("Lack of sufficient funds");
                throw noMoneyException;
            }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account fund: " + balance + "zł";
    }
}
