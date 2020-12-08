public class CubeFace {
    private char[][] cube = new char[3][3];

    public CubeFace(char color){
        initCubeFace(color);
    }
    public void printOneLineOfFace(int i){
            for (int j=0; j<3; j++){
                System.out.printf("%3c",cube[i][j]);
            }

    }

    private void initCubeFace(char color) {
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                cube[i][j] = color;
            }
        }
    }


}

