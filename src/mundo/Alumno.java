/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author Jmrias
 */
public class Alumno {
    
    
    private int semestre;
    private String nombre;
    private String apellido;
    private String correo;
    private float celular;
    private float cedula;
  
    
    public Alumno() { 

        
            
        
    }

    public Alumno(int semestre, String nombre, String apellido, String correo, float celular, float cedula) {
        this.semestre = semestre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.cedula = cedula;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public float getCelular() {
        return celular;
    }

    public void setCelular(float celular) {
        this.celular = celular;
    }

    public float getCedula() {
        return cedula;
    }

    public void setCedula(float cedula) {
        this.cedula = cedula;
    }
}

  
