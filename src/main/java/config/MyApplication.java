package config;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(info = @Info(description = "Cálculos de Odds - Trader Esportivo", title = "Win milionário", version = "1.0.0-SNAPSHOT", contact = @Contact(name = "Gabriela Guedes", email = "gabidevenginner@gmail.com")))
public class MyApplication extends Application {
	
}
