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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(info = @Info(title = "The Power of 1000 days Maternal health", version = "1.0", description = "this is the Maternal health system to support our mothers"
        + "\n"
        + " We offer premium health facilities . we are proud to see our Mothers Happy !!", license = @License(name = "Tell:+250788483455 | +250726203911", url = "  "), contact = @Contact(url = " ", name = " Maternal Health", email = "janvier.rutagengwa@gmail.com")))

@SpringBootApplication

@EnableJpaAuditing
public class MaternalHealth {

    public static void main(String[] args) {
        SpringApplication.run(MaternalHealth.class, args);

    }

    @Configuration
    public class CorsConfig implements WebMvcConfigurer {

        // @Override
        // public void addCorsMappings(CorsRegistry registry) {

        // registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST",
        // "PUT", "DELETE", "HEAD");

        // }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOrigins("*");
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
                // "/api/v1/agents/location/*",
                "/api/v1/clients/*",
                // "/api/v1/branches/",
                "/api/v1/logs/*",
                "/api/v1/User/setrole/*",
                "/api/v1/User/logout",
                "/api/v1/Baby/*",
                "/api/v1/mothers/*",
                "/api/v1/hospital/*",
                "/api/v1/HealthAdvisor/*",
                "/api/v1/department/*",
                "/api/v1/DoctorAdvise/*",
                "/api/v1/HealthTips/update/*",
                "/api/v1/HealthTips/add",
                "/api/v1/HealthTips/delete/*",
                "/api/v1/Consultation/*",
                "/api/v1/Rendez-VOus/*",
                "/api/v1/messages/*");
        return registrationBean;
    }
}