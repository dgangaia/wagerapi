
--Please be in PLSQL console to run the following scripts
create database wagerdb;

--Switch to wagerdb via plsql console

\connect wagerdb

create schema wager_tran;

-- Table: wager_tran.customers

-- DROP TABLE wager_tran.customers;

CREATE TABLE wager_tran.customers
(
  id serial NOT NULL,
  firstname character(50),
  lastname character(50),
  email character(50),
  address character(256),
  active_account boolean,
  created_at timestamp without time zone DEFAULT NOW(),
  upadted_at timestamp without time zone,
  CONSTRAINT customers_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE wager_tran.customers
  OWNER TO postgres;


INSERT INTO wager_tran.customers(
           id, firstname, lastname, email, address, active_account, 
           created_at, upadted_at)
   VALUES (1, 'andrew', 'nobel', 'andrewnobel@gmail.com', 'Unit 1009, 268 Filnders street', True, 
           current_timestamp, current_timestamp);

INSERT INTO wager_tran.customers(
           id, firstname, lastname, email, address, active_account, 
           created_at, upadted_at)
   VALUES (2, 'steven', 'cooper', 'stevecooper@gmail.com', 'Unit 202, 120 Spencer street', True, 
           current_timestamp, current_timestamp);		   



-- Table: wager_tran.bet_types

-- DROP TABLE wager_tran.bet_types;

CREATE TABLE wager_tran.bet_types
(
  id serial NOT NULL,
  name character varying(100),
  description character varying(256),
  CONSTRAINT bet_types_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE wager_tran.bet_types
  OWNER TO postgres;


  INSERT INTO wager_tran.bet_types(name, description)
   VALUES ('WIN', 'Predict Winner in a race');

  INSERT INTO wager_tran.bet_types(name, description)
  VALUES ('PLACE', 'Predict place of a prop');

  INSERT INTO wager_tran.bet_types(name, description)
  VALUES ('TRIFECTA', 'Predict places of three props');
  
  INSERT INTO wager_tran.bet_types(name, description)
  VALUES ('DOUBLE ', 'Bettors wager on the winners of two races');
  
  INSERT INTO wager_tran.bet_types(name, description)
  VALUES ('QUADDIE', 'A Quaddie (or Quadrella) requires you to pick the winner of four nominated races using any amount of selections');




-- Table: wager_tran.props

-- DROP TABLE wager_tran.props;

CREATE TABLE wager_tran.props
(
  id serial NOT NULL,
  name character varying(100),
  description character varying(256),
  CONSTRAINT props_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE wager_tran.props
  OWNER TO postgres;



  INSERT INTO wager_tran.props(name, description)
   VALUES ('Team A', '');

  INSERT INTO wager_tran.props(name, description)
  VALUES ('Team B', '');

  INSERT INTO wager_tran.props(name, description)
  VALUES ('Team C', '');





-- Table: wager_tran.bets

-- DROP TABLE wager_tran.bets;

CREATE TABLE wager_tran.bets
(
  id serial NOT NULL,
  customer_id integer NOT NULL,
  bet_type_id integer NOT NULL,
  prop_id integer NOT NULL,
  prop_position integer,
  investment double precision NOT NULL,
  created_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone,
  CONSTRAINT bets_pkey PRIMARY KEY (id),
  CONSTRAINT fk_bet_type_id FOREIGN KEY (bet_type_id)
      REFERENCES wager_tran.bet_types (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_customer_id FOREIGN KEY (customer_id)
      REFERENCES wager_tran.customers (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_prop_id FOREIGN KEY (prop_id)
      REFERENCES wager_tran.props (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE wager_tran.bets
  OWNER TO postgres;

-- Index: wager_tran.bets_bet_type_id_idx

-- DROP INDEX wager_tran.bets_bet_type_id_idx;

CREATE INDEX bets_bet_type_id_idx
  ON wager_tran.bets
  USING btree
  (bet_type_id);

-- Index: wager_tran.bets_bet_type_id_investment_idx

-- DROP INDEX wager_tran.bets_bet_type_id_investment_idx;

CREATE INDEX bets_bet_type_id_investment_idx
  ON wager_tran.bets
  USING btree
  (bet_type_id, investment);

-- Index: wager_tran.bets_created_at_idx

-- DROP INDEX wager_tran.bets_created_at_idx;

CREATE INDEX bets_created_at_idx
  ON wager_tran.bets
  USING btree
  (created_at);

-- Index: wager_tran.bets_customer_id_investment_idx

-- DROP INDEX wager_tran.bets_customer_id_investment_idx;

CREATE INDEX bets_customer_id_investment_idx
  ON wager_tran.bets
  USING btree
  (customer_id, investment);


  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (1,1,1,1,NULL,10, current_timestamp);


  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (2,1,1,2,NULL,100, current_timestamp);


  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (3,1,1,3,NULL,15, current_timestamp);

    INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (4,1,2,1,1,10, current_timestamp);

  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (5,1,2,2,2,100, current_timestamp);

  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (6,1,2,3,3,15, current_timestamp);

  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (7,2,3,1,1,10, current_timestamp);

  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (8,2,3,2,2,100, current_timestamp);

  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (9,1,3,3,3,15, current_timestamp);

  INSERT INTO wager_tran.bets(id, customer_id, bet_type_id, prop_id, prop_position, investment, created_at)
  VALUES (10,1,3,3,1,10, current_timestamp);


  