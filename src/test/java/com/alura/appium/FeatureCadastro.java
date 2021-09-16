package com.alura.appium;

import static org.junit.Assert.assertTrue;

import com.alura.appium.PageObjects.CadastroPageObjects;
import com.alura.appium.PageObjects.LoginPageObjects;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class FeatureCadastro {

    @Test
    public void nao_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementos();
        CadastroPageObjects telaCadastro = telaLogin.IrparaTeladeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Renato", "123", "456");
        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObjects telaLogin = new LoginPageObjects(driver);
        telaLogin.BuscarElementos();
        CadastroPageObjects telaCadastro = telaLogin.IrparaTeladeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin=telaCadastro.Cadastrar("Renato", "123", "123");
        telaLogin.BuscarElementos();

    }
}