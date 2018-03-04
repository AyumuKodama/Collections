import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrderTester {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		Integer prepTime = null;
		String menuItem = null;
		while (prepTime == null) {
			System.out.println("What do you want to order?");
			menuItem = scnr.next();
			if (menuItem.equalsIgnoreCase("Hamburger")) {
				prepTime = 6;
			} else if (menuItem.equalsIgnoreCase("Pizza")) {
				prepTime = 4;
			} else if (menuItem.equalsIgnoreCase("Salad")) {
				prepTime = 5;
			} else if (menuItem.equalsIgnoreCase("Nachos")) {
				prepTime = 4;
			} else if (menuItem.equalsIgnoreCase("Smoothie")) {
				prepTime = 2;
			} else {
				System.out.println("I am sorry, but we do not have that here.");
			}
		}
		
		System.out.println("What is your name?");
		String customerName = scnr.next();
		Order order = new Order(menuItem, customerName, prepTime.intValue());
		Queue<Order> queue = new LinkedList<Order>();
		queue.add(order);
		prepTime = null;
		int totalTime = 0;
		int time = 0;
		
		while (queue.size() > 0) {
			totalTime = 0;
			for (Order item : queue) {
				totalTime += item.time();
			}
			totalTime -= time;
			
			if (queue.size() == 1) {
				System.out.println("There is 1 more item in the queue.");
			} else {
				System.out.println("There are " + queue.size() + " more items in the queue.");
			}
			System.out.println("The item being made right now is " + queue.element().item() + ".");
			if (totalTime == 1) {
				System.out.println("It will take 1 more minute to finish your order.");
			} else {
				System.out.println("It will take " + totalTime + " more minutes to finish your order.");
			}
			
			System.out.println("Would you like  to order something else?");
			System.out.println("Yes/No");
			if ((scnr.next()).equalsIgnoreCase("yes")) {
				while (prepTime == null) {
					System.out.println("What do you want to order?");
					menuItem = scnr.next();
					if (menuItem.equalsIgnoreCase("Hamburger")) {
						prepTime = 6;
					} else if (menuItem.equalsIgnoreCase("Pizza")) {
						prepTime = 4;
					} else if (menuItem.equalsIgnoreCase("Salad")) {
						prepTime = 5;
					} else if (menuItem.equalsIgnoreCase("Nachos")) {
						prepTime = 4;
					} else if (menuItem.equalsIgnoreCase("Smoothie")) {
						prepTime = 2;
					} else {
						System.out.println("I am sorry, but we do not have that here.");
					}
				}
				Order order1 = new Order(menuItem, customerName, prepTime.intValue());
				queue.add(order1);
			}
			
			if (queue.element().time() == time) {
				System.out.println(queue.element().name() + ", your order of " + queue.element().item() + " is finished.");
				queue.remove();
				time = 0;
			} else {
				System.out.println("The first order will be finished in " + (queue.element().time() - time) + " min.");
			}
			time++;
			System.out.println();
		}
		scnr.close();
		
	}
}
