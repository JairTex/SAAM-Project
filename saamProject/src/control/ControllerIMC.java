/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.TelaImc;
import view.TelaPrincipal;

   
/**
 *
 * @author anton
 */
public class ControllerIMC {
    String Peso, Altura; 
    float PesoA, AlturaA;
    float imc;
    
    private final TelaImc view;
    
    public ControllerIMC( TelaImc view){
        this.view = view;
    }

    public boolean getCheckEmpty(String Peso,String Altura){
        if(Peso.equals("")||Altura.equals("")||(Peso.equals("")&&Altura.equals(""))){
            return true;
        }else{
            this.Peso=Peso;
            this.Altura=Altura;
            return false;
        }
    }
    
    public boolean getCheckIsNum(){
        try{
            Float.parseFloat(Peso);
            Float.parseFloat(Altura);        
            setConvertir();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void LigSaída1(){            
            TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
                this.view.dispose();
        }
    
    public void setConvertir(){
        this.PesoA=Float.parseFloat(Peso);
        this.AlturaA=Float.parseFloat(Altura);
    }
    
    public float getIMC(){
        float imc;
        imc = PesoA/(AlturaA*AlturaA);
        this.imc = imc;
        return imc;
    }
    
    public String getStatus(){
        String Status = "";
        if(imc <= 18.4){
            Status = "Abaixo do peso.";
        }else if(imc>=18.5 && imc <= 24.9){
            Status = "Peso Saudável.";
        }else if(imc>=25 && imc <= 29.9){
            Status = "Sobrepeso.";
        }else if(imc>=30 && imc <= 34.9){
            Status = "Obesidade tipo 1.";
        }else if(imc>=35 && imc <= 39.9){
            Status = "Obesidade tipo 2.";
        }else if(imc>40){
            Status = "Obesidade tipo 3.";
        }
        return Status;
    }
    
    public String getTipo(){
        String Tipo = "";
        if(imc <= 18.4){
            Tipo = "Melhore sua alimentação!";
        }else if(imc>=18.5 && imc <= 24.9){
            Tipo = "Continue assim!";
        }else if(imc>=25 && imc <= 29.9){
            Tipo = "Pratique mais exercicíos!";
        }else if(imc>=30 && imc <= 34.9){
            Tipo = "Pratique mais exercícios!";
        }else if(imc>=35 && imc <= 39.9){
            Tipo = "Melhore sua alimentação!";
        }else if(imc>40){
            Tipo = "Consulte um nutricionista!";
        }
        return Tipo;
    }
}