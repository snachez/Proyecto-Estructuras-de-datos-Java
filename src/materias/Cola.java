package materias;
import Control.Gestormaterias;
import Control.escribir_materias;
import Control.escribir_carrera;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import materias.Cola_nodo.Nodo1;
import static profesor.ListaCircularDoble.materia;

public class Cola extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo;
    String [] cabecera={"N°","Codigo","Carrera","Materia","Monto","Descuento 15%","Total"};
    String [][] data={};
    int num=0;
    Gestormaterias gestor = new Gestormaterias();
    String FileName = "Empleado.bin";
    Cola_nodo lista = new Cola_nodo();
    Nodo1 nodo;

    
    public Cola() {
        initComponents();
        gestor.AbrirArchivo(FileName, lista);
        modelo=new DefaultTableModel(data,cabecera);
        tblRegistro.setModel(modelo);
    }

    
    @SuppressWarnings("unchecked")
    private void mensaje(String data){
        StringTokenizer st=new StringTokenizer(data,",");
        String co=st.nextToken();
        String n=st.nextToken();
        String a1=st.nextToken();
        String d=st.nextToken();
        String cas=st.nextToken();
        String ce=st.nextToken();

        String datos="Descripcion del dato eliminado:\n"+
                     "Codigo :"+co+"\n"+
                     "Carrera  :"+n+"\n"+
                     "Materia  :"+a1+"\n"+
                     "Monto  :"+d+"\n"+
                     "Descuento 15%  :"+cas+"\n"+
                     "Total  :"+ce+"\n";
        JOptionPane.showMessageDialog(this,datos);
    }
    
    void verdatos(){
        String cod,car,mat;
        double des,tot;
        int mon;
        Nodo1 aux=lista.frente;
        vaciartabla();
        num=0;
        while(aux!=null){
            cod=aux.mat.getCodigo();
            car=aux.mat.getCarrera();
            mat=aux.mat.getMateria();
            mon=aux.mat.getMonto();
            des=aux.mat.getDescuento();
            tot=aux.mat.getTotal();
            num++;
            Object[]fila={num,cod,car,mat,mon,des,tot};
            modelo.addRow(fila);
            aux=aux.sig;
        }
    }
    
    void habilitar(){
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);
    }
    void deshabilitar(){
        btnactualizar.setEnabled(false);
        btnguardar.setEnabled(true);
    }
    void limpiarentradas(){
        txtcodigo.setText("");
        txtcarrera.setText("");
        txtmateria.setText("");
        txtmonto.setText("");
        txtcodigo.requestFocus();
    }
    void vaciartabla(){
        int filas=tblRegistro.getRowCount();
        for(int i=0;i<filas;i++)
            modelo.removeRow(0);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtcarrera = new javax.swing.JTextField();
        txtmateria = new javax.swing.JTextField();
        txtmonto = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnreestaurar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cola");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Universidad Fidelitas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Carrera");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Materia");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Monto");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnreestaurar.setText("Reestaurar");
        btnreestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreestaurarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Carrera", "Materia", "Monto", "Descuento 15%", "total"
            }
        ));
        jScrollPane1.setViewportView(tblRegistro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnreestaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtmateria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtcodigo))
                                .addGap(173, 173, 173)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        setBounds(0, 0, 800, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      
      String cod=txtcodigo.getText().toUpperCase();
      String car=txtcarrera.getText().toUpperCase();
      String mat=txtmateria.getText().toUpperCase();
      String mon1=txtmonto.getText().toUpperCase();
      String des1=txtmonto.getText().toUpperCase();
      String tot1=txtmonto.getText().toUpperCase();
      lista.pFound2=lista.buscar2(lista.frente,mat);
        if(cod.isEmpty() || car.isEmpty() || mat.isEmpty() || 
                mon1.isEmpty() || des1.isEmpty() || tot1.isEmpty()){
            JOptionPane.showMessageDialog(this,"Tienes campos vacios ingrese toda la informacion solicitada por favor");
        }else {
            lista.pFound=lista.buscar(lista.frente,cod);
            if(lista.pFound!=null){
                 lista.pFound=lista.buscar2(lista.frente,mat);
            if(lista.pFound!=null){
                JOptionPane.showMessageDialog(this,"El codigo: "+cod+" y esta materia: "+mat+" ya estan en la lista ingrese otros diferentes..");
            }else{
                JOptionPane.showMessageDialog(this,"El codigo: "+cod+" ya esta en la lista ingrese otro diferente..");
            }}else if(lista.pFound2!=null){
            JOptionPane.showMessageDialog(this,"Esta materia: "+mat+" ya esta en la lista ingrese otro diferente..");
        }else{
                int mon=Integer.parseInt(mon1);
                double des=Integer.parseInt(des1);
                double tot=Integer.parseInt(tot1);
                 lista.encolar(new materias(new Object[] {cod, car, mat, mon, des, tot}));
                 try{            
            StringBuffer materias  = new  StringBuffer(txtmateria.getText().trim()+"\t");
            escribir_materias.EscribeTxt(materias);
        }catch(Exception e){} 
          try{            
            StringBuffer carrera  = new  StringBuffer(txtcarrera.getText().trim()+"\t");
            escribir_carrera.EscribeTxt(carrera);
        }catch(Exception e){}         
      limpiarentradas();
      verdatos();
      gestor.GrabarArchivo(FileName, lista);
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnreestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreestaurarActionPerformed
        limpiarentradas();
        deshabilitar();
    }//GEN-LAST:event_btnreestaurarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        limpiarentradas();
        deshabilitar();
        verdatos();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        String cod=txtcodigo.getText();
        if(cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese un codigo por favor");
        }else {
            lista.pFound=lista.buscar(lista.frente,cod);
            if(lista.pFound!=null){
                txtcarrera.setText(lista.pFound.mat.getCarrera());
                txtmateria.setText(lista.pFound.mat.getMateria());
                txtmonto.setText(String.valueOf(lista.pFound.mat.getMonto()));
                habilitar();
            } else {
                JOptionPane.showMessageDialog(this,"El codigo: "+cod+" , no esta en la lista..");
            }
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if(lista.frente==null){
            JOptionPane.showMessageDialog(this,"La cola esta vacia");
            txtcodigo.requestFocus();
        }
 else
        {
            String dato=lista.frente();
            mensaje(dato);
            gestor.GrabarArchivo(FileName, lista);
            verdatos();
            limpiarentradas();
            if(lista.frente==null)
                JOptionPane.showMessageDialog(this,"La cola esta vacia");
            deshabilitar();

 }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnreestaurar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JTextField txtcarrera;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtmateria;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables

}
