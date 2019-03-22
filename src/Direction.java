import lombok.Data;


public interface Direction {

    String getName();
    Coordinate calculate(Coordinate coordinate,int steps);
}
