public class CubeFace {

    private char[][] cube = new char[3][3];

    public CubeFace(char color) {
        initCubeFace(color);
    }

    public void printOneLineOfFace(int i) {
        for (int j = 0; j < 3; j++) {
            System.out.printf("%3c", cube[i][j]);
        }
    }

    public StringBuilder getLeftAndRightLine(int column) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            line.append(cube[i][column]);
        }
        return line;
    }

    public StringBuilder getTopAndBottomLine(int row) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            line.append(cube[row][i]);
        }
        return line;
    }

    public void setLeftAndRightCube(int column, String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[i][column] = movedLine.charAt(i);
        }
    }

    public void setTopAndBottomCube(int row, String movedLine) {
        for (int i = 0; i < 3; i++) {
            cube[row][i] = movedLine.charAt(i);
        }
    }

    private void initCubeFace(char color) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[i][j] = color;
            }
        }
    }


}

