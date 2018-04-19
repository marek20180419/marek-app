Nie miałem jeszcze czasu dodać testów. Jeśli jest potrzeba mogę je dodać.

Demo: https://youtu.be/5Tj9bKAGs6I

Ogólnie stan na teraz jest taki:
- Aplikacja posiada 3 moduły:
    - marek-java - część serwerowa - implementacja w Javie (Spring boot)
    - marek-scala - część serwerowa - implementacja w Scali (Spray + Akka http)
    - marek-web - aplikacja SSO w AngularJS, która wyświetla drzewo zgodnie z założoną strukturą. Posiada trzy opcje (3 przyciski):
        - Mock (default) - wyświetla drzewko zapisane w strukturze pliku (hardcoded)
        - Java - pobiera drzewo z części serwerowej Javy - wymaga uruchomionego serwera marek-java (mvn install spring-boot:run)
        - Scala - pobiera drzewo z części serwerowej Scala - wymaga uruchomionego serwera marek-java (sbt run)

Drzewa w częściach serwerowych budowane są przy starcie serwerów na podstawie dostarczonego pliku test1.xlsx, a więc rozwiązują one zadanie 1.
Zadanie dwa to prezentacja na podstawie modułu marek-web