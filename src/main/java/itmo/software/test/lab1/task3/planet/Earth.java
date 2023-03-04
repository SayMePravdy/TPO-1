package itmo.software.test.lab1.task3.planet;

import itmo.software.test.lab1.task3.fact.Fact;
import itmo.software.test.lab1.task3.fact.TruthState;
import itmo.software.test.lab1.task3.resident.Population;

import java.util.List;

public class Earth extends Planet {
    public Earth(List<Population> populationList) {
        super("Земля", populationList);
    }

    public Fact getFact(Population population) {
        Population maxPopulation = null;
        double maxValue = Double.MIN_VALUE;
        double nowValue;
        for (Population p : getPopulationList()) {
            nowValue = p.getContributionValue();
            if (nowValue > maxValue || (nowValue == maxValue && population.equals(p))) {
                maxPopulation = p;
                maxValue = nowValue;
            }
        }
        if (population.equals(maxPopulation)) {
            return new Fact(TruthState.SUCH);
        }
        return new Fact(TruthState.NOT_SUCH);
    }
}
