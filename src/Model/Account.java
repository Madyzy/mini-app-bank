package Model;

import Model.Exceptions.NoMoneyException;

public interface Account {

     void deposit(double amount);
     void withdraw(double amount) throws NoMoneyException;
}
