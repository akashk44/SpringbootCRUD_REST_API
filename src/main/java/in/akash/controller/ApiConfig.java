package in.akash.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee Management API",
                version = "V1.0",
                description = "API for managing employee records, including CRUD operations",
                license = @License(
                        name = "Akashk",
                        url = "https://localhost/home"
                )

        ), servers = {@Server(description = "http://localhost:8080/api")
        ,@Server(description = "http://localhost:8080/api/v2") }

)
public class ApiConfig {
}
