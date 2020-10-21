package alumnos;

import java.io.Serializable;

public class ListaDoble_nodo implements Serializable{
    
    public class Nodo implements Serializable{
        alumnos alumno;
         Nodo sig;
        Nodo ant;

        public Nodo(alumnos alum) {
            alumno = alum;
            sig = null;
            ant = null;
        }

        public alumnos getAlumno() {
            return alumno;
        }

        public void setAlumno(alumnos alumno) {
            this.alumno = alumno;
        }

        public Nodo getSig() {
            return sig;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }

        public Nodo getAnt() {
            return ant;
        }

        public void setAnt(Nodo ant) {
            this.ant = ant;
        } 
    }
    
    public Nodo ini,fin;
    public Nodo pFound;

    public ListaDoble_nodo() {
        ini=fin=pFound=null;
    }
    
    public Nodo inserta_final(Nodo inicio,alumnos alum){
        Nodo nuevo=new Nodo(alum);
        nuevo.sig=inicio;
        if(inicio==null){
          fin=nuevo;
          fin.sig=null;
        }
        if(inicio!=null)
          inicio.ant=nuevo;
          inicio=nuevo;
          return inicio;
    }

    public Nodo getIni() {
        return ini;
    }

    public void setIni(Nodo ini) {
        this.ini = ini;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public Nodo getpFound() {
        return pFound;
    }

    public void setpFound(Nodo pFound) {
        this.pFound = pFound;
    }
    
    
}
