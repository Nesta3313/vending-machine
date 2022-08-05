package com.techelevator;

import com.techelevator.view.*;

import java.math.BigDecimal;
import java.util.Map;

public class CaTEringCapstoneCLI {

	private UserInput menu;

	public CaTEringCapstoneCLI(UserInput menu) {
		this.menu = menu;
	}

	FileReader fileReader = new FileReader();
	Map<String, Snacks> inventory =  fileReader.displayItems();

	public static void main(String[] args) {
		UserInput userInput = new UserInput();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(userInput);
		cli.run();
	}

	public void run() {

		while (true) {

			String choice = UserInput.getWelcomeScreen();

			if(choice.equals("d")){
				UserInput.displayItems(inventory);
			}
			else if(choice.equals("p")){
				purchaseScreen();
			}
			else if (choice.equals("e")){
				System.out.println("Have a nice day");
				break;
			}
			else if (choice.equals("s")){
				SalesReport.createFile();
				SalesReport.salesGenerator(inventory);
			}
			else{
				System.out.println("Choose again");
			}
		}
	}

	public void purchaseScreen() {

		while(true) {

			String option = UserInput.purchasingMenu();
			BigDecimal tempAmount = BigDecimal.ZERO;

			if(option.equals("m")){
				tempAmount = feedMoney();
			}
			else if (option.equals("s")){
				UserInput.displayItems(inventory);
				String itemOption = UserInput.pickItem();

				if(Wallet.getBalance().compareTo(inventory.get(itemOption).getPrice()) >= 0){
					tempAmount = Wallet.getBalance();

					if(inventory.get(itemOption).purchaseItem()){
						Wallet.removeMoney(inventory.get(itemOption));
						System.out.println(inventory.get(itemOption).toString());
						Auditor.purchaseAudit(inventory.get(itemOption).getItem() , inventory.get(itemOption).getLocation() , tempAmount);
					}


				}
				else{
					System.out.println("Please add more money");
					tempAmount = feedMoney();
				}

			}else if(option.equals("f")){
				System.out.println("Your change is: $" + Wallet.getBalance().toString());
				tempAmount = Wallet.getBalance();
				Wallet.clearBalance();
				Auditor.clearingAudit(tempAmount);
				break;

			}

		}

	}

	public BigDecimal feedMoney(){

		BigDecimal tempAmount = BigDecimal.ZERO;
		String whichBill = UserInput.feedMoney();
		if(whichBill.equals("a")){
			tempAmount = BigDecimal.ONE;
		}
		else if (whichBill.equals("b")){
			tempAmount = BigDecimal.valueOf(5.00);
		}
		else if (whichBill.equals("c")){
			tempAmount = BigDecimal.TEN;
		}
		else if (whichBill.equals("d")) {
			tempAmount = BigDecimal.valueOf(20.00);
		}
		else {
			System.out.println();
			System.out.println("Please choose from the options available!");
		}

		Wallet.addMoney(tempAmount);
		Auditor.addMoneyAudit(tempAmount);

		return tempAmount;
	}
}
