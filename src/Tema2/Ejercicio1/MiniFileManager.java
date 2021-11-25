package Tema2.Ejercicio1;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class MiniFileManager
{
    //ATRIBUTOS
    private File rutaActual = new File (System.getProperty("user.dir")); //Ruta actual
    private char barra; //Dependiendo del Sistema Operativo será barra o contrabarra

    //CONTRUCTOR

    //GETTERS Y SETTERS
    //Getters

    public File getRutaActual() {
        return rutaActual;
    }

    //Setters

    public void setBarra(char barra) {
        this.barra = barra;
    }

    //MÉTODOS
    //PWD
    public String pwd () throws FileNotFoundException
    {
        String ruta = rutaActual.getAbsolutePath();
        return ruta;
    }

    //CD
    public void cd(String directorio) throws FileNotFoundException
    {
        File nuevaRuta= new File(rutaActual.getAbsolutePath()+ barra + directorio);

        if (directorio.equals(".."))
        {
            rutaActual = new File(rutaActual.getParent());
        }
        else
        {
            rutaActual = nuevaRuta;
        }

        if (!nuevaRuta.exists())
        {
            throw new FileNotFoundException();
        }
    }

    //LS Y LL
    public void ls(boolean info) throws FileNotFoundException
    {
        if (!this.rutaActual.exists()) //Comprueba si existe el file
        {
            throw new FileNotFoundException("Ruta no encontrada");
        }

        if (this.rutaActual.isFile()) //Comprueba si es un archivo
        {
            System.out.println("El nombre del archivo es: " + this.rutaActual.getName());
        }
        else if (this.rutaActual.isDirectory()) //Si no comprueba si es un directorio
        {
            File[] files = this.rutaActual.listFiles();

            Arrays.sort(files); //Ordenar

            for (File n: files)
            {
                if (n.isDirectory())
                {
                    System.out.print("[*] " + n.getName());
                    if (info) //Si info es true muestra también los bytes y la última modificación
                    {
                        System.out.print(" " + n.length() + " bytes" + " Última mod. " + n.lastModified());
                    }
                    System.out.println();
                }
            }

            for (File n: files)
            {
                if (n.isFile())
                {
                    System.out.print("[A] " + n.getName());
                    if (info) //Si info es true muestra también los bytes y la última modificación
                    {
                        System.out.print(" " + n.length() + " bytes" + " Última mod. " + n.lastModified());
                    }
                    System.out.println();
                }
            }
        }
    }

    //MKDIR
    public void mk(String newFile) throws FileNotFoundException
    {
        if (newFile.charAt(newFile.length() - 1) == barra) //Comprueba el último caracter de la string
        {
            try
            {
                File newDir = new File(rutaActual.getAbsolutePath() + barra + newFile);
                rutaActual = newDir;
                rutaActual.mkdir();
                System.out.println("Directorio creado");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else //Sino, crea el archivo
        {
            try
            {
                new FileWriter(newFile);

                System.out.println("Archivo creado");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //RM
    public void rm(String file) throws FileNotFoundException
    {
        File filerm = new File(file);

        if (filerm.isFile())
        {
            filerm.delete();

            System.out.println("Archivo elminado.");
        }

        if (filerm.isDirectory())
        {
            filerm.delete();

            System.out.println("Directorio elminado.");
        }

        System.out.println("HECHO");
    }

    //MV
    public void mv(String ruta)
    {

    }
}
