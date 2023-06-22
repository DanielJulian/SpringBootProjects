CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY ,
    title varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Person_Info (
    id SERIAL PRIMARY KEY ,
    name varchar(255) NOT NULL,
    age NUMERIC,
    address VARCHAR(20) NOT NULL,
    nick_name VARCHAR(50) NOT NULL
);
