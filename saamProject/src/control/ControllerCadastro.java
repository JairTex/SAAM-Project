/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;
import view.TelaCadastro;
import view.TelaPrincipal;

/**
 *
 * @author Steix
 */
public class ControllerCadastro extends AbstractTableModel {

    private List<Cliente> dados = new ArrayList<>();
    private String[] colunas ={"CPF", "Nome", "E-mail", "Peso", "Altura"};
    private final TelaCadastro view;
    
    public ControllerCadastro( TelaCadastro view){
        this.view = view;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getCpf();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getEmail();
            case 3:
                return dados.get(linha).getPeso();
            case 4:
                return dados.get(linha).getAltura();
        }
        return  null;
    }
    
    public void LigSaída2(){   
            this.view.dispose();
            TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
        }
    
    public void setValueAt(Object valor,int linha, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linha).setCpf(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNome((String) valor);
                break;
            case 2:
                dados.get(linha).setEmail((String) valor);
                break;
            case 3:
                dados.get(linha).setPeso(Float.parseFloat((String) valor));
                break;
            case 4:
                dados.get(linha).setAltura(Float.parseFloat((String) valor));
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public  void adicionarLinha(Cliente cliente){
        this.dados.add(cliente);
        this.fireTableDataChanged();
    }
    
    public void removerLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
