import constants.NumberConstants;

public class CubeFace {


    private char[][] cube = new char[NumberConstants.CUBE_SIZE][NumberConstants.CUBE_SIZE];

    public CubeFace(char color) {
        initCubeFace(color);
    }

    public char[][] getCube() {
        return cube;
    }

    public boolean completeFace() {
        for (int i = 0; i < NumberConstants.CUBE_SIZE; i++) {
            if (!checkCompleteRow(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCompleteRow(int i) {
        char standard = cube[NumberConstants.CUBE_CENTER][NumberConstants.CUBE_CENTER];
        for (int j = 0; j < NumberConstants.CUBE_SIZE; j++) {
            if (standard != cube[i][j]) {
                return false;
            }
        }
        return true;
    }

    public StringBuilder getLeftAndRightLine(int column) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < NumberConstants.CUBE_SIZE; i++) {
            line.append(cube[i][column]);
        }
        return line;
    }

    public StringBuilder getTopAndBottomLine(int row) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < NumberConstants.CUBE_SIZE; i++) {
            line.append(cube[row][i]);
        }
        return line;
    }

    public void setLeftAndRightCube(int column, String movedLine) {
        for (int i = 0; i < NumberConstants.CUBE_SIZE; i++) {
            cube[i][column] = movedLine.charAt(i);
        }
    }

    public void setTopAndBottomCube(int row, String movedLine) {
        for (int i = 0; i < NumberConstants.CUBE_SIZE; i++) {
            cube[row][i] = movedLine.charAt(i);
        }
    }

    private void initCubeFace(char color) {
        for (int i = 0; i < NumberConstants.CUBE_SIZE; i++) {
            for (int j = 0; j < NumberConstants.CUBE_SIZE; j++) {
                cube[i][j] = color;
            }
        }
    }


}

