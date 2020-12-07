public class Validator {

    public Validator() {

    }

    public void checkInput(String[] parsedLine) {
        checkLineLength(parsedLine);
        checkNumber(parsedLine[1]);
        checkDirection(parsedLine[2]);
    }

    private void checkLineLength(String[] parsedLine) {
        if (parsedLine.length != 3) {
            throw new IllegalArgumentException("공백을 기준으로 `단어 숫자 방향`을 입력해 주세요.");
        }
    }

    private void checkNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (-100 > num || 99 < num) {
                throw new IllegalArgumentException("두번째 값으로 -100이상 100미만의 숫자를 입력해 주세요.");
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException("두번째 값으로 숫자를 입력해 주세요.");
        }
    }

    private void checkDirection(String direction) {
        if (!direction.toLowerCase().equals("r") && !direction.toLowerCase().equals("l")) {
            throw new IllegalArgumentException("세번째 값으로 r,l,R,L 중 하나를 입력해 주세요");
        }
    }

}
