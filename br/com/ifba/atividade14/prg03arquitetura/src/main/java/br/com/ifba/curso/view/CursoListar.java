
package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoController;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;

public class CursoListar extends javax.swing.JFrame {
    
    private final CursoController controller = new CursoController();
    private TableRowSorter<DefaultTableModel> sorter;


    
    public CursoListar() {
        initComponents();
        
        // ajusta o tamanho da janela automaticamente.
        pack();

        // define comportamento ao fechar a janela.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // centraliza a janela na tela.
        setLocationRelativeTo(null);
        
        jTable1.getColumnModel().getColumn(2).setMinWidth(0);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(2).setWidth(0);
        carregarCursos();
        
        // configura o mecanismo de ordenação e filtragem da tabela.
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        // "document listener" para filtrar enquanto digita.
        txtProcurar.getDocument().addDocumentListener(new DocumentListener() {
        private void filtrar() {
        String texto = txtProcurar.getText();
        if (texto == null || texto.trim().isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }
        // escapa caracteres especiais para evitar erros na busca.
        String safe = Pattern.quote(texto);
        try {
            // mostra apenas cursos cujo nome começa com o texto digitado (sem diferenciar maiúsculas/minúsculas).
            sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + safe, 0));
        } catch (PatternSyntaxException ex) {
            // remove o filtro se ocorrer algum erro.
            sorter.setRowFilter(null);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) { filtrar(); }
    @Override
    public void removeUpdate(DocumentEvent e) { filtrar(); }
    @Override
    public void changedUpdate(DocumentEvent e) { filtrar(); }
});
        // carrega cursos do banco ao abrir.
        carregarCursos();
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProcurar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProcurar.setBackground(new java.awt.Color(255, 255, 255));
        txtProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcurarActionPerformed(evt);
            }
        });
        getContentPane().add(txtProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Código do Curso", "ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 490, 340));

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 90, -1));

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 50, 90, -1));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 90, -1));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProcurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProcurarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
    int linhaSelecionada = jTable1.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this,
            "Selecione um curso para excluir!",
            "Aviso",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    // pega o ID da coluna oculta.
    Long id = (Long) jTable1.getValueAt(linhaSelecionada, 2);


    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Excluir este curso?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        // busca o curso pelo ID.
        Curso curso = controller.buscarPorId(id);

        if (curso != null) {
            controller.deletar(curso);
            carregarCursos();
            JOptionPane.showMessageDialog(this, "Curso excluído!");
        } else {
            JOptionPane.showMessageDialog(this, "Curso não encontrado!");
        }
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
     int linhaSelecionada = jTable1.getSelectedRow();

    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Selecione um curso para editar!",
            "Aviso",
            javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int linha = jTable1.getSelectedRow();
    Long id = (Long) jTable1.getValueAt(linha, 2);
    // pega os dados da linha.
    String nome = jTable1.getValueAt(linhaSelecionada, 0).toString();
    String codigo = jTable1.getValueAt(linhaSelecionada, 1).toString();

    // cria a tela de edição e passa os dados e a referência desta tela.
    javax.swing.JFrame frame = new javax.swing.JFrame("Editar Curso");
    frame.setContentPane(new CursoEditar(this, id, nome, codigo));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // cria uma nova janela (JFrame).
    javax.swing.JFrame frame = new javax.swing.JFrame("Adicionar Curso");

    // adiciona o painel CursoAdicionar dentro dessa janela.
    frame.setContentPane(new CursoAdicionar(this));
    
    // ajusta o tamanho conforme o conteúdo.
    frame.pack();
    
    // centraliza a janela na tela.
    frame.setLocationRelativeTo(null);
    
    // mostra a janela.
    frame.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed
    
    // método público para recarregar a lista de cursos do banco.
    public void carregarCursos() {
    try {
        List<Curso> cursos = controller.listarTodos();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Curso c : cursos) {
            // adiciona ID como coluna oculta.
            model.addRow(new Object[]{c.getNome(), c.getCodigo(), c.getId()});
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Erro ao carregar cursos: " + e.getMessage());
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField txtProcurar;
    // End of variables declaration//GEN-END:variables

   }
