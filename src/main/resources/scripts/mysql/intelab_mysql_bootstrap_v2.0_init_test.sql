LOCK TABLES `login_user` WRITE;
INSERT INTO `login_user` VALUES 
(2,1,'sample_platform_manager@ILAB','$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G','sample_platform_manager',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NOW(), NULL, NULL, 0, NOW(), 0, NULL),
(3,1,'sample_device_owner@ILAB','$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G','sample_device_owner',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NOW(), NULL, NULL, 0, NOW(), 0, NULL);
UNLOCK TABLES;

LOCK TABLES `site_role_user_map` WRITE;
INSERT INTO `site_role_user_map` VALUES 
(2,4,2),
(3,5,3);

LOCK TABLES `resource_role_user_map` WRITE;
INSERT INTO `resource_role_user_map` VALUES
(2, 'device', 1, 4, 2, NOW());
UNLOCK TABLES;