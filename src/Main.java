import Controller.BusinessLogic;
import Model.Bank;
import Model.BankAccount;
import Model.Exceptions.NoMoneyException;
import Model.Office.TaxOffice;
import Model.Owner;
import Model.SavingAccount;
import View.ViewInterface;


public class Main {



    public static void main(String[] args) throws NoMoneyException {
	// write your code here

        Owner owner = new Owner("Jan","Kowal");
        Owner owner1 = new Owner("Jola","Kowalska");


        Bank model =new Bank();

        BusinessLogic controller = new BusinessLogic();
        ViewInterface view= new ViewInterface(controller);
        TaxOffice taxOffice=new TaxOffice();
        model.addObserver(taxOffice);
        controller.setModel(model);
        view.setController(controller);

        controller=null;
        model=null;

        view.getContoller().addNewAccount(owner1);
        view.getContoller().addNewSavingAccount(owner1);
        view.getContoller().addNewAccount(owner);
        view.getContoller().deposit(20000,0);
        view.getContoller().withdraw(20001,0);
        view.getContoller().transfer(200,0,1);
        view.getContoller().transfer(11000,0,2);
        view.getContoller().transfer(10,2,3);

    }
}
