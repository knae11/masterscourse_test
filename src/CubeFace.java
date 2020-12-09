public class CubeFace {

    public static final int CUBE_SIZE = 3;
    public static final int CUBE_CENTER = CUBE_SIZE/2;


    private char[][] cube = new char[CUBE_SIZE][CUBE_SIZE];

    public CubeFace(char color) {
        initCubeFace(color);
    }

    public void printOneLineOfFace(int i) {
        for (int j = 0; j < CUBE_SIZE; j++) {
            System.out.printf("%3c", cube[i][j]);
        }
    }

    //TODO : indent 가 너무 깊다. 줄이는 방법 찾기
    public boolean completeFace() {
        char standard = cube[CUBE_CENTER][CUBE_CENTER];
        for (int i = 0; i < CUBE_SIZE; i++) {
            for (int j = 0; j < CUBE_SIZE; j++) {
                if (standard != cube[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public StringBuilder getLeftAndRightLine(int column) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < CUBE_SIZE; i++) {
            line.append(cube[i][column]);
        }
        return line;
    }

    public StringBuilder getTopAndBottomLine(int row) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < CUBE_SIZE; i++) {
            line.append(cube[row][i]);
        }
        return line;
    }

    public void setLeftAndRightCube(int column, String movedLine) {
        for (int i = 0; i < CUBE_SIZE; i++) {
            cube[i][column] = movedLine.charAt(i);
        }
    }

    public void setTopAndBottomCube(int row, String movedLine) {
        for (int i = 0; i < CUBE_SIZE; i++) {
            cube[row][i] = movedLine.charAt(i);
        }
    }

    private void initCubeFace(char color) {
        for (int i = 0; i < CUBE_SIZE; i++) {
            for (int j = 0; j < CUBE_SIZE; j++) {
                cube[i][j] = color;
            }
        }
    }


}

