package Control;

import alumnos.ListaDoble_nodo;
import java.io.*;
import alumnos.ListaDoble_nodo.Nodo;
import alumnos.ListaDoble_nodo;
import alumnos.alumnos;

public class Gestoralumno implements Serializable{
    
    public void GrabarArchivo(String FileName,  ListaDoble_nodo lista)
    {
        try {
            FileOutputStream fos = new FileOutputStream(FileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null)
            {
                Nodo auxiliar = lista.getIni();
                while(auxiliar != null)
                {
                    out.writeObject(auxiliar.getAlumno());
                    auxiliar = auxiliar.getSig();
                }
                out.close();
            }
        } catch (Exception e) {
        }
    }
    
    public void AbrirArchivo(String FileName, ListaDoble_nodo lista)
    {
        try {
            FileInputStream fis = new FileInputStream(FileName);
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null)
            {
                alumnos elemento;
                while((elemento = (alumnos) in.readObject()) != null)
                {
                    lista.ini=lista.inserta_final(lista.ini, elemento);
                }
                in.close();
            }
        } catch (Exception e) {
        }
    }
}
