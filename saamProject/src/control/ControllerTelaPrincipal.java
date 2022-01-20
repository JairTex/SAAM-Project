/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;
import view.TelaCadastro;
import view.TelaImc;
import view.TelaLogin;
import view.TelaPrincipal;

/**
 *
 * @author Steix
 */
public class ControllerTelaPrincipal {

    private final TelaPrincipal view;
    
    public ControllerTelaPrincipal( TelaPrincipal view){
        this.view = view;
    }
    
     public void Lig1(){            
            this.view.dispose();
            TelaCadastro telacadastro = new TelaCadastro();
                telacadastro.setVisible(true);
        }
     
     public void Lig2(){        
            this.view.dispose();
            TelaImc telaImc = new TelaImc();
                telaImc.setVisible(true);
        }
 
     public void LigSaída(){    
                this.view.dispose();
                TelaPrincipal telaSair = new TelaPrincipal();
                telaSair.setVisible(false);
        }
    
    public void adicionar(){
        if (this.view.getOcupacao() < this.view.getCapacidade()) {
            this.view.setOcupacao(this.view.getOcupacao() + 1);
            this.view.setVagas(this.view.getCapacidade() - this.view.getOcupacao());
            this.view.getjTextFieldOcupacao().setText(String.valueOf(this.view.getOcupacao()));
            this.view.getjTextFieldCapacidade().setText(String.valueOf(this.view.getCapacidade()));
            this.view.getjTextFieldVagas().setText(String.valueOf(this.view.getVagas()));
        } else {
            JOptionPane.showMessageDialog(null, "Ocupação limite atingida!", "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    public void remover(){
        if (this.view.getOcupacao() > 0) {
            this.view.setOcupacao(this.view.getOcupacao() - 1);
            this.view.setVagas(this.view.getCapacidade() - this.view.getOcupacao());
            this.view.getjTextFieldOcupacao().setText(String.valueOf(this.view.getOcupacao()));
            this.view.getjTextFieldCapacidade().setText(String.valueOf(this.view.getCapacidade()));
            this.view.getjTextFieldVagas().setText(String.valueOf(this.view.getVagas()));
        } else {
            JOptionPane.showMessageDialog(null, "O local já está vazio!", "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
}
