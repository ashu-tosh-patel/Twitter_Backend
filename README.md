Twitter-like Microservices Platform

Project summary
• Modular Spring Boot microservices project that simulates core Twitter features (user management, tweets, media, follow system, search/discovery) with an API gateway and optional service discovery.

Repository layout (top-level modules)
• user — User management service (registration, authentication, profile, user DTOs).
• tweet — Tweet service (create/read tweets, retweets, tweet DTOs).
• media — Media handling service (media uploads/links for tweets).
• followingAndFollower — Follow/unfollow and follower lists.
• seachAndDIscovery — Search and discovery functionality.
• gateway — API Gateway to centralize routing and client access.
• pom.xml (parent) — Maven multi-module parent for building modules together.

Tech stack
• Language: Java 17+ (or configured JDK in pom files)
• Frameworks: Spring Boot, Spring WebFlux (WebClient), Spring MVC, Spring Data JPA
• Database: MySQL (per-service configuration in application.yml)
• Build: Maven (multi-module)
• Service discovery (optional): Consul (configurable via application.yml)
• Reactive: Project Reactor (used by WebFlux)

Key features
• RESTful APIs for user, tweet, media and social graph operations.
• Reactive inter-service communication using WebClient and ParameterizedTypeReference for typed lists.
• DTO layer + Jakarta Validation to enforce API contracts and input validation.
• Centralized API gateway for routing and decoupling of clients from services.
• Maven multi-module layout for independent service packaging and coordinated builds.
• Configurable service discovery (Consul) with optional hardcoded endpoints for local development.
• Structured logging and error handling for easier debugging and resilience.

Prerequisites
• Java JDK 17 or later installed
• Maven 3.6+ installed
• MySQL server (update JDBC URLs / credentials in each service's application.yml)
• (Optional) Consul agent running on localhost:8500 if service discovery is enabled

Configuration
• Each module contains an application.yml (or application.properties) under src/main/resources.
• Update DB credentials and server.port per service as needed.
• To use Consul discovery, set spring.cloud.consul.enabled=true and discovery settings in application.yml for respective services and run a Consul agent.
• For local development without Consul, ensure services call hardcoded URLs (http://localhost:PORT/...) or configure the gateway routing accordingly.

Common workflows — build and run
1) Build all modules:
   mvn clean install

2) Run individual services (example):
   cd user
   mvn spring-boot:run
   (repeat for tweet, media, followingAndFollower, seachAndDIscovery, gateway)

3) Typical default ports (check each service application.yml):
   • user       : 8081 (example — verify in application.yml)
   • tweet      : 8080
   • media      : 8082
   • following  : 8083
   • search     : 8084
   • gateway    : 8085
   Adjust ports in application.yml to avoid conflicts.

Notes about WebClient and service discovery
• This project supports two approaches to inter-service calls:
   1) Hardcoded URLs: call services using http://localhost:{port}/path — simple for local testing.
   2) Service discovery (Consul): call using service name and a load-balancer-enabled WebClient (e.g. http://SERVICE_NAME/...), requires Consul registration and Spring Cloud load balancer.

• Troubleshooting common WebClient/Discovery issues:
   - "LoadBalancer does not contain an instance for the service <name>": ensure the target service is registered with Consul and check serviceName in application.yml.
   - "Connection refused: localhost:[port]": verify the target service is running on the expected port and no firewall/permission issues exist.
   - If Consul is not used, prefer hardcoded URLs or configure Ribbon/Spring Cloud LoadBalancer correctly.

Best practices and extension points
• Keep DTOs and entity models separate to avoid accidental database exposure.
• Add resilience patterns (resilience4j retries, circuit breakers) around WebClient calls for better fault tolerance.
• Add integration tests for inter-service contracts (e.g., using Testcontainers for dependent services and DB).
• Containerize services (Docker) and orchestrate with Docker Compose or Kubernetes for realistic integration testing.

Testing
• Unit tests live under each module's src/test/java. Run:
   mvn test -pl <module>
• For cross-service integration testing, add end-to-end tests that start multiple services or use Testcontainers.

Troubleshooting and logs
• Each service writes logs under the module/log directory in this repo — inspect these files for stack traces and request/response details.
• Common log files: user/log/ErrorLog.log — contains WebClient errors and connection traces.

Contribution
• Follow the existing multi-module Maven structure.
• Update module-specific application.yml files when adding new services or changing ports.
• Submit PRs with clear descriptions and include unit/integration tests for new behavior.

License & contact
• This repository contains sample/demo code for a Twitter-like microservices platform.
• For questions about the code or to request features, open an issue or contact the maintainer listed in the repository metadata.


Appendix — quick checklist to run locally
• Ensure MySQL is running and update DB URLs in each service.
• (Optional) Start Consul: consul agent -dev (if using discovery).
• Build: mvn clean install
• Start services one-by-one (gateway last) and verify endpoints using Postman or curl.

End of README

