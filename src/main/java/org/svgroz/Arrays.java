package org.svgroz;

import java.util.Comparator;

public class Arrays {
    public static <T> void bubbleSort(T[] values, Comparator<T> comparator) {
        for (int external = 0; external < values.length; external++) {
            for (int internal = 0; internal < values.length - external - 1; internal++) {
                T value = values[internal];
                T nextValue = values[internal + 1];
                if (comparator.compare(value, nextValue) > 0) {
                    values[internal] = nextValue;
                    values[internal + 1] = value;
                }

            }
        }
    }

    public static <T> void gnomeSort(T[] values, Comparator<T> comparator) {
        int i = 1;
        while (i < values.length) {
            T x = values[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(values[j], x) > 0) {
                values[j + 1] = values[j];
                j = j - 1;
            }
            values[j + 1] = x;
            i = i + 1;
        }
    }
}