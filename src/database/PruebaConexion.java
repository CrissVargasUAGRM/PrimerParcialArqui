/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Christian Vargas
 */
public class PruebaConexion {
    public static void main(String[] args) {
        Conexion con = Conexion.getInstancia();
        con.conectar();
        if(con.cadena != null){
            System.out.println("Conectado");
        }else{
            System.out.println("Desconectado");
        }
    }
}
