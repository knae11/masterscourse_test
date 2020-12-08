public class CubeFace {
    private char[][] cube = new char[3][3];

    public CubeFace(char color){
        initCubeFace(color);
    }
    public void printFace(){
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(cube[i][j]);
            }
            System.out.println();
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

