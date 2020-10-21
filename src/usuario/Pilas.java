package usuario;
import Control.Gestorusuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.awt.Font;
import java.util.*;
import usuario.Pila_nodo.Nodo;

public class Pilas extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    String [] cabecera={"N°","Usuario","Password"};
    String [][] data={};
    int num=0,tam;
    Gestorusuario gestor = new Gestorusuario();
    String FileName = "Usuario.bin";
    Pila_nodo lista = new Pila_nodo();
    Nodo nodo;
   

    public Pilas() {
        initComponents(); 
        gestor.AbrirArchivo(FileName, lista);
        tam=0;
        modelo=new DefaultTableModel(data,cabecera);
        tblRegistro.setModel(modelo);
    }
    
     public String pop(){
        String eliminado="";
        Nodo aux=lista.tope;
        String usu=aux.usu.getUsuario();
        int pass=aux.usu.getPassword();
        eliminado=usu+","+String.valueOf(pass);
        lista.tope=lista.tope.sig;
        aux.sig=null;
        return eliminado;

    }

    public Nodo Buscar(Nodo tope,String usuar){
        Nodo pos=tope;
        while(pos!=null&& !usuar.equalsIgnoreCase(pos.usu.usuario))
            pos=pos.sig;
        return pos;
    }
    
    public Nodo Buscar2(Nodo tope,String passwor){
        Nodo pos=tope;
        while(pos!=null&& !passwor.equalsIgnoreCase(String.valueOf(pos.usu.password)))
            pos=pos.sig;
        return pos;
    }

    public void mensaje(String data){
        StringTokenizer st=new StringTokenizer(data,",");
        String usu=st.nextToken();
        String pass=st.nextToken();

        String datos="Descripcion del dato eliminado:\n"+
                     "Usuario :"+usu+"\n"+
                     "Password  :"+pass+"\n";
        JOptionPane.showMessageDialog(this,datos);
    }

    public void verdatos(){
        String usuar;
        int passwor;
        Nodo aux=lista.tope;
        vaciartabla();
        Nodo p;
        num=Numelem();
        while(aux!=null){
            usuar=aux.usu.getUsuario();
            passwor=aux.usu.getPassword();

            Object[]fila={num,usuar,passwor};
            num--;
            modelo.addRow(fila);
            aux=aux.sig;
        }
        txttam.setText(String.valueOf(tam));
    }

    public int Numelem(){
        int num=0;
        Nodo aux=lista.tope;
        while(aux!=null){
            num++;
            aux=aux.sig;
        }return num;
    }


    void habilitar(){
        btn_modificar.setEnabled(true);
        btn_guardar.setEnabled(false);
    }
    void deshabilitar(){
        btn_modificar.setEnabled(false);
        btn_guardar.setEnabled(true);
    }
    void limpiarentradas(){
        txtusuario.setText("");
        txtpassword.setText("");
        txtusuario.requestFocus();
    }
    void vaciartabla(){
        int filas=tblRegistro.getRowCount();
        for(int i=0;i<filas;i++)
            modelo.removeRow(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_modificar1 = new javax.swing.JButton();
        btn_modificar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        txttam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Areas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        txtusuario.setToolTipText("Digite Id. Area");
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        txtpassword.setToolTipText("Escriba El Nombre De Area");
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswordKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("password:");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 204, 204));
        jTextField3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Registro");

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        btn_guardar.setToolTipText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mantenimiento.png"))); // NOI18N
        btn_modificar.setToolTipText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_modificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btn_modificar1.setToolTipText("Cancelar");
        btn_modificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar1ActionPerformed(evt);
            }
        });

        btn_modificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btn_modificar2.setToolTipText("Salir");
        btn_modificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar2ActionPerformed(evt);
            }
        });

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRegistro);

        txttam.setEditable(false);

        jLabel3.setText("Registro total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btn_modificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(btn_modificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(676, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
         String usuar=txtusuario.getText();
      int passwor=Integer.parseInt(txtpassword.getText());
      lista.push(new usuario(new Object[] {usuar, passwor}));
      tam=tam+1;
      limpiarentradas();
      verdatos();
      gestor.GrabarArchivo(FileName, lista);
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        String usuar=txtusuario.getText();
        if(usuar.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese un codigo por favor");
        }else {
            lista.pFound=Buscar(lista.tope,usuar);
            if(lista.pFound!=null){
                txtusuario.setText(lista.pFound.usu.getUsuario());
                txtpassword.setText(String.valueOf(lista.pFound.usu.getPassword()));

                habilitar();
            } else {
                JOptionPane.showMessageDialog(this,"El usuario: "+usuar+" , no esta en la lista..");
            }
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
          limpiarentradas();
        deshabilitar();
        verdatos();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_modificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar1ActionPerformed
        // TODO add your handling code here:
        if(lista.tope==null){
            JOptionPane.showMessageDialog(this,"La pila esta vacia");
            txtusuario.requestFocus();
        }
 else
        {
            String dato=pop();
            mensaje(dato);
            gestor.GrabarArchivo(FileName, lista); 
            verdatos();
            limpiarentradas();
            if(lista.tope==null)
                JOptionPane.showMessageDialog(this,"La pila esta vacia");
            deshabilitar();

 }
    }//GEN-LAST:event_btn_modificar1ActionPerformed

    private void txtpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyTyped
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtpasswordKeyTyped

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void btn_modificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar2ActionPerformed
        // TODO add your handling code here:
        Ingresar b = new Ingresar();
            b.setVisible(true);
            dispose();
    }//GEN-LAST:event_btn_modificar2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pilas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_modificar1;
    private javax.swing.JButton btn_modificar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txttam;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
