package example.com;

import java.util.Scanner;

import example.com.admin.*;
import example.com.client.Client;
import example.com.client.Order;

public class Main {

	public static void main(String[] args) {
		String login = "admin12";
		String password = "admin12";
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("** Выберите роль **");
		System.out.println("[1] Админ");
		System.out.println("[2] Покупатель");
		
		System.out.println();
		System.out.print("-> ");
		int role = scan.nextInt();
		
		if(role == 1) {
		  	ProductManager productManager = new ProductManager();
		  	System.out.println("Выберите действие: ");
		  	System.out.println("[1] Добавить продукт");
		  	System.out.println("[2] Удалить продукт");
		  	System.out.println("[3] Вывести все продукты");
		  	
		  	System.out.print("-> ");
		  	
		  	int managerRole = scan.nextInt();
		  	
		  	if(managerRole == 1) {
		  		productManager.addNewProduct();
		  	} else if(managerRole == 2) {
		  		productManager.deleteProduct();
		  	} else if(managerRole == 3) {
		  		productManager.listProducts();
		  	}
		} else if(role == 2) {
			Client client = new Client();
			client.clientStart();
		}
	}
}
