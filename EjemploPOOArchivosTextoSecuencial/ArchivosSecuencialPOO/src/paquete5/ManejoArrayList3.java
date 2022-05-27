/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete5;

import java.util.ArrayList;
import paquete1.Profesor;
import paquete1.Calificacion;

/**
 *
 * @author reroes
 */
public class ManejoArrayList3 {

    public static void main(String[] args) {

        Calificacion c1 = new Calificacion(9.7, "Matematicas");
        Calificacion c2 = new Calificacion(8.4, "Quimica");

        Profesor prof1 = new Profesor("Joseph Jimenez", "facturado");
        Profesor prof2 = new Profesor("David Jones", "nombramiento");

        System.out.println("-----------------------------");

        // ArrayList
        ArrayList<Calificacion> calificaciones = new ArrayList<>();
        c1.establecerProfesor(prof1);
        c2.establecerProfesor(prof2);

        calificaciones.add(c1);
        calificaciones.add(c2);

        for (int i = 0; i < calificaciones.size(); i++) {
            //Nombre del profesor
            //Nombre de la materia
            //La nota
            System.out.printf("%s - %s - %s\n", 
                    calificaciones.get(i).obtenerProfesor().obtenerNombre(),
                    calificaciones.get(i).obtenerNombreMateria(),
                    calificaciones.get(i).obtenerNota());
        }

    }
}
