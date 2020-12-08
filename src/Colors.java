public enum Colors {
    BLACK('B'),WHITE('W'), ORANGE('O'), GREEN('G'), YELLOW('Y'), RED('R');

    char color;

    Colors(char color) {
        this.color = color;
    }

    public char getColor(){
        return color;
    }
}
