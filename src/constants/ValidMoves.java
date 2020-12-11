package constants;

public enum ValidMoves {

    FRONT('F'), RIGHT('R'), UP('U'), BACK('B'), LEFT('L'), DOWN('D'), REVERSE('\''), TWO('2'), EXIT(
        'Q');

    char key;

    ValidMoves(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }

    public String getKeyString() {
        return String.valueOf(key);
    }
}
