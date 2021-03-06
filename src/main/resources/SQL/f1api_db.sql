-- MySQL Script generated by MySQL Workbench
-- Tue Jan 18 11:10:11 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema f1api
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema f1api
-- -----------------------------------------------------
DROP DATABASE f1api;
CREATE SCHEMA IF NOT EXISTS `f1api` DEFAULT CHARACTER SET utf8 ;
USE `f1api` ;

-- -----------------------------------------------------
-- Table `f1api`.`teams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `f1api`.`teams` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(45) NOT NULL,
                                               PRIMARY KEY (`id`),
                                               UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `f1api`.`drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `f1api`.`drivers` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `firstname` VARCHAR(45) NOT NULL,
                                                 `lastname` VARCHAR(45) NOT NULL,
                                                 `teams_id` INT NOT NULL,
                                                 PRIMARY KEY (`id`, `teams_id`),
                                                 INDEX `fk_drivers_teams_idx` (`teams_id` ASC) VISIBLE,
                                                 UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                 CONSTRAINT `fk_drivers_teams`
                                                     FOREIGN KEY (`teams_id`)
                                                         REFERENCES `f1api`.`teams` (`id`)
                                                         ON DELETE NO ACTION
                                                         ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `f1api`.`gp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `f1api`.`gp` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `year` INT NOT NULL,
                                            `drivers_id` INT NOT NULL,
                                            `gp` VARCHAR(45) NOT NULL,
                                            PRIMARY KEY (`id`),
                                            INDEX `fk_gp_drivers1_idx` (`drivers_id` ASC) VISIBLE,
                                            UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                            CONSTRAINT `fk_gp_drivers1`
                                                FOREIGN KEY (`drivers_id`)
                                                    REFERENCES `f1api`.`drivers` (`id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
