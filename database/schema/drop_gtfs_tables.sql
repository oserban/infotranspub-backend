/*
 Order of creation 
DirectionType, TransportType
City, Agency
CityAgency
Route
Trip
Stops

Drop order
Stops
Trip
Route
CityAgency
City, Agency
DirectionType, TransportType
*/

-- The order of the drop is : first index, second table, third sequence

DROP INDEX IF EXISTS I_Stops;
DROP TABLE IF EXISTS T_Stops;
DROP SEQUENCE S_Stops;


DROP INDEX IF EXISTS I_Trips;
DROP TABLE IF EXISTS T_Trips;
DROP SEQUENCE S_Trips;

DROP INDEX IF EXISTS I_Routes;
DROP TABLE IF EXISTS T_Routes;
DROP SEQUENCE S_Routes;

DROP INDEX IF EXISTS I_CityAgency;
DROP TABLE IF EXISTS T_CityAgency;

DROP INDEX IF EXISTS I_City;
DROP TABLE IF EXISTS T_City;
DROP SEQUENCE S_City;

DROP INDEX IF EXISTS I_Agency;
DROP TABLE IF EXISTS T_Agency;
DROP SEQUENCE S_Agency;

DROP INDEX IF EXISTS I_DirectionType;
DROP TABLE IF EXISTS T_DirectionType;

DROP INDEX IF EXISTS I_TransportType;
DROP TABLE IF EXISTS T_TransportType;



