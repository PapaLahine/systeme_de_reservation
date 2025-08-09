# Reservation System - Demo (Ready-to-run ZIP)

## Prérequis
- Java 17+ doit être installé et `JAVA_HOME` configuré.
- Si Maven n'est pas installé, je recommande d'installer Maven ou d'ajouter le Maven Wrapper officiel (optionnel).

## Lancer l'application
1. Ouvre PowerShell ou CMD dans le dossier du projet (contenant `pom.xml`).
2. Sous Windows PowerShell/CMD :
   ```powershell
   .\\mvnw.cmd spring-boot:run
   ```
   Si `mvn` est installé, tu peux aussi utiliser :
   ```powershell
   mvn spring-boot:run
   ```

3. L'application démarre sur le port **8081**.

## Endpoints
- GET  http://localhost:8081/api/classrooms
- GET  http://localhost:8081/api/users
- GET  http://localhost:8081/api/reservations
- POST http://localhost:8081/api/reservations

## Tests unitaires
```
mvn test
```

## Remarques
- Si tu veux le Maven Wrapper officiel (avec `.mvn/wrapper/maven-wrapper.jar`) dis-le moi — je peux l'ajouter.
