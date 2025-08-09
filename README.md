# Système de réservation de salles - Architecture & Code
Projet minimal de démonstration pour un système de réservation de salles de classe.
## Architecture
- **Présentation (Controller)** : API REST exposée via Spring MVC.
- **Service Métier** : Contient la logique métier, validation et règles.
- **DAO (Repository)** : Spring Data JPA pour l'accès aux entités.
- **Entités (Domain)** : JPA entities: User, Classroom, Reservation.

## Fonctionnalités fournies
- CRUD pour les salles et réservations (REST).
- Validation simple (vérifie conflit de réservation).
- Tests unitaires pour le service de réservation.

## Comment utiliser
1. Décompressez le projet.
2. Build : `./mvnw package` ou `mvn package`
3. Run : `java -jar target/reservation-system-1.0.0.jar`
4. API: `http://localhost:8080/api/...`

## Pousser sur GitHub
1. `git init`
2. `git add .`
3. `git commit -m "Initial commit - reservation system"`
4. créer un repo GitHub et `git remote add origin git@github.com:USERNAME/repo.git`
5. `git push -u origin main`

