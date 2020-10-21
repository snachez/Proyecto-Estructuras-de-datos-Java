package Control;
import java.io.*;
import materias.Cola_nodo;
import materias.Cola_nodo.Nodo1;
import materias.materias;

/**
 *
 * @author AbaquerizoALP
 */
public class Gestormaterias implements Serializable
{
    
    public void GrabarArchivo(String FileName, Cola_nodo lista)
    {
        try {
            FileOutputStream fos = new FileOutputStream(FileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null)
            {
                Nodo1 auxiliar = lista.getFrente();
                while(auxiliar != null)
                {
                    out.writeObject(auxiliar.getMat());
                    auxiliar = auxiliar.getSig();
                }
                out.close();
            }
        } catch (Exception e) {
        }
    }
    
    public void AbrirArchivo(String FileName, Cola_nodo lista)
    {
        try {
            FileInputStream fis = new FileInputStream(FileName);
            ObjectInputStream in = new ObjectInputStream(fis);
            if(in != null)
            {
                materias elemento;
                while((elemento = (materias) in.readObject()) != null)
                {
                    lista.encolar(elemento);
                }
                in.close();
            }
        } catch (Exception e) {
        }
    }
    
}
