/*
DROP TABLE IF EXISTS user_data CASCADE;
DROP TABLE IF EXISTS role CASCADE;
DROP TABLE IF EXISTS user_role;
*/

CREATE TABLE IF NOT EXISTS user_data
(
  id bigint NOT NULL,
  name character varying(100),
  password character varying(40),
  username character varying(32),
  email character varying(100),
  CONSTRAINT user_data_pkey PRIMARY KEY (id ),
  CONSTRAINT user_data_username_key UNIQUE (username )
);
