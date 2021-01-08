CREATE ROLE scalabank PASSWORD 'scalabank_password' LOGIN;

CREATE DATABASE scalabank;
CREATE DATABASE scalabank_tests;

GRANT ALL PRIVILEGES ON DATABASE scalabank TO scalabank;
GRANT ALL PRIVILEGES ON DATABASE scalabank_tests TO scalabank;