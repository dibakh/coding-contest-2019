import java.util.List;

public class South implements Direction {

    private FileWriter writer = new FileWriter();

    @Override
    public String getName() {
        return "South";
    }

    @Override
    public Coordinate calculate(Coordinate coordinate, int steps) {

        for (int i = 0; i < steps; i++) {

            int currentY = coordinate.getY() - 1;
            coordinate.setY(currentY);

            String s = coordinate.toString();
            writer.append(List.of(s), "/home/hosam/programming/coding-contest/coding-contest/src/text_answer.txt");

        }

        return coordinate;
    }
}
