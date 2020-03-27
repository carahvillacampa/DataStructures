package hw2;

/*
 * 1. private int data field named id for the account
 * 2. private double named balance for the account
 * 3. private double data field named annualInterestRate that stores the current interest rate
 * with a default of 0
 * 4. a private Date data field named date created that stores the date when the account
 * was created
 * 5. a no arg constructor that creates a default account
 * 6. A constructor that creates an account with the specified Id and initial balance
 * 7. accessor and mutator methods for id, balance, annualInterestRate
 * 8. accessor method for dateCreated
 * 9. getMonthlyInterestRate() that returns the monthly interest rate
 * 10. a method named withdraw that withdraws a specified amount from the account
 * 11. a method named deposit that deposists a specified amount to the account
 * 
 * Tester:
 * 1. write a test program that creates an Account object with an accountID of 1122
 * 2. balance of 20,000 and an annual interest rate of 4.5% 
 * 3. Use the withdraw method to withdraw 2,500
 * 4. use the deposit method to deposit 3000 and print the balance, monthly interest and the
 * date when the account was created
 * 
 * Hints:
 * 1. getMonthlyInterest= return monthly interest
 * 2. Monthly interest is balance*monthlyInterestRate.monthlyInterestRate 
 * is annualInterestRate/12
 * 3. note that annualInterestRate is a percentage so multiply by 100
 */

import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate=0.0;
	private Date date;
	
	
	Account(){ //no arc constructor that creates a default account
	}
	
	Account(int ident, double bal,double annualInterest) {
		this.id= ident;
		this.balance= bal;	
		this.annualInterestRate= annualInterest;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate *100;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getmonthlyInterestRate() {
		return (annualInterestRate/12);
	}
	
	public double depositAcc(int deposit) {
		this.balance= balance+deposit;
		return balance;
	}
	
	public double withdrawAcc(int withdraw) {
		this.balance= balance- withdraw;
		return balance;
	}
	

	public static void main(String[] args) {
		Account unknownclient= new Account(); //using the no arg constructor without anything
		System.out.println(unknownclient.getBalance());
		
		Account client1= new Account(1122, 20000, 3.5); //using the second constructor with 
														//specified values
	
		System.out.println(client1.withdrawAcc(12000));
		System.out.println(client1.depositAcc(6000));
		System.out.println("This is your monthly interest: "+ client1.getmonthlyInterestRate());
		System.out.println("This is your account's balance: "+ client1.getBalance());
		System.out.println("Date the account was created: "+ client1.getDate());
		

	}

}
