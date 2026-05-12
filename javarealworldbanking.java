import java.io.*;
import java.util.*;
public class javarealworldbanking {
    int balance;
    Scanner s=new Scanner(System.in);
    ArrayList<String> history=new ArrayList<>();
    public void askbalance()
    {
        System.out.println("how much is your bank balance: ");
        balance =s.nextInt();
    }
    private void checkbalance()
    {
            System.out.println("current bank balance: " + balance);
    
    }
    public void deposit()
    {
        System.out.println("enter the amount to deposit: ");
        int amount=s.nextInt();
        if(amount>0)
        {
            balance+=amount;
            history.add("deposit: " + amount);
            System.out.println("current bank balance: " + balance);
        }
        else
        {
            System.out.println("invalid amount");
        }
    }
    private void withdraw()
    {
        System.out.println("enter the amount to withdraw: ");
        int amount=s.nextInt();
        if(amount>0 && amount<=balance)
        {
            balance-=amount;
            history.add("withdraw: " + amount);
            System.out.println("current bank balance: " + balance);
        }
        else
        {
            System.out.println("invalid amount or insufficient funds");
        }
    }
    private void transactions()
    {
        if(history.isEmpty())
        {
            System.out.println("no transactions yet");
        }
        else
        {
            System.out.println("transaction history: ");
            for(String record : history)
           {
                System.out.println(record);
           } 
        }

    }
    public void menu()
    {
       while(true)
        {
            System.out.println("enter an option: ");
            System.out.println("1. check balance");
            System.out.println("2. deposit");
            System.out.println("3. withdraw");
            System.out.println("4. transaction history");
            System.out.println("5. exit");
            int choice=s.nextInt();
            switch(choice)
            {
                case 1:
                    checkbalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transactions();
                    break;
                case 5:
                    System.out.println("thank you for using Nikhil's banking system");
                    return;
                default:
                    System.out.println("invalid choice");
            }
        } 
    }
    public static void main(String[] args)
    {
        javarealworldbanking obj = new javarealworldbanking();
        obj.askbalance();
        obj.menu(); 
    }

}
