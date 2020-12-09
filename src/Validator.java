public class Validator {

    public Validator() {
    }

    public void checkInput(String[] parsedLine) {
        checkLineLength(parsedLine);
        checkNumber(parsedLine[Constants.COUNT]);
        checkDirection(parsedLine[Constants.DIRECTION]);
    }

    private void checkLineLength(String[] parsedLine) {
        if (parsedLine.length != Constants.INPUT_UNITS) {
            throw new IllegalArgumentException(Constants.WORD_NUMBER_DIRECTION);
        }
    }

    private void checkNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (Constants.MIN_NUMBER > num || Constants.MAX_NUMBER < num) {
                throw new IllegalArgumentException(Constants.NUMBER_RANGE);
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(Constants.NUMBER_ONLY);
        }
    }

    private void checkDirection(String direction) {
        if (!direction.toLowerCase().equals(Constants.RIGHT) && !direction.toLowerCase()
            .equals(Constants.LEFT)) {
            throw new IllegalArgumentException(Constants.DIRECTIONS);
        }
    }

}
