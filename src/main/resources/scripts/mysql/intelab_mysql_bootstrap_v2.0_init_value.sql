LOCK TABLES `common_lookup` WRITE;
/*!40000 ALTER TABLE `common_lookup` DISABLE KEYS */;
INSERT INTO `common_lookup` VALUES 
(1,'LOCATION_TYPE','TABLE LOCATION: LOCATION_TYPE','CITY','City',1,NOW()),
(2,'LOCATION_TYPE','TABLE LOCATION: LOCATION_TYPE','BUILDING','Building Name',2,NOW()),
(3,'LOCATION_TYPE','TABLE LOCATION: LOCATION_TYPE','FLOOR','Floor',3,NOW()),
(4,'LOCATION_TYPE','TABLE LOCATION: LOCATION_TYPE','ROOM','Room',4,NOW()),
(5,'PERMISSION_TYPE','TABLE PERMISSION: PERMISSION_TYPE','SITE_ROLE_PERMISSION','SITE_ROLE_PERMISSION',1,NOW()),
(6,'PERMISSION_TYPE','TABLE PERMISSION: PERMISSION_TYPE','RESOURCE_ROLE_PERMISSION','RESOURCE_ROLE_PERMISSION',2,NOW()),
(7,'ROLE_TYPE','TABLE ROLE: ROLE_TYPE','SYSTEM_ROLE','SYSTEM_ROLE',1,NOW()),
(8,'ROLE_TYPE','TABLE ROLE: ROLE_TYPE','USER_DEFINED_ROLE','USER_DEFINED_ROLE',2,NOW()),
(9,'MON_TARGET_STATUS','TABLE MON_TARGET: STATUS_TYPE','ENABLED','REGULAR',1,NOW()),
(10,'MON_TARGET_STATUS','TABLE MON_TARGET: STATUS_TYPE','DISABLED','UNDER_MAINTENANCE',2,NOW()),
(11,'EVENT_PROCESS_STATUS','TABLE EVENT: STATUS_TYPE','NOT_PROCESSED','ACKNOWLEDGED',1,NOW()),
(12,'EVENT_PROCESS_STATUS','TABLE EVENT: STATUS_TYPE','ACKNOWLEDGED','UNDER_MAINTENANCE',2,NOW()),
(13,'EVENT_PROCESS_STATUS','TABLE EVENT: STATUS_TYPE','RESOLVED','UNDER_MAINTENANCE',3,NOW());



/*!40000 ALTER TABLE `common_lookup` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES 
(1,'ILAB','iLabService','Shanghai','xx@xx','xxx-xxx-xxx',NULL,NULL,NULL,NULL,NULL,NULL,NOW(),NULL,NULL,NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;



LOCK TABLES `measure_type` WRITE;
/*!40000 ALTER TABLE `measure_type` DISABLE KEYS */;
INSERT INTO `measure_type` VALUES
(1,'温度(PT100)','00','度','TEMPERATURE_PT100_4'),
(2,'温湿度(湿度)','01','%','humidity'),
(3,'二氧化碳','02','ppm','CO2'),
(4,'电池电量','03','%','battery'),
(5,'温湿度(温度)','04','度','temperature_SHT20'),
(6,'设备门状态','05','on/off','door'),
(7,'房间压差','06','pa','PSID'),
(8,'甲烷含量','07','LEL%','methane'),
(9,'有功电能','08','KWH','active_energy'),
(10,'无功电能','09','KWH','passive_energy'),
(11,'电压','0a','V','voltage'),
(12,'电流','0b','A','current'),
(13,'有功功率','0c','W','active_power'),
(14,'无功功率','0d','W','passive_power'),
(15,'温度','0e','degree','temperature_SHT30'),
(16,'湿度','0f','%','humidity'),
(17,'TVOC','10','mg/m3','TVOC'),
(18,'烟雾监控','11','normal/abnormal','Smoke'),
(19,'pm2.5','12','ug/m3','pm2.5'),
(20,'pm10','13','ug/m3','pm10'),
(21,'电能','14','kWH','energy'),
(22,'电压','15','V','voltage'),
(23,'电流','16','A','current'),
(24,'功率','17','W','power'),

(25,'AD0(酸性溶液)','18','degree','temperature_PT100_3'),
(26,'AD1(碱性溶液)','19','degree','temperature_PT100_3'),
(27,'AD2(中性溶液)','1a','degree','temperature_PT100_3'),
(28,'电流环','1b','A','current'),
(29,'x加速度','1c','g','acceleration_x'),
(30,'y加速度','1d','g','acceleration_y'),
(31,'z加速度','1e','g','acceleration_z'),
(32,'x角速度','1f','r/s','angular_speed_x'),
(33,'y角速度','20','r/s','angular_speed_y'),
(34,'z角速度','21','r/s','angular_speed_z'),

