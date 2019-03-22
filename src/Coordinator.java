import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Coordinator {

    private final List<Direction> directions = getDirections();
    private FileReader reader = new FileReader();
    private FileWriter writer = new FileWriter();
    private final Alien alien;
    private List<String> visitedCoordinates = new ArrayList<>();
    public Coordinator(Alien alien) {
        this.alien = alien;
    }

    private List<Direction> getDirections() {
        List<Direction> objects = new ArrayList<>();
        objects.add(new East());
        objects.add(new South());
        objects.add(new West());
        objects.add(new North());
        return objects;
    }

    public Queue<String> get(String path) {
        return Stream.of(path.toLowerCase().split(" "))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Coordinate coordinate(int initialX, int initialY, String path, int boundaryX, int boundaryY) {
        Queue<String> splittedPath = get(path);

//        Stream<String> strings = reader.asStream("text.txt");
//        Queue<String> splittedPath = strings.map(e -> e.split(" ")).flatMap(Stream::of).collect(Collectors.toCollection(LinkedList::new));

        Coordinate coordinate = new Coordinate(initialX, initialY);

        String s = coordinate.toString();
        writer.append(List.of(s), "/home/hosam/programming/coding-contest/coding-contest/src/text_answer.txt");

        alien.setCoordinate(coordinate);
        alien.setDirection("East");

        while (!splittedPath.isEmpty()) {
            String stringPath = splittedPath.poll();

            if (stringPath.equalsIgnoreCase("f")) {
                Optional<Coordinate> first = directions.stream()
                        .filter(e -> e.getName().equalsIgnoreCase(alien.getDirection()))
                        .map(e -> e.calculate(alien.getCoordinate(), Integer.valueOf(splittedPath.poll())))
                        .findFirst();
                Coordinate coordinatesSpelled = first.get();
                alien.setCoordinate(coordinatesSpelled);

            }
            if (splittedPath.size() > 1) {
                splittedPath.poll();
                Integer numberOfTurns = Integer.valueOf(splittedPath.poll());

                Collections.rotate(directions, numberOfTurns);  /// might fail, not sure how many it actuallly is
                alien.setDirection(directions.get(0).getName());

            }

        }
        System.out.println(visitedCoordinates);
        return alien.getCoordinate();
    }
}
