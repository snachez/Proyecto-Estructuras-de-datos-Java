package profesor;

import java.io.Serializable;

public class profesores implements Serializable
{
        String nombre;
        String apellido1;
        String apellido2;
        int DNI;
        int casa;
        int celular;
        String profesor;
        String materia;
        
        public final void setRegistro(Object[] registro)
    {
        this.nombre = registro[0].toString();
        this.apellido1 = registro[1].toString();
        this.apellido2 = registro[2].toString();
        this.DNI = Integer.parseInt(registro[3].toString());
        this.casa = Integer.parseInt(registro[4].toString());
        this.celular = Integer.parseInt(registro[5].toString());
        this.profesor = registro[6].toString();
        this.materia = registro[7].toString();
    }
    
    public Object[] getRegistro()
    {
        Object[] registro = {nombre, apellido1, apellido2, DNI, casa, celular, profesor, materia};
        return registro;
    }
    
    public profesores(Object[] registro)
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

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
}