(35,'A相电压','22','V','phase_voltage_a'),
(36,'B相电压','23','V','phase_voltage_b'),
(37,'C相电压','24','V','phase_voltage_c'),

(38,'A相电流','25','A','phase_current_a'),
(39,'B相电流','26','A','phase_current_b'),
(40,'C相电流','27','A','phase_current_c'),
(41,'三相功率','28','KW','three_phase_power'),
(42,'三相电能','29','kWH','three_phase_energy'),
(43,'x轴加速度','2a','m/s2','acceleration_x'),
(44,'y轴加速度','2b','m/s2','acceleration_y'),
(45,'z轴加速度','2c','m/s2','acceleration_z'),
(46,'有害气体','2d','ppm','harmful_gas'),
(47,'分贝传感器','2e','db','decibel');
/*!40000 ALTER TABLE `measure_type` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `geo_location` WRITE;
/*!40000 ALTER TABLE `geo_location` DISABLE KEYS */;
INSERT INTO `geo_location` VALUES
(1,NULL,'SHANGHAI','Shainghai','Shanghai','CITY',NULL,NULL,NULL,NOW(),NULL,NULL,1,0),
(2,1,'Sample Buiding','Sample Buiding','address xxx','BUILDING',NULL,NULL,NULL,NOW(),NULL,NULL,0,0),
(3,2,'4th Floor','Sample Lab 4th Floor','address xxx','FLOOR',NULL,NULL,NULL,NOW(),NULL,NULL,0,0),
(4,2,'5th Floor','Sample Lab 5th Floor','address xxx','FLOOR',NULL,NULL,NULL,NOW(),NULL,NULL,0,0),
(5,3,'Room 401','Sample Room 401','address xxx','ROOM',NULL,NULL,NULL,NOW(),NULL,NULL,0,1),
(6,3,'Room 402','Sample Room 402','address xxx','ROOM',NULL,NULL,NULL,NOW(),NULL,NULL,0,1),
(7,4,'Room 501','Sample Room 501','address xxx','ROOM',NULL,NULL,NULL,NOW(),NULL,NULL,0,1);
/*!40000 ALTER TABLE `geo_location` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `iotdevice` WRITE;
/*!40000 ALTER TABLE `iotdevice` DISABLE KEYS */;
INSERT INTO `iotdevice` VALUES
(1,'Simulator_1',100,1,'SIMULATOR',NULL,NOW()),
(2,'Simulator_2',100,1,'SIMULATOR',NULL,NOW());
/*!40000 ALTER TABLE `iotdevice` ENABLE KEYS */;
UNLOCK TABLES;



LOCK TABLES `event_condition` WRITE;
/*!40000 ALTER TABLE `event_condition` DISABLE KEYS */;
INSERT INTO `event_condition` VALUES
(1,1,null,'<=', -90, NOW()),
(2,2,null,'>=', 90, NOW());
/*!40000 ALTER TABLE `event_condition` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `mon_target_type` WRITE;
/*!40000 ALTER TABLE `mon_target_type` DISABLE KEYS */;
INSERT INTO `mon_target_type` VALUES
  (1,'超低温冰箱',NULL,NULL,NOW()),
  (2,'测试设备',NULL,NULL,NOW());
/*!40000 ALTER TABLE `mon_target_type` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `event_rule` WRITE;
/*!40000 ALTER TABLE `event_rule` DISABLE KEYS */;
INSERT INTO `event_rule` VALUES
  (1,'REFRIGERATOR_RED_ALERT','超低温冰箱红色报警规则', 1, NOW()),
  (2,'REFRIGERATOR_YELLLOW_ALERT','超低温冰箱黄色报警规则', 1, NOW());

/*!40000 ALTER TABLE `event_rule` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `event_rule_condition_map` WRITE;
/*!40000 ALTER TABLE `event_rule_condition_map` DISABLE KEYS */;
INSERT INTO `event_rule_condition_map` VALUES
(1,1,1,1,'OR',NOW()),
(2,1,2,2,NULL,NOW());

