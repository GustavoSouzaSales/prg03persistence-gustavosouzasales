
package br.com.ifba.curso.view;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.controller.CursoController;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class CursoEditar extends javax.swing.JPanel {
    
    private final CursoController controller = new CursoController();
    
    private long idCurso;
    private CursoListar telaListar;
    private int linha; // índice da linha que será editada.
    private String nomeOriginal;
    private String codigoOriginal;
    
    public CursoEditar(CursoListar telaListar, Long idCurso, String nome, String codigo) {
    this.telaListar = telaListar;
    this.idCurso = idCurso;
    this.nomeOriginal = nome;
    this.codigoOriginal = codigo;
    initComponents();
    

    // preenche os campos com os dados atuais.
    txtCurso.setText(nome);
    txtCodigo.setText(codigo);
}
    public CursoEditar() {
        initComponents();
        
    }

    
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
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

    controller.atualizar(curso); // SE DER ERRO, CAI NO CATCH

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
