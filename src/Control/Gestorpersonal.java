package Control;

import java.io.*;
import personal.ListaSimple_nodo;
import personal.ListaSimple_nodo.Nodo;
import personal.personal;

public class Gestorpersonal implements Serializable{
    
    public void GrabarArchivo(String FileName, ListaSimple_nodo lista)
    {
        try {
            FileOutputStream fos = new FileOutputStream(FileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null)
            {
                Nodo auxiliar = lista.getIni();
                while(auxiliar != null)
                {
                    out.writeObject(auxiliar.getPer());
                    auxiliar = auxiliar.getSig();
                }
                out.close();
            }
        } catch (Exception e) {
        }
    }
    
    public void AbrirArchivo(String FileName, ListaSimple_nodo lista)
    {
        try {
            FileInputStream fis = new FileInputStream(FileName);
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null)
            {
                personal elemento;
                while((elemento = (personal) in.readObject()) != null)
                {
                    lista.ini=lista.insertarinicio(lista.ini, elemento);
                }
                in.close();
            }
        } catch (Exception e) {
        }
    }
}
