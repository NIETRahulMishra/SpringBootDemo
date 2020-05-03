package com.example.CurrencyConversionService;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		System.out.println("----Spring Boot Start-----");
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
		System.out.println("----Spring Boot End------");
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
		
	}
	
	/*
	 * @Bean public ResourceBundleMessageSource resourceBundleMessageSource() {
	 * ResourceBundleMessageSource resourceBundleMessageSource = new
	 * ResourceBundleMessageSource();
	 * resourceBundleMessageSource.setBasename("messages"); return
	 * resourceBundleMessageSource; }
	 */

}
