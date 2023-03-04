package itmo.software.test.lab1.task3.resident;

import itmo.software.test.lab1.task3.invention.ContributionCalculator;
import itmo.software.test.lab1.task3.invention.Invention;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class Population {
    private List<Invention> inventions;
    private LocationType locationType;

    public double getContributionValue() {
        return ContributionCalculator.calculate(getInventions());
    }
}
