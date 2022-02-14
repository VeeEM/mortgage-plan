CREATE TABLE IF NOT EXISTS `prospects` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`loan_total` DOUBLE NOT NULL,
	`interest` DOUBLE NOT NULL,
	`years` INT(10) NOT NULL,
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;
