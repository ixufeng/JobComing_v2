
CREATE TABLE addresscity (
  city_id int(11)  PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  city_code int(11) DEFAULT NULL,
  province_code int(11) DEFAULT NULL,
  city_name varchar(255) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE addressprovince (
  province_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  province_code int(11) not NULL,
  province_name varchar(255) not NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE addresstown (
  town_id int(11) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  town_code int(11) not NULL,
  city_code int(11) not NULL,
  town_name varchar(255) not NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE agreement (
  agreement_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  job_id int(11) not NULL,
  user_id int(11) not NULL,
  status int(11) DEFAULT NULL,
  complete_time datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE  chat (
  chat_id int(11)  PRIMARY KEY not NULL AUTO_INCREMENT,
  user_sendId int(11) NOT NULL,
  user_recieveId int(11) not NULL,
  chat_content varchar(255) DEFAULT NULL,
  chat_time datetime DEFAULT NULL,
  status int(11)  DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE evaluate (
  evaluate_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  job_id int(11) not NULL,
  user_id int(11) not NULL,
  score int(11) DEFAULT NULL,
  content varchar(255) DEFAULT NULL,
  evaluate_time date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;