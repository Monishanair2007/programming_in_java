-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS FoodDB;
USE FoodDB;

-- Create Restaurant table
CREATE TABLE Restaurant (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Address VARCHAR(200) NOT NULL
);

-- Create MenuItem table
CREATE TABLE MenuItem (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Price INT NOT NULL,
    ResId INT,
    FOREIGN KEY (ResId) REFERENCES Restaurant(Id)
);
