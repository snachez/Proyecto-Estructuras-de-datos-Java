package usuario;

import java.io.Serializable;

public class Pila_nodo implements Serializable{
    
    public class Nodo implements Serializable{
         usuario usu;
         Nodo sig;

        public Nodo(usuario usuarios) {
            usu=usuarios;
            sig=null;
        }

        public usuario getUsu() {
            return usu;
        }

        public void setUsu(usuario usu) {
            this.usu = usu;
        }

        public Nodo getSig() {
            return sig;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }
    }
    public Nodo tope;
    public Nodo pFound;
    public Nodo pFound2;

    public Pila_nodo() {
        tope = null;
    }
    
     public void push(usuario usuarios){
        Nodo nuevo=new Nodo(usuarios);
        if(tope==null)
            nuevo.sig=null;
        else
            nuevo.sig=tope;
        tope=nuevo;

    }

    public Nodo getTope() {
        return tope;
    }

    public void setTope(Nodo tope) {
        this.tope = tope;
    }

    public Nodo getpFound() {
        return pFound;
    }

    public void setpFound(Nodo pFound) {
        this.pFound = pFound;
    }
     
     
}
     

