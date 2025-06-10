import manager.SubscriptionManager;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SubscriptionManager manager = new SubscriptionManager();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.trim().isEmpty()) break;
			manager.processCommand(line);
		}
		}

}