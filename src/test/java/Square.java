import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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
            return (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static Square random(int lo, int hi) {
        return new Square(ThreadLocalRandom.current().nextInt(lo, hi));
    }

    public static Square random() {
        return random(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Square[] randomArray(int len, int lo, int hi) {
        Square[] arr = new Square[len];
        Arrays.setAll(arr, i -> Square.random(lo, hi));
        return arr;
    }

    public static Square[] randomArray(int len) {
        return randomArray(len, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
