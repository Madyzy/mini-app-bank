package Model;

import Model.Exceptions.NoMoneyException;

public interface BankingOperations {

     void deposit (int nrAccount, double amount);
     void withdraw (int nrAccount, double amount) throws NoMoneyException ;
     void transfer (int nrAccountFrom, int nrAccountTo, double amount)throws NoMoneyException;
}
