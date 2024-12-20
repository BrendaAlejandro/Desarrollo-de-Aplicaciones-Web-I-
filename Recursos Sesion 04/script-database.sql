-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS backoffice;

-- Usar la base de datos
USE backoffice;

-- Crear la tabla User
CREATE TABLE `User` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `email` VARCHAR(100) NOT NULL UNIQUE,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
	`role` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insertar registros con datos reales
INSERT INTO `User` (username, password, email, first_name, last_name, role)
VALUES
('john.doe', '$2a$12$3AmSNJug8GgSWGDnhVok5uQdTmzZml0wVX0oD6zJWrFLmTVuv.mhy', 'john.doe@mail.com', 'John', 'Doe', 'ADMIN'),
('jane.smith', '$2a$12$huxJ5GYadPSR1iTi2OO63.WdteU7ZrL6.LUVButbTobSmWRRgNH2m', 'jane.smith@mail.com', 'Jane', 'Smith', 'ADMIN'),
('michael.brown', '$2a$12$yvP6mnzq4wdIszUyCDn/UefRtzzr01qOXF7pA6vA8efq3ixgsvH9C', 'michael.brown@mail.com', 'Michael', 'Brown', 'OPERATOR'),
('emily.johnson', '$2a$12$rKf5dwuZxVfogVITbbftcOpDZBNdz013jwnzjykfEF6D1zy/wb.Hi', 'emily.johnson@mail.com', 'Emily', 'Johnson', 'OPERATOR'),
('chris.davis', '$2a$12$.LkymDGE1fmO7pb/EBV6lec5BeGMgGCxy9gFssc/YyG9dXSO404YG', 'chris.davis@mail.com', 'Chris', 'Davis', 'OPERATOR'),
('patricia.wilson', '$2a$12$HKL7gsoVFD9ET.93LLevtO.3UhC0douWfsmUPmxs7kkNKKNDDvQxe', 'patricia.wilson@mail.com', 'Patricia', 'Wilson', 'OPERATOR'),
('linda.martinez', '$2a$12$9fVG3/dB7oP4YB9vFLmm8u4RH.bow0ilLW4mv2y5qf5rdMsSoYrDq', 'linda.martinez@mail.com', 'Linda', 'Martinez', 'OPERATOR'),
('barbara.lopez', '$2a$12$XG5opmmz88oQhwzP5AwyVuXY2h7uQS6bDHRiNKfU8gfQojcSCMG/i', 'barbara.lopez@mail.com', 'Barbara', 'Lopez', 'OPERATOR'),
('robert.hernandez', '$2a$12$e6oIJ6ETrOP3Rn1dBa54nu/2YkwgTcdE5Nd3f/6lKpt4tYOeOHbqG', 'robert.hernandez@mail.com', 'Robert', 'Hernandez', 'OPERATOR'),
('james.clark', '$2a$12$U9a/mWq1a//V8eUHZiPoKu0U4mn0GBvqdJfo/p7jyCG14tzXHWM1S', 'james.clark@mail.com', 'James', 'Clark', 'OPERATOR'),
('david.allen', '$2a$12$iypYm9ywaJh32YWwW1sLeu32xD0cpI3GaC6hVIMs1EldpV75vSN6a', 'david.allen@mail.com', 'David', 'Allen', 'OPERATOR'),
('susan.young', '$2a$12$vAGW4nLjHRzl0a00Birq8.rQKn2qKCcrX6RX0jbcNFCO0gStFf4v.', 'susan.young@mail.com', 'Susan', 'Young', 'OPERATOR'),
('karen.king', '$2a$12$PjQa3HcPME/fsbBXFAnRI.JdjAiE44vAp5poo04tey2ClTkh5S3MS', 'karen.king@mail.com', 'Karen', 'King', 'OPERATOR'),
('nancy.lee', '$2a$12$Ytagnm8PNItPnHynLtjw5.hr8yG0s4o9TP2o7woeA1WdOYdutPxRa', 'nancy.lee@mail.com', 'Nancy', 'Lee', 'OPERATOR'),
('betty.garcia', '$2a$12$dSthJZ0MimGXuK8JaVBw5e7ZFXlXbPnoEDa23df3hasq/A1WOn/Tu', 'betty.garcia@mail.com', 'Betty', 'Garcia', 'OPERATOR'),
('ronald.lewis', '$2a$12$Jr6Oy.WBOfdlTjqAWed5pOEImdOwYTXhRnHJbVgNeCvMuPcqCmxcK', 'ronald.lewis@mail.com', 'Ronald', 'Lewis', 'OPERATOR'),
('daniel.robinson', '$2a$12$NkrMrH6hRMZfyX4SFjDwEu8JK20kp4um5KLKLj6wzH/zzhrnAmcfy', 'daniel.robinson@mail.com', 'Daniel', 'Robinson', 'OPERATOR'),
('margaret.walker', '$2a$12$NnEbd3YeYpbIxY8YCj5CfOGcdUamjHgn3vn.LIxUpQH9cY8Nsr3.i', 'margaret.walker@mail.com', 'Margaret', 'Walker', 'OPERATOR'),
('jessica.hall', '$2a$12$s95IlKz1BTe008PUwdQdueJQoSnrfoctD84tStk52mfnC9HiWCqya', 'jessica.hall@mail.com', 'Jessica', 'Hall', 'OPERATOR'),
('sandra.allen', '$2a$12$ubvNSQBoV337R4C/jXyVleBnriiPXkLBcuDlIW4uQJXH6gcXvv5yS', 'sandra.allen@mail.com', 'Sandra', 'Allen', 'OPERATOR');
