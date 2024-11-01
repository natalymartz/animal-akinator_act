package com.example;

public class Main {
    public static void main(String[] args) {
        String filePath= "AkinatorArbol.dat"; //nombre y direccion en donde se guardar a el archivo
        BinaryNode<String,String> rootNode;
        rootNode= Akinator.cargarArbol(filePath);
        if (rootNode== null) {
            rootNode = new BinaryNode<>("¿Tu animal tiene unicamente 2 patas?", "aguila");//este sera el nodo raiz a lo cual empezara-- 
            rootNode.setLeftNode(new BinaryNode<>("¿Es un aguila?", "aguila"));//siempre desde aqui e ira moviendose segun la repsuesta del usuario
            rootNode.setRightNode(new BinaryNode<>("¿Es un perro?", "perro"));
        }
        while (true) {
            Akinator.iniciarAkinator(rootNode);
            System.out.println("Volver a jugar? (si/no)");//aqui pongo de opcion al usuario si quiere volver a jugar o si quier salir
            if (!new java.util.Scanner(System.in).nextLine().equalsIgnoreCase("si")) {
                break;
            }
        }
        Akinator.guardarArbol(rootNode, filePath);//aqui se guarda el arbol con el nuevo animal junto a su caracteristica
    }
}
