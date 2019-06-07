public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("MAGIC SQUARE\n\n");
            MagicSquare magicSquare = new MagicSquare(8, 8, 0);
            magicSquare.generate();

            System.out.println("DECIMAL MATRIX");
            magicSquare.displayDecimal();

            System.out.println("BINARY MATRIX");
            magicSquare.displayBinary();

            System.out.println("MAGIC CUBE\n\n");
            for (int i = 0; i < 64; i += 16) {
                magicSquare = new MagicSquare(4, 4, i);
                magicSquare.generate();

                System.out.println("Cube");
                magicSquare.displayDecimal();
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
