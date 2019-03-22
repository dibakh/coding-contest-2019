import java.util.List;

public class East implements Direction {

    private FileWriter writer = new FileWriter();

    @Override
    public String getName() {
        return "East";
    }

    @Override
    public Coordinate calculate(Coordinate coordinate, int steps) {
        for (int i = 0; i < steps; i++) {

            int currentX = coordinate.getX() + 1;
            coordinate.setX(currentX);

            String s = coordinate.toString();
//            writer.append(List.of(s), "text_answer.txt");
            writer.append(List.of(s), "/home/hosam/programming/coding-contest/coding-contest/src/text_answer.txt");

        }

        return coordinate;
    }
}