/*!40000 ALTER TABLE `event_rule_condition_map` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES 
(1,'SITE_ROLE_PERMISSION','USER_INFO','ALLOW TO ACCESS USER INFO TAG',NULL),
(2,'SITE_ROLE_PERMISSION','RESOURCES_MANAGE','ALLOW TO ACCESS RESOURCES MANAGE TAG',NULL),
(3,'SITE_ROLE_PERMISSION','USER_LIST','ALLOW TO ACCESS USER LIST TAG',NULL),
(4,'SITE_ROLE_PERMISSION','DEVICE_LIST','ALLOW TO ACCESS DEVICE LIST TAG',NULL),
(5,'SITE_ROLE_PERMISSION','STATISTICS_REPORT','ALLOW TO ACCESS STATISTICS REPORT TAG',NULL),
(6,'SITE_ROLE_PERMISSION','DEVICE_DETAIL','ALLOW TO ACCESS DEVICE DETAIL TAG',NULL),

(7,'RESOURCE_ROLE_PERMISSION','EDIT_USER_INFO','ALLOW TO EDIT USER INFO',NULL),
(8,'RESOURCE_ROLE_PERMISSION','EDIT_COMPANY_LOGO','ALLOW TO EDIT COMPANY LOGO',NULL),
(9,'RESOURCE_ROLE_PERMISSION','VIEW_DEVICE_TYPE','ALLOW TO VIEW RESOURCE DEVICE TYPE',NULL),
(10,'RESOURCE_ROLE_PERMISSION','ADD_DEVICE_TYPE','ALLOW TO CREATE RESOURCE DEVICE TYPE',NULL),
(11,'RESOURCE_ROLE_PERMISSION','EDIT_DEVICE_TYPE','ALLOW TO EDIT RESOURCE DEVICE TYPE',NULL),
(12,'RESOURCE_ROLE_PERMISSION','DELETE_DEVICE_TYPE','ALLOW TO DELETE RESOURCE DEVICE TYPE',NULL),

(13,'RESOURCE_ROLE_PERMISSION','VIEW_GEO_LOCATION','ALLOW TO VIEW RESOURCES GEO LOCATION',NULL),
(14,'RESOURCE_ROLE_PERMISSION','ADD_GEO_LOCATION','ALLOW TO ADD RESOURCE GEO LOCATION',NULL),
(15,'RESOURCE_ROLE_PERMISSION','EDIT_GEO_LOCATION','ALLOW TO EDIT RESOURCE GEO LOCATION',NULL),
(16,'RESOURCE_ROLE_PERMISSION','DELETE_GEO_LOCATION','ALLOW TO DELETE RESOURCE GEO LOCATION',NULL),

(17,'RESOURCE_ROLE_PERMISSION','VIEW_USER_LIST','ALLOW TO VIEW USER LIST',NULL),
(18,'RESOURCE_ROLE_PERMISSION','EDIT_USER_LIST','ALLOW TO EDIT USER LIST',NULL),

(19,'RESOURCE_ROLE_PERMISSION','VIEW_DEVICE','ALLOW TO READ RESOURCE DEVICE INFO',NULL),
(20,'RESOURCE_ROLE_PERMISSION','ADD_DEVICE','ALLOW TO EDIT RESOURCE DEVICE INFO',NULL),
(21,'RESOURCE_ROLE_PERMISSION','EDIT_DEVICE','ALLOW TO CREATE RESOURCE DEVICE TYPE',NULL),
(22,'RESOURCE_ROLE_PERMISSION','DELETE_DEVICE','ALLOW TO READ RESOURCE DEVICE TYPE INFO',NULL),
(23,'RESOURCE_ROLE_PERMISSION','BIND_DEVICE_AND_TERMINAL','ALLOW TO BIND AND UNBIND DEVICE AND TERMINAL',NULL);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `pt100` WRITE;
/*!40000 ALTER TABLE `pt100` DISABLE KEYS */;
/*!40000 ALTER TABLE `pt100` ENABLE KEYS */;
UNLOCK TABLES;





LOCK TABLES `role_definition` WRITE;
/*!40000 ALTER TABLE `role_definition` DISABLE KEYS */;
INSERT INTO `role_definition` VALUES 
(1,'ADMINSTRATOR','system platform administrator','SYSTEM_ROLE',NOW()),
(2,'ENGINEER','system platform engineer','SYSTEM_ROLE',NOW()),
(3,'CUSTOMER_SERVER','system platform customer server','SYSTEM_ROLE',NOW()),
(4,'USER_PLATFORM_MANAGER','user platform administrator','USER_ROLE',NOW()),
(5,'USER_DEVICE_OWNER','user platform device owner, default user role','USER_ROLE',NOW()),
(6,'USER_SAMPLE_MANAGER','user platform sample manager','USER_ROLE',NOW()),
(7,'USER_SAMPLE_INSPECTOR','user platform sample inspector','USER_ROLE',NOW());
/*!40000 ALTER TABLE `role_definition` ENABLE KEYS */;
UNLOCK TABLES;



