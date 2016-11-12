Proiectul DBTools contine unelte pentru importul fisierelor GTFS in baza de date SQL
Orice fisier GTFS de pe http://transitfeeds.com/feeds poate fi importat in baza prin dbtools

Pentru moment, fisierul de import  trebuie sa se numeasca sfmta.gtfs si sa fie in folderul in care se afla pom.xml


Procedura de import

Nota: dupa import vor fi create tablele tmp_xxxxx unde xxxxx corespunde fisierului txt din GTFS
De aceea, inainte de a importa fisierul GTFS, trebuie sterse din baza de date tabelele tmp_xxxxxx existente
Tabelele tmp_xxx sunt o etapa temporara

Comenzile pentru import

Optional

cd infotranspub-backend  # repo
cd database/dbtools	# proiect DBTools


Obligatoriu pentru import in baza de date

java -cp ./target/dbtools-1.0-SNAPSHOT.jar  ro.gov.ithub.infotranspub.dbtools.app.GTFSFileImportApp


