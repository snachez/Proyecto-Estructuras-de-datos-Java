package profesor;

import java.io.Serializable;

public class ListaCirculardoble_nodo implements Serializable{
    
    public class Nodo implements Serializable{
        profesores pro;
        Nodo enlace;
        Nodo enlace1;
        
        public Nodo(profesores profe){
            pro=profe;
            enlace=enlace1=this;
        }

        public profesores getPro() {
            return pro;
        }

        public void setPro(profesores pro) {
            this.pro = pro;
        }

        public Nodo getEnlace() {
            return enlace;
        }

        public void setEnlace(Nodo enlace) {
            this.enlace = enlace;
        }

        public Nodo getEnlace1() {
            return enlace1;
        }

        public void setEnlace1(Nodo enlace1) {
            this.enlace1 = enlace1;
        }
        
    }
    
    public Nodo lc,lc1;
    public Nodo pFound;

    public ListaCirculardoble_nodo() {
        lc=lc1=pFound=null;
    }
    
    public Nodo inserta_final(Nodo inicio,profesores profe){
        Nodo nuevo=new Nodo(profe);
        nuevo.enlace=inicio;
        if(inicio==null){
          lc1=nuevo;
          lc1.enlace=null;
        }
        if(inicio!=null)
            inicio.enlace1=nuevo;
        inicio=nuevo;
        return inicio;
    }
   
    

    public Nodo getLc() {
        return lc;
    }

    public void setLc(Nodo lc) {
        this.lc = lc;
    }

    public Nodo getLc1() {
        return lc1;
    }

    public void setLc1(Nodo lc1) {
        this.lc1 = lc1;
    }

    public Nodo getpFound() {
        return pFound;
    }

    public void setpFound(Nodo pFound) {
        this.pFound = pFound;
    }
    
    
}
