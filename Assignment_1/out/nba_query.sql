-- does not change for any db


-- [10 points] Use table players to find the count of the number of players in each position. 
.mode box
select position, count(ilkid) from players group by position;
-- C,579
-- F,1528
-- G,1465

-- [10 points] Find the top-5 most productive years, which is determined based on the total number 
-- of games played (gp) by all the players, including both regular seasons and playoffs, for each year. 
-- Solve ties by preferring chronologically older years, and print only the years.

with T as (select year, sum(gp) as games from player_playoffs group by year order by games desc, year),
U as (select year, sum(gp) as games from player_regular_season group by year order by games desc, year)
select Y from (select T.year as Y, T.games + U.games as G from T, U where T.year = U.year order by G desc, Y)
limit 5;

-- 2004
-- 2003
-- 1997
-- 1995
-- 1996

-- After foreign key shit.


-- 2004
-- 1999
-- 2002
-- 2003
-- 1997


-- [10 points] In the table player_regular_season_career, add a new column eff (efficiency rating), which is defined as follows:

-- 	eff = (pts + reb + asts + stl + blk − ((fga − fgm) + (fta − ftm) + turnover))

alter table player_regular_season_career add eff INTEGER;
update player_regular_season_career set eff = pts + reb + asts + stl + blk + fgm + ftm - fga - fta - turnover;


-- Among the players who have played more than 500 games, find the top-10 most efficient players. 

with T as (select ilkid, sum(gp) as S,sum (eff) as E from player_regular_season_career group by ilkid)
select T.ilkid from T where T.S > 500 order by T.E desc limit 10;

-- ABDULKA01
-- CHAMBWI01
-- MALONKA01
-- MALONMO01
-- GILMOAR01
-- OLAJUHA01
-- ROBEROS01
-- ERVINJU01
-- HAYESEL01
-- JORDAMI01

-- No change after foreign key shit.


-- [15 points] Find the number of players who have played more regular season games in the year 1990 than regular season games in any other year in their career. 

with T as (select ilkid, sum(gp) as S, year from player_regular_season group by ilkid, year order by ilkid, S)
select count (*) from T as _T where year = 1990 and not exists (select * from T as TT where TT.ilkid = _T.ilkid and TT.year != 1990 and TT.S >= _T.S);


-- 57

-- After foreign key shit.
-- 55


-- [15 points] Use table player_regular_season_career to find the all-time best players. 
-- Use the two attributes gp (games played) and eff (efficiency rating) to compare players. 
-- For two players p1 and p2, we define that p1 dominates p2 if and only if p1 has a higher gp and eff value than p2.

-- Find a set of players (ilkid, firstname, lastname, gp, eff) P, so that each player in P is not 
-- dominated by any other player in the table player_regular_season_career. Return the output in ascending order of ilkid. 

with T as (select ilkid, sum(gp) as S, eff, firstname as F, lastname as L from player_regular_season_career group by ilkid)
select * from T where eff in (select eff from T order by eff desc limit 1) or S in (select S from T order by S desc limit 1);

-- ABDULKA01,1560,48247,Kareem,Abdul-jabbar
-- PARISRO01,1611,30738,Robert,Parish

-- No change after foreign key shit.
