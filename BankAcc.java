
public class BankAcc
{ String accNumber;
String accHolder;
    int balance=10000;
    
    void deposit(int dep)
    {
       this.balance = dep + this.balance;  
       System.out.println("Deposit Amount = "+ dep);
       System.out.println("Current Balance = "+ this.balance);
    }
   
    void withdraw(int wd)
    {
        this.balance =  this.balance - wd ;
        System.out.println("Withdraw Amount = "+ wd);
       System.out.println("Current Balance = "+ this.balance);
    }
    
    public static void main(String args[])
    {
        BankAcc bm = new BankAcc();
        
        bm.accHolder="yug";
        bm.accNumber="1";
        
        System.out.println("Account Holder : " + bm.accHolder);
        System.out.println("Account Number : " + bm.accNumber);
        
        System.out.println("Previous Balance = "+ bm.balance);
        System.out.println();
        
        bm.withdraw(2500);
        System.out.println();
        
        bm.deposit(+4000);
    }
   
}

