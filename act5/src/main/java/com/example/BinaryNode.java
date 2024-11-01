package com.example;

import java.io.Serializable; //se usara para poder guardar los nodos en un archivo e irse actualizando con la nueva informacion

public class BinaryNode<E, K> implements Serializable {
    private BinaryNode<E, K> leftNode, rightNode;
    private E data; //lo usare para guardar las caracteristicas del animal
    private K key; //aqui se guardara el nombre del animal 

    public BinaryNode(E data, K key) {//constructor
        this.data= data;
        this.key= key;
        this.leftNode= null;
        this.rightNode= null;
    }

    public E getData() { //getters 
        return data;
    }
    public K getKey() {
        return key;
    }
    public BinaryNode<E, K> getLeftNode() {
        return leftNode;
    }
    public BinaryNode<E, K> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode<E, K> rightNode) { //setters
        this.rightNode= rightNode;
    }
    public void setLeftNode(BinaryNode<E, K> leftNode) {
        this.leftNode= leftNode;
    }
    public void setKey(K key) {
        this.key= key;
    }
    public void setData(E data) {
        this.data= data;
    }
}