LOCK TABLES `role_permission_map` WRITE;
/*!40000 ALTER TABLE `role_permission_map` DISABLE KEYS */;
INSERT INTO `role_permission_map` VALUES 
(1,4,1),
(2,4,2),
(3,4,3),
(4,4,4),
(5,4,5),
(6,4,6),
(7,4,7),
(8,4,8),
(9,4,9),
(10,4,10),
(11,4,11),
(12,4,12),
(13,4,13),
(14,4,14),
(15,4,15),
(16,4,16),
(17,4,17),
(18,4,18),
(19,4,19),
(20,4,20),
(21,4,21),
(22,4,22),
(23,4,23),
(24,5,1),
(25,5,2),
(26,5,4),
(27,5,5),
(28,5,6),
(29,5,7),
(30,5,9),
(31,5,10),
(32,5,11),
(33,5,12),
(34,5,13),
(35,5,19),
(36,5,20),
(37,5,21),
(38,5,22);

/*!40000 ALTER TABLE `role_permission_map` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES 
(1,'Sensor_Temp_1',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NOW()),
(2,'Sensor_Humidity_1',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NOW()),
(3,'Sensor_Temp_2',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NOW()),
(4,'Sensor_Humidity_2',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NOW());
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `sensor_measure_type_map` WRITE;
/*!40000 ALTER TABLE `sensor_measure_type_map` DISABLE KEYS */;
INSERT INTO `sensor_measure_type_map` VALUES 
(1,1,1),
(2,2,2),
(3,3,1),
(4,4,2);
/*!40000 ALTER TABLE `sensor_measure_type_map` ENABLE KEYS */;
UNLOCK TABLES;




LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES 
(1,1,1,10, NOW() - INTERVAL 1 DAY, NOW(),'电源问题','恢复电源','ACKNOWLEDGED', NOW()),
(2,2,1,20, NOW() - INTERVAL 1 DAY, NOW(),'电源问题','恢复电源','NOT_PROCESSED',NOW());
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;



LOCK TABLES `login_user` WRITE;
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` VALUES 
(1,1,'administrator@ILAB','$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G','system adminstrator',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NOW(), NULL, NULL, 0, NOW(), 0, NULL);
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `mon_target` WRITE;
/*!40000 ALTER TABLE `mon_target` DISABLE KEYS */;
INSERT INTO `mon_target` VALUES 
(1,6,'LA3521215',1,'device',1,NULL,'设备1',NULL,1,NOW(),1,'REGULAR', 0, NULL, NULL, NULL, NULL),
(2,7,'ECAA12547',1,'device',2,NULL,'设备2',NULL,1,NOW(),1,'REGULAR', 0, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `mon_target` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `iotdevice_monitor_target_map` WRITE;
/*!40000 ALTER TABLE `iotdevice_monitor_target_map` DISABLE KEYS */;
INSERT INTO `iotdevice_monitor_target_map` VALUES 
(1,1,1,NOW(),NULL,1,NOW());
/*!40000 ALTER TABLE `iotdevice_monitor_target_map` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `site_role_user_map` WRITE;
/*!40000 ALTER TABLE `site_role_user_map` DISABLE KEYS */;
INSERT INTO `site_role_user_map` VALUES 
(1,1,1);
/*!40000 ALTER TABLE `site_role_user_map` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `resource_role_user_map` WRITE;
/*!40000 ALTER TABLE `resource_role_user_map` DISABLE KEYS */;
INSERT INTO `resource_role_user_map` VALUES 
(1,'DEVICE',1,4,1,NOW());
/*!40000 ALTER TABLE `resource_role_user_map` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `event_action` WRITE;
/*!40000 ALTER TABLE `event_action` DISABLE KEYS */;
INSERT INTO `event_action` VALUES 
(1,'EMAIL','Send Email',1),
(2,'SMS','Send SMS',1);

/*!40000 ALTER TABLE `event_action` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `event_rule_action_map` WRITE;
/*!40000 ALTER TABLE `event_rule_action_map` DISABLE KEYS */;
INSERT INTO `event_rule_action_map` VALUES 
(1,1,1),
(2,1,2);

/*!40000 ALTER TABLE `event_rule_action_map` ENABLE KEYS */;
UNLOCK TABLES;