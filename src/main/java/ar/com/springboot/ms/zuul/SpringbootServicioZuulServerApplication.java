package ar.com.springboot.ms.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

@Configuration // Para crear las configuraciones
@EnableEurekaClient // Para que sea Cliente de Eureka y pueda registrarse en el server
@EnableZuulProxy // Para definir que sea Getway Zuul y actue como Proxy
@SpringBootApplication
public class SpringbootServicioZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioZuulServerApplication.class, args);
	}

}
