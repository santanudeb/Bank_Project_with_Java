package com.SimpleBank;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main extends Account {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.getLogin();
    }

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    public void getLogin() throws IOException {
        int x=1;
        do
        {
            try
            {
                data.put(9876,98);
                data.put(8989,89);
                System.out.println("Welcome to the Bank ==> ");
                System.out.print("Enter your customer number: "+"\n");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter your pin number"+"\n");
                setPinNumber(menuInput.nextInt());
            }
            catch(Exception e)
            {
                System.out.println("Invalid");
                x=2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) //??
            {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber())  //??
                {
                    getAccountType();
                }
            }
            System.out.println("\n"+"Wrong Login Entry: "+"\n");
        } while (x == 1);
    }

    public void getAccountType(){
        System.out.println("Select Account you want to access: ");
        System.out.println("1: Checking Account");
        System.out.println("2: Saving Account");
        System.out.println("3: Exit");
        System.out.print("Choice: ");

        selection=menuInput.nextInt();

        switch (selection)
        {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using ATM");
                break;
            default:
                System.out.println("Error");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("1: View Balance");
        System.out.println("2: Withdraw Funds");
        System.out.println("3: Deposit Funds");
        System.out.println("4: Exit");
        System.out.print("Choice: ");

        selection=menuInput.nextInt();

        switch (selection)
        {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance())); //??
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using ATM");
                break;
            default:
                System.out.println("Error");
                getChecking();
        }
    }
    public void getSaving(){
        System.out.println("Savinging Account: ");
        System.out.println("1: View Balance");
        System.out.println("2: Withdraw Funds");
        System.out.println("3: Deposit Funds");
        System.out.println("4: Exit");
        System.out.print("Choice: ");

        selection=menuInput.nextInt();

        switch (selection)
        {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance())); //??
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using ATM");
                break;
            default:
                System.out.println("Error");
                getChecking();
        }
    }
    int selection;
}
