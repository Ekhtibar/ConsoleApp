package example.com.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public void addProductToOrder() {
        ArrayList<String> products = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("C://Users//Эхтибар//Downloads//products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении продуктов: " + e.getMessage());
            return;
        }

        if (products.isEmpty()) {
            System.out.println("Список продуктов пуст.");
            return;
        }

        System.out.println("📝 Список продуктов для добавления в корзину: ");
        for (int i = 0; i < products.size(); i++) {
            String[] data = products.get(i).split(",");
            if (data.length == 4) {
                String prodName = data[0];
                double prodPrice = Double.parseDouble(data[1]);
                String prodDesc = data[2];
                String prodCategory = data[3];
                System.out.println("[" + (i + 1) + "] Название: " + prodName + ", Цена: " + prodPrice +
                                   ", Описание: " + prodDesc + ", Категория: " + prodCategory);
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер продукта для добавления в корзину: ");
        int productNumber = scan.nextInt();
        scan.nextLine();

        if (productNumber < 1 || productNumber > products.size()) {
            System.out.println("Неверный номер продукта.");
            return;
        }

        String selectedProduct = products.get(productNumber - 1);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Эхтибар//Downloads//order.txt", true))) {
            writer.write(selectedProduct);
            writer.newLine();
            System.out.println("Продукт добавлен в корзину: " + selectedProduct);
        } catch (IOException e) {
            System.out.println("Ошибка при добавлении продукта в корзину: " + e.getMessage());
        }
    }
    
    public void orderList() {
        ArrayList<String> orders = new ArrayList<>();

        // Считываем заказы из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("C://Users//Эхтибар//Downloads//order.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении заказов: " + e.getMessage());
            return;
        }

        // Проверяем, есть ли заказы
        if (orders.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        // Выводим заказы в нумерованном виде
        System.out.println("📝 Список заказов: ");
        for (int i = 0; i < orders.size(); i++) {
            String[] data = orders.get(i).split(",");
            if (data.length == 4) {
                String prodName = data[0];
                double prodPrice = Double.parseDouble(data[1]);
                String prodDesc = data[2];
                String prodCategory = data[3];
                System.out.println("[" + (i + 1) + "] Название: " + prodName + ", Цена: " + prodPrice +
                                   ", Описание: " + prodDesc + ", Категория: " + prodCategory);
            }
        }
    }
}