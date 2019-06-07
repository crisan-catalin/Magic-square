public class MagicSquare {
    private int arr[][];
    private String arrString[][];

    public MagicSquare(int rows, int cols) throws Exception {
        if (rows != cols || rows % 2 != 0) {
            throw new Exception("MagicSquare support only square matrix with even number of rows/cols.");
        }

        arr = new int[rows][cols];
        arrString = new String[rows][cols];
    }

    public void generate() {
        int size = arr.length;
        int currentValue = 0;
        int maxValue = (size * size) - 1;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                if (validateDiamondPattern(i, j)) {
                    arr[i][j] = currentValue;
                    arrString[i][j] = getBinaryValue(currentValue, size - 1);
                } else {
                    int value = maxValue - currentValue;
                    arr[i][j] = value;
                    arrString[i][j] = getBinaryValue(value, size - 1);
                }
                currentValue++;
            }
        }
    }

    public void displayDecimal() {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void displayBinary() {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arrString[i][j] + " ");
            }
            System.out.println();
        }
    }

    private String getBinaryValue(int value, int digits) {
        return String.format("%" + digits + "s", Integer.toBinaryString(value)).replace(' ', '0');
    }

    private boolean validateDiamondPattern(int row, int col) {
        int fullSize = arr.length;
        int size = arr.length - 1;
        int halfSize = size / 2;

        if (row == col || col + row == size) {
            return true;
        }

        if (row <= halfSize) {
            if (col <= halfSize) {
                return col + row == Math.floor(size / 2);
            } else {
                return col - row == fullSize / 2;
            }
        } else {
            if (col <= halfSize) {
                return row - col == fullSize / 2;
            } else {
                return col + row == (Math.floor(size / 2) + 2 * fullSize / 2);
            }
        }
    }
}
