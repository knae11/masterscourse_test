public class RandomMix {

    private final String[] moveCases = {
        "R","F","U","B","L","D","R'","F'","U'","B'","L'","D'"
    };
    private String[] mixArray;

    public RandomMix(){
    }

    public String[] getRandomMove(){
        mixArray = new String[RandomUtils.nextInt(8,15)];
        for(int i=0; i<mixArray.length; i++){
            mixArray[i] = getMoveFromNumber();
        }
        return mixArray;
    }

    private String getMoveFromNumber() {
        int randomNumber = RandomUtils.nextInt(0,11);
        return moveCases[randomNumber];
    }

}
