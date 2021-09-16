package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageObjects extends PageObjectsBase {

    private final By botaoCadastroID;
    private MobileElement botaoCadastro;

    public LoginPageObjects(AppiumDriver driver){
        super(driver);
        botaoCadastroID = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }
    @Override
    public void BuscarElementos(){
        botaoCadastro = (MobileElement) driver.findElement(botaoCadastroID);
    }

    public CadastroPageObjects IrparaTeladeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObjects(this.driver);
    }
}
