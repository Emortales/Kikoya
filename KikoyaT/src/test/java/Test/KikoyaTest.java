package Test;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Funciones.Actualizar;
import Funciones.Funciones;
import Funciones.Login;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class KikoyaTest {

	
	String link="https://buggy.justtestit.org/overall";
	String driv="webdriver.chrome.driver";
	String ruta="C:\\Users\\Ernesto Morales\\eclipse-workspace\\KikoyaLogin\\drivers\\chromedriver98.0.4758.48.exe";
	
	Login login;
	Funciones funciones;
	Actualizar actualizar;
	
	WebDriver driver;
	
	
	@Before
	public void CargaInicial() {
		System.setProperty(driv,ruta);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);

		login = new Login(driver);
		funciones = new Funciones(driver);
		actualizar = new Actualizar(driver);

	}
	
	@Test
	public void registerUser() throws InterruptedException, IOException {
		login.RegistrarUsuario("Emorales", "Ernesto", "Morales", "User123456*", "User123456*");
		String fechahora=funciones.Fechahora();
		Screenshot Scremcotizar01 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(Scremcotizar01.getImage(), "PNG", new File("C:\\Users\\Ernesto Morales\\eclipse-workspace\\KikoyaLogin\\Screens\\Login\\"+fechahora+"  Registrar Usuario 1-2.png"));	
	}

	@Test
	public void Login() throws IOException, InterruptedException {
		login.IniciarSesion("Emorales", "User123456*");
		String fechahora=funciones.Fechahora();
		Screenshot Scremcotizar01 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		ImageIO.write(Scremcotizar01.getImage(), "PNG", new File("C:\\Users\\Ernesto Morales\\eclipse-workspace\\KikoyaLogin\\Screens\\Login\\"+fechahora+"  Login.png"));	
	}
	
	@Test
	public void ComentarAuto() throws IOException, InterruptedException {
		login.IniciarSesion("Emorales", "User123456*");
		actualizar.Comentar("Prueba Automatizada");
		String fechahora=funciones.Fechahora();
		TakesScreenshot miScreenDetalle = ((TakesScreenshot)driver);
		File destino = new File("C:\\Users\\Ernesto Morales\\eclipse-workspace\\KikoyaLogin\\Screens\\Actualizar\\"+fechahora+" Agregar Comentario.png");
		File archivo = miScreenDetalle.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archivo, destino);
}

}
