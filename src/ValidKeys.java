public enum ValidKeys {

    FRONT('F'), RIGHT('R'), UP('U'), BACK('B'), LEFT('L'), DOWN('D'), REVERSE('\''), TWO('2'), EXIT('Q');

    char key;

    ValidKeys(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }
}
