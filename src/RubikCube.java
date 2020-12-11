import constants.Faces;
import constants.NumberConstants;
import constants.ValidMoves;
import java.util.HashMap;
import java.util.Map;

public class RubikCube {

    private final Map<Faces, CubeFace> rubikCube = new HashMap<>();

    public RubikCube() {
        initRubik();
    }

    public Map<Faces, CubeFace> getRubikCube() {
        return rubikCube;
    }

    public boolean checkSuccess() {
        for (CubeFace face : rubikCube.values()) {
            if (!face.completeFace()) {
                return false;
            }
        }
        return true;
    }

    public void moveRight(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getLeftAndRightLine(NumberConstants.BOTTOM_OR_RIGHT));
        line.append(rubikCube.get(Faces.BACK).getLeftAndRightLine(NumberConstants.TOP_OR_LEFT));
        line.append(
            rubikCube.get(Faces.BOTTOM).getLeftAndRightLine(NumberConstants.BOTTOM_OR_RIGHT));
        line.append(
            rubikCube.get(Faces.FRONT).getLeftAndRightLine(NumberConstants.BOTTOM_OR_RIGHT));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setLeftAndRightCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(0, NumberConstants.FIRST_UNIT));
        rubikCube.get(Faces.BACK).setLeftAndRightCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.FIRST_UNIT, NumberConstants.SECOND_UNIT));
        rubikCube.get(Faces.BOTTOM).setLeftAndRightCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.SECOND_UNIT, NumberConstants.THIRD_UNIT));
        rubikCube.get(Faces.FRONT).setLeftAndRightCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.THIRD_UNIT));
    }

    public void moveLeft(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getLeftAndRightLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.FRONT).getLeftAndRightLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.BOTTOM).getLeftAndRightLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.BACK).getLeftAndRightLine(NumberConstants.BOTTOM_OR_RIGHT));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setLeftAndRightCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(0, NumberConstants.FIRST_UNIT));
        rubikCube.get(Faces.FRONT).setLeftAndRightCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.FIRST_UNIT, NumberConstants.SECOND_UNIT));
        rubikCube.get(Faces.BOTTOM).setLeftAndRightCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.SECOND_UNIT, NumberConstants.THIRD_UNIT));
        rubikCube.get(Faces.BACK).setLeftAndRightCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.THIRD_UNIT));
    }

    public void moveBottom(String move) {
        StringBuilder line = new StringBuilder();
        line.append(
            rubikCube.get(Faces.FRONT).getTopAndBottomLine(NumberConstants.BOTTOM_OR_RIGHT));
        line.append(
            rubikCube.get(Faces.RIGHT).getTopAndBottomLine(NumberConstants.BOTTOM_OR_RIGHT));
        line.append(rubikCube.get(Faces.BACK).getTopAndBottomLine(NumberConstants.BOTTOM_OR_RIGHT));
        line.append(rubikCube.get(Faces.LEFT).getTopAndBottomLine(NumberConstants.BOTTOM_OR_RIGHT));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.FRONT).setTopAndBottomCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(0, NumberConstants.FIRST_UNIT));
        rubikCube.get(Faces.RIGHT).setTopAndBottomCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.FIRST_UNIT, NumberConstants.SECOND_UNIT));
        rubikCube.get(Faces.BACK).setTopAndBottomCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.SECOND_UNIT, NumberConstants.THIRD_UNIT));
        rubikCube.get(Faces.LEFT).setTopAndBottomCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.THIRD_UNIT));
    }

    public void moveTop(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.FRONT).getTopAndBottomLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.LEFT).getTopAndBottomLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.BACK).getTopAndBottomLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.RIGHT).getTopAndBottomLine(NumberConstants.TOP_OR_LEFT));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.FRONT).setTopAndBottomCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(0, NumberConstants.FIRST_UNIT));
        rubikCube.get(Faces.LEFT).setTopAndBottomCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.FIRST_UNIT, NumberConstants.SECOND_UNIT));
        rubikCube.get(Faces.BACK).setTopAndBottomCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.SECOND_UNIT, NumberConstants.THIRD_UNIT));
        rubikCube.get(Faces.RIGHT).setTopAndBottomCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.THIRD_UNIT));
    }

    public void moveFront(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getTopAndBottomLine(NumberConstants.BOTTOM_OR_RIGHT));
        line.append(rubikCube.get(Faces.RIGHT).getLeftAndRightLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.BOTTOM).getTopAndBottomLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.LEFT).getLeftAndRightLine(NumberConstants.BOTTOM_OR_RIGHT));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setTopAndBottomCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(0, NumberConstants.FIRST_UNIT));
        rubikCube.get(Faces.RIGHT).setLeftAndRightCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.FIRST_UNIT, NumberConstants.SECOND_UNIT));
        rubikCube.get(Faces.BOTTOM).setTopAndBottomCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.SECOND_UNIT, NumberConstants.THIRD_UNIT));
        rubikCube.get(Faces.LEFT).setLeftAndRightCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.THIRD_UNIT));
    }

    public void moveBack(String move) {
        StringBuilder line = new StringBuilder();
        line.append(rubikCube.get(Faces.TOP).getTopAndBottomLine(NumberConstants.TOP_OR_LEFT));
        line.append(rubikCube.get(Faces.LEFT).getLeftAndRightLine(NumberConstants.TOP_OR_LEFT));
        line.append(
            rubikCube.get(Faces.BOTTOM).getTopAndBottomLine(NumberConstants.BOTTOM_OR_RIGHT));
        line.append(
            rubikCube.get(Faces.RIGHT).getLeftAndRightLine(NumberConstants.BOTTOM_OR_RIGHT));
        String newLine = clockwiseOrCounter(move, line);
        rubikCube.get(Faces.TOP).setTopAndBottomCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(0, NumberConstants.FIRST_UNIT));
        rubikCube.get(Faces.LEFT).setLeftAndRightCube(NumberConstants.TOP_OR_LEFT,
            newLine.substring(NumberConstants.FIRST_UNIT, NumberConstants.SECOND_UNIT));
        rubikCube.get(Faces.BOTTOM).setTopAndBottomCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.SECOND_UNIT, NumberConstants.THIRD_UNIT));
        rubikCube.get(Faces.RIGHT).setLeftAndRightCube(NumberConstants.BOTTOM_OR_RIGHT,
            newLine.substring(NumberConstants.THIRD_UNIT));
    }

    private String clockwiseOrCounter(String move, StringBuilder line) {
        if (move.contains(ValidMoves.TWO.getKeyString())) {
            return line.substring(NumberConstants.SECOND_UNIT) + line
                .substring(0, NumberConstants.SECOND_UNIT);
        }
        if (move.contains(ValidMoves.REVERSE.getKeyString())) {
            return line.substring(NumberConstants.FIRST_UNIT) + line
                .substring(0, NumberConstants.FIRST_UNIT);
        }
        return line.substring(NumberConstants.THIRD_UNIT) + line
            .substring(0, NumberConstants.THIRD_UNIT);
    }

    private void initRubik() {
        for (Faces face : Faces.values()) {
            rubikCube.put(face, new CubeFace(face.getColor()));
        }
    }

}
