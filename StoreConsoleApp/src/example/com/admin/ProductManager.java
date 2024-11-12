package example.com.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
	public void addNewProduct() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Эхтибар//Downloads//products.txt", true))) {
            Scanner scan = new Scanner(System.in);

            System.out.print("Сколько продуктов хотите добавить? -> ");
            int countOfProductsToAdd = scan.nextInt();
            scan.nextLine();
            System.out.println("");
            
            for (int i = 1; i <= countOfProductsToAdd; i++) {
                System.out.println("Добавьте продукт номер: " + i);

                System.out.print("Введите название продукта: ");
                String prodName = scan.nextLine();

                System.out.print("Введите цену продукта: ");
                double prodPrice = scan.nextDouble();
                scan.nextLine();

                System.out.print("Введите описание продукта: ");
                String prodDesc = scan.nextLine();

                System.out.print("Введите категорию продукта: ");
                String prodCategory = scan.nextLine();


                writer.write(prodName + "," + prodPrice + "," + prodDesc + "," + prodCategory);
                writer.newLine();

                System.out.println("Продукт добавлен: " + prodName);
                System.out.println("");
            }
            System.out.println("Вы добавили " + countOfProductsToAdd + " продукт(ов) в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи продукта в файл: " + e.getMessage());
        }
    }
	

    public void listProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C://Users//Эхтибар//Downloads//products.txt"))) {
            String line;
            if ((line = reader.readLine()) == null) {
                System.out.println("Список продуктов пуст.");
                return;
            }
            System.out.println("📝 Список продуктов: ");
            do {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String prodName = data[0];
                    double prodPrice = Double.parseDouble(data[1]);
                    String prodDesc = data[2];
                    String prodCategory = data[3];
                    System.out.println("Название: " + prodName + ", Цена: " + prodPrice +
                                       ", Описание: " + prodDesc + ", Категория: " + prodCategory);
                }
            } while ((line = reader.readLine()) != null);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении продуктов из файла: " + e.getMessage());
        }
    }
    
    public void deleteProduct() {
        try {
            // Сначала считываем все продукты из файла
            ArrayList<String> products = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("C://Users//Эхтибар//Downloads//products.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    products.add(line);
                }
            }

            // Проверяем, есть ли продукты для удаления
            if (products.isEmpty()) {
                System.out.println("Список продуктов пуст.");
                return;
            }

            // Выводим все продукты в нумерованном виде
            System.out.println("📝 Список продуктов для удаления: ");
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

            // Запрашиваем номер продукта для удаления
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите номер продукта для удаления: ");
            int productNumber = scan.nextInt();
            scan.nextLine();

            // Проверяем, корректен ли номер
            if (productNumber < 1 || productNumber > products.size()) {
                System.out.println("Неверный номер продукта.");
                return;
            }

            // Удаляем выбранный продукт
            products.remove(productNumber - 1); // Уменьшаем на 1, так как индексация начинается с 0

            // Записываем обновленный список продуктов обратно в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Эхтибар//Downloads//products.txt"))) {
                for (String product : products) {
                    writer.write(product);
                    writer.newLine();
                }
            }

            System.out.println("Продукт успешно удален.");
        } catch (IOException e) {
            System.out.println("Ошибка при удалении продукта: " + e.getMessage());
        }
    }
}
