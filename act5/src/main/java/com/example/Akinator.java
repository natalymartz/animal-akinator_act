package com.example;

import java.io.*;
import java.util.Scanner;

public class Akinator {
    public static void iniciarAkinator(BinaryNode<String, String> node) {
        Scanner in = new Scanner(System.in);
        if(node.getLeftNode() == null && node.getRightNode() == null) {
            System.out.println("¿Es tu animal un/una " + node.getKey() + "?");
            String respuesta = in.nextLine().toLowerCase();
            if(respuesta.equals("si")) { //si responde que si es porque el animal es correcto a lo cual no necesita guardarse ya que ya esta en los datos
                System.out.println("Lo sabia he adivinado :) !");
            } else {
                System.out.println("Cual era tu animal?");
                String nuevoAnimal = in.nextLine();
                System.out.println("¿Qué diferencia tiene un/una" + nuevoAnimal + " de un/una " + node.getKey() + "?");
                String nuevaCaracteristica = in.nextLine();
                node.setLeftNode(new BinaryNode<>(nuevoAnimal,nuevoAnimal)); //se actualiza el nodo izquierdo en el valor de key
                node.setRightNode(new BinaryNode<>(node.getData(),node.getKey()));//se actualiza el nodo derecho
                node.setData(nuevaCaracteristica);//se actualiza el valor de data
            }
        } else {
            System.out.println(node.getData());
            String respuesta = in.nextLine().toLowerCase();
            if(respuesta.equals("si")) {
                iniciarAkinator(node.getLeftNode());
            } else {
                iniciarAkinator(node.getRightNode());
            }
        }
    }

    public static void guardarArbol(BinaryNode<String, String> node, String filePath) {//aqui tuve que investigar en youtube y otras plataformas
        try (FileOutputStream fileOut = new FileOutputStream(filePath);//para poder ver como guardar los datos ingresados en un tipo de archivo
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {//y asi usarlos para actualizar la base de datos del programa
            out.writeObject(node);
            System.out.println("Guardado exitosamente en " + filePath);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    public static BinaryNode<String, String> cargarArbol(String filePath) {//al igual que el metodo anterior este se tuvo que investigar
        try (FileInputStream fileIn = new FileInputStream(filePath);//y sirve para abrir el archivo donde se guardaron los nodos de informacion
             ObjectInputStream in = new ObjectInputStream(fileIn)) {//para usarlos en el akinator
            return (BinaryNode<String, String>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el arbol: " + e.getMessage());
            return null;
        }
    }
}
