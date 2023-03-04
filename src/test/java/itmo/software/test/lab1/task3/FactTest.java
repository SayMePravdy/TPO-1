package itmo.software.test.lab1.task3;

import itmo.software.test.lab1.task3.fact.TruthState;
import itmo.software.test.lab1.task3.invention.Invention;
import itmo.software.test.lab1.task3.invention.InventionType;
import itmo.software.test.lab1.task3.planet.Earth;
import itmo.software.test.lab1.task3.resident.Dolphin;
import itmo.software.test.lab1.task3.resident.Human;
import itmo.software.test.lab1.task3.resident.Population;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactTest {
    @Test
    void onlyHumanPopulation_FactTrue_test() {
        List<Invention> humanInventions = createHumanInventions(10);
        Population human = new Human(humanInventions);
        Earth earth = new Earth(List.of(human));
        assertAll(
                () -> assertEquals(TruthState.SUCH, earth.getFact(human).getTruth().getTruthState(), "Факты людей таковы!")
        );
    }

    @Test
    void onlyDolphinPopulation_FactTrue_test() {
        List<Invention> dolphinInventions = createDolphinInventions(10);
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(dolphin));
        assertAll(
                () -> assertEquals(TruthState.SUCH, earth.getFact(dolphin).getTruth().getTruthState(), "Факты дельфинов таковы!")
        );
    }

    @Test
    void humanPopulation_FactTrue_test() {
        List<Invention> humanInventions = createHumanInventions(10);
        Population human = new Human(humanInventions);
        List<Invention> dolphinInventions = createDolphinInventions(9);
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(human, dolphin));
        assertAll(
                () -> assertEquals(TruthState.SUCH, earth.getFact(human).getTruth().getTruthState(), "Факты людей таковы!")
        );
    }

    @Test
    void humanPopulation_FactFalse_test() {
        List<Invention> humanInventions = createHumanInventions(10);
        Population human = new Human(humanInventions);
        List<Invention> dolphinInventions = createDolphinInventions(16);
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(human, dolphin));
        assertAll(
                () -> assertEquals(TruthState.NOT_SUCH, earth.getFact(human).getTruth().getTruthState(), "Факты людей не таковы!")
        );
    }

    @Test
    void dolphinPopulation_FactFalse_test() {
        List<Invention> humanInventions = createHumanInventions(10);
        Population human = new Human(humanInventions);
        List<Invention> dolphinInventions = createDolphinInventions(9);
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(human, dolphin));
        assertAll(
                () -> assertEquals(TruthState.NOT_SUCH, earth.getFact(dolphin).getTruth().getTruthState(), "Факты дельфинов не таковы!")
        );
    }

    @Test
    void humanPopulation_FactTrue_equalsInventions_test() {
        List<Invention> humanInventions = createHumanInventions(10);
        Population human = new Human(humanInventions);
        List<Invention> dolphinInventions = createDolphinInventions(15);
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(human, dolphin));
        assertAll(
                () -> assertEquals(TruthState.SUCH, earth.getFact(human).getTruth().getTruthState(), "Факты людей таковы!")
        );
    }

    @Test
    void dolphinPopulation_FactTrue_equalsInventions_test() {
        List<Invention> humanInventions = createHumanInventions(10);
        Population human = new Human(humanInventions);
        List<Invention> dolphinInventions = createDolphinInventions(15);
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(human, dolphin));
        assertAll(
                () -> assertEquals(TruthState.SUCH, earth.getFact(dolphin).getTruth().getTruthState(), "Факты дельфинов таковы!")
        );
    }

    @Test
    void humanPopulation_FactFalse_withoutInventions_test() {
        List<Invention> humanInventions = List.of();
        Population human = new Human(humanInventions);
        List<Invention> dolphinInventions = createDolphinInventions(15);
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(human, dolphin));
        assertAll(
                () -> assertEquals(TruthState.NOT_SUCH, earth.getFact(human).getTruth().getTruthState(), "Факты людей не таковы!")
        );
    }

    @Test
    void dolphinPopulation_FactFalse_withoutInventions_test() {
        List<Invention> humanInventions = createHumanInventions(10);
        Population human = new Human(humanInventions);
        List<Invention> dolphinInventions = List.of();
        Population dolphin = new Dolphin(dolphinInventions);
        Earth earth = new Earth(List.of(human, dolphin));
        assertAll(
                () -> assertEquals(TruthState.NOT_SUCH, earth.getFact(dolphin).getTruth().getTruthState(), "Факты дельфинов не таковы!")
        );
    }


    private List<Invention> createHumanInventions(double weight) {
        return List.of(
                new Invention(InventionType.WHEEL, weight),
                new Invention(InventionType.WAR, weight),
                new Invention(InventionType.NEW_YORK, weight)
        );
    }

    private List<Invention> createDolphinInventions(double weight) {
        return List.of(
                new Invention(InventionType.HAVE_FUN, weight),
                new Invention(InventionType.SPLASHING_AROUND, weight)
        );
    }
}
