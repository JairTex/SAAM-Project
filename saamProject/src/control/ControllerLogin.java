/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;
import model.Usuario;
import view.TelaLogin;
import view.TelaPrincipal;

/**
 *
 * @author jair
 */
public class ControllerLogin {

    private final TelaLogin view;

    public ControllerLogin(TelaLogin view){
        this.view = view;
    }

    public void autenticar(){
        Usuario adm = new Usuario("123", "12345678910", "adm", "adm@email");
        if (this.view.getjTextFieldUsuario().getText().equals(adm.getNome())&& this.view.getjPasswordFieldSenha().getText().equals(adm.getSenha()) ) {
            JOptionPane.showMessageDialog(null, "Acesso Confirmado!");            
            this.view.dispose();
            TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
        } 
        else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro no acesso!", JOptionPane.ERROR_MESSAGE);            
        }
    }

}
