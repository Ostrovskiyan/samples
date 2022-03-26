package com.aostrovskyi.samples.structures.tree;

public class TreeTestMain {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(7);
        tree.add(9);
        tree.add(10);

//        var deepIterator = tree.getDeepIterator();
//        while(deepIterator.hasNext()) {
//            System.out.println(deepIterator.next());
//        }

        for (Integer i: tree) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println();

    }

}
