# siw-galleria
Si vuole realizzare il sistema informativo su Web per la gestione di una piccola galleria d’arte. Possono accedere al sistema utenti generici e un amministratore.
L’amministratore, previa autenticazione, può inserire e rimuovere le informazioni relative alle opere d’arte presenti nella galleria; per semplicità supponiamo che le opere d’arte siano quadri e che per ciascuno di essi siano di interesse il titolo, l’anno in cui è stato realizzato, la tecnica, le dimensioni, l’autore. Dell’autore sono di interesse nome, cognome, nazionalità data di nascita e data di morte.
L’utente generico può accedere alle informazioni della galleria attraverso diversi percorsi di navigazione, opportunamente predisposti (ad esempio, per autore, oppure per anno, etc.).


Studenti:

* Marco Oliva
* Jerin George Mathew



Casi d'uso:

>Caso d'uso UC1: Inserimento di un nuovo Quadro - Attore primario: un Amministratore    
Un Amministratore autenticato usa il Sistema per inserire un nuovo quadro. Il Sistema restituisce una form. L'Amministratore compila la form e la invia al Sistema. Se i dati 	inseriti dall'Amministratore sono validi il Sistema registra il nuovo Quadro e mostra un riepilogo delle informazioni inserite altrimenti mostra nuovamente la form con dei 	opportuni messaggi di errore.

>Caso d'uso UC2: Modifica di un Quadro - Attore primario: un Amministratore
Un Amministratore autenticato usa il Sistema per modificare un quadro esistente. L'Amministratore seleziona uno dei Quadri registrati nel Sistema e preme sul pulsante 	"modifica".  Il Sistema restituisce una form. L'Amministratore compila la form e la invia al Sistema. Se i dati inseriti sono validi il Sistema aggiorna i dati del Quadro 	esistente e mostra la lista aggiornata dei Quadri altrimenti mostra nuovamente la form con dei opportuni messaggi di errore.

>Caso d'uso UC3: Cancellazione di un Quadro - Attore primario: un Amministratore
Un Amministratore autenticato usa il Sistema per cancellare un quadro.L'Amministratore sceglie uno dei Quadri mostrati dal sistema e clicca sul tasto "cancella". Il Sistema 	cancella il Quadro selezionato e mostra la lista aggiornata dei Quadri presenti.

>Caso d'uso UC4: Consultazione dei Quadri presenti nel Sistema - Attore: un Utente del Sistema
Un Utente vuole visualizzare i Quadri presenti nel Sistema. Il Sistema restituisce la lista di Quadri che ha registrato. L'Utente può selezionare un Quadro in particolare e 	visualizzarne le informazioni in dettaglio.


Tabelle presenti nel database:

(Le primary keys sono in corsivo)


| Quadro |      |      |         |           |        |         |            |
|:------:|:----:|:----:|:-------:|:---------:|:------:|:-------:|:----------:|
| _id_   | nome | anno | altezza | larghezza | autore | tecnica | pictureUrl |

Con vincolo di integrita referenziale tra autore e la table Autore e tra tecnica e la table Tecnica

| Autore |      |         |               |             |             |
|:------:|:----:|:-------:|:-------------:|:-----------:|:-----------:|
| _id_   | nome | cognome | dataDiNascita | dataDiMorte | nazionalita |

Con vincolo di integrita referenziale tra nazionalita e la table Nazione

| Nazione |             |
|:-------:|:-----------:|
| _id_    | nomeNazione |

| Tecnica |      |             |
|:-------:|:----:|:-----------:|
| _id_    | nome | descrizione |

| Amministratore |          |          |
|:--------------:|:--------:|:--------:|
| _id_           | username | password |

Informazioni sullo strato di persistenza: Le politiche di FETCH  e CASCADE usate sono quelle di default

Tecnologie utilizzate:
* Progetto realizzato con Spring Boot
* Autenticazione con Spring Security
* JPA framework per la persistenza 
* Utilizzo di Thymeleaf template engine
* Deploy su AWS EC2 (34.211.140.78:8080 -Credenziali: username:user, password: pass)
* Salvataggio dei dati su AWS RDS (PostgresSQL database engine)
* Utilizzo di Javascript e Ajax e di controller REST per mostrare i quadri nella index
