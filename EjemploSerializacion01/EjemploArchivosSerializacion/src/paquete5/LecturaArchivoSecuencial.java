/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete5;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author SALA I
 */
public class LecturaArchivoSecuencial implements Serializable{
    
    private ObjectInputStream entrada;
    private ArrayList<Hospital> hospitales;
    private String identificador;
    private String nombreArchivo;
    private Hospital hospitalBuscado;

    public LecturaArchivoSecuencial(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerHospital() {
        // 
        hospitales = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Hospital registro = (Hospital) entrada.readObject();
                    hospitales.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }
    
    public void establecerIdentificador(String n) {
        identificador = n;
    }
    
    public void establecerHospitalBuscado() {
        // 
        
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Hospital registro = (Hospital) entrada.readObject();
                    
                    if(registro.obtenerNombre().equals(identificador)){
                        hospitalBuscado = registro;
                        break;
                    }
                    
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }
    

    public ArrayList<Hospital> obtenerHospital() {
        return hospitales;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
     public String obtenerIdentificador() {
        return identificador;
    }
        
    public Hospital obtenerHospitalBuscado() {
        return hospitalBuscado;
    }


    @Override
    public String toString() {
        String cadena = "Lista de Hospitales\n";
        for (int i = 0; i < obtenerHospital().size(); i++) {
            Hospital h = obtenerHospital().get(i);
            cadena = String.format("%s(%d) %s-%d-%.2f\n", cadena,
                    i + 1,
                    h.obtenerNombre(),
                    h.obtenerNumeroCamas(),
                    h.obtenerPresupuesto());
        }

        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
}
