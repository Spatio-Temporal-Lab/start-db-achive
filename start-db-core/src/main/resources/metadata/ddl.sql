# CREATE DATABASE if not exists meta_data;
#
# use meta_data;

-- 表一 User
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user`
(
    `id`            INT PRIMARY KEY AUTO_INCREMENT,
    `name`          VARCHAR(200) NOT NULL,
    `password`      VARCHAR(200) NOT NULL,
    `created_date`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_date` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `delete_time`   BIGINT       NOT NULL DEFAULT 0 COMMENT '删除时间',
    INDEX idx_name (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 表二 DataBase
DROP TABLE IF EXISTS `sys_database`;
CREATE TABLE IF NOT EXISTS `sys_database`
(
    `id`            INT PRIMARY KEY AUTO_INCREMENT,
    `user_id`       INT          NOT NULL,
    `name`          VARCHAR(200) NOT NULL,
    `created_date`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_date` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `delete_time`   BIGINT       NOT NULL DEFAULT 0 COMMENT '删除时间',
    INDEX idx_user_id_name (`user_id`, `name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 表三 Table
DROP TABLE IF EXISTS `sys_table`;
CREATE TABLE IF NOT EXISTS `sys_table`
(
    `id`             INT PRIMARY KEY AUTO_INCREMENT,
    `db_id`          INT          NOT NULL,
    `name`           VARCHAR(200) NOT NULL,
    `storage_engine` VARCHAR(200) NOT NULL,
    `created_date`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_date`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `delete_time`    BIGINT       NOT NULL DEFAULT 0 COMMENT '删除时间',
    INDEX idx_db_id_name (`db_id`, `name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 表四 Field
DROP TABLE IF EXISTS `sys_field`;
CREATE TABLE IF NOT EXISTS `sys_field`
(
    `id`            INT PRIMARY KEY AUTO_INCREMENT,
    `table_id`      INT          NOT NULL,
    `name`          VARCHAR(200) NOT NULL,
    `type`          VARCHAR(200) NOT NULL,
    `is_primary`    TINYINT      NOT NULL COMMENT '0:非主键、1:主键',
    `created_date`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_date` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `delete_time`   BIGINT       NOT NULL DEFAULT 0 COMMENT '删除时间',
    INDEX idx_table_id_name (`table_id`, `name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- 插入测试用户、库、表，DDL好了后就没必要手动插入了, 密码是 start-db
INSERT INTO sys_user(id, name, password) VALUE (1, 'start_db', '6ee5f4a8b6a2697f5add5ab1333968d0');
INSERT INTO sys_database(id, user_id, name) VALUE (1, 1, 'db_test');
INSERT INTO sys_table(id, db_id, name, storage_engine) VALUE (1, 1, 't_test', 'hbase');
INSERT INTO sys_table(id, db_id, name, storage_engine) VALUE (2, 1, 't_road_segment_test', 'hbase');
INSERT INTO sys_table(id, db_id, name, storage_engine) VALUE (3, 1, 't_trajectory_test', 'hbase');
-- field
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (1, 1, 'idx', 'Integer', 1);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (2, 1, 'ride_id', 'String', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (3, 1, 'rideable_type', 'String', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (4, 1, 'started_at', 'Timestamp', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (5, 1, 'ended_at', 'Timestamp', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (6, 1, 'start_station_name', 'String', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (7, 1, 'start_station_id', 'Double', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (8, 1, 'start_point', 'Point', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (9, 1, 'end_station_name', 'String', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (10, 1, 'end_station_id', 'Double', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (11, 1, 'end_point', 'Point', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (12, 1, 'track', 'LineString', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (13, 1, 'member_casual', 'String', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (14, 2, 'a', 'Integer', 1);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (15, 2, 'b', 'RoadSegment', 0);
INSERT INTO sys_field(id, table_id, name, type, is_primary) VALUE (16, 2, 'c', 'RoadSegment', 0);
