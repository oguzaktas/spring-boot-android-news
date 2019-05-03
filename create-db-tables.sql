-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema news
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema news
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `news` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `news` ;

-- -----------------------------------------------------
-- Table `news`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `news`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news`.`news` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(255) NULL DEFAULT NULL,
  `content` VARCHAR(255) NULL DEFAULT NULL,
  `dislikes` INT(11) NULL DEFAULT NULL,
  `header` VARCHAR(255) NULL DEFAULT NULL,
  `imageurl` VARCHAR(255) NULL DEFAULT NULL,
  `likes` INT(11) NULL DEFAULT NULL,
  `publish_date` DATE NULL DEFAULT NULL,
  `views` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

