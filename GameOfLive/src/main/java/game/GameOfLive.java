package game;

/**
 * Created by arabk on 17.02.2018.
 */
public class GameOfLive {

    public static int [][] nextEvolutionStep(int [][] currentCells) {

        int [][] result = new int[currentCells.length][];


        for(int i = 0; i < currentCells.length; i++) {
            result[i] = new int[currentCells[i].length];
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
        if(checkIfArrayElementExists(array,x-1, y-1)) {
            sum += array[x-1][y-1];
        }

        if(checkIfArrayElementExists(array,x-1, y)) {
            sum += array[x-1][y];
        }

        if(checkIfArrayElementExists(array,x-1, y+1)) {
            sum += array[x-1][y+1];
        }

        if (checkIfArrayElementExists(array,x, y+1)) {
            sum += array[x][y + 1];
        }

        if (checkIfArrayElementExists(array,x+1, y+1)) {
            sum += array[x + 1][y + 1];
        }

        if (checkIfArrayElementExists(array,x+1, y)) {
            sum += array[x + 1][y];
        }

        if (checkIfArrayElementExists(array,x+1, y-1)) {
            sum += array[x + 1][y - 1];
        }

        if (checkIfArrayElementExists(array,x, y-1)) {
            sum += array[x][y - 1];
        }

        return sum;
    }


    private static boolean checkIfArrayElementExists(int [][] array, int x, int y) {
        if(x < 0 || y < 0) {
            return false;
        }

        if(x >= array.length) {
            return false;
        }

        if(y >= array[x].length) {
            return false;
        }

        return true;
    }

}
