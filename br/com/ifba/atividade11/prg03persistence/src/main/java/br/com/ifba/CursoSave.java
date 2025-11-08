/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba;
import br.com.ifba.curso.view.CursoAdicionar;
import br.com.ifba.curso.view.CursoEditar;
import br.com.ifba.curso.view.CursoListar;

/**
 *
 * @author gugsa
 */
public class CursoSave {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
        new CursoListar().setVisible(true);
    });
    }
}
