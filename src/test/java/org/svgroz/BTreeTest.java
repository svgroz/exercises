package org.svgroz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class BTreeTest {
    BTree<Integer> integerBTree;
    final List<Integer> randomList = new ArrayList<>();

    @Before
    public void before() {
        Random random = new Random();

        integerBTree = new BTree<>(random.nextInt());

        for (int i = 0; i < 100; i++) {
            int nextInt = random.nextInt();
            integerBTree.add(nextInt);
            randomList.add(nextInt);
        }
    }

    @Test
    public void test1() {
        final Integer toFind = randomList.stream().findAny().get();
        Assert.assertTrue(integerBTree.any(toFind));
    }
}