package usuario;

import java.io.Serializable;

public class usuario implements Serializable{
     String usuario;
        int password;
        
        public final void setRegistro(Object[] registro)
    {
        this.usuario = registro[0].toString();
        this.password = Integer.parseInt(registro[1].toString());
    }
    
    public Object[] getRegistro()
    {
        Object[] registro = {usuario, password};
        return registro;
    }
    
    public usuario(Object[] registro)
    {
        this.setRegistro(registro);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    
    
}
