package itmo.software.test.lab1.task3.invention;

import java.util.List;

public class ContributionCalculator {
    public static Double calculate(List<Invention> inventionList) {
        double summaryWeight = 0d;
        for (Invention i : inventionList) {
            summaryWeight += i.getWeight();
        }
        return summaryWeight;
    }
}
