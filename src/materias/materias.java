package materias;

import java.io.Serializable;

/**
 *
 * @author AbaquerizoALP
 */
public class materias implements Serializable
{
        String codigo;
        String carrera;
        String materia;
        int monto;
        double descuento;
        double total;
    
    public final void setRegistro(Object[] registro)
    {
        this.codigo = registro[0].toString();
        this.carrera = registro[1].toString();
        this.materia = registro[2].toString();
        this.monto = Integer.parseInt(registro[3].toString());
        this.descuento = Double.parseDouble(registro[4].toString());
        this.total = Double.parseDouble(registro[5].toString());
    }
    
    public Object[] getRegistro()
    {
        Object[] registro = {codigo, carrera, materia, monto, descuento, total};
        return registro;
    }
    
    public materias(Object[] registro)
    {
        this.setRegistro(registro);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public double getDescuento() {
        return descuento*0.15;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total-getDescuento();
    }

    public void setTotal(double total) {
        this.total = total;
    }

   
    
    
    
}
