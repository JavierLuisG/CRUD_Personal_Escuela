package ventana;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Personal extends javax.swing.JFrame {

    // variables para conexion a la db
    public String driver = "com.mysql.cj.jdbc.Driver"; // se optiene con la libreria mysql-connector
    public String username = "root"; // normalmente es root
    public String password = ""; // clave configurada en su db (ingresela si tiene)
    public String hostname = "localhost"; // normalmente es localhost o 127.0.0.1
    public String port = "3306"; // normalmente es 3306
    public String database = "crud_escuela"; // Esta es la db configurada para este CRUD
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet rs;
    
    String id;
    String buscar_identificacion;
    String identificacion;
    String nombre;
    String email;
    String direccion;
    String celular;
    String fecha_ingreso;
    String genero;
    // generar los valores del JComboBox
    String[] generoArray = {"", "Masculino", "Femenino"};
    DefaultComboBoxModel model = new DefaultComboBoxModel(generoArray);

    public Personal() {
        initComponents();
        // Permite localizar en el centro de la pantalla
        setLocationRelativeTo(null);
        // No permite modificar el tamaño
        setResizable(false);
        // No necesitamos la visibilidad de la cajaId
        cajaId.setVisible(false);
        // titulo de la ventana
        setTitle("Personal de la escuela");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cajaBuscar = new javax.swing.JTextField();
        cajaId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cajaIdentificacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cajaEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cajaDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cajaCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cajaIngreso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 100, 30));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ingrese No. Identificación");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 15, 146, -1));

        cajaBuscar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 33, 146, 24));

        cajaId.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 78, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Número Identificación:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 24));

        cajaIdentificacion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 230, 24));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nombre y apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 136, -1, 24));

        cajaNombre.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 136, 230, 24));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Correo electrónico:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 172, -1, 24));

        cajaEmail.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 172, 230, 24));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Dirección:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 208, -1, 24));

        cajaDireccion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 208, 230, 24));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Celular:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 160, 24));

        cajaCelular.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 158, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fecha ingreso:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 170, 24));

        cajaIngreso.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jPanel1.add(cajaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 172, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Genero:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 68, 24));

        comboGenero.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        comboGenero.setModel(model);
        jPanel1.add(comboGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 180, -1));

        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 100, 30));

        btnActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 100, 30));

        btnBorrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 100, 30));

        btnLimpiar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        conn = getConnection();
        String query = "DELETE FROM personal WHERE idPersonal = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            id = cajaId.getText();
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            limpiar();
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar, " + ex);
        }        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        conn = getConnection();
        String query = "UPDATE personal SET numero_identificacion = ?,nombre = ?,email = ?,direccion = ?,"
                + "celular = ?,fecha_ingreso = ?,genero = ? WHERE idPersonal = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            // obtener los valores de las cajas
            id = cajaId.getText();
            identificacion = String.valueOf(cajaIdentificacion.getText());
            nombre = String.valueOf(cajaNombre.getText());
            email = String.valueOf(cajaEmail.getText());
            direccion = String.valueOf(cajaDireccion.getText());
            celular = String.valueOf(cajaCelular.getText());
            fecha_ingreso = String.valueOf(cajaIngreso.getText());
            genero = String.valueOf(comboGenero.getSelectedItem());
            // pasar los valores al query correspondiente
            preparedStatement.setString(1, identificacion);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, direccion);
            preparedStatement.setString(5, celular);
            // @validacionIngresoFecha si el usuario no ingresa una fecha, por Default se pondra la fecha actual
            preparedStatement.setString(6, validacionIngresoFecha(fecha_ingreso));
            preparedStatement.setString(7, genero);
            preparedStatement.setString(8, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
            conn.close();            
        } catch (SQLException ex) {
            System.err.println("Error en actualización, " + ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        conn = getConnection();
        String query = "INSERT INTO personal (numero_identificacion,nombre,email,direccion,celular,fecha_ingreso,genero)"
                + " value (?,?,?,?,?,?,?)";
        try {
            preparedStatement = conn.prepareStatement(query);
            // obtener los valores ingresados por el usuario en cada caja de texto
            identificacion = cajaIdentificacion.getText();
            nombre = cajaNombre.getText();
            email = cajaEmail.getText();
            direccion = cajaDireccion.getText();
            celular = cajaCelular.getText();
            fecha_ingreso = cajaIngreso.getText();
            genero = String.valueOf(comboGenero.getSelectedItem());
            // mandar los valores a la db
            preparedStatement.setString(1, identificacion);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, direccion);
            preparedStatement.setString(5, celular);
            // @validacionIngresoFecha si el usuario no ingresa una fecha, por Default se pondra la fecha actual
            preparedStatement.setString(6, validacionIngresoFecha(fecha_ingreso));
            preparedStatement.setString(7, genero);
            // para que se ejecute la modificación
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Error en registrar, " + ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        conn = getConnection();
        String query = "SELECT * FROM personal where numero_identificacion = ?";
        // se verifica si se ha ingresado un valor en la cajaBuscar
        if (!cajaBuscar.getText().trim().isEmpty()) {
            try {
                // obtener el valor del No identificacion ingresado por el usuario 
                buscar_identificacion = cajaBuscar.getText().trim(); // (.trim() quita los espacios antes y despues)
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, buscar_identificacion); // pasa el valor al parametro ? de la query
                rs = preparedStatement.executeQuery();
                // se establece un if para saber si es o no una identificación registrada
                if (rs.next()) { // como el valor ha encontrar es Unique, el if es apropiado
                    // obtener los valores que se encuentran en la db
                    identificacion = String.valueOf(rs.getString("numero_identificacion"));
                    nombre = String.valueOf(rs.getString("nombre"));
                    email = String.valueOf(rs.getString("email"));
                    direccion = String.valueOf(rs.getString("direccion"));
                    celular = String.valueOf(rs.getString("celular"));
                    fecha_ingreso = String.valueOf(rs.getDate("fecha_ingreso"));
                    genero = rs.getString("genero");
                    // obtener el valor del id para generar actualización
                    cajaId.setText(String.valueOf(rs.getInt("idPersonal")));
                    // teniendo el valor en las variables ahora los envio a las cajas
                    cajaIdentificacion.setText(identificacion);
                    cajaNombre.setText(nombre);
                    cajaEmail.setText(email);
                    cajaDireccion.setText(direccion);
                    cajaCelular.setText(celular);
                    cajaIngreso.setText(fecha_ingreso);
                    comboGenero.setSelectedItem(genero); // el valor en la db debe ser igual que en el comboGenero (tener en cuenta las mayusculas y minusculas
                    JOptionPane.showMessageDialog(null, "Consulta exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "No. Identificación no registrado");
                    // si no está registrado el valor ingresado pasa a la cajaIdentificacion para que pueda realizar el registro
                    limpiar();
                    cajaIdentificacion.setText(buscar_identificacion);
                }
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al realizar la consulta");
                System.err.println("Error al realizar consulta, " + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar No. Identificación para realizar consulta");
            limpiar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    // metodo para la conexion a la db
    public Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error en la conexión, " + ex);
        }
        return conexion;
    }

    public void limpiar() {
        cajaBuscar.setText("");
        cajaId.setText("");
        cajaIdentificacion.setText("");
        cajaNombre.setText("");
        cajaEmail.setText("");
        cajaDireccion.setText("");
        cajaCelular.setText("");
        cajaIngreso.setText("");
        comboGenero.setSelectedItem("");
    }
    
    private static String validacionIngresoFecha(String fecha_ingreso) {
        // si el usuario no ingresa una fecha, por Default se pondra la fecha actual
        if (fecha_ingreso.isEmpty()) {
            return obtenerFechaActual();
        } else {
            return fecha_ingreso;
        }
    }
    
    private static String obtenerFechaActual() {
        // Método para obtener la fecha actual en formato "yyyy-MM-dd"
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaActual.format(formatter);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Personal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaCelular;
    private javax.swing.JTextField cajaDireccion;
    private javax.swing.JTextField cajaEmail;
    private javax.swing.JTextField cajaId;
    private javax.swing.JTextField cajaIdentificacion;
    private javax.swing.JTextField cajaIngreso;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
