public enum Faces {
    FRONT('B'), TOP('W'), BOTTOM('O'), LEFT('G'), RIGHT('Y'), BACK('R');

    char color;

    Faces(char color) {
        this.color = color;
    }

    public char getColor(){
        return color;
    }
}
