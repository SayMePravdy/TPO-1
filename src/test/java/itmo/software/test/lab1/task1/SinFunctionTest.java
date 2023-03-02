package itmo.software.test.lab1.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinFunctionTest {

    private static final double DELTA = 0.00001;

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI, -1 * Math.PI})
    void testSinZeroValues(double dot) {
        assertAll(
                () -> assertEquals(0, SinFunction.calc(dot), DELTA)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5 * Math.PI, -1.5 * Math.PI})
    void testSinMaxValues(double dot) {
        assertAll(
                () -> assertEquals(1, SinFunction.calc(dot), DELTA)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.5 * Math.PI, 1.5 * Math.PI})
    void testSinMinValues(double dot) {
        assertAll(
                () -> assertEquals(-1, SinFunction.calc(dot), DELTA)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.334, 0.987, 1.29, 1.5, -0.3, -0.66, -0.894, -1.22, -1.465})
    void testRandomValue(double dot) {
        assertAll(
                () -> assertEquals(Math.sin(dot), SinFunction.calc(dot), DELTA)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            3 * Math.PI, 4.999999 * Math.PI, 9 * Math.PI, 100.4 * Math.PI, -4 * Math.PI, -19 * Math.PI, -24.99999999 * Math.PI
    })
    void testWithGreaterThen2PIDots(double dot) {
        assertAll(
                () -> assertEquals(Math.sin(dot), SinFunction.calc(dot), DELTA)
        );
    }

}
