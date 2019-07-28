#SpringBoot #JpaRepository #Hibernate #SpringData #H2 #REST #JSON #Lombok #CRUD #Maven #Eclipse
----
Cruise Logger - version REST
---
Trzecia wersja loggera rejsów żeglarskich. Aplikacja umożliwia wykonywanie operacji CRUD(zapisu/odczytu/aktualizacji/usuwania) na bazie danych H2. REST'owa implementacja aplikacji Cruise-Log wykorzystująca Spring Boot oraz Spring Data (JpaRepository). Aplikacja obsługuje zapytania w formacie JSON. Brak warstwy widoku - aby korzystać z usługi należy użyć metod HTTP (GET/POST/PUT/DELETE) dostępnych np. za pomocą aplikacji Postman. Do testowania aplikacji przewidziano generator losowych rejsów umożliwiający utworzenie przykładowych danych.

/init (GET) - dodaje 5 rekordów do bazy danych <br>
/cruises (GET) - wyświetla listę rejsów (JSON)<br>
/cruises.{id} (GET) - wyświetla rejs o podanym id (JSON)<br>
/addCruise (POST) - zapisuje nowy rejs (wymagany JSON)<br>
/addRandomCruise (POST) - dodaje losowy rejs do bazy danych<br>
/cruises/{id} (PUT) - aktualizuje dane w istniejącym rejsie (wymagany JSON)<br>
/cruises/{id} (DELETE) - usuwa rejs o podanym id z bazy danych

----------

Third version of app that allows you to log your sailing cruises. Application provide CRUD operations (Create/Read/Update/Delete) on H2 database.
REST immplementation on CruiseLog. Application uses JSON format. Version without view layer - to use it you need to use Http methods (GET/POST/PUT/DELETE) provided by e.g. Postman API. 
For testing purposes there is random-cruise service that can create sample data.

/init (GET) - inject 5 samples data to DB<br>
/cruises (GET) - list cruises (JSON)<br>
/cruises.{id} (GET) - retrieve cruise with given id<br>
/addCruise (POST) - save new cruise (JSON required)<br>
/addRandomCruise (POST) - add one sample to DB<br>
/cruises/{id} (PUT) - update data of existing cruise (JSON required)<br>
/cruises/{id} (DELETE) - delete cruise with given id from DBample data.
