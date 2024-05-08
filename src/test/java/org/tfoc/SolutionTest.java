package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SolutionTest {

    static Solution solution;

    @BeforeAll
    static void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("provideLinkedLists")
    void testSolution(int[] height, int volume) {

        assertEquals(volume, solution.maxArea(height));
    }

    private static Stream<Arguments> provideLinkedLists() {

        return Stream.of(
                Arguments.of(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                Arguments.of(new int[]{1,1}, 1),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{10}, 0)
        );
    }
}