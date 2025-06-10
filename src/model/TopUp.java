package model;

public class TopUp {
	private String type;              // FOUR_DEVICE or TEN_DEVICE
	private int durationInMonths;
	private int costPerMonth;

	public TopUp(String type, int durationInMonths) {
		this.type = type;
		this.durationInMonths = durationInMonths;
		this.costPerMonth = determineCostPerMonth(type);
	}

	private int determineCostPerMonth(String type) {
		switch (type) {
			case "FOUR_DEVICE":
				return 50;
			case "TEN_DEVICE":
				return 100;
			default:
				throw new IllegalArgumentException("INVALID TOPUP TYPE");
		}
	}

	public int getTotalCost() {
		return costPerMonth * durationInMonths;
	}

	public String getType() {
		return type;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public int getCostPerMonth() {
		return costPerMonth;
	}
}
