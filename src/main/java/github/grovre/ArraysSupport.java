package github.grovre;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.math3.util.FastMath;

import java.util.Arrays;
import java.util.function.*;


/**
 * This class adds features similar to {@link java.util.Collections}
 * that {@link java.util.Arrays} does not have. Algorithms are
 * created to be as fast as possible. However, that does not guarantee
 * the best speed. Improvements can always be made to this class
 * by <a href="https://github.com/Grovre/ArraysSupport">creating a pull request on Github</a>.
 */
@SuppressWarnings("unused")
@UtilityClass
public class ArraysSupport {

    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     * Generation is unchecked.
     *
     * @param arrayGenerator The function used to create an array safely.
     *                       It should look like <code>T[]::new</code>
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static <T> T[] generate(@NonNull IntFunction<T[]> arrayGenerator,@NonNull  Supplier<T> op, int len) {
        T[] arr = arrayGenerator.apply(len);
        for (int i = 0; i < len; i++)
            arr[i] = op.get();
        return arr;
    }

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static int[] generateInt(@NonNull IntSupplier op, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = op.getAsInt();
        return arr;
    }

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static short[] generateShort(@NonNull IntSupplier op, int len) {
        short[] arr = new short[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (short) op.getAsInt();
        return arr;
    }

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static byte[] generateByte(@NonNull IntSupplier op, int len) {
        byte[] arr = new byte[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (byte) op.getAsInt();
        return arr;
    }

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static long[] generateLong(@NonNull LongSupplier op, int len) {
        long[] arr = new long[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = op.getAsLong();
        return arr;
    }

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static boolean[] generateBoolean(@NonNull BooleanSupplier op, int len) {
        boolean[] arr = new boolean[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = op.getAsBoolean();
        return arr;
    }

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static double[] generateDouble(@NonNull DoubleSupplier op, int len) {
        double[] arr = new double[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = op.getAsDouble();
        return arr;
    }

    /**
     * Generates an array based off of the generate function provided.
     * The parameter to the generate function is the index; the first
     * index, 0, is applied to the function and assigned to index 0 and so on.
     *
     * @param op The operation to generate the elements
     * @param len The length of the array
     * @return A new array after applying the generating function to all indices
     */
    public static float[] generateFloat(@NonNull DoubleSupplier op, int len) {
        float[] arr = new float[len];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) op.getAsDouble();
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
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static byte max(@NonNull final byte[] arr) {
        int max = arr[0];
        for (byte n : arr)
            max = FastMath.max(max, n);
        return (byte) max;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static short max(@NonNull final short[] arr) {
        int max = arr[0];
        for (short n : arr)
            max = FastMath.max(max, n);
        return (short) max;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static long max(@NonNull final long[] arr) {
        long max = arr[0];
        for (long n : arr)
            max = FastMath.max(max, n);
        return max;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static double max(@NonNull final double[] arr) {
        double max = arr[0];
        for (double n : arr)
            max = FastMath.max(max, n);
        return max;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static float max(@NonNull final float[] arr) {
        float max = arr[0];
        for (float n : arr)
            max = FastMath.max(max, n);
        return max;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the max.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static char max(@NonNull final char[] arr) {
        int max = arr[0];
        for (char n : arr)
            max = FastMath.max(max, n);
        return (char) max;
    }

    /**
     * Linearly searches through an array using the
     * object's <code>compareTo(o)</code> method.
     *
     * @param arr The array to be searched for the max
     * @return The max number from the array
     */
    public static <T extends Comparable<T>> T max(@NonNull final T[] arr) {
        T max = arr[0];
        for (T o : arr)
            max = max.compareTo(o) > 0 ? max : o;
        return max;
    }

    /**
     * Linearly searches through an array using the
     * object's <code>compareTo(o)</code> method.
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
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static short min(@NonNull final short[] arr) {
        int min = arr[0];
        for(short n : arr)
            min = FastMath.min(min, n);
        return (short) min;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static byte min(@NonNull final byte[] arr) {
        int min = arr[0];
        for (byte n : arr)
            min = FastMath.min(min, n);
        return (byte) min;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static long min(@NonNull final long[] arr) {
        long min = arr[0];
        for (long n : arr)
            min = FastMath.min(min, n);
        return min;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static float min(@NonNull final float[] arr) {
        float min = arr[0];
        for (float n : arr)
            min = FastMath.min(min, n);
        return min;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static double min(@NonNull final double[] arr) {
        double min = arr[0];
        for (double n : arr)
            min = FastMath.min(min, n);
        return min;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static char min(@NonNull final char[] arr) {
        int min = arr[0];
        for(char n : arr)
            min = FastMath.min(min, n);
        return (char) min;
    }

    /**
     * Linearly searches through an array using Apache Common's
     * {@link FastMath} utility class to find the min.
     *
     * @param arr The array to be searched for the min
     * @return The min number from the array
     */
    public static <T extends Comparable<T>> T min(@NonNull final T[] arr) {
        T min = arr[0];
        for(T o : arr)
            min = min.compareTo(o) > 0 ? o : min;
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
     * Finds the minimum and maximum.
     * This differs from the min and max methods
     * already provided by this class
     * by finding both in a single pass.
     *
     * @param arr The array to find minimum and maximum within.
     * @return A sorted array with minimum and maximum, respectively.
     */
    public static long[] minmax(@NonNull final long[] arr) {
        long min = arr[0];
        long max = arr[0];
        for (long n : arr) {
            min = FastMath.min(min, n);
            max = FastMath.max(max, n);
        }
        return new long[]{min, max};
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
    public static byte[] minmax(@NonNull final byte[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (byte n : arr) {
            min = FastMath.min(min, n);
            max = FastMath.max(max, n);
        }
        return new byte[]{(byte) min, (byte) max};
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
    public static short[] minmax(@NonNull final short[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (short n : arr) {
            min = FastMath.min(min, n);
            max = FastMath.max(max, n);
        }
        return new short[]{(short) min, (short) max};
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
    public static float[] minmax(@NonNull final float[] arr) {
        float min = arr[0];
        float max = arr[0];
        for (float n : arr) {
            min = FastMath.min(min, n);
            max = FastMath.max(max, n);
        }
        return new float[]{min, max};
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
    public static double[] minmax(@NonNull final double[] arr) {
        double min = arr[0];
        double max = arr[0];
        for (double n : arr) {
            min = FastMath.min(min, n);
            max = FastMath.max(max, n);
        }
        return new double[]{min, max};
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
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final long[] arr, final long target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final short[] arr, final short target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final byte[] arr, final byte target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final float[] arr, final float target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final double[] arr, final double target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the targdoubleet, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final char[] arr, final char target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the targdoubleet, or -1 if it doesn't exist.
     */
    public static int indexOf(@NonNull final boolean[] arr, final boolean target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter
     * using {@code firstIndexOf} from this class.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the targdoubleet, or -1 if it doesn't exist.
     */
    public static <T> int indexOf(@NonNull final T[] arr, final T target) {
        return firstIndexOf(arr, target);
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static <T> int firstIndexOf(@NonNull final T[] arr, final T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target))
                return i;
        }
        return -1;
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
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final boolean[] arr, final boolean target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final long[] arr, final long target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final short[] arr, final short target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final byte[] arr, final byte target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final float[] arr, final float target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final double[] arr, final double target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Finds the first occurrence of the target parameter.
     *
     * @param arr The array to find the target in
     * @param target The target to find
     * @return The index of the target, or -1 if it doesn't exist.
     */
    public static int firstIndexOf(@NonNull final char[] arr, final char target) {
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
    public static <T> int lastIndexOf(@NonNull final T[] arr, final T target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(target))
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
    public static void countingSort(@NonNull final short[] arr) {
        Sort.countingSort(arr);
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
    public static void countingSort(@NonNull final byte[] arr) {
        Sort.countingSort(arr);
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
     *
     * @param arr The array to sort
     */
    public static void countingSort(@NonNull final boolean[] arr) {
        Sort.countingSort(arr);
    }

    /**
     * <P>
     *     Returns true if the two specified arrays have no elements in common.
     * </P>
     * <P>
     *     This method streams both arrays then uses filtering and anyMatch to
     *     determine if they have anything in common. This method's speed is untested.
     * </P>
     *
     * @param arr1 The first array
     * @param arr2 The second array
     * @return True if both arrays have no elements in common. False if they both contain
     */
    public static boolean disjoint(@NonNull int[] arr1, @NonNull int[] arr2) {
        return Arrays.stream(arr1).filter(n -> Arrays.stream(arr2).anyMatch(n2 -> n == n2)).count() == 0;
    }

    /**
     * <P>
     *     Returns true if the two specified arrays have no elements in common.
     * </P>
     * <P>
     *     This method streams both arrays then uses filtering and anyMatch to
     *     determine if they have anything in common. This method's speed is untested.
     * </P>
     *
     * @param arr1 The first array
     * @param arr2 The second array
     * @return True if both arrays have no elements in common. False if they both contain
     */
    public static boolean disjoint(@NonNull long[] arr1, @NonNull long[] arr2) {
        return Arrays.stream(arr1).filter(n -> Arrays.stream(arr2).anyMatch(n2 -> n == n2)).count() == 0;
    }

    /**
     * <P>
     *     Returns true if the two specified arrays have no elements in common.
     * </P>
     * <P>
     *     This method streams both arrays then uses filtering and anyMatch to
     *     determine if they have anything in common. This method's speed is untested.
     * </P>
     *
     * @param arr1 The first array
     * @param arr2 The second array
     * @return True if both arrays have no elements in common. False if they both contain
     */
    public static boolean disjoint(@NonNull double[] arr1, @NonNull double[] arr2) {
        return Arrays.stream(arr1).filter(n -> Arrays.stream(arr2).anyMatch(n2 -> n == n2)).count() == 0;
    }

    /**
     * <P>
     *     Returns true if the two specified arrays have no elements in common.
     * </P>
     * <P>
     *     This method streams both arrays then uses filtering and anyMatch to
     *     determine if they have anything in common. This method's speed is untested.
     * </P>
     *
     * @param arr1 The first array
     * @param arr2 The second array
     * @return True if both arrays have no elements in common. False if they both contain
     */
    public static <T> boolean disjoint(@NonNull T[] arr1, @NonNull T[] arr2) {
        return Arrays.stream(arr1).noneMatch(o -> Arrays.asList(arr2).contains(o));
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull int[] arr, int target) {
        int count = 0;
        for (int n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull byte[] arr, byte target) {
        int count = 0;
        for (byte n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull short[] arr, short target) {
        int count = 0;
        for (short n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull long[] arr, long target) {
        int count = 0;
        for (long n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull double[] arr, double target) {
        int count = 0;
        for (double n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull float[] arr, float target) {
        int count = 0;
        for (float n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull boolean[] arr, boolean target) {
        int count = 0;
        for (boolean n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static int frequency(@NonNull char[] arr, char target) {
        int count = 0;
        for (char n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Returns the number of elements in the specified array equal to the specified target.
     *     Does a basic linear search on an array using a for loop.
     * </P>
     *
     * @param arr The array to search
     * @param target The target to search for
     * @return The amount of appearances of the target in the given array
     */
    public static <T> int frequency(@NonNull T[] arr, T target) {
        int count = 0;
        for (T n : arr)
            if (n == target)
                count++;
        return count;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull int[] arr, int oldVal, int newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull long[] arr, long oldVal, long newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull byte[] arr, byte oldVal, byte newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull short[] arr, short oldVal, short newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull float[] arr, float oldVal, float newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull double[] arr, double oldVal, double newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull boolean[] arr, boolean oldVal, boolean newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static boolean replaceAll(@NonNull char[] arr, char oldVal, char newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldVal) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param newVal The new value
     * @return True if at least one element was replaced
     */
    public static <T> boolean replaceAll(@NonNull T[] arr, T oldVal, T newVal) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(oldVal)) {
                arr[i] = newVal;
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * <P>
     *     Replaces all occurrences of one specified value in a list with another.
     * </P>
     *
     * @param arr The array
     * @param oldVal The old value to be replaced
     * @param supplier The supplier that will generate the replacing value
     * @return True if at least one element was replaced
     */
    public static <T> boolean replaceAll(@NonNull T[] arr, T oldVal, Supplier<T> supplier) {
        boolean replaced = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(oldVal)) {
                arr[i] = supplier.get();
                replaced = true;
            }
        }
        return replaced;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull char[] arr, int i1, int i2) {
        char temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull boolean[] arr, int i1, int i2) {
        boolean temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull short[] arr, int i1, int i2) {
        short temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull byte[] arr, int i1, int i2) {
        byte temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull long[] arr, int i1, int i2) {
        long temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull float[] arr, int i1, int i2) {
        float temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static void swap(@NonNull double[] arr, int i1, int i2) {
        double temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Simply swaps the elements at two indices using a temp variable.
     *
     * @param arr The array to swap in
     * @param i1 The first index to swap
     * @param i2 The second index to swap
     */
    public static <T> void swap(@NonNull T[] arr, int i1, int i2) {
        T temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull int[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull byte[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull short[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull long[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull float[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull double[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull boolean[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static void reverse(@NonNull char[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses an array by swapping elements equidistant from both edges until the middle
     *
     * @param arr The array to reverse
     */
    public static <T> void reverse(@NonNull T[] arr) {
        final int len = arr.length;
        final int mid = len / 2;
        for (int i = 0; i < mid; i++)
            swap(arr, i, len - i - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull int[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull byte[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull short[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull double[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull float[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull char[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull boolean[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static void reverse(@NonNull long[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * Reverses the given part of an array by swapping elements
     *
     * @param arr The array to reverse
     * @param from The inclusive index to begin from
     * @param to The exclusive index to reverse up to
     */
    public static <T> void reverse(@NonNull T[] arr, int from, int to) {
        final int len = arr.length;
        final int mid = (to + from) / 2;
        for (int i = from, offset = to; i < mid; i++, offset--)
            swap(arr, i, offset - 1);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull int[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull float[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull double[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull char[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull boolean[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull long[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull short[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static void rotate(@NonNull byte[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    /**
     * <P>
     *     Rotates an array the same way {@link java.util.Collections}'
     *     rotate2 does: reversing thrice
     * </P>
     *
     * @param arr The array to rotate
     * @param distance The distance to rotate the array
     */
    public static <T> void rotate(@NonNull T[] arr, int distance) {
        if (arr.length <= 1)
            return;

        int mid = -distance % arr.length;
        if (mid < 0)
            mid += arr.length;
        if (mid == 0)
            return;

        ArraysSupport.reverse(arr, 0, mid);
        ArraysSupport.reverse(arr, mid, arr.length);
        ArraysSupport.reverse(arr);
    }

    // TODO: 6/12/2022 shuffle
    // TODO: 6/12/2022 append?
    // TODO: 6/12/2022 prepend?
    // TODO: 6/12/2022 insert?
}
