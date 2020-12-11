public class Printer {

    public Printer() {
    }

    public void printCube(char[][] cube) {
        for (char[] row : cube) {
            for (char box : row) {
                System.out.printf("%3s", box);
            }
            System.out.println();
        }
    }
}
