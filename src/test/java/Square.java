import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Square implements Comparable<Square>, Cloneable, Serializable {

    private int side;

    @Override
    public int compareTo(Square o) {
        return Integer.compare(this.side, o.side);
    }

    @Override
    public Square clone() {
        try {
            Square clone = (Square) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
