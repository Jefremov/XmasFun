package com.accenture.internship.bst;

import java.util.*;

public class BinarySearchTreeImpl<K extends Comparable<K>, V> implements BinarySearchTree<K, V> {

    private Node<K, V> root;

    public Node<K, V> getRoot() {
        return root;
    }

    public void setRoot(Node<K, V> root) {
        this.root = root;
    }

    public BinarySearchTreeImpl(Node<K, V> root) {
        this.root = root;
    }

    public BinarySearchTreeImpl() {

    }

    @Override
    public void insert(K k, V v) {

        if (root == null) {
            root = new Node<>(k, v);
            return;
        }
        Node<K, V> current = root;
        while (true) {
            if (k.compareTo(current.getKey()) < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(new Node<>(k, v));
                    return;
                }
                current = current.getLeft();
            } else {
                if (k.compareTo(current.getKey()) > 0) {
                    if (current.getRight() == null) {
                        current.setRight(new Node<>(k, v));
                        return;
                    }
                    current = current.getRight();
                } else {
                    current.setValue(v);
                    return;
                }
            }

        }
    }

    @Override
    public V find(K k) {
        Node current = findNode(k);
        if (current != null)
            return (V) current.getValue();
        else
            return null;
    }

    private Node findNode(K k) {
        if (root == null)
            return null;
        Node<K, V> current = root;
        boolean found = false;
        while (true) {
            if (current.getValue().equals(k)) {
                found = true;
                break;
            }
            if (k.compareTo(current.getKey()) <= 0) {
                if (current.getLeft() == null) {
                    break;
                } else {
                    current = current.getLeft();
                }
            } else {
                if (k.compareTo(current.getKey()) >= 0) {
                    if (current.getRight() == null) {
                        break;
                    } else {
                        current = current.getRight();
                    }
                } else {
                    break;
                }
            }
        }
        if (found) {
            return current;
        } else
            return null;
    }

    protected Node findPreviousNode(K k) {
        if (root == null)
            return null;
        Node<K, V> current = root;
        boolean found = false;
        while (true) {
            if(current.getLeft() == null && current.getRight() == null){
                break;
            }
            if(current.getLeft() != null)
            {
                if(current.getLeft().getValue().equals(k)) {
                    found = true;
                    break;
                }
            }
            if(current.getRight() != null){
                if(current.getRight().getValue().equals(k)) {
                    found = true;
                    break;
                }
            }

            if (k.compareTo(current.getKey()) <= 0) {
                current = current.getLeft();
            } else {
                if (k.compareTo(current.getKey()) >= 0) {
                    current = current.getRight();
                } else {
                    break;
                }
            }
        }
        if (found) {
            return current;
        } else
            return null;
    }


    @Override
    public V delete(K k) {
        Node current = findNode(k);
        if (current == null)
            return null;
        Node previous = root;
        if (current.getLeft() == null && current.getRight() == null) {
            V value = (V) current.getValue();
            current = null;
            return value;
        } else return null;

    }

    @Override
    public void inOrderTraverse(Node<K, V> node) {

    }

    @Override
    public void preOrderTraverse(Node<K, V> node) {

    }

    @Override
    public void postOrderTraverse(Node<K, V> node) {

    }

    @Override
    public V getTopElement() {
        if (root == null)
            return null;
        else return (V) root.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTreeImpl<?, ?> that = (BinarySearchTreeImpl<?, ?>) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}