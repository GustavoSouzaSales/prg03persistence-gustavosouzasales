
package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoController;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import jakarta.annotation.PostConstruct;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CursoListar extends javax.swing.JFrame {
    
    

    private TableRowSorter<DefaultTableModel> sorter;
    // agora a tela recebe o Service por injeção via construtor
    @Autowired   
    private CursoIService service;
    
    @Autowired
    private CursoAdicionar telaAdicionar;
    
    @Autowired
    private ApplicationContext context;


    

   private List<Curso> listaCursos;

    
    public CursoListar() {
        initComponents();
        this.pack();                    // ajusta automaticamente
        this.setLocationRelativeTo(null); // centraliza
     }



    @PostConstruct
    public void init(){    
    

        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       


        // Carrega os cursos via Service 
        //carregarCursos();

        // configura sorter para a tabela 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
        
         SwingUtilities.invokeLater(() -> {
    jTable1.getColumnModel().getColumn(2).setMinWidth(0);
    jTable1.getColumnModel().getColumn(2).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(2).setWidth(0);
});

        // document listener para filtrar enquanto digita
        txtProcurar.getDocument().addDocumentListener(new DocumentListener() {

    private void filtrar() {
        String texto = txtProcurar.getText();
        if (texto == null || texto.trim().isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }

        String safe = Pattern.quote(texto);

        try {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + safe, 0));
        } catch (PatternSyntaxException ex) {
            sorter.setRowFilter(null);
        }
    } // ✅ AGORA A CHAVE ESTÁ FECHADA!

    @Override
    public void insertUpdate(DocumentEvent e) { filtrar(); }

    @Override
    public void removeUpdate(DocumentEvent e) { filtrar(); }

    @Override
    public void changedUpdate(DocumentEvent e) { filtrar(); }
});

        
       
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

        txtProcurar.setBackground(new java.awt.Color(255, 255, 255));
        txtProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcurarActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Código do Curso", "ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
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
        Curso curso = service.buscarPorId(id);

        if (curso != null) {
            service.deletar(curso);
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
    frame.setContentPane(new CursoEditar(service, this, id, nome, codigo));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
          CursoAdicionar telaAdicionar = context.getBean(CursoAdicionar.class);

    telaAdicionar.setTelaListar(this);

    JFrame frame = new JFrame("Adicionar Curso");
    frame.setContentPane(telaAdicionar);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
            
    }//GEN-LAST:event_btnAdicionarActionPerformed
    
    // método público para recarregar a lista de cursos do banco.
    public void carregarCursos() {
    try {
        List<Curso> cursos = service.listarTodos();

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
