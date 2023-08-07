package com.ecommerce.alpha.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
/**
 * Reference : <a href="https://support.intershop.com/kb/index.php/Display/2914L4">...</a>
 */
@OpenAPIDefinition(
        info = @Info(
                description = "Awesome Resources",
                version = "V12.0.12",
                title = "Awesome Resource API",
                contact = @Contact(
                        name = "PRAVEEN MAURYA",
                        email = "praveen110195@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        )
//        servers = {@Server(url = "http://in28minutes.com")}
)
public interface ApiDocumentationConfig {

}