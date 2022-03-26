package com.aostrovskyi.samples.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node<T>
{
    public T value;
    public Node<T> left, right, parent;

    public Node(T value)
    {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    public Iterator<Node<T>> preOrder()
    {
        return new NodeIterator(this);
    }

    public class NodeIterator implements Iterator<Node<T>> {

        private Node<T> node;
        private boolean visitedNode;
        private NodeIterator left;
        private NodeIterator right;

        public NodeIterator(Node<T> node) {
            this.node = node;
            if (node != null) {
                left = new NodeIterator(node.left);
                right = new NodeIterator(node.right);
            }
        }

        @Override
        public boolean hasNext() {
            if (node == null) {
                return false;
            }

            return !visitedNode || left.hasNext() || right.hasNext();
        }

        @Override
        public Node<T> next() {
            if (!visitedNode) {
                visitedNode = true;
                return node;
            } else if (left.hasNext()) {
                return left.next();
            } else if (right.hasNext()) {
                return right.next();
            }
            return null;
        }

    }
}
