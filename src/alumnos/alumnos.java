package alumnos;

import java.io.Serializable;

public class alumnos implements Serializable{
    
     String nombre;
        String apellido1;
        String apellido2;
        int DNI;
        int casa;
        int celular;
        String correo;
        String carrera;
        String materia1;
        String materia2;
        String materia3;
        
        public final void setRegistro(Object[] registro)
    {
        this.nombre = registro[0].toString();
        this.apellido1 = registro[1].toString();
        this.apellido2 = registro[2].toString();
        this.DNI = Integer.parseInt(registro[3].toString());
        this.casa = Integer.parseInt(registro[4].toString());
        this.celular = Integer.parseInt(registro[5].toString());
        this.correo = registro[6].toString();
        this.carrera = registro[7].toString();
        this.materia1 = registro[8].toString();
        this.materia2 = registro[9].toString();
        this.materia3 = registro[10].toString();
        
    }
    
    public Object[] getRegistro()
    {
        Object[] registro = {nombre, apellido1, apellido2, DNI, casa, celular, correo, carrera, materia1, materia2, materia3};
        return registro;
    }
    
    public alumnos(Object[] registro)
    {
        this.setRegistro(registro);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getCasa() {
        return casa;
    }

    public void setCasa(int casa) {
        this.casa = casa;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMateria1() {
        return materia1;
    }

    public void setMateria1(String materia1) {
        this.materia1 = materia1;
    }

    public String getMateria2() {
        return materia2;
    }

    public void setMateria2(String materia2) {
        this.materia2 = materia2;
    }

    public String getMateria3() {
        return materia3;
    }

    public void setMateria3(String materia3) {
        this.materia3 = materia3;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
}
