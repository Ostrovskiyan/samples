package com.aostrovskyi.samples.structures.tree;

import java.util.Iterator;
import java.util.Optional;

public class Tree<T extends Comparable<T>> implements Iterable<T> {

    private Node root;

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.add(value);
        }
    }

    public DeepIterator getDeepIterator() {
        return new DeepIterator(root);
    }

    @Override
    public Iterator<T> iterator() {
        return getDeepIterator();
    }

    private class Node {
        private T value;
        private Node parent;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean isRoot() {
            return parent == null;
        }

        public void add(T value) {
            if (this.value.compareTo(value) >= 0) {
                if (left == null) {
                    left = new Node(value, this);
                } else {
                    left.add(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value, this);
                } else {
                    right.add(value);
                }
            }
        }
    }

    public class DeepIterator implements Iterator<T> {

        private Node node;
        private DeepIterator left;
        private DeepIterator right;
        private boolean currentNodeProcessed;

        public DeepIterator(Node node) {
            this.node = node;
            if (node != null) {
                this.left = new DeepIterator(node.left);
                this.right = new DeepIterator(node.right);
                currentNodeProcessed = false;
            } else {
                currentNodeProcessed = true;
            }
        }

        @Override
        public boolean hasNext() {
            if (node != null) {
                return !currentNodeProcessed || left.hasNext() || right.hasNext();
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            if (left.hasNext()) {
                return left.next();
            } else if (!currentNodeProcessed) {
                currentNodeProcessed = true;
                return node.getValue();
            } else if (right.hasNext()) {
                return right.next();
            } else {
                throw new IllegalStateException("Next item is absent");
            }
        }
    }

}
