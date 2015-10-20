/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serializacion1;


/**
 *
 * @author ddizoya
 */
public class Principal {
    /**
     * Clase puramente de testeo de que todo funciona. 
     */
    public static void main(String [] args){
        Mclase aux = new Mclase(); //Lo empleamos para usar los métodos de la clase Mclase.
        Mclase uno = new Mclase("ola",-7,27E10);
        Mclase dos = null;
        
        aux.serializar(uno);
        dos = aux.leerSerializacion();
                
        System.out.println("Atributos del primer objeto: "
                + " s: " + uno.getNome()
                + " int: " + uno.getNumero1()
                + " float: " + uno.getNumero2()
                );
        
            System.out.println("Atributos del segundo objeto: "
                + " s: " + dos.getNome()
                + " int: " +dos.getNumero1()
                + " float: " + dos.getNumero2()
                );
        
   
        
        
    }
}
