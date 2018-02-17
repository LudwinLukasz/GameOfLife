package game;

/**
 * Created by arabk on 17.02.2018.
 */
public class GameOfLive {

    public static int [][] nextEvolutionStep(int [][] currentCells) {

        int [][] result = new int[currentCells.length][];


        for(int i = 0; i < currentCells.length; i++) {
            for(int k = 0; k < currentCells[i].length; k++) {
                int aliveNeighboursSum = getNeighboursSum(currentCells, i, k);

                if(currentCells[i][k] == 1) {
                    result[i][k] = checkIfCellStaysAlive(aliveNeighboursSum);
                } else {
                    result[i][k] = checkIfCellBecomesAlive(aliveNeighboursSum);
                }
            }
        }

        return result;
    }

    private static int checkIfCellStaysAlive(int aliveNeighboursSum) {
        if(aliveNeighboursSum == 2 || aliveNeighboursSum == 3) {
            return 1;
        }

        return 0;
    }

    private static int checkIfCellBecomesAlive(int aliveNeighboursSum) {
        if(aliveNeighboursSum == 3) {
            return 1;
        }
        return 0;
    }

    private static int getNeighboursSum(int [][] array, int x, int y) {
        int sum = 0;
        if(x - 1 >= 0 && y - 1 >= 0) {
            sum += array[x-1][y-1];
        }

        if(y - 1 >= 0) {
            sum += array[x][y-1];
        }

        if(x + 1 < array.length && y - 1 >= 0) {
            sum += array[x + 1][y-1];
        }

        if (x + 1 < array.length) {
            sum += array[x + 1][y];
        }

        if (x + 1 < array.length && y + 1 < array[x + 1].length) {
            sum += array[x + 1][y + 1];
        }

        if (y + 1 < array[x + 1].length) {
            sum += array[x][y + 1];
        }

        if (x - 1 >= 0 && y + 1 < array[x + 1].length) {
            sum += array[x - 1][y + 1];
        }

        if (x - 1 >= 0) {
            sum += array[x - 1][y];
        }

        return sum;
    }

}
