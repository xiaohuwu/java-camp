CREATE TABLE `user` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(255) NOT NULL,
    `avatar` VARCHAR(255),
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255),
    `status` INT,
    `created` DATETIME,
    `last_login` DATETIME,
    CONSTRAINT `uc_email` UNIQUE (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `m_blog` (
                          `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                          `user_id` BIGINT,
                          `title` VARCHAR(255),
                          `description` TEXT,
                          `content` LONGTEXT,
                          `created` DATETIME,
                          `status` INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

