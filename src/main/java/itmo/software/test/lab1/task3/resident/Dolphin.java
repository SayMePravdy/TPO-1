package itmo.software.test.lab1.task3.resident;

import itmo.software.test.lab1.task3.invention.Invention;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Dolphin extends Population {

    public Dolphin(List<Invention> inventions) {
        super(inventions, LocationType.WATER);
    }

}
