INSERT INTO character(character_name, alias, gender, picture_url, test) VALUES('Loki Odinson', 'Loki', 'God', 'placeholder', 1);
INSERT INTO character(character_name, alias, gender, picture_url, test) VALUES('Thor Odinson', 'Thor', 'God', 'placeholder', 2);

INSERT INTO franchise(franchise_name, description) VALUES('Marvel Cinematic Universe', 'An American media franchise and shared universe centered on a series of superhero films produced by Marvel studios');

INSERT INTO movie(movie_title, genre, release_year, director, poster_url, trailer_url, franchise_id) VALUES('Thor: Ragnarok', 'Action, Superhero, Comedy', 2017, 'Taika Waititi', 'link to poster', 'link to trailer', 1);
INSERT INTO movie(movie_title, genre, release_year, director, poster_url, trailer_url, franchise_id) VALUES('Thor: The Dark World', 'Action, Superhero, Comedy', 2013, 'Alan Taylor', 'link to poster', 'link to trailer', 1);
INSERT INTO movie(movie_title, genre, release_year, director, poster_url, trailer_url, franchise_id) VALUES('Thor: Love and Thunder', 'Action, Superhero, Comedy', 2022, 'Taika Waititi', 'link to poster', 'link to trailer', 1);

INSERT INTO movies_characters(movie_id, character_id) VALUES (1, 1);
INSERT INTO movies_characters(movie_id, character_id) VALUES (1, 2);
INSERT INTO movies_characters(movie_id, character_id) VALUES (2, 2);
INSERT INTO movies_characters(movie_id, character_id) VALUES (3, 1);
INSERT INTO movies_characters(movie_id, character_id) VALUES (3, 2);