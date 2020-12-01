package com.corsanhub.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, SpringDataWebAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class, })
@EnableSwagger2
@EnableOpenApi
public class BaseApplication {

	private static Logger logger = LoggerFactory.getLogger(BaseApplication.class);

	@Value("${application.name}")
	private String applicationName;

	@Value("${application.version}")
	private String applicationVersion;

	private ApiInfo getApiInfo() {
		ApiInfo info = new ApiInfoBuilder().title("CORSAN " + applicationName + "	 API Info")
				.description("CORSAN " + applicationName + " API reference for developers").version(applicationVersion).build();
		return info;
	}

	@Bean
	public Docket api() {
		logger.info("Adding swagger support ...");
		Docket docket = new Docket(DocumentationType.OAS_30).groupName("public-api").apiInfo(getApiInfo()).select().paths(PathSelectors.any()).build();

		return docket;
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
		return threadPoolTaskScheduler;
	}

//	@Bean
//	public CommandLineRunner bootstrapData(BankAccountRepository repository) {
//		return (args) -> {
//			BigDecimal initialBalance = BigDecimal.valueOf(1000);
//			BankAccount bankAccount = new BankAccount(0L, initialBalance);
//			repository.save(bankAccount);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}

}
