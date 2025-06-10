package util;

import model.PlanDetail;

import java.util.HashMap;
import java.util.Map;

public class PlanDetailsProvider {
	private static final Map<String, Map<String, PlanDetail>> plans = new HashMap<>();

	static {
		// MUSIC plans
		Map<String, PlanDetail> musicPlans = new HashMap<>();
		musicPlans.put("FREE", new PlanDetail(1, 0));
		musicPlans.put("PERSONAL", new PlanDetail(1, 100));
		musicPlans.put("PREMIUM", new PlanDetail(3, 250));

		// VIDEO plans
		Map<String, PlanDetail> videoPlans = new HashMap<>();
		videoPlans.put("FREE", new PlanDetail(1, 0));
		videoPlans.put("PERSONAL", new PlanDetail(1, 200));
		videoPlans.put("PREMIUM", new PlanDetail(3, 500));

		// PODCAST plans
		Map<String, PlanDetail> podcastPlans = new HashMap<>();
		podcastPlans.put("FREE", new PlanDetail(1, 0));
		podcastPlans.put("PERSONAL", new PlanDetail(1, 100));
		podcastPlans.put("PREMIUM", new PlanDetail(3, 300));

		// Store in outer map
		plans.put("MUSIC", musicPlans);
		plans.put("VIDEO", videoPlans);
		plans.put("PODCAST", podcastPlans);
	}

	public static PlanDetail getPlanDetail(String category, String planName) {
		if (!plans.containsKey(category) || !plans.get(category).containsKey(planName)) {
			throw new IllegalArgumentException("INVALID PLAN");
		}
		return plans.get(category).get(planName);
	}
}
