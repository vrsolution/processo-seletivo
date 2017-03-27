package br.com.vagner.processo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * 
 * @author Vagner Rodrigues Souza
 *
 */

@Configuration 
@EnableAutoConfiguration 
@EnableSwagger //Habilita o Swagger
@ComponentScan(basePackages = {"br.com.vagner.processo"}) 
public class ProcessoSeletivoApplication {

    @Autowired
    private SpringSwaggerConfig swaggerConfig;
   

	public static void main(String[] args) {
		new SpringApplicationBuilder(ProcessoSeletivoApplication.class).web(true).run(args);
	}
	
    @Bean
    public SwaggerSpringMvcPlugin groupOnePlugin() {
       return new SwaggerSpringMvcPlugin(swaggerConfig)
            //Adiciona as configurações do Swagger ao SwaggerSpringMvcPlugin 
           .apiInfo(apiInfo()) //Adiciona as propriedades de configuração
           .includePatterns("/cep.*?", "/endereco.*?") //Habilita o Swagger para os nossos 2 endpoints
           .swaggerGroup("admin");
    }
     
    private ApiInfo apiInfo() {
       ApiInfo apiInfo = new ApiInfo( //Configurações de contato, licença etc não nescessáriamente precisa ser definida
             "Swagger With Spring Boot",
             "This is a simple application to demonstrate how to work with Swagger in Spring Boot project!",
             "Free to use and mess around",
             "developer71@gmail.com",
             "Open Licence",
             "developer71@gmail.com"
       );
       return apiInfo;
    }	
}
