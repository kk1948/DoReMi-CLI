package model;

import util.PlanDetailsProvider;

public class Subscription {
	private String category;
	private String planName;
	private int durationInMonths;
	private int cost;

	public Subscription(String category, String planName) {
		this.category = category;
		this.planName = planName;

		PlanDetail detail = PlanDetailsProvider.getPlanDetail(category, planName);
		this.durationInMonths = detail.getDurationInMonths();
		this.cost = detail.getCost();
	}

	public String getCategory() {
		return category;
	}

	public String getPlanName() {
		return planName;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public int getCost() {
		return cost;

	}
}
