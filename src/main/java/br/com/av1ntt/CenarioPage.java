package br.com.av1ntt;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class CenarioPage {
    WebDriver webDriver;

    @FindBy(xpath = "//img[@class='lnXdpd']")
    WebElement pgGoogle;

    @FindBy(id = "APjFqb")
    WebElement cmpPesquisaGoogle;

    @FindBy(xpath = "//h3[contains(.,'NTT DATA: Global IT Services Provider & Consultant')]")
    WebElement lnkNttData;

    @FindBy(xpath = "//img[contains(@src,'https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/feature/emea/components/sections/logo-white.svg?hash=')]")
    WebElement pgNttData;

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    WebElement btnCareers;

    @FindBy(xpath = "//a[contains(text(),'Job opportunities')]")
    WebElement btnJobOpportunities;

    @FindBy(xpath = "//img[@alt='NTT DATA']")
    WebElement pgCarreiras;

    @FindBy(id = "sGlobal")
    WebElement cmpPesquisaVaga;

    @FindBy(xpath = "//button[contains(.,'Pesquisar')]")
    WebElement btnPesquisaVaga;

    @FindBy(xpath = "//a[contains(text(),'Pessoa Engenheira de Dados - Híbrido')]")
    WebElement bntVagaPessoaEngenheiraDeDados;

    @FindBy(id = "ifrmCookieBanner")
    WebElement frameCookiePgInicial;

    @FindBy(xpath = "//div[@id='grouped-pageload-Banner']/div/div/div/div[3]/button[2]")
    WebElement btnAccCookie;

    public CenarioPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inserirPesquisa() throws Throwable {
        validaElemento(pgGoogle, 2);
        validaElemento(cmpPesquisaGoogle, 2);
        setText(cmpPesquisaGoogle, "ntt data");
        setCommand(cmpPesquisaGoogle, Keys.ENTER);
    }

    public void validaSiteNtt() throws Throwable {
        click(lnkNttData);
        aguarda(3);
        aceitaCookie(frameCookiePgInicial, btnAccCookie);
        validaElemento(pgNttData, 2);
    }

    public void acessaTelaCarreiras() throws Throwable {

        validaElemento(btnCareers, 3);
        click(btnCareers);
        click(btnJobOpportunities);
        aguarda(2);
        List<String> abas = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(abas.get(1));
        aceitaCookie(frameCookiePgInicial, btnAccCookie);
        validaElemento(pgCarreiras, 2);

    }

    public void pesquisaVaga() throws Throwable {
        aguarda(4);
        setText(cmpPesquisaVaga, "PESSOA ENGENHEIRA DE DADOS");
        click(btnPesquisaVaga);
    }

    public void validavaga() throws Throwable {
        validaElemento(bntVagaPessoaEngenheiraDeDados, 5);
        new Actions(webDriver)
                .scrollToElement(bntVagaPessoaEngenheiraDeDados)
                .perform();
        click(bntVagaPessoaEngenheiraDeDados);
    }

    private void aceitaCookie(WebElement frame, WebElement botao) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
            click(botao);
            webDriver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("O FRAME NÃO APARECEU!");
        }
    }

    private void validaElemento(WebElement webElement, long secondsSleep) {
        try {
            if (webElement.isDisplayed()) {
                Thread.sleep(Duration.ofSeconds(secondsSleep));
            } else {
                System.out.println("Caiu no ELSE");
                //webdriver.close();
            }
        } catch (Exception e) {
            System.out.println("Erro no método no validaLogo " + e);
        }
    }

    private void click(WebElement webElement) {
        try {
            WebElement wait = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(webElement));
            if (webElement.isDisplayed() || webElement.isEnabled())
                wait.click();
        } catch (Exception e) {
            System.out.println("Não foi possível clicar no elemento " + e);
        }
    }
     private void aguarda(long tempo) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(tempo));
    }

    private void setText(WebElement webElement, String texto) {
        webElement.sendKeys(Keys.chord(texto));
    }

    private void setCommand(WebElement webElement, Keys key) {
        webElement.sendKeys(key);
    }

}
