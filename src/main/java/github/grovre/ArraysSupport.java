package github.grovre;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.math3.util.FastMath;

import java.util.function.IntUnaryOperator;


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
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new int array after applying the generating function to all indices
     */
    public static int[] generate(IntUnaryOperator op, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = op.applyAsInt(i);
        return arr;
    }

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
     * Finds the minimum and maximum.
     * This differs from the min and max methods
     * already provided by this class
     * by finding both in a single pass.
     *
     * @param arr The array to find minimum and maximum within.
     * @return A sorted array with minimum and maximum, respectively.
     */
    public static int[] minmax(@NonNull final int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int n : arr) {
            min = FastMath.min(min, n);
            max = FastMath.max(max, n);
        }
        return new int[]{min, max};
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

    /**
     * <P>
     *     <a href="https://en.wikipedia.org/wiki/Counting_sort">Wikipedia Article</a>
     * </P>
     * <P>
     *     Counting sort is an efficient sorting method with worst-case performance
     *     of O(n+k), where k is the maximum number in an array. This means it is best on arrays
     *     that contain a small difference between the minimum and maximum. For example,
     *     sorting {1, 2, 3, 4, 3, 2, 1} will be faster than {1, 1000, 500}. This is also the drawback
     *     of counting sorts. The larger the difference between min and max of an array, despite the size
     *     of the array being sorted, will consume a larger amount of memory.
     * </P>
     * <P>
     *     The algorithm creates a temporary array (map) with a length of the maximum number.
     *     It will then iterate through the array being sorted, placing every number
     *     into an index of the same number. The map is then iterated linearly beginning from 0, placing
     *     the index where the map is greater than 0 at the offset index in the original array until it is done iterating.
     * </P>
     * <P>
     *     This implementation of counting sort involves an offset variable to accommodate for negative numbers.
     *     That means the length of the map will be <code>max + -min</code>. If the offset is >= 0, the offset is 0.
     * </P>
     *
     * @param arr The array to sort
     */
    public static void countingSort(@NonNull final int[] arr) {
        Sort.countingSort(arr);
    }
}
