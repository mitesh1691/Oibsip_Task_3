package Oasis;

import java.util.Scanner;
import java.util.ArrayList;

class ATM{
    int balance = 0,withdraw,deposit;
    int flag=0;
    Scanner sc=new Scanner(System.in);
    ArrayList <String> History=new ArrayList<>();
    public void Withdraw(){
        System.out.println("Enter amount : ");
        withdraw = sc.nextInt();
        if(balance >= withdraw)
        {
            balance = balance - withdraw;
            System.out.println("Transaction successful!!!!");
            System.out.println("Please collect your money!!!!");
            String q="Withdraw : -"+withdraw;
            History.add(q);
            flag+=1;
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
        System.out.println("");
    }
    public void Deposit(){
        System.out.print("Enter amount : ");

        deposit = sc.nextInt();

        balance = balance + deposit;
        System.out.println("Your Money has been deposited successfully!!!!");
        String s="Deposit : +"+deposit;
        History.add(s);
        System.out.println("");
        flag+=1;
    }
    public void Balance(){
        System.out.println("Your Account Balance Is : "+balance);
        System.out.println("");
    }

    public void Trans_history(){
        System.out.println("Your last transactions were....");
        for (int j=0;j<flag;j++){
            System.out.println(History.get(j));
        }
    }

    public void transfer(){
        System.out.print("Enter Receiver's Account No. : ");
        int a=sc.nextInt();
        System.out.print("Enter Amount To Transfer : ");
        int b=sc.nextInt();
        if (b>balance){
            System.out.println("Sorry, You Have Insufficient Balance !!!!");
        }
        else{
            balance-=b;
            System.out.println("Transferred Successfully!!");
            String r="Transfer : -"+b;
            History.add(r);
            flag+=1;
        }
    }
}

public class Oibsip_Task_3_ATM_Interface
{
    public static void main(String[]args )
    {
        ArrayList <Integer> User=new ArrayList<>();

        User.add(12345678);
        User.add(87654321);
        User.add(16092001);
        User.add(13579753);

        ArrayList <Integer> Pin=new ArrayList<>();
        Pin.add(12345);
        Pin.add(87654);
        Pin.add(16092);
        Pin.add(13579);

        int balance = 0;

        Scanner sc = new Scanner(System.in);

        while(true)
        {
            ATM obj=new ATM();
            System.out.print("Enter Your Account number : ");
            int a=sc.nextInt();
            System.out.print("Enter Your Account PIN : ");
            int b=sc.nextInt();

            for (int i=0;i<4;i++){
                if (User.get(i).equals(a) && Pin.get(i).equals(b)){
                    System.out.println("Logged In Successfully!!");
                    boolean isit=true;
                    while (isit=true){
                        System.out.println("\n");
                        System.out.println("****** WELCOME TO ATM ******");

                        System.out.println("| 1 - Withdraw             |");

                        System.out.println("| 2 - Deposit              |");

                        System.out.println("| 3 - Balance              |");

                        System.out.println("| 4 - Transaction History  |");

                        System.out.println("| 5 - Transfer             |");

                        System.out.println("| 6 - Exit                 |");
                        System.out.println("|--------------------------|");
                        System.out.println("\n");
                        System.out.print("Choose what you want to perform : ");

                        int option = sc.nextInt();
                        switch(option)
                        {
                            case 1: {
                                obj.Withdraw();
                                break;
                            }
                            case 2:{
                                obj.Deposit();
                                break;
                            }
                            case 3:{
                                obj.Balance();
                                break;
                            }
                            case 4:{
                                obj.Trans_history();
                                break;
                            }
                            case 5:{
                                obj.transfer();
                                break;
                            }
                            case 6:{
                                System.exit(0);
                            }
                        }
                    }
                }
                else {
                    System.out.println("Invalid Login Details!!");
                    System.out.println("Please re-enter!!");
                    break;
                }
            }
        }
    }
}