package example.com.client;

import java.util.Scanner;

public class Client {
	public void clientStart() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Выберите действие");
		System.out.println("[1] Купить продукт");
		System.out.print("-> ");
		
		int role = scan.nextInt();
		
		if(role == 1) {
			Order order = new Order();
			order.addProductToOrder();
		}
		
		
	}
}
