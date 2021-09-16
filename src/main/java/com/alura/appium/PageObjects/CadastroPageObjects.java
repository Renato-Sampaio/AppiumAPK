package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObjects extends PageObjectsBase {


    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement MensagemErro;

    private final By erroId;
    private final By campoNomeID;
    private final By campoSenhaID;
    private final By campoConfirmarSenhaID;
    private final By botaoCadastrarID;



    protected CadastroPageObjects(AppiumDriver driver) {
        super(driver);
        erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeID = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaID = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenhaID = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarID = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos(){

        campoNome = (MobileElement) driver.findElement(campoNomeID);
        campoSenha = (MobileElement) driver.findElement(campoSenhaID);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmarSenhaID);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarID);
    }
    private void PreencherFormulario(String usuario,String senha, String confimacao){

        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confimacao);
    }
    public LoginPageObjects Cadastrar(String usuario,String senha, String confimacao){
        PreencherFormulario(usuario,senha,confimacao);
        botaoCadastrar.click();
        return new LoginPageObjects(driver);
    }

    public String MensagemErro(){

        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));
        MensagemErro = (MobileElement) driver.findElement(erroId);
        return MensagemErro.getText();
    }
}
