package br.com.av1ntt;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class CenarioStep {
    String url;
    WebDriver webdriver;
    CenarioPage pagina;

    @Before
    public void iniciar() {

        url = "https://www.google.com.br";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jcabrals\\Desktop\\av1_ntt_data_1\\drivers\\chrome\\114.0.5735.90\\chromedriver.exe");
        ChromeOptions opc = new ChromeOptions();
        opc.addArguments("--incognito");
        webdriver = new ChromeDriver(opc);
        pagina = PageFactory.initElements(webdriver, CenarioPage.class);
    }

    @After
    public void terminar() {
        //webdriver.quit();

    }


    @Given("que tenha acessado o site da ntt")
    public void que_tenha_acessado_o_site_da_ntt() throws Throwable {

        webdriver.get(url);
        webdriver.manage().window().setSize(new Dimension(1300, 800));
        pagina.inserirPesquisa();


    }

    @When("clicar no menu job opportunities")
    public void clicar_no_menu_job_opportunities() throws Throwable {
        pagina.validaSiteNtt();
        pagina.acessaTelaCarreiras();
    }

    @And("buscar por pessoa engenheira de dados")
    public void buscar_por_pessoa_engenheira_de_dados() throws Throwable {
        pagina.pesquisaVaga();
    }

    @Then("o site retornara a busca conforme parametros inseridos")
    public void o_site_retornara_a_busca_conforme_parametros_inseridos() throws Throwable {
        pagina.validavaga();
    }
}
