package itmo.software.test.lab1.task3;

import itmo.software.test.lab1.task3.fact.Fact;
import itmo.software.test.lab1.task3.fact.Truth;
import itmo.software.test.lab1.task3.fact.TruthState;
import itmo.software.test.lab1.task3.invention.Invention;
import itmo.software.test.lab1.task3.invention.InventionType;
import itmo.software.test.lab1.task3.planet.Earth;
import itmo.software.test.lab1.task3.resident.Dolphin;
import itmo.software.test.lab1.task3.resident.Human;
import itmo.software.test.lab1.task3.resident.Population;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContractTest {
    @Test
    @DisplayName("Проверка контракта класса Fact")
    void fact_contract_test() {
        Fact fact = new Fact(TruthState.SUCH);
        assertAll(
                () -> assertEquals(TruthState.SUCH, fact.getTruth().getTruthState(), "Состояние факта не соотвествует заявленному"),
                () -> assertTrue(fact.getIsKnown(), "Состояние известности не соответсвует заявленному"),
                () -> assertTrue(fact.getIsImportant(), "Состояние важности не соответсвует заявленному")
        );
    }

    @Test
    @DisplayName("Проверка контракта класса Truth")
    void truth_contract_test() {
        Truth truth = new Truth(TruthState.SUCH);
        assertAll(
                () -> assertEquals(TruthState.SUCH, truth.getTruthState(), "Состояние правды не соотвествует заявленному")
        );
    }

    @Test
    @DisplayName("Проверка контракта класса Invention")
    void invention_contract_test() {
        Invention invention = new Invention(InventionType.HAVE_FUN, 10d);
        assertAll(
                () -> assertEquals(InventionType.HAVE_FUN, invention.getType(), "Тип Изобретения не соотвествует заявленному"),
                () -> assertEquals(10d, invention.getWeight(), "Вес изобретения не соотвествует заявленному")
        );
    }

    @Test
    @DisplayName("Проверка контракта класса Earth")
    void earth_contract_test() {
        Population human = new Human(List.of());
        Earth earth = new Earth(List.of(human));
        assertAll(
                () -> assertEquals("Земля", earth.getName(), "Название Земли не соотвествует заявленному"),
                () -> assertEquals(List.of(human), earth.getPopulationList(), "Популяция Земли не соотвествует заявленной")
        );
    }

    @Test
    @DisplayName("Проверка контракта класса Dolphin")
    void dolphin_contract_test() {
        Invention invention = new Invention(InventionType.SPLASHING_AROUND, 30d);
        Invention invention2 = new Invention(InventionType.HAVE_FUN, 30d);
        Dolphin dolphin = new Dolphin(List.of(invention, invention2));
        assertAll(
                () -> assertEquals(List.of(invention, invention2), dolphin.getInventions(), "Изобретения дельфинов не соотвествует заявленным"),
                () -> assertEquals(60d, dolphin.getContributionValue(), "Вклад в изобретения не соотвествует заявленным")
        );
    }

    @Test
    @DisplayName("Проверка контракта класса Human")
    void human_contract_test() {
        Invention invention = new Invention(InventionType.NEW_YORK, 10d);
        Invention invention2 = new Invention(InventionType.WAR, 10d);
        Invention invention3 = new Invention(InventionType.WHEEL, 10d);
        Human human = new Human(List.of(invention, invention2, invention3));
        assertAll(
                () -> assertEquals(List.of(invention, invention2, invention3), human.getInventions(), "Изобретения людей не соотвествует заявленным"),
                () -> assertEquals(30d, human.getContributionValue(), "Вклад в изобретения не соотвествует заявленным")
        );
    }
}
