public enum ValidKeys {

    UP('U'),RIGHT('R'), LEFT('L'),BOTTOM('B'), REVERSE('\''), EXIT('Q');
    char key;

    ValidKeys(char key) {
        this.key = key;
    }

    public char getKey(){
        return key;
    }

    public String getKeyString(){
        return String.valueOf(key);
    }
}
