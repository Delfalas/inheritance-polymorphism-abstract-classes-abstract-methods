package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		List <Product> list = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
		System.out.println("Product #" + i + " data: ");
		System.out.print("Common, used or imported (c/u/i)? ");
		char ch = sc.next().charAt(0);
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Price: ");
		double price = sc.nextDouble();
			if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			else if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee)); 
			}
			else if (ch == 'c') {
				list.add(new Product(name, price));
			}
			else {
				System.out.println("Não digitou nenhuma das opções acima, repita o processo! ");
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product prod : list) { //for each para percorrer a lista e entregar o resultado da tag do produto
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}
}
