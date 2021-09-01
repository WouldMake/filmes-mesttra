INSERT INTO PALAVRAS_CHAVES
values
(100, 'TESTE');

INSERT INTO FILMES
(id, titulo)
values
(133, 'Senhor dos Aneis'),
(134, 'Senhor dos Aneis 2');

INSERT INTO FILMES_PALAVRAS_CHAVES
(id_filme, id_palavra_chave)
values
(133, 100),
(134, 100);