
package br.com.ifba.curso.view;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class CursoEditar extends javax.swing.JPanel {
    
    private CursoIService service;

    
    private long idCurso;
    private CursoListar telaListar;
    private int linha; // índice da linha que será editada.
    private String nomeOriginal;
    private String codigoOriginal;
    
    public CursoEditar(CursoIService service, CursoListar telaListar, Long idCurso, String nome, String codigo) {
    this.service = service;
    this.telaListar = telaListar;
    this.idCurso = idCurso;
    this.nomeOriginal = nome;
    this.codigoOriginal = codigo;
    initComponents();
    

    // preenche os campos com os dados atuais.
    txtCurso.setText(nome);
    txtCodigo.setText(codigo);
}
    //public CursoEditar() {
      //  initComponents();
        
    //}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Editando Curso");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Insira o novo código do curso");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Insira o novo nome do curso");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Editar Curso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // botão pra confirmar a edição do curso.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
    String novoNome = txtCurso.getText();
    String novoCodigo = txtCodigo.getText();

    if (novoNome.isEmpty() || novoCodigo.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Preencha todos os campos!",
            "Erro",
            JOptionPane.ERROR_MESSAGE);
        return;
    }

    Curso curso = new Curso(novoNome, novoCodigo);
    curso.setId(idCurso);

    service.atualizar(curso); // SE DER ERRO, CAI NO CATCH

    JOptionPane.showMessageDialog(this, 
        "Curso \"" + novoNome + "\" atualizado com sucesso!");

    telaListar.carregarCursos();

    SwingUtilities.getWindowAncestor(this).dispose();

} catch (Exception e) {
    JOptionPane.showMessageDialog(this,
        e.getMessage(),   // <-- AQUI APARECE "Nome já existe" ou "Código já existe"
        "Erro",
        JOptionPane.ERROR_MESSAGE);
}



    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCurso;
    // End of variables declaration//GEN-END:variables
}
