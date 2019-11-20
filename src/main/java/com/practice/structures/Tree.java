package com.practice.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree data structure implementation.
 *
 * @author Dimitre Bogdanov
 *
 * @param <E> Generic type
 */
public class Tree<E> {

    private E data;
    private List<Tree<E>> children;
    private Tree<E> parent;

    public List<E> leaves;

    public Tree() {
        parent = null;
        data = null;
        children = new ArrayList<Tree<E>>();
    }

    public Tree(E data) {
        parent = null;
        this.data = data;
        children = new ArrayList<Tree<E>>();
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void addChild(E data) {
        Tree<E> child = new Tree<E>(data);
        child.setParent(this);
        children.add(child);
    }

    public void addChild(Tree<E> child) {
        child.setParent(this);
        children.add(child);
    }

    public void addChildren(List<E> children) {
        for (E element : children)
            addChild(element);
    }

    public void clearChildren() {
        children = new ArrayList<Tree<E>>();
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    public Tree<E> getParent() {
        return parent;
    }

    public boolean isEmpty() {
        return parent == null && children.size() == 0 && data == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public boolean isRoot() {
        return parent == null;
    }

}