public class BankAccount{
    private double balance;
    private int accountID;
    private String password;

    //toString method
    public String toString(){
        return "Account Number: " + accountID + "\t Balance = " + balance;
    }

    //Constructor
    public BankAccount(double b, int ID, String pass) {
        balance = b;
        while (ID < 10000000){
            ID *= 10;
        }
        accountID = ID;
        password = pass;
    }


    //Get methods
    public double getBalance(){
        return balance;
    }
    public int getID(){
        return accountID;
    }

    //Set method
    public void setPass(String newP){
        password = newP;
    }

    //Balance mutator methods
    public boolean deposit(double money){
        double bal = balance + money;
        if (money < 0){return false;}
        else{
            balance = bal;
            return true;
        }
    }

    public boolean withdraw(double money){
        double bal = balance - money;
        if (bal <= 0 || money > balance){return false;}
        else{
            balance = bal;
            return true;
        }
    }

//////////////////////////////////////////////////////////////////////////////

    public static void main(String[]args){
        BankAccount Adams = new BankAccount(300, 208979849, "notpasword");
        System.out.println(Adams); //Summary of the account
        System.out.println(Adams.getBalance()); //300
        System.out.println(Adams.getID()); //208979849
        if (Adams.withdraw(210)){
            System.out.println("Successful Withdraw! Your balance is now: " + Adams.getBalance());
        }

        System.out.println("\n");

        BankAccount Others = new BankAccount(20, 12, "notpasword");
        System.out.println(Others); //Summary of the account
        System.out.println(Others.getBalance()); //20
        System.out.println(Others.getID()); //120000000
        if (Others.deposit(500)){
            System.out.println("Successful Deposit! Your balance is now: " + Others.getBalance());
        }
    }


}
