-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS `currency_converter` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Use the created database
USE `currency_converter`;

-- Create `conversions` table
CREATE TABLE IF NOT EXISTS `conversions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_currency` varchar(255) NOT NULL,
  `to_currency` varchar(255) NOT NULL,
  `amount` varchar(255) NOT NULL,
  `converted_amount` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create `currencies` table
CREATE TABLE IF NOT EXISTS `currencies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currency_code` varchar(255) NOT NULL,
  `rate_per_usd` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insert data into `currencies` table
INSERT INTO `currencies` (`id`, `currency_code`, `rate_per_usd`) VALUES
(6, 'USD', '1.0'),
(7, 'EUR', '0.92'),
(8, 'INR', '86.52'),
(9, 'GBP', '0.78');
