public class RandomMix {

    private static final int MIN_RANDOM_MIX = 8;
    private static final int MAX_RANDOM_MIX = 15;

    private final String[] moveCases = {
        "R","F","U","B","L","D",
        "R'","F'","U'","B'","L'","D'",
        "R2","F2","U2","B2","L2","D2",
    };
    private String[] mixArray;

    public RandomMix(){
    }

    public String[] getRandomMove(){
        mixArray = new String[RandomUtils.nextInt(MIN_RANDOM_MIX,MAX_RANDOM_MIX)];
        for(int i=0; i<mixArray.length; i++){
            mixArray[i] = getMoveFromNumber();
        }
        return mixArray;
    }

    private String getMoveFromNumber() {
        int randomNumber = RandomUtils.nextInt(0,moveCases.length-1);
        return moveCases[randomNumber];
    }

}
