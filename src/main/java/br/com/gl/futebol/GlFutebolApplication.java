package br.com.gl.futebol;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "" })
@EnableAutoConfiguration
public class GlFutebolApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GlFutebolApplication.class, args);
	}

	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(GlFutebolApplication.class);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
				servlet, "*.jsf");
		return servletRegistrationBean;
	}


	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION","true");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE","Development");
	}

}
