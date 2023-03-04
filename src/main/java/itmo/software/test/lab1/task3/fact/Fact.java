package itmo.software.test.lab1.task3.fact;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fact {
    private Boolean isKnown = true;
    private Boolean isImportant = true;
    private Truth truth;

    public Fact(TruthState truthState) {
        this.truth = new Truth(truthState);
    }
}
