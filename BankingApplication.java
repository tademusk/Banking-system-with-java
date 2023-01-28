import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {

	   System.out.println("Type 1 to choose the 1st account");
	   System.out.println("Type 2 to choose the 2nd account");

      Scanner s = new Scanner(System.in);
	   int ss = s.nextInt();

	   if (ss == 1){
		BankAccount obj = new BankAccount("SL DevCode", "SL00001");
		obj.showMenu();	
	   }

	   else if (ss == 2) {
		BankAccount obj = new Xaccount("SL DevCode", "SL00001");
		obj.showMenu();	
	   }
	   else {
		System.out.println("Invalid input, please try again");
	   }		

	}

}
class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname , String cid) {
		customerName = cname;
		customerId = cid;
	}
	
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(balance > amount) {
			balance = balance - amount;
			previousTransaction = -amount;
            System.out.print("You succesfully withdrow " + amount + "birr");
		}
		else {
			System.out.print("You do not have enough balance");

		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdraw: " +Math.abs(previousTransaction));
		}
		
		else {
			System.out.println("No Transaction Occured");
		}
	}
	char inout = '\0';

	void showMenu() {
		
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " +customerName);
		System.out.println("Your ID is " +customerId);
		System.out.println("\n");
		
		
		
		do {

			System.out.println("A : Check Your Balance");
		    System.out.println("B : Deposit");
		    System.out.println("C : Withdraw");
		    System.out.println("D : Previous Transaction");
		    System.out.println("E : Exit The System");
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("Enter Your Option");
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch (option) {
			
			case 'A':
				System.out.println("-------------------------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("-------------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("-------------------------------------------------------");
				System.out.println("Enter an amount to deposit ");
				System.out.println("-------------------------------------------------------");
				
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("-------------------------------------------------------");
				System.out.println("Enter an amount to withdraw ");
				System.out.println("-------------------------------------------------------");
				
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("-------------------------------------------------------");
				getPreviousTransaction();
				System.out.println("-------------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E' :
				System.out.println("=========================================================================================================");
				break;

			default:
				System.out.println("Invalid Option!! Please Enter Correct Opton...");
				break;
			}
			System.out.println("press any key if you want an other service");
			Scanner inputScanner = new Scanner(System.in);
			inout = inputScanner.next().charAt(0);			
		}
		while(option != 'E' && inout != '\0');
			System.out.println("Thank You for Using our Services.....!!");
	}
}
// the class Xaccount is inherited from class "bankaccount"
class Xaccount extends BankAccount {
	Xaccount (String s, String d) {
		super(s,d);
	}

	// fllowing withdraw methed is overrode with the "withdrow" methode inside the parrent class "bankaccount". this concept is called 
	// polimorphism.

	void withdraw(int amount) {
		System.out.println("Withdrawing is not allowed with this account please try again with account 1");
   }
}