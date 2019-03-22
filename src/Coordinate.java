import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {

    @Override
    public String toString() {
        return x + "" + y;
    }

    private int x;
    private int y;
//    private String direction;
/*
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }*/
}
