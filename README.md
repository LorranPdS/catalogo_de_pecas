# catalogo_de_pecas
FUNCIONAMENTO DO CATÁLOGO DE PEÇAS
Code Challenge - Zen S.A.

1. Tecnologias utilizadas
Foram utilizadas para a criação do sistema as seguintes tecnologias:
Java 8
Thymeleaf
PostgreSQL
HTML5/CSS3
Spring Boot

2. Detalhes gerais
Ao fazer o teste, importante lembrar de criar o banco de dados com o nome 'estoquezensa',
username 'postgres' e password 'admin', conforme configurado no arquivo application.properties
do projeto.

3. Utilização do sistema

3.1 - Ao subir o projeto, basta colocar o endereço do repositório local na URL
(localhost:8080 no meu caso) para ser direcionado à página Index do sistema.

3.2 - Estando na página Index, clicar no link 'clique aqui' para ser direcionado para a página
que conterá o cadastro para as peças e o catálogo com o que já está registrado.

3.3 - Estando na página para o cadastro de peça, inserir o nome da peça, veículo de aplicação da
peça, peso líquido e peso bruto. Os campos 1, 3 e 4 são obrigatórios e o campo 3 não pode ter
valor maior que o campo 4. Caso você clique no botão 'SALVAR' sem que essas exigências sejam
atendidas, o sistema não terá acesso à camada Back-End. Se atendidas, será mostrada uma mensagem
em vermelho no canto superior esquerdo confirmando que o registro foi salvo no banco de dados.

3.4 - Logo abaixo, serão listados todos os produtos já cadastrados por você no banco de dados com
as seguintes colunas:
3.4.1 - Nome da Peça: os dados estão ordenados por esses nomes
3.4.2 - Veículo: veículo de aplicação da peça informada na primeira coluna
3.4.3 - Peso Líquido
3.4.4 - Peso Bruto
3.4.5 - Ação: nessa coluna estarão os links descritos como 'Apagar'. Basta clicar no link 'Apagar'
para que os dados da linha sejam removidos do banco de dados e será mostrada uma mensagem em
vermelho no canto superior esquerdo da página confirmando que a peça foi removida dos registros
do banco de dados.

3.5 - Por fim, foi colocada uma paginação com um limite máximo de 10 registros por página.
Caso queira acessar a próxima página de dados registrados no banco de dados, basta clicar em
'Próximo', e para retornar à página anterior, clique em 'Anterior'.
