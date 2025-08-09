-- users
INSERT INTO users (id, full_name, email) VALUES (1, 'Alice Dupont', 'alice@example.com');
INSERT INTO users (id, full_name, email) VALUES (2, 'Bob Martin', 'bob@example.com');

-- classrooms
INSERT INTO classroom (id, name, capacity) VALUES (1, 'Salle A', 30);
INSERT INTO classroom (id, name, capacity) VALUES (2, 'Salle B', 50);

-- reservations
INSERT INTO reservation (id, classroom_id, user_id, start_time, end_time)
VALUES (1, 1, 1, TIMESTAMP '2025-08-10 08:00:00', TIMESTAMP '2025-08-10 10:00:00');
