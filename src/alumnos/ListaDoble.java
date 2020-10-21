package alumnos;
import Control.Gestoralumno;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import alumnos.ListaDoble_nodo.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ListaDoble extends javax.swing.JInternalFrame {

    public final String ruta = System.getProperties().getProperty("user.dir");
    DefaultTableModel Modelo;
    String [] cabecera={"N°","Nombre","Ape. Paterno","Ape. Materno","Cedula","Telef.casa","Celular","Correo","Carrera","Materia1","Materia2","Materia3"};
    String [][] data={};
    int num=0;
    Gestoralumno gestor = new Gestoralumno();
    String FileName = "profesores.bin";
    ListaDoble_nodo lista = new  ListaDoble_nodo();
    Nodo nodo;

    public ListaDoble() {
        initComponents();
        gestor.AbrirArchivo(FileName, lista);
        Modelo=new DefaultTableModel(data,cabecera);
        tblRegistro.setModel(Modelo);
        
        File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (ruta+"//carrera.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
            carrera.addItem(linea);
         }
      }      
      catch(IOException e){}finally{try{if( null != fr ){fr.close();}}catch (IOException e2){}
      }
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (ruta+"//materias.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
            materia1.addItem(linea);
            materia2.addItem(linea);
            materia3.addItem(linea);
         }
      }      
      catch(IOException e){}finally{try{if( null != fr ){fr.close();}}catch (IOException e2){}
      }
    }

   
    @SuppressWarnings("unchecked")

     void habilitar(){
        btneliminar.setEnabled(true);
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);

    }

    void deshabilitar(){
        btneliminar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btnguardar.setEnabled(true);
    }

    void limpiar_entradas(){
        txtnombre.setText("");
        txtapellido1.setText("");
        txtapellido2.setText("");
        txtdni.setText("");
        txtcasa.setText("");
        txtcelular.setText("");
        txtcorreo.setText("");
        txtnombre.requestFocus();
    }

    void vaciar_tabla(){
        int filas=tblRegistro.getRowCount();
        for(int i=0;i<filas;i++)
            Modelo.removeRow(0);
    }

    void ver_datos(int ind){
        String nom,ape1,ape2,cor,car,mat1,mat2,mat3;
        int dni,ca,cel;

        switch(ind){
            case 1:{
                vaciar_tabla();
                Nodo aux=lista.ini;
                num=0;
                while(aux!=null){
                    nom=aux.alumno.getNombre();
                    ape1=aux.alumno.getApellido1();
                    ape2=aux.alumno.getApellido2();
                    dni=aux.alumno.getDNI();
                    ca=aux.alumno.getCasa();
                    cel=aux.alumno.getCelular();
                    cor=aux.alumno.getCorreo();
                    car=aux.alumno.getCarrera();
                    mat1=aux.alumno.getMateria1();
                    mat2=aux.alumno.getMateria2();
                    mat3=aux.alumno.getMateria3();
                    num++;
                    Object[] fila={num,nom,ape1,ape2,dni,ca,cel,cor,car,mat1,mat2,mat3};
                    Modelo.addRow(fila);
                    aux=aux.sig;
               }
            }break;

           case 2:{
                vaciar_tabla();
                Nodo aux=lista.fin;
                num=0;
                while(aux!=null){
                    nom=aux.alumno.getNombre();
                    ape1=aux.alumno.getApellido1();
                    ape2=aux.alumno.getApellido2();
                    dni=aux.alumno.getDNI();
                    ca=aux.alumno.getCasa();
                    cel=aux.alumno.getCelular();
                    cor=aux.alumno.getCorreo();
                    car=aux.alumno.getCarrera();
                    mat1=aux.alumno.getMateria1();
                    mat2=aux.alumno.getMateria2();
                    mat3=aux.alumno.getMateria3();
                    num++;
                    Object[] fila={num,nom,ape1,ape2,dni,ca,cel,cor,car,mat1,mat2,mat3};
                    Modelo.addRow(fila);
                    aux=aux.ant;
                }
            }break;
        }
    }

    Nodo buscar(Nodo inicio,String nom){
        Nodo pos=inicio;
        while(pos!=null && !nom.equalsIgnoreCase(pos.alumno.nombre))
            pos=pos.sig;
        return pos;
    }
    
    Nodo buscar2(Nodo inicio,String ape1){
        Nodo pos=inicio;
        while(pos!=null && !ape1.equalsIgnoreCase(pos.alumno.apellido1))
            pos=pos.sig;
        return pos;
    }
    
    Nodo buscar3(Nodo inicio,String ape2){
        Nodo pos=inicio;
        while(pos!=null && !ape2.equalsIgnoreCase(pos.alumno.apellido2))
            pos=pos.sig;
        return pos;
    }

    void eliminar(){
        Nodo actual;
        boolean encontrado = false;
        actual=lista.ini;
        while((actual!=null)&&(!encontrado)){
          encontrado=actual.alumno.nombre.equalsIgnoreCase(txtnombre.getText().trim());
          if(!encontrado)
              actual=actual.sig;
        }
        if(actual!=null){
            if(actual== lista.ini){
                lista.ini=actual.sig;
                if(actual.sig!=null)
                    actual.sig.ant=null;
            }else if(actual.sig!=null){
                actual.ant.sig=actual.sig;
                actual.sig.ant=actual.ant;
            }else {
                actual.ant.sig=null;
                lista.fin=actual.ant;
            }actual=null;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnguardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtapellido2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        btnreestaurar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        txtcasa = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        carrera = new javax.swing.JComboBox<>();
        materia1 = new javax.swing.JComboBox<>();
        materia2 = new javax.swing.JComboBox<>();
        materia3 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista Doble");
        setPreferredSize(new java.awt.Dimension(804, 700));

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel3.setText("Apellido Paterno");

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

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellido Materno");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Universidad Fidelitas");

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnreestaurar.setText("Reestaurar");
        btnreestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreestaurarActionPerformed(evt);
            }
        });

        jLabel6.setText("Cedula");

        jLabel7.setText("Telef. Casa");

        jLabel8.setText("Celular");

        jLabel2.setText("Correo");

        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtapellido2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtcorreo))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(110, 110, 110)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)))
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtcelular, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                    .addComponent(materia1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(materia2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(btnreestaurar)
                                .addGap(35, 35, 35)
                                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(materia3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(materia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(materia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(materia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        setBounds(0, 0, 800, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      String nom=txtnombre.getText().toUpperCase();
      String ape1=txtapellido1.getText().toUpperCase();
      String ape2=txtapellido2.getText().toUpperCase();
      String dni1=txtdni.getText().toUpperCase();
      String ca1=txtcasa.getText().toUpperCase();
      String cel1=txtcelular.getText().toUpperCase();
      String cor=txtcorreo.getText().toUpperCase();
      String car=carrera.getSelectedItem().toString();
      String mat1=materia1.getSelectedItem().toString();
      String mat2=materia2.getSelectedItem().toString();
      String mat3=materia3.getSelectedItem().toString();
        if(nom.isEmpty() || ape1.isEmpty() || ape2.isEmpty() || 
                dni1.isEmpty() || ca1.isEmpty() || cel1.isEmpty()
                || cor.isEmpty() || car.isEmpty() || mat1.isEmpty()){
            JOptionPane.showMessageDialog(this,"Tienes campos vacios ingrese toda la informacion solicitada por favor");
        }else if(mat2.isEmpty() && mat3.isEmpty()){
        JOptionPane.showMessageDialog(this,"Vas ingresar mas materias?");
    }else {
            lista.pFound=buscar(lista.ini,nom);
            if(lista.pFound!=null){
               lista.pFound=buscar2(lista.ini,ape1);
            if(lista.pFound!=null){
                lista.pFound=buscar3(lista.ini,ape2);
            if(lista.pFound!=null){
                JOptionPane.showMessageDialog(this,"El nombre: "+nom+" , apellidos: "+ape1+", "+ape2+"ya esta en la lista ingrese otro diferente..");  
            }   
            }   
            } else {
                int dni=Integer.parseInt(dni1);
                int ca=Integer.parseInt(ca1);
                int cel=Integer.parseInt(cel1);
                lista.ini=lista.inserta_final(lista.ini, new alumnos(new Object[] {nom, ape1, ape2, dni, ca, cel, cor,car,mat1,mat2,mat3}));
      limpiar_entradas();
      ver_datos(1);
      gestor.GrabarArchivo(FileName, lista);
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar();
        gestor.GrabarArchivo(FileName, lista);
        limpiar_entradas();
        ver_datos(1);
        if(lista.ini==null)
            JOptionPane.showMessageDialog(this, "La lista esta vacia");
        deshabilitar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        String nom=txtnombre.getText();
        if(nom.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese en nombre por favor");
        }else {
            lista.pFound=buscar(lista.ini,nom);
            if(lista.pFound!=null){
                txtnombre.setText(lista.pFound.alumno.getNombre());
                txtapellido1.setText(lista.pFound.alumno.getApellido1());
                txtapellido2.setText(lista.pFound.alumno.getApellido2());
                txtdni.setText(String.valueOf(lista.pFound.alumno.getDNI()));
                txtcasa.setText(String.valueOf(lista.pFound.alumno.getCasa()));
                txtcelular.setText(String.valueOf(lista.pFound.alumno.getCelular()));
                txtcorreo.setText(lista.pFound.alumno.getCorreo());
                habilitar();
            } else {
                JOptionPane.showMessageDialog(this,"El nombre: "+nom+" , no esta en la lista..");
            }
        }

    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        limpiar_entradas();
        deshabilitar();
        ver_datos(1);

    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnreestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreestaurarActionPerformed
        limpiar_entradas();
        deshabilitar();
    }//GEN-LAST:event_btnreestaurarActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnreestaurar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> carrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> materia1;
    private javax.swing.JComboBox<String> materia2;
    private javax.swing.JComboBox<String> materia3;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JTextField txtapellido1;
    private javax.swing.JTextField txtapellido2;
    private javax.swing.JTextField txtcasa;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

}
