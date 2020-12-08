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
            rubikCube.get(Faces.LEFT).printOneLineOfFace(i);
            System.out.printf("%3s", " ");
            rubikCube.get(Faces.FRONT).printOneLineOfFace(i);
            System.out.printf("%3s", " ");
            rubikCube.get(Faces.RIGHT).printOneLineOfFace(i);
            System.out.printf("%3s", " ");
            rubikCube.get(Faces.BACK).printOneLineOfFace(i);
            System.out.println();
        }
    }

    private void printTopAndBottom(Faces face) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%18s", " ");
            rubikCube.get(face).printOneLineOfFace(i);
            System.out.println();
        }
    }

}
