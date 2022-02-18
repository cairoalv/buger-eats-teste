import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CadastroPO {

	WebDriver driver = new ChromeDriver();

	public void abrirNavegador() {

		driver.manage().window().maximize();
		driver.get("https://buger-eats.vercel.app/");
	}

	public void clicarNoBotao() throws InterruptedException {

		WebElement btnCadastro = driver
				.findElement(By.xpath("//a[@href='/deliver'][contains(.,'Cadastre-se para fazer entregas')]"));
		btnCadastro.click();

	}

	public void preencherNome(String nome) throws InterruptedException {

		WebElement campoNome = driver.findElement(By.xpath("//input[@name='name']"));
		campoNome.click();
		campoNome.sendKeys(nome);

	}

	public void preencherCPF(String cpf) throws InterruptedException {

		WebElement campoCPF = driver.findElement(By.xpath("//input[@name='cpf']"));
		campoCPF.click();
		campoCPF.sendKeys(cpf);
	}

	public void preencherEmail(String email) throws InterruptedException {

		WebElement campoEmail = driver.findElement(By.xpath("//input[@name='email']"));
		campoEmail.click();
		campoEmail.sendKeys(email);
	}

	public void preencherWhats(String whats) throws InterruptedException {

		WebElement campoWhats = driver.findElement(By.xpath("//input[@name='whatsapp']"));
		campoWhats.click();
		campoWhats.sendKeys(whats);
	}

	public void preencherCep(String cep) throws InterruptedException {

		WebElement campoCep = driver.findElement(By.xpath("//input[@name='postalcode']"));
		campoCep.click();
		campoCep.sendKeys(cep);
	}

	public void clicarBtnCep() throws InterruptedException {

		WebElement btnCep = driver.findElement(By.xpath("//input[contains(@value,'Buscar CEP')]"));
		btnCep.click();
	}

	public void preencherNumCasa(String casa) throws InterruptedException {

		WebElement campoNumCasa = driver.findElement(By.xpath("//input[@name='address-number']"));
		campoNumCasa.click();
		campoNumCasa.sendKeys(casa);
	}

	public void clicarBtnMoto() throws InterruptedException {

		WebElement btnMoto = driver.findElement(By.xpath("//img[contains(@alt,'Moto')]"));
		btnMoto.click();
	}

	public void clicarBtnBike() throws InterruptedException {

		WebElement btnBike = driver.findElement(By.xpath("//img[contains(@alt,'Bicicleta')]"));
		btnBike.click();
	}

	public void clicarBtnCarro() throws InterruptedException {

		WebElement btnCarro = driver.findElement(By.xpath("//img[contains(@alt,'Van/Carro')]"));
		btnCarro.click();
	}

	public void fotoCNH() throws InterruptedException {

		WebElement abrirFotoCNH = driver.findElement(By.xpath("//input[@type='file']"));
		abrirFotoCNH.sendKeys("D:\\logoGit.png");
	}

	public void clicarBtnFinalizar() throws InterruptedException {

		WebElement btnFinalizar = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
		btnFinalizar.click();
	}

	public void scrollUP() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public void scrollDOWN() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	public void fechar() {
		driver.close();
	}

	@Test
	public void TL001_NaoAbrirAPagDeCadastro() {
		abrirNavegador();
		WebElement button = driver.findElement(By.xpath("//div[contains(@class,'content')]"));
		button.click();
		System.out.println("O Caso de teste 001 Passou!");
	}

	@Test
	public void TL002_NomeVazio() throws InterruptedException {
		String msgEsperada = "É necessário informar o nome";
		abrirNavegador();
		clicarNoBotao();
		preencherNome("");
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'É necessário informar o nome')]"));
		String msgRecebida = msgErro.getText();
		scrollUP();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 002 Passou!");

	}

	@Test
	public void TL003_CPFInvalido() throws InterruptedException {
		String msgEsperada = "Oops! CPF inválido";
		abrirNavegador();
		clicarNoBotao();
		preencherCPF("123");
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'Oops! CPF inválido')]"));
		String msgRecebida = msgErro.getText();
		scrollUP();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 003 Passou!");

	}

	@Test
	public void TL004_CPFVazio() throws InterruptedException {
		String msgEsperada = "É necessário informar o CPF";
		abrirNavegador();
		clicarNoBotao();
		preencherCPF("");
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'É necessário informar o CPF')]"));
		String msgRecebida = msgErro.getText();
		scrollUP();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 004 Passou!");

	}

	@Test
	public void TL005_EmailInvalido() throws InterruptedException {
		String msgEsperada = "É necessário informar o email";
		abrirNavegador();
		clicarNoBotao();
		preencherEmail("");
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'É necessário informar o email')]"));
		String msgRecebida = msgErro.getText();
		scrollUP();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 005 Passou!");

	}

	@Test
	public void TL006_CepVazio() throws InterruptedException {
		String msgEsperada = "É necessário informar o CEP";
		abrirNavegador();
		clicarNoBotao();
		preencherCep("");
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'É necessário informar o CEP')]"));
		String msgRecebida = msgErro.getText();
		scrollUP();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 006 Passou!");

	}
	
	@Test
	public void TL007_CepInvalido() throws InterruptedException {
		String msgEsperada = "Informe um CEP válido";
		abrirNavegador();
		clicarNoBotao();
		preencherCep("123");
		clicarBtnCep();
		Thread.sleep(3000);
		WebElement msgErro = driver.findElement(By.xpath("//span[@class='alert-error'][contains(.,'Informe um CEP válido')]"));
		String msgRecebida = msgErro.getText();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 007 Passou!");

	}

	@Test
	public void TL008_numVazio() throws InterruptedException {
		String msgEsperada = "É necessário informar o número do endereço";
		abrirNavegador();
		clicarNoBotao();
		preencherNumCasa("");
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'É necessário informar o número do endereço')]"));
		String msgRecebida = msgErro.getText();
		scrollUP();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 008 Passou!");

	}

	@Test
	public void TL009_NenhumMetodo() throws InterruptedException {
		String msgEsperada = "Selecione o método de entrega";
		abrirNavegador();
		clicarNoBotao();
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'Selecione o método de entrega')]"));
		String msgRecebida = msgErro.getText();
		scrollDOWN();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 009 Passou!");

	}

	@Test
	public void TL010_MaisDeUmMetodo() throws InterruptedException {
		String msgEsperada = "Oops! Selecione apenas um método de entrega";
		abrirNavegador();
		clicarNoBotao();
		clicarBtnMoto();
		clicarBtnCarro();
		clicarBtnBike();
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'Oops! Selecione apenas um método de entrega')]"));
		String msgRecebida = msgErro.getText();
		scrollDOWN();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 010 Passou!");

	}

	@Test
	public void TL011_CNHInvalida() throws InterruptedException {
		String msgEsperada = "Adicione uma foto da sua CNH";
		abrirNavegador();
		clicarNoBotao();
		clicarBtnFinalizar();
		WebElement msgErro = driver.findElement(By.xpath("//span[contains(.,'Adicione uma foto da sua CNH')]"));
		String msgRecebida = msgErro.getText();
		scrollDOWN();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 011 Passou!");

	}

	@Test
	public void TL012_CadastroSucesso() throws InterruptedException {
		String msgEsperada = "Aí Sim...";
		abrirNavegador();
		clicarNoBotao();
		preencherNome("Joao Maria Pereira");
		preencherCPF("98313287620");
		preencherEmail("joao.maria@gmail.com");
		preencherWhats("62987395642");
		scrollDOWN();
		preencherCep("72017392");
		clicarBtnCep();
		Thread.sleep(3000);
		preencherNumCasa("2");
		clicarBtnMoto();
		fotoCNH();
		clicarBtnFinalizar();
		Thread.sleep(3000);
		WebElement msgSucesso = driver.findElement(By.xpath("//h2[contains(.,'Aí Sim...')]"));
		String msgRecebida = msgSucesso.getText();
		assertEquals(msgEsperada, msgRecebida);
		System.out.println("O Caso de teste 012 Passou!");
		

	}
}
