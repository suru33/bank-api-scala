CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE ROLE scalabank PASSWORD 'scalabank_password' LOGIN;

CREATE DATABASE scalabank;

GRANT ALL PRIVILEGES ON DATABASE scalabank TO scalabank;
