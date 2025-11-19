
package br.com.ifba.curso.view;

// imports necessários para salvar no banco.
import br.com.ifba.curso.entity.Curso;
import javax.swing.JOptionPane;
import br.com.ifba.curso.service.CursoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CursoAdicionar extends javax.swing.JPanel {

   private final CursoIService service;

    private CursoListar telaListar;

    @Autowired
    public CursoAdicionar(CursoIService service) {
        this.service = service;
        initComponents();
    }

    public void setTelaListar(CursoListar telaListar) {
        this.telaListar = telaListar;
    }

    public void limparCampos() {
        txtCurso.setText("");
        txtCurso1.setText("");
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCurso1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Criando Curso");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Insira o código do curso");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Insira o nome do curso");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Criar Curso");
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
                .addGap(181, 181, 181)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
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
                .addComponent(txtCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String nome = txtCurso.getText();
    String codigo = txtCurso1.getText();

    // vai verificar se os campos não estão vazios
    if (nome.isEmpty() || codigo.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Preencha todos os campos!", 
            "Erro", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        // Criar o objeto Curso
        Curso curso = new Curso(nome, codigo);

        // Chamar o service para salvar o curso
        service.salvar(curso); // Usamos o método  para persistir o curso

        // Exibir mensagem de sucesso
        javax.swing.JOptionPane.showMessageDialog(this, 
        "Curso \"" + nome + "\" adicionado com sucesso!");

        // Atualiza a tela principal com o novo curso
        telaListar.carregarCursos(); // Recarrega a tabela com os cursos atualizados

        // Fecha a janela de adicionar
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Erro ao salvar curso: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    

    }//GEN-LAST:event_jButton1ActionPerformed

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtCurso1;
    // End of variables declaration//GEN-END:variables

    void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
