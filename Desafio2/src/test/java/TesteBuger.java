import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteBuger {
	
	private WebDriver driver;
	private final String urlBase = "https://buger-eats.vercel.app/";
	
	
	public static void main(String[] args) throws InterruptedException {
		CadastroPO po = new CadastroPO();
		
			
	
		po.TL001_NaoAbrirAPagDeCadastro();
		po.TL002_NomeVazio();
		po.TL003_CPFInvalido();
		po.TL004_CPFVazio();
		po.TL005_EmailInvalido();
		po.TL006_CepVazio();
		po.TL007_CepInvalido();
		po.TL008_numVazio();
		po.TL009_NenhumMetodo();
		po.TL010_MaisDeUmMetodo();
		po.TL011_CNHInvalida();
		po.TL012_CadastroSucesso();
		po.fechar();
		
	
	}
	
	
}