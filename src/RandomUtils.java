import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    private RandomUtils(){

    }

    public static int nextInt(int startInclusive, int endInclusive){
        if(endInclusive<startInclusive){
            throw new IllegalArgumentException("뒷자리수는 앞자리보다 같거나 커야한다.");
        }
        return startInclusive + random.nextInt(endInclusive-startInclusive+1);
    }

}
