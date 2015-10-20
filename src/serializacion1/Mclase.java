/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serializacion1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddizoya
 */
public class Mclase implements Serializable{
    String nome;
    //int numero1;
    transient int numero1;
    double numero2;
    
    
    
    String ruta = "/datos/local/ddizoya/Escritorio/serial.txt";
    File fich = new File(ruta);
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Mclase mAux;

    public Mclase() {
    }

    public Mclase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }
    
    
    public void serializar(Mclase obj){
        try {
            if (!fich.exists())
                fich.createNewFile();
            
            oos = new ObjectOutputStream(new FileOutputStream(fich));
            oos.writeObject(obj);
        
        } catch (IOException ex) {
            Logger.getLogger(Mclase.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally{
            try {
                oos.close();
            } catch (IOException ex) {
                System.err.println("No se ha cerrado correctamente el ObjectOutputStream.");
            }
            
        }
    }
    
    public Mclase leerSerializacion(){
        try {
            ois = new ObjectInputStream(new FileInputStream(fich));
            mAux = (Mclase) ois.readObject();
            
        } catch (IOException ex) {
            Logger.getLogger(Mclase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mclase.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return mAux;
        
    }

}
