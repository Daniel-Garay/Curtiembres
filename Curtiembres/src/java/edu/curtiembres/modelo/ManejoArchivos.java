package edu.curtiembres.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ManejoArchivos {

    public ManejoArchivos() {
    }

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    Usuario usuarioEncontro;

    public Usuario VerificaUsuario(String nombre, String contrasena) {
        try {

            lectorUrlArchivo();
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lineaArreglo;
                lineaArreglo = linea.split(";");

                if ((lineaArreglo[1].equals(nombre)) && (lineaArreglo[4].equals(contrasena))) {  // Existe el usuario
                   // usuarioEncontro = new Usuario(Integer.parseInt(lineaArreglo[0]), lineaArreglo[1], lineaArreglo[2], "", lineaArreglo[3], lineaArreglo[4], lineaArreglo[5], true);
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

    public void lectorUrlArchivo() {
        URL getLocation = ManejoArchivos.class.getProtectionDomain().getCodeSource().getLocation();
        String getPath = getLocation.getPath();
        String getPathReplace = getPath.replace("/build/web/WEB-INF/classes/edu/curtiembres/modelo/ManejoArchivos.class", "");
        archivo = new File(getPathReplace + "/Archivos/Usuario.txt");
        
    }

    public List<Permisos> VerificarPermiso(String rol) {
        List<Permisos> lstPermisoEncontrado = new ArrayList<>();
        try {
            String ruta = "";
            switch (rol) {
                case "Administrador":
                    ruta = "C:/Users/Daniel/Documents/NetBeansProjects/Curtiembres/Curtiembres/Archivos/AdminPermisos.txt";
                    break;
                case "Cliente":
                    ruta = "C:/Users/Daniel/Documents/NetBeansProjects/Curtiembres/Curtiembres/Archivos/ClientePermisos.txt";
                    break;
            }

            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lineaArreglo;
                lineaArreglo = linea.split(";");

                Permisos objPermiso = new Permisos(lineaArreglo[0], lineaArreglo[1]);
                lstPermisoEncontrado.add(objPermiso);

            }
            return lstPermisoEncontrado;
        } catch (Exception e) {
            e.printStackTrace();
            return lstPermisoEncontrado;
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
