INSERT INTO FILM (ID, DESCRIPTION, TITRE) VALUES (100, 'la description du film', 'le titre du film');
INSERT INTO FILM (ID, DESCRIPTION, TITRE) VALUES (101, 'la description du film1', 'le titre du film1');
INSERT INTO FILM (ID, DESCRIPTION, TITRE) VALUES (102, 'la description du film2', 'le titre du film2');

INSERT INTO ACTEUR (ID, NOM,  PRENOM) VALUES (102, 'Mahdi', 'BL');
INSERT INTO ACTEUR (ID, NOM,  PRENOM) VALUES (104, 'Georges', 'clonney');
INSERT INTO ACTEUR (ID, NOM,  PRENOM) VALUES (105, 'Joaquin', 'Phoenix');

INSERT INTO ACTEUR_FILM (FILM_ID,ACTEUR_ID)VALUES (100, 102);
INSERT INTO ACTEUR_FILM(FILM_ID,ACTEUR_ID) VALUES (100, 104);
INSERT INTO ACTEUR_FILM(FILM_ID,ACTEUR_ID) VALUES (100, 105);

