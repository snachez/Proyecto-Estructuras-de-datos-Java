package Control;
import java.io.*;
import profesor.ListaCirculardoble_nodo.Nodo;
import profesor.ListaCirculardoble_nodo;
import profesor.profesores;

/**
 *
 * @author AbaquerizoALP
 */
public class Gestorprofesor implements Serializable
{
    
    public void GrabarArchivo(String FileName,  ListaCirculardoble_nodo lista)
    {
        try {
            FileOutputStream fos = new FileOutputStream(FileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null)
            {
                Nodo auxiliar = lista.getLc();
                while(auxiliar != null)
                {
                    out.writeObject(auxiliar.getPro());
                    auxiliar = auxiliar.getEnlace();
                }
                out.close();
            }
        } catch (Exception e) {
        }
    }
    
    public void AbrirArchivo(String FileName, ListaCirculardoble_nodo lista)
    {
        try {
            FileInputStream fis = new FileInputStream(FileName);
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null)
            {
                profesores elemento;
                while((elemento = (profesores) in.readObject()) != null)
                {
                    lista.lc=lista.inserta_final(lista.lc, elemento);
                }
                in.close();
            }
        } catch (Exception e) {
        }
    }
    
}
