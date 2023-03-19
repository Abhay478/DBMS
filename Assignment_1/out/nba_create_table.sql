CREATE TABLE teams (
	team CHAR(3) NOT NULL,
  	location VARCHAR NOT NULL,
  	name VARCHAR,
  	leag CHAR(1) NOT NULL,
  	PRIMARY KEY (team, leag)
);

CREATE TABLE players (
	ilkid TEXT NOT NULL,
	firstname TEXT,
	lastname TEXT,
	position char(1),
	firstseason INTEGER,
	lastseason INTEGER,
	h_feet REAL,
	h_inches INTEGER,
	weight INTEGER,
	college TEXT,
	birthdate char(19),
	primary key (ilkid)
);

-- REMOVE FOR NEWR_NBADB.DB

-- CREATE TABLE fk_check (
-- 	ilk TEXT,
-- 	ilk_ws TEXT primary key,
-- 	foreign key (ilk) references players(ilkid)
-- );
-- .mode csv
-- .import --skip 1 /Users/abhay/Code/DBMS/Assignment_1/players.csv players 
-- insert into fk_check (ilk) select ilkid from players;
-- update fk_check set ilk_ws = ilk || " " where length(ilk) = 9;
-- update fk_check set ilk_ws = ilk || "  " where length(ilk) = 8;

CREATE TABLE coaches_career (
	coachid TEXT not null,
	firstname TEXT,
	lastname TEXT,
	season_win INTEGER,
	season_loss INTEGER,
	playoff_win INTEGER,
	playoff_loss INTEGER,
	primary key (coachid)
);

CREATE TABLE coaches_season (
	coachid TEXT NOT NULL,
	year INTEGER,
	yr_order INTEGER,
	firstname TEXT,
	lastname TEXT,
	season_win INTEGER,
	season_loss INTEGER,
	playoff_win INTEGER,
	playoff_loss INTEGER,
	team char(3),
	primary key (coachid, year, yr_order)
); 

CREATE TABLE player_playoffs (
	ilkid TEXT NOT NULL,
	year INTEGER,
	firstname TEXT,
	lastname TEXT,
	team char(3),
	leag char(1),
	gp INTEGER,
	minutes INTEGER,
	pts INTEGER,
	dreb INTEGER,
	oreb INTEGER,
	reb INTEGER,
	asts INTEGER,
	stl INTEGER,
	blk INTEGER,
	turnover INTEGER,
	pf INTEGER,
	fga INTEGER,
	fgm INTEGER,
	fta INTEGER,
	ftm INTEGER,
	tpa INTEGER,
	tpm INTEGER,
	primary key (ilkid, year, team),
	-- REMOVE FOR NEWR_NBADB.DB
	-- foreign key (ilkid) references fk_check (ilk_ws),
	foreign key (ilkid) references players (ilkid),
	foreign key (team, leag) references teams (team, leag)
);

CREATE TABLE player_playoffs_career (
        ilkid TEXT NOT NULL,
        firstname TEXT,
        lastname TEXT,
        leag char(1),
        gp INTEGER,
        minutes INTEGER,
        pts INTEGER,
        dreb INTEGER,
        oreb INTEGER,
        reb INTEGER,
        asts INTEGER,
        stl INTEGER,
        blk INTEGER,
        turnover INTEGER,
        pf INTEGER,
        fga INTEGER,
        fgm INTEGER,
        fta INTEGER,
        ftm INTEGER,
        tpa INTEGER,
        tpm INTEGER,
	primary key (ilkid, leag),
	-- REMOVE FOR NEWR_NBADB.DB
	-- foreign key (ilkid) references fk_check (ilk_ws)
	foreign key (ilkid) references players (ilkid)
); 

CREATE TABLE player_regular_season (
        ilkid TEXT NOT NULL,
        year INTEGER,
        firstname TEXT,
        lastname TEXT,
        team char(3),
        leag char(1),
        gp INTEGER,
        minutes INTEGER,
        pts INTEGER,
        dreb INTEGER,
        oreb INTEGER,
        reb INTEGER,
        asts INTEGER,
        stl INTEGER,
        blk INTEGER,
        turnover INTEGER,
        pf INTEGER,
        fga INTEGER,
        fgm INTEGER,
        fta INTEGER,
        ftm INTEGER,
        tpa INTEGER,
        tpm INTEGER,
	primary key (ilkid, year, team),
	foreign key (ilkid) references players(ilkid)
	foreign key (team, leag) references teams (team, leag)
);


CREATE TABLE player_regular_season_career (
        ilkid TEXT NOT NULL,
        firstname TEXT,
        lastname TEXT,
        leag char(1),
        gp INTEGER,
        minutes INTEGER,
        pts INTEGER,
        dreb INTEGER,
        oreb INTEGER,
        reb INTEGER,
        asts INTEGER,
        stl INTEGER,
        blk INTEGER,
        turnover INTEGER,
        pf INTEGER,
        fga INTEGER,
        fgm INTEGER,
        fta INTEGER,
        ftm INTEGER,
        tpa INTEGER,
        tpm INTEGER,
	primary key (ilkid, leag),
	foreign key (ilkid) references players(ilkid) 
);


