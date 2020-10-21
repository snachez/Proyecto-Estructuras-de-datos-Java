package Control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class escribir_materias {
   
    static String ruta = System.getProperties().getProperty("user.dir")+"//";
    
    public static void EscribeTxt(StringBuffer materias)
    {
          File archivo;
        FileWriter escribir;
        PrintWriter linea;
        archivo = new File("materias.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(materias);
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(escribir_carrera.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(materias);
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(escribir_carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}}
