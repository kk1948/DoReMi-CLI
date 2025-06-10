package manager;
import model.Subscription;
import model.TopUp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class SubscriptionManager {

	private LocalDate startDate;
	private final Map<String, Subscription> subscriptions;
	private TopUp topUp;
	private boolean isStartDateSet;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public SubscriptionManager() {
		subscriptions = new HashMap<>();
		isStartDateSet = false;
	}

	public void processCommand(String commandLine) {
		String[] parts = commandLine.split(" ");
		String command = parts[0];

		switch (command) {
			case "START_SUBSCRIPTION":
				handleStartSubscription(parts);
				break;
			case "ADD_SUBSCRIPTION":
				handleAddSubscription(parts);
				break;
			case "ADD_TOPUP":
				handleAddTopUp(parts);
				break;
			case "PRINT_RENEWAL_DETAILS":
				printRenewalDetails();
				break;
			default:
				System.out.println("INVALID COMMAND");
		}
	}


	private void handleStartSubscription(String[] parts) {
		try {
			this.startDate = LocalDate.parse(parts[1], formatter);
			isStartDateSet = true;
		} catch (Exception e) {
			System.out.println("INVALID_DATE");
		}
	}

	private void handleAddSubscription(String[] parts) {
		if (!isStartDateSet) {
			System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
			return;
		}

		String category = parts[1];
		String planName = parts[2];

		if (subscriptions.containsKey(category)) {
			System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
			return;
		}

		try {
			Subscription sub = new Subscription(category, planName);
			subscriptions.put(category, sub);
		} catch (IllegalArgumentException e) {
			System.out.println("ADD_SUBSCRIPTION_FAILED " + e.getMessage());
		}
	}

	//Add TOP Up
	private void handleAddTopUp(String[] parts) {
		if (!isStartDateSet || subscriptions.isEmpty()) {
			System.out.println("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
			return;
		}

		if (topUp != null) {
			System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
			return;
		}

		String topUpType = parts[1];
		int months = Integer.parseInt(parts[2]);

		try {
			topUp = new TopUp(topUpType, months);
		} catch (IllegalArgumentException e) {
			System.out.println("ADD_TOPUP_FAILED " + e.getMessage());
		}
	}

	private void printRenewalDetails() {
		if (!isStartDateSet || subscriptions.isEmpty()) {
			System.out.println("SUBSCRIPTIONS_NOT_FOUND");
			return;
		}

		int totalAmount = 0;

		for (Subscription sub : subscriptions.values()) {
			LocalDate renewalDate = startDate.plusMonths(sub.getDurationInMonths()).minusDays(10);
			System.out.println("RENEWAL_REMINDER " + sub.getCategory() + " " + renewalDate.format(formatter));
			totalAmount += sub.getCost();
		}

		if (topUp != null) {
			totalAmount += topUp.getTotalCost();
		}

		System.out.println("RENEWAL_AMOUNT " + totalAmount);
	}
}


