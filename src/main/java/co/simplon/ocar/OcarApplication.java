package co.simplon.ocar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OcarApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcarApplication.class, args);
    }

//    @Bean
//    public Docket offersApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("co.simplon.ocar.controller"))
//                .paths(PathSelectors.ant("/api/offers"))
//                .build();
//    }

//    @Bean
//    public Docket offersFilterApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("offersFilter")
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.ant("/api/offers/filter"))
//                .build();
//    }

}

//.paths(PathSelectors.any())
