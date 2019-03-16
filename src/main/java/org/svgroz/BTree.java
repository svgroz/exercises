package org.svgroz;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BTree<T> {
    private static class Node<T> {
        T value;
        Node<T> parent;
        Node<T> left;
        Node<T> right;
    }

    private final Node<T> root;

    public BTree(T rootValue) {
        this.root = new Node<>();
        this.root.parent = null;
        this.root.value = rootValue;
    }

    @SuppressWarnings("unchecked")
    public void add(T value) {
        Node<T> currentNode = root;
        Node<T> newNode = new Node<>();
        newNode.value = value;
        boolean added = false;
        do {
            Comparable currentValue = (Comparable) currentNode.value;
            int compareResult = currentValue.compareTo(value);

            if (compareResult < 0) {
                Node<T> left = currentNode.left;
                if (left == null) {
                    newNode.parent = currentNode;
                    currentNode.left = newNode;
                    added = true;
                } else {
                    currentNode = left;
                }
            } else if (compareResult > 0) {
                Node<T> right = currentNode.right;
                if (right == null) {
                    newNode.parent = currentNode;
                    currentNode.right = newNode;
                    added = true;
                } else {
                    currentNode = right;
                }
            } else {
                added = true;
            }

        } while (!added);
    }

    @SuppressWarnings("unchecked")
    public boolean any(T value) {
        Node<T> currentNode = root;

        while (currentNode != null) {
            Comparable nodeValue = (Comparable) currentNode.value;
            int compareResult = nodeValue.compareTo(value);
            if (compareResult < 0) {
                currentNode = currentNode.left;
            } else if (compareResult > 0) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public void foreach(Consumer<T> consumer) {
        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            consumer.accept(node.value);
        }
    }
}
