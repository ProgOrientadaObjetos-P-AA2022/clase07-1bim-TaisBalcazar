/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete5;

import java.util.ArrayList;
import paquete1.Empresa;

/**
 *
 * @author TaisBalcazar
 */
public class ManejoArrayList4 {

    public static void main(String[] args) {
        Empresa e1 = new Empresa("Importadora Ortega", "Loja");
        Empresa e2 = new Empresa("Ecolac", "Machala");
        Empresa e3 = new Empresa("ILE", "Quito");

        ArrayList<Empresa> empresa = new ArrayList<>();

        empresa.add(e1);
        empresa.add(e2);
        empresa.add(e3);

        for (int i = 0; i < empresa.size(); i++) {
            //Nombre del profesor
            //Nombre de la materia
            //La nota
            System.out.printf("%s - %s\n",
                    empresa.get(i).obtenerNombre(),
                    empresa.get(i).obtenerCiudad());
        }

    }
}
