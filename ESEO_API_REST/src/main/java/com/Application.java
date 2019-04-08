package com;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application 
{
	private static Logger logger = Logger.getLogger(Application.class.getName());
	
	private Application() {
	}
	
    public static void main( String[] args )
    {
        try {
        	SpringApplication.run(Application.class, args);
        	logger.log(Level.INFO, "Application demarrée");
        } catch (Exception e) {
        	logger.log(Level.WARN, "Échec lors du démarrage de l'Application", e);
        }
    }
}