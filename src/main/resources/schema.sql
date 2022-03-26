CREATE database pfm;
CREATE TABLE `asset_details` (
                                 `asset_id` int NOT NULL,
                                 `security_name` varchar(45) DEFAULT NULL,
                                 `created_date` datetime DEFAULT NULL,
                                 `crteated_by` varchar(45) DEFAULT NULL,
                                 `updated_date` datetime DEFAULT NULL,
                                 `updated_by` varchar(45) DEFAULT NULL,
                                 PRIMARY KEY (`asset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `order_detail` (
                                `order_ref_no` int NOT NULL AUTO_INCREMENT,
                                `order_date` date NOT NULL,
                                `order_state` varchar(20) DEFAULT NULL,
                                `quantity` int DEFAULT NULL,
                                `transaction_type` varchar(20) DEFAULT NULL,
                                `order_value` decimal(6,2) NOT NULL,
                                `created_date` date NOT NULL,
                                `created_by` varchar(20) DEFAULT NULL,
                                `update_date` date NOT NULL,
                                `update_by` varchar(20) DEFAULT NULL,
                                `unit_price` decimal(6,2) NOT NULL,
                                `asset_id` int NOT NULL,
                                PRIMARY KEY (`order_ref_no`),
                                KEY `asset_id_idx` (`asset_id`),
                                CONSTRAINT `asset_id` FOREIGN KEY (`asset_id`) REFERENCES `asset_details` (`asset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `portfolio_details` (
                                     `portfolio_id` int NOT NULL AUTO_INCREMENT,
                                     `order_ref_no` int NOT NULL,
                                     `credit` decimal(10,2) DEFAULT NULL,
                                     `debit` decimal(10,2) DEFAULT NULL,
                                     `running_balance` decimal(10,2) DEFAULT NULL,
                                     `created_date` datetime DEFAULT NULL,
                                     `created_by` varchar(20) DEFAULT NULL,
                                     `update_date` datetime DEFAULT NULL,
                                     `update_by` varchar(20) DEFAULT NULL,
                                     `assert_id` int NOT NULL,
                                     PRIMARY KEY (`portfolio_id`),
                                     KEY `order_ref_no_idx` (`order_ref_no`),
                                     CONSTRAINT `order_ref_no` FOREIGN KEY (`order_ref_no`) REFERENCES `order_detail` (`order_ref_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `audit_action` (
                                `audit_id` int NOT NULL,
                                `old_data` varchar(45) DEFAULT NULL,
                                `new_data` varchar(45) DEFAULT NULL,
                                `created_date` varchar(45) DEFAULT NULL,
                                `created_by` varchar(45) DEFAULT NULL,
                                `update_date` varchar(45) DEFAULT NULL,
                                `update_by` varchar(45) DEFAULT NULL,
                                PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

