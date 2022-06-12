package github.grovre;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.math3.util.FastMath;


/**
 * This class adds features similar to {@link java.util.Collections}
 * that {@link java.util.Arrays} does not have. Algorithms are
 * created to be as fast as possible. However, that does not guarantee
 * the best speed. Improvements can always be made to this class
 * by <a href="https://github.com/Grovre/ArraysSupport">creating a pull request on Github</a>.
 */
@UtilityClass
public class ArraysSupport {

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static int max(@NonNull final int[] arr) {
        int max = arr[0];
        for (int n : arr)
            max = FastMath.max(max, n);
        return max;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static int min(@NonNull final int[] arr) {
        int min = arr[0];
        for(int n : arr)
            min = FastMath.min(min, n);
        return min;
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final int[] arr, final int target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final int[] arr, final int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Finds the last occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int lastIndexOf(@NonNull final int[] arr, final int target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
