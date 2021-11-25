package Tema2.Ejercicio1;

import java.io.*;
import java.util.Scanner;

public class MiniTerminal
{
    public static void main(String[] args) throws FileNotFoundException {
        //VARIABLES
        Scanner in = new Scanner(System.in);
        boolean exit = false; //Se utiliza para salir del programa.
        String input = ""; //Se utiliza para introducir los comandos al terminal.
        String system = System.getProperty("os.name"); //Comprueba el Sistema Operativo
        char barra = ' '; //Dependiendo del Sistema Operativo será barra o contrabarra

        //INSTANCIAS
        MiniFileManager fileman = new MiniFileManager();

        //Establece barra o contrabarra dependiendo del SO.
        if (system.equals("Windows 10"))
        {
            barra = '\\';
        }
        else
        {
            barra = '/';
        }
        fileman.setBarra(barra);

        //TERMINAL
        System.out.println(system);
        System.out.println("\n- MINI TERMINAL -\n");

        do
        {
            System.out.print(":~" + fileman.getRutaActual() + " $"); //Devuelve la ruta actual (Se usa como prompt).
            input = in.nextLine(); //Envía en forma de String lo introducido en terminal.

            //MENÚ
            String[] orden = input.split(" "); //Recoge el input y lo parte

            switch (orden[0])
            {
                case "pwd"://PWD
                    System.out.println("La ruta actual es: " + fileman.pwd());

                    break;

                case "cd": //CD
                    try
                    {
                        fileman.cd(orden[1]);
                    } catch (FileNotFoundException e)
                    {
                        System.out.println("El directorio no existe.");
                    }

                    break;

                case "ls": //LS
                    try
                    {
                        fileman.ls(false);
                    }
                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }

                    break;

                case "ll": //LS PERO CON INFO
                    try
                    {
                        fileman.ls(true);
                    }
                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }

                    break;

                case "mkdir": //MKDIR
                    try
                    {
                        fileman.mk(orden[1]);
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }

                    break;

                case "rm": //RM
                    try
                    {
                        fileman.rm(orden [1]);
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }

                    break;

                case "exit": //SALIR
                    System.out.println("\nSaliendo de la terminal...\n");
                    //System.out.println("EXIT");
                    exit = true;

                    break;
            }
        }while(!exit);
    }
}
