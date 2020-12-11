import constants.Faces;
import constants.Messages;
import constants.NumberConstants;
import java.util.Map;

public class Printer {

    Map<Faces, CubeFace> rubikCube;

    public Printer() {

    }

    public void rubikCube(Map<Faces, CubeFace> rubikCube) {
        this.rubikCube = rubikCube;
        printTopAndBottom(Faces.TOP);
        System.out.println();
        printSides();
        System.out.println();
        printTopAndBottom(Faces.BOTTOM);


    }

    private void printSides() {
        for (int i = 0; i < 3; i++) {
            printOneLineOfFace(i, rubikCube.get(Faces.LEFT));
            System.out.printf("%3s", " ");
            printOneLineOfFace(i, rubikCube.get(Faces.FRONT));
            System.out.printf("%3s", " ");
            printOneLineOfFace(i, rubikCube.get(Faces.RIGHT));
            System.out.printf("%3s", " ");
            printOneLineOfFace(i, rubikCube.get(Faces.BACK));
            System.out.println();
        }
    }

    private void printTopAndBottom(Faces face) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%18s", " ");
            printOneLineOfFace(i, rubikCube.get(face));
            System.out.println();
        }
    }

    private void printOneLineOfFace(int i, CubeFace cube) {
        for (int j = 0; j < NumberConstants.CUBE_SIZE; j++) {
            System.out.printf("%3c", cube.getCube()[i][j]);
        }
    }

    public static void printEnding(long start, long end, int counter) {
        final int time = (int) ((end - start) / 1000);
        System.out.printf(Messages.TIME_SPEND, time / 60, time % 60);
        System.out.println(Messages.MOVE_COUNT + counter);
        System.out.println(Messages.THANKS);
    }
}
