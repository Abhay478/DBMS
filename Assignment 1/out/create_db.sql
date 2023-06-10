-- Database: univdb

-- DROP DATABASE IF EXISTS univdb;

CREATE DATABASE univdb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE univdb
    IS 'DBMS2';