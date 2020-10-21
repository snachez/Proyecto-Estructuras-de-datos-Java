package personal;

import java.io.Serializable;

public class ListaSimple_nodo implements Serializable{
    
     public class Nodo implements Serializable{
         personal per;
         Nodo sig;

        public Nodo(personal perso) {
            per = perso;
            sig = null;
        }

        public personal getPer() {
            return per;
        }

        public void setPer(personal per) {
            this.per = per;
        }

        public Nodo getSig() {
            return sig;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }    
     }
     public Nodo ini,fin;
    public Nodo pFound;
    
    public Nodo insertarinicio(Nodo inicio,personal perso){
        Nodo nuevo=new Nodo(perso);
        nuevo.sig=inicio;
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
