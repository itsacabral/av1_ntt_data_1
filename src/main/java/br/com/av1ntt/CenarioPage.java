package br.com.av1ntt;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CenarioPage {
    WebDriver webdriver;

    @FindBy(xpath = "//img[@class='lnXdpd']")
    WebElement pgGoogle;

    @FindBy(id = "//textarea[@id='APjFqb']")
    WebElement cmpPesquisaGoogle;

    @FindBy(xpath = "//*[@data-ved='0ahUKEwj73sSgnNX_AhWzkpUCHe58CLYQ4dUDCAk']")
    WebElement btnPesquisaGoogle;

    @FindBy(xpath = "//h3[contains(.,'NTT DATA: Global IT Services Provider & Consultant')]")
    WebElement lnkNttData;

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

    public void telaDoGoogle() throws Throwable {
        validaElemento(pgGoogle, 3000);
    }

    public void inserirPesquisa() throws Throwable {
        validaElemento(cmpPesquisaGoogle, 10000);
        cmpPesquisaGoogle.sendKeys(Keys.chord("ntt data brasil"));
    }

    public void clicarNoBotaoDePesquisa() throws Throwable {
        btnPesquisaGoogle.isDisplayed();
        btnPesquisaGoogle.click();
    }

    public void validaLinkNtt() throws Throwable {
        lnkNttData.isDisplayed();
        lnkNttData.click();
    }

    public void telaDaNttDataBrasil() throws Throwable {
        pgNttData.isDisplayed();
        pgNttData.wait(5000);
    }

    public void botaoCarreiras() throws Throwable {
        btnCareers.isDisplayed();
        btnCareers.click();
    }


    private void validaElemento(WebElement webElement, long secondsSleep) {
        try {
            if (webElement.isDisplayed() == true) {
                Thread.sleep(secondsSleep);
            } else {
                System.out.println("Caiu no ELSE");
                webdriver.close();
            }
        } catch (Exception e) {
            System.out.println("Erro no método no validaLogo " + e);
        }

    }

}
