package br.com.xyinc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("br.com.xyinc"))            
	          .paths(PathSelectors.any())                          
	          .build()
	          .apiInfo(metaData());                                           
	    }
	 
	  private ApiInfo metaData() {
		    return new ApiInfoBuilder()
		        .title("API XY INC")
		        .description("\"Spring Boot REST API for Zup Innovation \"")
		        .version("1.0.0")
		        .license("licence")
		        .contact( new Contact("Leonardo Patrick", 
		        		"https://www.linkedin.com/in/leonardopatrickppinto/",
		        		"leonardop@itout.com.br"))
		        .licenseUrl("https://www.xy.inc/licenses/LICENSE-2.0\"")
		        .build();
		  }
}
