delete from FILMES_PALAVRAS_CHAVES;
delete from PALAVRAS_CHAVES;
delete from FILMES;
INSERT INTO PALAVRAS_CHAVES
values
(100, 'TESTE'),
(101, 'TESTE 1'),
(102, 'TESTE 2');


INSERT INTO FILMES
(id, titulo)
values
(133, 'Senhor dos Aneis'),
(134, 'Senhor dos Aneis 2');

INSERT INTO FILMES_PALAVRAS_CHAVES
(id_filme, id_palavra_chave)
values
(133, 100),
(133, 101),
(133, 102),
(134, 100);