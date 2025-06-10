package model;

public class PlanDetail {
	int durationInMonths;
	int cost;

	public PlanDetail(int durationInMonths, int cost) {
		this.durationInMonths = durationInMonths;
		this.cost = cost;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public int getCost() {
		return cost;
	}
}
