# Render Deployment TODO

## Current Status: Dockerfile JAR name fixed

**Completed:**
- [x] 1. Added lombok-mapstruct-binding to pom.xml to fix Lombok annotation processing for Java 17/Docker.
- [x] 2. Create .dockerignore
- [x] 3. Update Dockerfile to use correct JAR name (demo-0.0.1-SNAPSHOT.jar -> demo.jar)

**Next Steps:**
- [ ] 4. Test Maven: cd demo && ./mvnw clean package
- [ ] 5. Test Docker: docker build -t test . && docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod test
- [ ] 6. Git commit/push
- [ ] 7. Render deploy with env vars (SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD, SPRING_PROFILES_ACTIVE=prod)
- [ ] 8. Test API endpoints

Dockerfile is now fixed. Run `docker build -t test demo/` to verify.

