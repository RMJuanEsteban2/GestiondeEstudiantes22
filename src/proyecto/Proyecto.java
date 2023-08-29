/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;


import mundo.Alumno;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author Jmrias
 */
public class Proyecto {

    public static void main (String [] args){
        //arraylist y scanner para guardar y recibir la informacion
        Scanner lector = new Scanner (System.in); 
        
        ArrayList<Alumno> misAlumnos = new ArrayList<>();
        
       //ban que inicia y cierra el programa, inicia
        boolean programaActivo = true;
       
        //metodo de la lectura llamado
        lectura(misAlumnos);

        do {
            //llamado de metodos con sus parametrtos a continuacion
            //menu principal
             menuPrincipal(lector);
             
           int opcion = lector.nextInt();
            
            switch (opcion) 
            {
                case 1 -> 
                {
                    //metodo llamado del registro de los alumnos
                  registrarAlumno(lector, misAlumnos);
                  //actualizar el archivo registro y llamar su metodo
                  escritura (misAlumnos);
                }
                //elimina la informacion del alumno
                case 2 -> 
                {
                    eliminarAlumno(lector, misAlumnos);
                    
                 //actualizar el archivo registro y llamar su metodo
                   escritura (misAlumnos);
                }
                //modifica la informacion del alumno
                case 3 -> 
                {
                    //llamado al metodo que modifica la informacion del alumno
                   modificarAlumno(lector, misAlumnos);
                   
                   //actualizar el archivo registro y llamar su metodo
                   escritura (misAlumnos);
                    }
                case 4 -> 
                {
                    //llamado al metodo que consulta la inforamciuon del alumno
                    consultarAlumno(lector, misAlumnos);
                    
                   //actualizar el archivo registro y llamar su metodo
                   escritura (misAlumnos);
                }
                case 5 -> 
                {
                    System.out.println("programa terminado!");
                    programaActivo = false;
                }

                default -> System.out.println("Esta opcion no esta disponible");
            }
  } //Find algoritmo
        while (programaActivo);
}
    //todo en POO 
    //metodo para hacer la escritura del archivo
    public static void escritura(ArrayList<Alumno> misAlumnos)
        { 
            //try para una mejor interfaz y eficiente          
        try {

            //file para tomar la direccion del txt
            File archivo = new File("./data/Registro.txt");
            //printwriter para escribir la informacion de los alumnos en el archivo de texto
            PrintWriter pluma = new PrintWriter (archivo); 
            //ciclo for para que se repita la escritura           
            for (Alumno alumno : misAlumnos) {
                String alumnob = 
                        alumno.getSemestre() + "," 
                        + alumno.getNombre() + ","
                        + alumno.getApellido() + ","
                        + alumno.getCorreo() + ","
                        + alumno.getCelular() + "," 
                        + alumno.getCedula();
                //esta pluma imprimira lo anterior
                pluma.println(alumnob);
            }
            //cerramos la pluma
            pluma.close();

        } catch (Exception e)
        {
            System.out.println("Proceso no realizado");
        }        
    }
        
//metodo para hacer la lectura del archivo
        public static void lectura(ArrayList<Alumno> misAlumnos)
        {
        try {                        
            //File
            //ubica la direccion del archivo
            File archivo = new File("./data/Registro.txt");

            FileReader fr = new FileReader (archivo);

            BufferedReader lector = new BufferedReader(fr);  
            //ijnicializa  la variable del array para que lea el txt
            String in;

            //ciclo para que se realice el split en este array            
            while ((in = lector.readLine()) != null) 
            {
                String[] alumnob = in.split(",");
                
                int semestre = Integer.parseInt(alumnob[0]);
                String nombre = alumnob[1];
                String apellido = alumnob[2];
                String correo = (alumnob[3]);
                float celular = Float.parseFloat(alumnob[4]);
                float cedula = Float.parseFloat(alumnob[5]);
                
                //se guardara la informacion del alumno anterior 
                Alumno alumno = new Alumno (semestre, nombre, apellido, correo, celular, cedula);
                misAlumnos.add(alumno);
            }
            //cerramos el lector scanner
            lector.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Proceso no realizado");
        }
    }
    //metodo de menuPrincipal
    public static void menuPrincipal(Scanner lector)
    {
            System.out.println("================================");
            System.out.println("Menu Principal");
            System.out.println("1. Registrar alumno nuevo");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Consultar alumnos");
            System.out.println("5. Salir del programa");
            System.out.println("================================");
    }
    //metodo para registrar la informaacion del alumno
public static void registrarAlumno (Scanner lector, ArrayList<Alumno> misAlumnos)
{  
                    lector.nextLine();
                    System.out.println("Ingresa el nombre del alumno");
                    String nombre = lector.nextLine();                    
                    System.out.println("Ingresa el apellido del alumno");
                    String apellido = lector.nextLine();                    
                    System.out.println("Ingresa el correo del alumno");
                    String correo = lector.nextLine();     
                    System.out.println("Ingresa el semestre del alumno");
                    int semestre = lector.nextInt();
                    System.out.println("Ingresa el celular del alumno");
                    float celular = lector.nextFloat();                   
                    System.out.println("Ingresa la cedula del alumno");
                    float cedula = lector.nextFloat();  
                    System.out.println("Informacion registrada");
                    Alumno a = new Alumno();
                    a.setNombre(nombre);
                    a.setApellido(apellido);
                    a.setCorreo(correo);
                    a.setCelular(celular);
                    a.setCedula(cedula);
                    a.setSemestre(semestre);
                    misAlumnos.add(a);
                    //en este caso 1 se guardara la iformacion de los alumnos
}
public  static void eliminarAlumno (Scanner lector, ArrayList<Alumno> misAlumnos){
    if (misAlumnos.isEmpty())  
   {
       System.out.println("Sin informacion de alumnos que mostrar");
   } 
    else 
    {
    System.out.println("Ingrese la cedula del alumno para eliminar:");
    float cedulaEliminar = lector.nextFloat();
    // Consumir nueva línea
    lector.nextLine(); 
    boolean alumnoEncontrado = false;
    for (Alumno alumno : misAlumnos) {
    if (alumno.getCedula() == cedulaEliminar) {
        alumnoEncontrado = true;
        misAlumnos.remove(alumno);
        System.out.println("Alumno eliminado");
        break; // Importante para evitar problemas
    }
}     
   }
}
public static void modificarAlumno (Scanner lector, ArrayList<Alumno> misAlumnos)
{
 System.out.println("Ingrese la cedula del alumno a modificar:");
    float cedulaModificar = lector.nextFloat();
         boolean alumnoEncontrado = false;
          for (Alumno alumno:misAlumnos) {
            if (alumno.getCedula() == cedulaModificar) {
               alumnoEncontrado = true;
               lector.nextLine();             
                System.out.println("Ingrese el nuevo nombre:");
                String nuevoNombreMod = lector.nextLine();
                System.out.println("Ingrese el nuevo apellido:");              
                String nuevoApellidoMod = lector.nextLine();
                System.out.println("Ingrese el nuevo correo:");
                String nuevoCorreoMod = lector.nextLine();
                System.out.println("Ingrese el nuevo semestre:");
                int nuevoSemestreMod = lector.nextInt();
                System.out.println("Ingrese el nuevo celular:");
                float nuevoCelularMod = lector.nextFloat();
                System.out.println("Ingrese la nueva cedula:");
                float nuevaCedulaMod = lector.nextFloat();
                alumno.setNombre(nuevoNombreMod);
                alumno.setApellido(nuevoApellidoMod);
                alumno.setCorreo(nuevoCorreoMod);
                alumno.setSemestre(nuevoSemestreMod);
                alumno.setCelular(nuevoCelularMod);
                alumno.setCedula(nuevaCedulaMod);
                System.out.println("================================");
                System.out.println("Se cambio la informacion del alumno");
            }
          }
          if (!alumnoEncontrado) 
          {
              System.out.println("Informacion no valida");
          }                   
}
public static void consultarAlumno (Scanner lector, ArrayList<Alumno> misAlumnos){
        if (misAlumnos.isEmpty())
        {
            System.out.println("No hay informacion que mostrar");
        }
            else{ 
            
            System.out.println("Listado de alumnos");
            System.out.println("================================");
            for (Alumno alumno : misAlumnos) {
                System.out.println("Semestre: " + alumno.getSemestre());
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido: " + alumno.getApellido());
                System.out.println("Correo: " + alumno.getCorreo());
                System.out.println("Celular: " + alumno.getCelular());
                System.out.println("Cedula: " + alumno.getCedula());
                System.out.println("================================");
            } 
        }   
}
}       
