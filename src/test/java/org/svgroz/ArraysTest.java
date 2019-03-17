package org.svgroz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.Stream;

public class ArraysTest {
    @Test
    public void bubbleSort() {
        Integer[] unsortedValues = getUnsortedArray();
        Arrays.bubbleSort(unsortedValues, Integer::compareTo);
        System.out.println(java.util.Arrays.toString(unsortedValues));
    }

    @Test
    public void gnomeSort() {
        for (int i = 0; i < 100; i++) {
            Integer[] unsortedValues = getUnsortedArray();
            final Integer[] sortedValues = Stream.of(unsortedValues).sorted().toArray(Integer[]::new);
            Arrays.gnomeSort(unsortedValues, Integer::compareTo);
            Assert.assertArrayEquals(sortedValues, unsortedValues);
        }
    }

    private Integer[] getUnsortedArray() {
        int size = 100;
        Random random = new Random();
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt(1000);
        }
        return integers;
    }
}