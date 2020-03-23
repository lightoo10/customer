package pe.com.retail.customer.domain.util;

import java.util.List;
import java.util.OptionalDouble;

public class StatisticalCalculation {

	public static double average(List<Integer> lstEntity) {
		OptionalDouble average = lstEntity.stream().mapToInt(a -> a).average();
		return average.isPresent() ? average.getAsDouble() : 0;
	}

	public static double standardDeviation(List<Integer> lstEntity) {
		double median = median(lstEntity);
		double variance = lstEntity.stream()
                .map(i -> i - median)
                .map(i -> i*i)
                .mapToDouble(i -> i).average().getAsDouble();
		return Math.sqrt(variance);
	}

	public static double median(List<Integer> lstEntity) {
		return lstEntity.stream().sorted().skip(Math.max(0, ((lstEntity.size() + 1) / 2) - 1))
                .limit(1 + (1 + lstEntity.size()) % 2).mapToInt(Integer::intValue).average().getAsDouble();
	}
}
