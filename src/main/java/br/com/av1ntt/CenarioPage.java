package br.com.av1ntt;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;


public class CenarioPage {
    WebDriver webdriver;

    @FindBy(xpath = "//img[@class='lnXdpd']")
    WebElement pgGoogle;

    @FindBy(id = "APjFqb")
    WebElement cmpPesquisaGoogle;

    @FindBy(xpath = "//*[@data-ved='0ahUKEwj73sSgnNX_AhWzkpUCHe58CLYQ4dUDCAk']")
    WebElement btnPesquisaGoogle;

    @FindBy(xpath = "//h3[contains(.,'NTT DATA: Global IT Services Provider & Consultant')]")
    WebElement lnkNttData;

    @FindBy(xpath = "//button[contains(.,'Aceitar')]")
    WebElement cookieSiteNtt;

    @FindBy(xpath = "//img[contains(@src,'https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/feature/emea/components/sections/logo-white.svg?hash=')]")
    WebElement pgNttData;

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    WebElement btnCareers;

    @FindBy(xpath = "//a[contains(text(),'Job opportunities')]")
    WebElement btnJobOpportunities;

    @FindBy(xpath = "//img[@alt='NTT DATA']")
    WebElement pgCareers;

    @FindBy(id = "sGlobal")
    WebElement cmpPesquisaVaga;

    @FindBy(xpath = "//button[contains(.,'Pesquisar')]")
    WebElement btnPesquisaVaga;

    @FindBy(xpath = "//a[contains(text(),'Pessoa Engenheira de Dados - Híbrido')]")
    WebElement bntVagaPessoaEngenheiraDeDados;


    public void inserirPesquisa() throws Throwable {
        validaElemento(pgGoogle, 1000);
        validaElemento(cmpPesquisaGoogle, 1000);
        setText(cmpPesquisaGoogle, "ntt data");
        setCommand(cmpPesquisaGoogle, Keys.ENTER);
    }

    public void validaSiteNtt() throws Throwable {
        validaElemento(lnkNttData, 2000);
        lnkNttData.click();
        Thread.sleep(5000);
        validaElemento(pgNttData, 1000);
    }

    public void acessaTelaCarreiras() throws Throwable {
        validaElemento(btnCareers, 3000);
        btnCareers.click();
        validaElemento(btnJobOpportunities, 2000);
        btnJobOpportunities.click();
        validaElemento(pgCareers, 3000);

    }

    public void pesquisaVaga() throws Throwable{
        validaElemento(cmpPesquisaVaga, 3000);
        cmpPesquisaVaga.click();
        setText(cmpPesquisaVaga, "PESSOA ENGENHEIRA DE DADOS");
        validaElemento(btnPesquisaVaga, 3000);
        btnPesquisaVaga.click();

    }

    public void validavaga() throws Throwable{
        validaElemento(bntVagaPessoaEngenheiraDeDados, 3000);
        bntVagaPessoaEngenheiraDeDados.click();
    }



    private void validaElemento(WebElement webElement, long secondsSleep) {
        try {
            if (webElement.isDisplayed() == true) {
                Thread.sleep(secondsSleep);
            } else {
                System.out.println("Caiu no ELSE");
                //webdriver.close();
            }
        } catch (Exception e) {
            System.out.println("Erro no método no validaLogo " + e);
        }
    }

    private void setText(WebElement webElement, String texto) {
        webElement.sendKeys(Keys.chord(texto));
    }

    private void setCommand(WebElement webElement, Keys key) {
        webElement.sendKeys(key);
    }

}
