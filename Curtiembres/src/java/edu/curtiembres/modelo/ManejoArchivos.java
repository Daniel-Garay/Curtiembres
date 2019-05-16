package edu.curtiembres.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ManejoArchivos {

    public ManejoArchivos() {
    }

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    Usuario usuarioEncontro;

    public Usuario VerificaUsuario(String nombre, String contrasena) {
        try {
            archivo = new File("C:/Users/xcbdgara/Documents/NetBeansProjects/CurtiembresBogota/Curtiembres/Curtiembres/Archivos/Usuario.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lineaArreglo;
                lineaArreglo = linea.split(";");

                if ((lineaArreglo[1].equals(nombre)) && (lineaArreglo[3].equals(contrasena))) {  // Existe el usuario
                    usuarioEncontro = new Usuario(Integer.parseInt(lineaArreglo[0]), lineaArreglo[1], lineaArreglo[2], "", lineaArreglo[3]);
                }
            }
            return usuarioEncontro;
        } catch (Exception e) {
            e.printStackTrace();
            return usuarioEncontro;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
