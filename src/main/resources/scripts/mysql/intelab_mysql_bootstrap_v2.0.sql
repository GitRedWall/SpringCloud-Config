-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ilabservice
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ilabservice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ilabservice` DEFAULT CHARACTER SET utf8mb4 ;
USE `ilabservice` ;

-- -----------------------------------------------------
-- Table `ilabservice`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`company` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`company` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sys_code` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `address` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `email` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `telephone` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `contract_no` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `sign_date` DATE NULL DEFAULT NULL,
  `contract_start_date` DATE NULL DEFAULT NULL,
  `contract_end_date` DATE NULL DEFAULT NULL,
  `logo` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `background_url` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  `login_url` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `update_datetime` DATETIME NULL DEFAULT NULL,
  `block_chain_address` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`login_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`login_user` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`login_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `company_id` INT(11) NOT NULL,
  `user_name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `password` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `head_icon` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `mobile` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `telephone` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `gender` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `email` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `department` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `job` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `job_number` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `bind_mobile` INT(11) NULL DEFAULT NULL,
  `bind_email` INT(11) NULL DEFAULT NULL,
  `verify` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NOT NULL,
  `update_datetime` DATETIME NULL DEFAULT NULL,
  `last_password_error_date` DATE NULL DEFAULT NULL,
  `password_error_retry_times` INT(11) NULL DEFAULT '0',
  `latest_password_update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `alert_notification_type` INT(11) NULL DEFAULT '0',
  `block_chain_address` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_login_user_company` (`company_id` ASC),
  CONSTRAINT `FK_login_user_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `ilabservice`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`geo_location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`geo_location` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`geo_location` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `parent_id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `description` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `address` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `location_type` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `timezone` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `latitude` DECIMAL(12,9) NULL DEFAULT NULL,
  `longtitude` DECIMAL(12,9) NULL DEFAULT NULL,
  `create_datetime` DATETIME NOT NULL,
  `x_location` FLOAT(24,0) NULL DEFAULT NULL,
  `y_location` FLOAT(24,0) NULL DEFAULT NULL,
  `is_root` TINYINT(1) NOT NULL,
  `is_leaf` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `SelfKey` 
    FOREIGN KEY (`parent_id`) 
    REFERENCES `ilabservice`.`geo_location` (`id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `ilabservice`.`mon_target_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`mon_target_type` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`mon_target_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `description` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `logo_url` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`mon_target`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`mon_target` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`mon_target` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `location_id` INT(11) NOT NULL,
  `serial_no` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci',
  `mon_target_type_id` INT(11) NOT NULL,
  `ref_table` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `ref_table_id` INT(11) NOT NULL,
  `code` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `owner_id` INT(11) NULL DEFAULT NULL,
  `creator_id` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  `is_enabled` TINYINT(1) NULL DEFAULT NULL,
  `status` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `enable_sharing` INT(2) NULL DEFAULT '0',
  `block_chain_key` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `rent_clause` VARCHAR(300) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `rent_price_per_hour` DOUBLE NULL DEFAULT NULL,
  `latest_running_status` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_mon_target_location` (`location_id` ASC),
  INDEX `FK_mon_target_mon_target_type` (`mon_target_type_id` ASC),
  INDEX `FK_mon_target_user` (`creator_id` ASC),
  CONSTRAINT `FK_mon_target_location`
    FOREIGN KEY (`location_id`)
    REFERENCES `ilabservice`.`geo_location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_mon_target_mon_target_type`
    FOREIGN KEY (`mon_target_type_id`)
    REFERENCES `ilabservice`.`mon_target_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_mon_target_creator`
    FOREIGN KEY (`creator_id`)
    REFERENCES `ilabservice`.`login_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_mon_target_owner`
    FOREIGN KEY (`owner_id`)
    REFERENCES `ilabservice`.`login_user`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`block_chain_deal_record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`block_chain_deal_record` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`block_chain_deal_record` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mon_target_id` INT(11) NOT NULL,
  `lessor_id` INT(11) NOT NULL,
  `lessee_id` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `begin_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  `aggrement` VARCHAR(300) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `status` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_block_chain_deal_record_mon_target` (`mon_target_id` ASC),
  INDEX `FK_block_chain_deal_record_lessee` (`lessee_id` ASC),
  INDEX `FK_block_chain_deal_record_lessor` (`lessor_id` ASC),
  CONSTRAINT `FK_block_chain_deal_record_lessee`
    FOREIGN KEY (`lessee_id`)
    REFERENCES `ilabservice`.`login_user` (`id`),
  CONSTRAINT `FK_block_chain_deal_record_lessor`
    FOREIGN KEY (`lessor_id`)
    REFERENCES `ilabservice`.`login_user` (`id`),
  CONSTRAINT `FK_block_chain_deal_record_mon_target`
    FOREIGN KEY (`mon_target_id`)
    REFERENCES `ilabservice`.`mon_target` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`camera_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`camera_list` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`camera_list` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `mon_target_id` INT(11) NOT NULL,
  `serial_no` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `play_url` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `description` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_camera_list_mon_target` (`mon_target_id` ASC),
  CONSTRAINT `FK_camera_list_mon_target`
    FOREIGN KEY (`mon_target_id`)
    REFERENCES `ilabservice`.`mon_target` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`common_lookup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`common_lookup` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`common_lookup` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `category_desc` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `code` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `value` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `sort_order` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`device`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`device` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`device` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `purchase_date` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `photo` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `manufacturer` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `product_model` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `health_score` FLOAT(24,0) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`event_rule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`event_rule` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`event_rule` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `rule_name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `description` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `mon_target_type_id` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_event_rule_mon_target_type`
  FOREIGN KEY (`mon_target_type_id`)
  REFERENCES `ilabservice`.`mon_target_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`event` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`event` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `iot_device_id` INT(11) NOT NULL,
  `event_rule_id` INT(11) NOT NULL,
  `counts` INT(11) NOT NULL,
  `start_datetime` DATETIME NOT NULL,
  `end_datetime` DATETIME NOT NULL,
  `diagnose_reason` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `corrective_action` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `process_status` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `last_process_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_iot_device_id` (`iot_device_id` ASC),
  INDEX `FK_event_rule_id` (`event_rule_id` ASC),
  CONSTRAINT `FK_event_event_rule`
    FOREIGN KEY (`event_rule_id`)
    REFERENCES `ilabservice`.`event_rule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_event_iot_device`
    FOREIGN KEY (`iot_device_id`)
    REFERENCES `ilabservice`.`iotdevice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`event_action`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`event_action` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`event_action` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `action_name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `description` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `is_enabled` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;



-- -----------------------------------------------------
-- Table `ilabservice`.`measure_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`measure_type` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`measure_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `code` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `unit` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `measurement` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT "measurement",
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  AUTO_INCREMENT = 10;

-- -----------------------------------------------------
-- Table `ilabservice`.`event_condition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`event_condition` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`event_condition` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `measure_type_id` INT(11) NULL DEFAULT NULL,
  `iot_device_id` INT(11) NULL DEFAULT NULL,
  `operator` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `value` FLOAT NOT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_event_condition_measure_type`
    FOREIGN KEY (`measure_type_id`)
    REFERENCES `ilabservice`.`measure_type`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_event_condition_iot_device`
    FOREIGN KEY (`iot_device_id`)
    REFERENCES `ilabservice`.`iotdevice`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`event_rule_action_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`event_rule_action_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`event_rule_action_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `event_rule_id` INT(11) NULL DEFAULT NULL,
  `event_action_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_event_rule_action_map_event_action` (`event_action_id` ASC),
  INDEX `FK_event_rule_action_map_event_rule` (`event_rule_id` ASC),
  CONSTRAINT `FK_event_rule_action_map_event_action`
    FOREIGN KEY (`event_action_id`)
    REFERENCES `ilabservice`.`event_action` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_event_rule_action_map_event_rule`
    FOREIGN KEY (`event_rule_id`)
    REFERENCES `ilabservice`.`event_rule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`event_rule_condition_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`event_rule_condition_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`event_rule_condition_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `event_rule_id` INT(11) NULL DEFAULT NULL,
  `event_condition_id` INT(11) NULL DEFAULT NULL,
  `order` INT(11) NULL DEFAULT NULL,
  `operator` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_event_rule_condition_map_event_condition` (`event_condition_id` ASC),
  INDEX `FK_event_rule_condition_map_event_rule` (`event_rule_id` ASC),
  CONSTRAINT `FK_event_rule_condition_map_event_condition`
    FOREIGN KEY (`event_condition_id`)
    REFERENCES `ilabservice`.`event_condition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_event_rule_condition_map_event_rule`
    FOREIGN KEY (`event_rule_id`)
    REFERENCES `ilabservice`.`event_rule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`iotdevice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`iotdevice` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`iotdevice` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `serial_no` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `battery_status` FLOAT(24,0) NULL DEFAULT NULL,
  `is_online` TINYINT(1) NULL DEFAULT NULL,
  `model` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `firmware_version` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`iotdevice_monitor_target_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`iotdevice_monitor_target_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`iotdevice_monitor_target_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `iotdevice_id` INT(11) NOT NULL,
  `mon_target_id` INT(11) NOT NULL,
  `start_time` DATETIME NULL DEFAULT NULL,
  `end_time` DATETIME NULL DEFAULT NULL,
  `is_current` TINYINT(1) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_iotdevice_monitor_target_map_iotdevice` (`iotdevice_id` ASC),
  INDEX `FK_iotdevice_monitor_target_map_mon_target` (`mon_target_id` ASC),
  CONSTRAINT `FK_iotdevice_monitor_target_map_iotdevice`
    FOREIGN KEY (`iotdevice_id`)
    REFERENCES `ilabservice`.`iotdevice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_iotdevice_monitor_target_map_mon_target`
    FOREIGN KEY (`mon_target_id`)
    REFERENCES `ilabservice`.`mon_target` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`mon_target_disable_sharing_strategy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`mon_target_disable_sharing_strategy` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`mon_target_disable_sharing_strategy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mon_target_id` INT(11) NOT NULL,
  `strategy_type` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `content` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_mon_target_disable_sharing_strategy_mon_target` (`mon_target_id` ASC),
  CONSTRAINT `FK_mon_target_disable_sharing_strategy_mon_target`
    FOREIGN KEY (`mon_target_id`)
    REFERENCES `ilabservice`.`mon_target` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`mon_target_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`mon_target_group` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`mon_target_group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `group_desc` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `is_dynamic` INT(11) NULL DEFAULT NULL,
  `dynamic_group_rule` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `parent_group_id` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`mon_target_group_static_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`mon_target_group_static_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`mon_target_group_static_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `group_id` INT(11) NULL DEFAULT NULL,
  `mon_target_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_mon_target_group_static_map_mon_target` (`mon_target_id` ASC),
  INDEX `FK_mon_target_group_static_map_mon_target_group` (`group_id` ASC),
  CONSTRAINT `FK_mon_target_group_static_map_mon_target`
    FOREIGN KEY (`mon_target_id`)
    REFERENCES `ilabservice`.`mon_target` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_mon_target_group_static_map_mon_target_group`
    FOREIGN KEY (`group_id`)
    REFERENCES `ilabservice`.`mon_target_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`mon_target_type_default_rule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`mon_target_type_default_rule` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`mon_target_type_default_rule` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mon_target_type_id` INT(11) NULL DEFAULT NULL,
  `measure_type_id` INT(11) NULL DEFAULT NULL,
  `standard` FLOAT(24,0) NULL DEFAULT NULL,
  `low_up_alert` FLOAT(24,0) NULL DEFAULT NULL,
  `low_down_alert` FLOAT(24,0) NULL DEFAULT NULL,
  `high_up_alert` FLOAT(24,0) NULL DEFAULT NULL,
  `high_down_alert` FLOAT(24,0) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_mon_target_type_default_rule_measure_type` (`measure_type_id` ASC),
  INDEX `FK_mon_target_type_default_rule_mon_target_type` (`mon_target_type_id` ASC),
  CONSTRAINT `FK_mon_target_type_default_rule_measure_type`
    FOREIGN KEY (`measure_type_id`)
    REFERENCES `ilabservice`.`measure_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_mon_target_type_default_rule_mon_target_type`
    FOREIGN KEY (`mon_target_type_id`)
    REFERENCES `ilabservice`.`mon_target_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`permission` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`permission` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `permission_type` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `description` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`pt100`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`pt100` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`pt100` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `temperature` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `resistance` DECIMAL(6,2) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`rent_clause`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`rent_clause` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`rent_clause` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ilabservice`.`role_definition`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`role_definition` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`role_definition` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `description` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `role_type` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `create_datetime` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`resource_role_user_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`resource_role_user_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`resource_role_user_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `resource_type` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `resource_id` INT(11) NULL DEFAULT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_resource_role_user_map_mon_target` (`resource_id` ASC),
  INDEX `FK_resource_role_user_map_role` (`role_id` ASC),
  INDEX `FK_resource_role_user_map_user` (`user_id` ASC),
  CONSTRAINT `FK_resource_role_user_map_mon_target`
    FOREIGN KEY (`resource_id`)
    REFERENCES `ilabservice`.`mon_target` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_resource_role_user_map_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `ilabservice`.`role_definition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_resource_role_user_map_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ilabservice`.`login_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`resource_type_role_user_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`resource_type_role_user_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`resource_type_role_user_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `resource_type_id` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_resource_type_role_user_map_mon_target_type` (`resource_type_id` ASC),
  INDEX `FK_resource_type_role_user_map_role` (`role_id` ASC),
  INDEX `FK_resource_type_role_user_map_user` (`user_id` ASC),
  CONSTRAINT `FK_resource_type_role_user_map_mon_target_type`
    FOREIGN KEY (`resource_type_id`)
    REFERENCES `ilabservice`.`mon_target_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_resource_type_role_user_map_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `ilabservice`.`role_definition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_resource_type_role_user_map_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ilabservice`.`login_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`geo_location_role_user_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`geo_location_role_user_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`geo_location_role_user_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `geo_location_id` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_geo_location_role_user_map_mon_target_type` (`geo_location_id` ASC),
  INDEX `FK_geo_location_role_user_map_role` (`role_id` ASC),
  INDEX `FK_geo_location_role_user_map_user` (`user_id` ASC),
  CONSTRAINT `FK_geo_location_role_user_map_geo_location`
    FOREIGN KEY (`geo_location_id`)
    REFERENCES `ilabservice`.`geo_location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_geo_location_role_user_map_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `ilabservice`.`role_definition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_geo_location_role_user_map_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ilabservice`.`login_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`role_permission_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`role_permission_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`role_permission_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_id` INT(11) NOT NULL,
  `permission_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_role_permssion_map_permission` (`permission_id` ASC),
  INDEX `FK_role_permssion_map_role` (`role_id` ASC),
  CONSTRAINT `FK_role_permssion_map_permission`
    FOREIGN KEY (`permission_id`)
    REFERENCES `ilabservice`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_role_permssion_map_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `ilabservice`.`role_definition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`sensor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`sensor` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`sensor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `serial_no` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `device_id` INT(11) NOT NULL,
  `sample_frequency` INT(11) NULL DEFAULT NULL,
  `sample_time_unit` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `zero_drift` DECIMAL(8,6) NULL DEFAULT NULL,
  `calibration_frequency` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NULL DEFAULT NULL,
  `last_calibration_date` DATE NULL DEFAULT NULL,
  `input_high` FLOAT(24,0) NULL DEFAULT NULL,
  `input_low` FLOAT(24,0) NULL DEFAULT NULL,
  `output_high` FLOAT(24,0) NULL DEFAULT NULL,
  `output_low` FLOAT(24,0) NULL DEFAULT NULL,
  `create_datetime` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_sensor_iotdevice` (`device_id` ASC),
  CONSTRAINT `FK_sensor_iotdevice`
    FOREIGN KEY (`device_id`)
    REFERENCES `ilabservice`.`iotdevice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`sensor_measure_type_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`sensor_measure_type_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`sensor_measure_type_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sensor_id` INT(11) NULL DEFAULT NULL,
  `measure_type_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_sensor_measure_type_map_measure_type` (`measure_type_id` ASC),
  INDEX `FK_sensor_measure_type_map_sensor` (`sensor_id` ASC),
  CONSTRAINT `FK_sensor_measure_type_map_measure_type`
    FOREIGN KEY (`measure_type_id`)
    REFERENCES `ilabservice`.`measure_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_sensor_measure_type_map_sensor`
    FOREIGN KEY (`sensor_id`)
    REFERENCES `ilabservice`.`sensor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`site_role_user_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`site_role_user_map` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`site_role_user_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_site_role_map_user_role` (`role_id` ASC),
  INDEX `FK_site_role_map_user_user` (`user_id` ASC),
  CONSTRAINT `FK_site_role_map_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `ilabservice`.`role_definition` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_site_role_map_user_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ilabservice`.`login_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`extra_feature`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`extra_feature` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`extra_feature` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(160) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `description` VARCHAR(255) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `category` VARCHAR(160) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `tier` INT(3) NOT NULL,
  `parent_feature_id` INT(11),
  PRIMARY KEY (`id`),
  CONSTRAINT `SK_extra_feature_parent_feature_id_id` 
    FOREIGN KEY (`parent_feature_id`) 
    REFERENCES `ilabservice`.`extra_feature` (`id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `ilabservice`.`company_extra_feature`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`company_extra_feature` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`company_extra_feature` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `company_id` INT(11) NOT NULL,
  `extra_feature_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_company_extra_feature_company_id` 
    FOREIGN KEY (`company_id`) 
    REFERENCES `ilabservice`.`company` (`id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_company_extra_feature_extra_feature_id` 
    FOREIGN KEY (`extra_feature_id`) 
    REFERENCES `ilabservice`.`extra_feature` (`id`) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `ilabservice`.`sysdiagrams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ilabservice`.`sysdiagrams` ;

CREATE TABLE IF NOT EXISTS `ilabservice`.`sysdiagrams` (
  `name` VARCHAR(160) COLLATE 'utf8mb4_unicode_ci' NOT NULL,
  `principal_id` INT(11) NOT NULL,
  `diagram_id` INT(11) NOT NULL AUTO_INCREMENT,
  `version` INT(11) NULL DEFAULT NULL,
  `definition` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`diagram_id`),
  UNIQUE INDEX `UK_principal_name` (`principal_id` ASC, `name` ASC))
ENGINE = InnoDB;

USE `ilabservice` ;

-- -----------------------------------------------------
-- Placeholder table for view `ilabservice`.`view_event_rule_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ilabservice`.`view_event_rule_detail` (`id` INT, `rule_name` INT, `rule_desc` INT, `mon_target_type` INT, `measure_type_id` INT, `measure_type` INT, `unit` INT, `condition_op` INT, `value` INT, `order` INT, `rule_op` INT, `action_name` INT, `is_enabled` INT);

-- -----------------------------------------------------
-- Placeholder table for view `ilabservice`.`view_user_site_role_permissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ilabservice`.`view_user_site_role_permissions` (`user_id` INT, `login_name` INT, `full_name` INT, `role_name` INT, `role_type` INT, `permission_name` INT);

-- -----------------------------------------------------
-- View `ilabservice`.`view_event_rule_detail`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `ilabservice`.`view_event_rule_detail` ;
DROP TABLE IF EXISTS `ilabservice`.`view_event_rule_detail`;
USE `ilabservice`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED VIEW `ilabservice`.`view_event_rule_detail` AS select `er`.`id` AS `id`,`er`.`rule_name` AS `rule_name`,`er`.`description` AS `rule_desc`,`tt`.`name` AS `mon_target_type`,`ec`.`measure_type_id` AS `measure_type_id`,`mt`.`name` AS `measure_type`,`mt`.`unit` AS `unit`,`ec`.`operator` AS `condition_op`,`ec`.`value` AS `value`,`er_ec`.`order` AS `order`,`er_ec`.`operator` AS `rule_op`,`ea`.`action_name` AS `action_name`,`ea`.`is_enabled` AS `is_enabled` from ((((((`ilabservice`.`event_rule` `er` left join `ilabservice`.`mon_target_type` `tt` on((`er`.`mon_target_type_id` = `tt`.`id`))) left join `ilabservice`.`event_rule_condition_map` `er_ec` on((`er`.`id` = `er_ec`.`event_rule_id`))) left join `ilabservice`.`event_condition` `ec` on((`er_ec`.`event_condition_id` = `ec`.`id`))) left join `ilabservice`.`event_rule_action_map` `er_ea` on((`er`.`id` = `er_ea`.`event_rule_id`))) left join `ilabservice`.`event_action` `ea` on((`er_ea`.`event_action_id` = `ea`.`id`))) left join `ilabservice`.`measure_type` `mt` on((`mt`.`id` = `ec`.`measure_type_id`))) order by `er`.`id`,`ea`.`action_name`,`er_ec`.`order`;

-- -----------------------------------------------------
-- View `ilabservice`.`view_user_site_role_permissions`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `ilabservice`.`view_user_site_role_permissions` ;
DROP TABLE IF EXISTS `ilabservice`.`view_user_site_role_permissions`;
USE `ilabservice`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED VIEW `ilabservice`.`view_user_site_role_permissions` AS select `u`.`id` AS `user_id`,`u`.`user_name` AS `login_name`,`u`.`name` AS `full_name`,`r`.`name` AS `role_name`,`r`.`role_type` AS `role_type`,`p`.`name` AS `permission_name` from ((((`ilabservice`.`login_user` `u` left join `ilabservice`.`site_role_user_map` `ru` on((`u`.`id` = `ru`.`user_id`))) left join `ilabservice`.`role_definition` `r` on((`ru`.`role_id` = `r`.`id`))) left join `ilabservice`.`role_permission_map` `rp` on((`rp`.`role_id` = `r`.`id`))) left join `ilabservice`.`permission` `p` on((`rp`.`permission_id` = `p`.`id`))) order by `u`.`id`,`r`.`id`,`p`.`id`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
