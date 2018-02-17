package game;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by arabk on 17.02.2018.
 */
public class GameOfLiveTest {

    @Test
    public void nextEvolutionStepEmptyArrayTest() {
        int [][] inputArray =  new int[][]{
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        int [][] result = GameOfLive.nextEvolutionStep(inputArray);
        int [][] expectedResult = new int[][]{
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        assertArrayEquals(expectedResult,result);
    }

    @Test
    public void nextEvolutionStepRandomArrayTest() {
        int [][] inputArray =  new int[][]{
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        int [][] result = GameOfLive.nextEvolutionStep(inputArray);
        int [][] expectedResult = new int[][]{
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        assertArrayEquals(expectedResult,result);
    }

    @Test
    public void nextEvolutionStepArraySideAliveValuesTest() {
        int [][] inputArray =  new int[][]{
                { 1, 1, 1, 1, 1},
                { 1, 0, 0, 0, 1},
                { 1, 0, 0, 0, 1},
                { 1, 0, 0, 0, 1},
                { 1, 1, 1, 1, 1}
        };

        int [][] result = GameOfLive.nextEvolutionStep(inputArray);
        int [][] expectedResult = new int[][]{
                { 1, 1, 1, 1, 1},
                { 1, 0, 1, 0, 1},
                { 1, 1, 0, 1, 1},
                { 1, 0, 1, 0, 1},
                { 1, 1, 1, 1, 1}
        };
        assertArrayEquals(expectedResult,result);
    }
    @Test
    public void nextEvolutionStepArrayAllAliveTest() {
        int [][] inputArray =  new int[][]{
                { 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 1}
        };

        int [][] result = GameOfLive.nextEvolutionStep(inputArray);
        int [][] expectedResult = new int[][]{
                { 1, 0, 0, 0, 1},
                { 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0},
                { 1, 0, 0, 0, 1}
        };
        assertArrayEquals(expectedResult,result);
    }
    @Test
    public void nextEvolutionStepIrregularArrayTest() {
        int [][] inputArray =  new int[][]{
                { 1, 1, 1, 1, 1},
                { 1, 1, 1, 1, 1, 0, 1},
                { 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                { 1, 1, 1, 1, 1},
                { 1, 1}
        };

        int [][] result = GameOfLive.nextEvolutionStep(inputArray);
        int [][] expectedResult = new int[][]{
                { 1, 0, 0, 0, 1},
                { 0, 0, 0, 0, 0, 0, 1},
                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                { 0, 0, 0, 0, 0},
                { 1, 0}
        };
        assertArrayEquals(expectedResult,result);
    }
}
