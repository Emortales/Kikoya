package Funciones;

import java.time.LocalDate;
import java.time.LocalTime;
import org.openqa.selenium.WebDriver;

public class Funciones {

 WebDriver driver;
	
	public Funciones(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String Fechahora () {
		LocalDate fechaactual = LocalDate.now();
		LocalTime horaactual = LocalTime.now();
		String H =horaactual+"";
		String F =fechaactual+"";	
		String hora="";
		for (int x=0; x<8; x++) {
          if (x==2||x==5) {
        	  hora = hora +".";
          }else 
        	  hora = hora + H.charAt(x);   
            }
		
		String fecha="";
		for (int x=2; x<10; x++) {
            fecha = fecha + F.charAt(x); 
            }
		String FechaHora = ""+fecha+" "+hora;
		return FechaHora;
	}
	
	
	
	
}
