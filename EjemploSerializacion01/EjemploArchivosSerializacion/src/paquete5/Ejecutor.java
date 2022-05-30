/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete5;

/**
 *
 * @author SALA I
 */
public class Ejecutor {

    public static void main(String[] args) {
        String nombreArchivo = "hospitales.data";

        Hospital hos1 = new Hospital("UTPL", 25, 500.5);
        Hospital hos2 = new Hospital("IESS", 45, 789.5);
        Hospital hos3 = new Hospital("Isidro Ayora", 405, 1000.5);

        EscrituraArchivoSecuencial archivo
                = new EscrituraArchivoSecuencial(nombreArchivo);

        // establecer el valor del atributo registro
        archivo.establecerRegistroHospital(hos1);
        // establecer en el archivo el atributo del registro
        archivo.establecerSalida();
        archivo.establecerRegistroHospital(hos2);
        archivo.establecerSalida();
        archivo.establecerRegistroHospital(hos3);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        LecturaArchivoSecuencial lectura
                = new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerHospital();
        System.out.println(lectura); //se llama al toString
    }
}
