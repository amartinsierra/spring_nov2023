package com.buscador.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.buscador.controller")
public class WebConfig {
	//objetos de configuración de Thymeleaf
		@Autowired
		private ApplicationContext applicationContext;
		
		@Bean
		public SpringResourceTemplateResolver templateResolver(){
			SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
			templateResolver.setApplicationContext(this.applicationContext);
			templateResolver.setPrefix("/");
			templateResolver.setSuffix(".html");
			// HTML es la plantilla por defecto, se indica por claridad.
			templateResolver.setTemplateMode(TemplateMode.HTML);
			return templateResolver;
		}
		@Bean
		public SpringTemplateEngine templateEngine(){
			SpringTemplateEngine templateEngine = new SpringTemplateEngine();
			templateEngine.setTemplateResolver(templateResolver());
			templateEngine.setEnableSpringELCompiler(true);
			return templateEngine;
		}
		@Bean
		public ThymeleafViewResolver viewResolver(){
			ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
			viewResolver.setTemplateEngine(templateEngine());
			return viewResolver;
		}
}
