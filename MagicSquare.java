public class MagicSquare {
    private int arr[][];

    public MagicSquare(int rows, int cols) {
        arr = new int[rows][cols];
    }

    public void generate() {
        int size = arr.length;
        int currentValue = 0;
        int maxValue = (size * size) - 1;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                if (validateDiamondPattern(i, j)) {
                    arr[i][j] = currentValue;
                } else {
                    arr[i][j] = maxValue - currentValue;
                }
                currentValue++;
            }
        }
    }

    public void display() {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    private boolean validateDiamondPattern(int row, int col) {
        int size = arr.length - 1;
        int halfSize = size / 2;

        if (row == col || col + row == size) {
            return true;
        }

        if (row <= halfSize) {
            if (col <= halfSize) {
                return col + row == 3;
            } else {
                return col - row == 4;
            }
        } else {
            if (col <= halfSize) {
                return row - col == 4;
            } else {
                return col + row == 11;
            }
        }
    }
}
