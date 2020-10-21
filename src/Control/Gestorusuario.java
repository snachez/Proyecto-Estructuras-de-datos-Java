package Control;
import java.io.*;
import usuario.Pila_nodo;
import usuario.Pila_nodo.Nodo;
import usuario.usuario;

public class Gestorusuario {
    
    public void GrabarArchivo(String FileName, Pila_nodo lista)
    {
        try {
            FileOutputStream fos = new FileOutputStream(FileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null)
            {
                Nodo auxiliar = lista.getTope();
                while(auxiliar != null)
                {
                    out.writeObject(auxiliar.getUsu());
                    auxiliar = auxiliar.getSig();
                }
                out.close();
            }
        } catch (Exception e) {
        }
    }
    
    public void AbrirArchivo(String FileName, Pila_nodo lista)
    {
        try {
            FileInputStream fis = new FileInputStream(FileName);
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null)
            {
                usuario elemento;
                while((elemento = (usuario) in.readObject()) != null)
                {
                    lista.push(elemento);
                }
                in.close();
            }
        } catch (Exception e) {
        }
    }
}
