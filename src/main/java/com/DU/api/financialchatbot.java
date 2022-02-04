package com.DU.api;

import com.DU.api.service.AuthFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration

@OpenAPIDefinition(info = @Info(title = "DU Financial Chat-bot API", version = "1.0", description = "Leading financial institutions use our chatbots and voice-powered assistants that customers love to use"
        + "\n"
        + " We offer premium material from banking industry leaders. Learn how banking professionals are using conversational AI To improve customer experience using AI-enabled services, build robust, multi-domain dialog systems.The future of banking AI assistants", license = @License(name = "Tell:+250788498484 | +250789101080", url = "https://digitalumuganda.com/"), contact = @Contact(url = "https://digitalumuganda.com/", name = "Digital umuganda", email = "info@digitalumuganda.com")))

@SpringBootApplication

@EnableJpaAuditing
public class financialchatbot {
    public static void main(String[] args) {
        SpringApplication.run(financialchatbot.class, args);
    }

    @Configuration
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {

            registry.addMapping("/**").allowedOrigins("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                    .allowCredentials(true);

        }

    }

    @Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        AuthFilter authFilter = new AuthFilter();
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns(
                "/api/v1/staffs/*",
                "/api/v1/agents/*",
                "/api/v1/clients/*",
                "/api/v1/branches/*",
                "/api/v1/logs/*",
                "/api/v1/User/setrole/*",
                "/api/v1/User/logout");
        return registrationBean;
    }
}