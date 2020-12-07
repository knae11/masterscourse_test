import java.util.Scanner;

public class PushingWords {

    private final Scanner scanner;
    public PushingWords(Scanner scanner){
        this.scanner = scanner;
        init();
    }

    private void init() {
        while(true){
            String userLine = scanner.nextLine().trim();
            if(userLine.equals("q")){
                return;
            }
            System.out.println(userLine);
        }
    }


}
