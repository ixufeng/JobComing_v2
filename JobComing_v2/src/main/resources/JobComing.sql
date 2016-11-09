
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `true_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `identify_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--��ע��
CREATE TABLE IF NOT EXISTS `relationship`(

	relationship_id int not null AUTO_INCREMENT,
	user_id_a int not null,
	user_id_b int  not null,
	 PRIMARY KEY (`relationship_id`)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 
--

CREATE TABLE IF NOT EXISTS `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `jobkind_id` int(11) DEFAULT NULL,
  `job_time` datetime DEFAULT NULL,
  `addr_number` varchar(255) DEFAULT NULL,
  `detail_addr` varchar(255) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `job_scribe` varchar(255) DEFAULT NULL,
  `is_validate` int(11) DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- jobkind

CREATE TABLE IF NOT EXISTS `jobkind` (
  `jobkind_id` int(11) NOT NULL AUTO_INCREMENT,
  `jobkind_name` varchar(255) DEFAULT NULL,
  `jobkind_introduce` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jobkind_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;







