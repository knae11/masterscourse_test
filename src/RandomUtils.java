import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    private RandomUtils(){

    }

    public static int nextInt(int startInclusive, int endInclusive){
        if(endInclusive<=startInclusive){
            throw new IllegalArgumentException(Messages.END_BIGGER_THAN_START);
        }
        return startInclusive + random.nextInt(endInclusive-startInclusive+1);
    }

}
