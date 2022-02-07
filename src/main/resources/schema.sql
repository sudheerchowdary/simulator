CREATE DOMAIN IF NOT EXISTS JSONB AS OTHER;

CREATE TABLE IF NOT EXISTS  sb_data (
      id BIGINT AUTO_INCREMENT,
      url VARCHAR(5000) NOT NULL ,
      request_type VARCHAR(50) NOT NULL ,
      request_status VARCHAR(50) NOT NULL ,
      data JSONB NOT NULL,
      PRIMARY KEY (url, request_status, request_type)
);