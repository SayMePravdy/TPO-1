package itmo.software.test.lab1.task3.resident;

import itmo.software.test.lab1.task3.invention.Invention;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Human extends Population {

    public Human(List<Invention> inventions) {
        super(inventions, LocationType.EARTH);
    }
}
