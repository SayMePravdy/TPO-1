package itmo.software.test.lab1.task3.planet;

import itmo.software.test.lab1.task3.resident.Population;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Accessors(chain = true)
public abstract class Planet {
    private String name = "Планета";
    private List<Population> populationList = List.of();
}

