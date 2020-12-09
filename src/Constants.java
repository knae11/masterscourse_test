public class Constants {
    private Constants(){
    }

    public static final String ENDING_MESSAGE="Bye~";
    public static final String INPUT_PREFIX="CUBE> ";
    public static final String SPLIT_DELIMITER = " ";

    public static final int CUBE_SIZE =3;
    public static final int LAST = CUBE_SIZE-1;
    public static final int FIRST = 0;

    public static final int TOP_OR_LEFT = 0;
    public static final int BOTTOM_OR_RIGHT = CUBE_SIZE-1;

    public static final String INVALID_INPUT = "[ERROR] 연산가능한 유효한 문자를 입력해 주세요.";
    public static final String IS_EMPTY = "[ERROR] 값을 입력해 주세요.";
    public static final String BAN_WHITESPACE = "[ERROR] 공백없이 원하는 값을 입력해주세요.";

}
