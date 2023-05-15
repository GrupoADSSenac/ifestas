# Aplicação Ichurras

## Necessário instalação: 
* Java 11 ou superior
* Maven
* Banco de Dados MYSQL 8.0.32
* NodeJs versão 16 ou superior

## Passos para preparar o banco de dados
* Dar o start no banco de dados mysql.
* Abrir prompt de comando e executar os comandos abaixo:
* mysql -u root -p
* Entrar com a senha do usuário ROOT da máquina
* Isto fará com que o usuário ROOT se conecte ao banco de dados MYSQL

### No prompt de comandos do mysql, execute como segue abaixo: 

* mysql> create database db_ichurrasapp;

* mysql> create user 'ichurrasapp'@'%' identified by 'ichurrasapp';

* *mysql> grant all on db_ichurrasapp.* to  'ichurrasapp'@'%';


O comando [create database] criará o banco de dados da aplicação chamado db_ichurrasapp.

O comando [create user] irá criar o usuário ichurras utilizado na aplicação back-end.

o comando [grant all] irá conceder acesso ao usuário [root] a todas as operações no banco de dados db_ichurrasapp.



## Subindo a aplicação back-end


No prompt de comando, vá até a pasta ichurras. Nela, execute o comando maven abaixo:

./mvnw spring-boot:run

isto irá executar a aplicação que subirá na porta 8080 do localhost.



## Abrir aplicação front end no browser...


Executar os comandos no prompt.
Navegue até a pasta /frontEnd/angular e execute os comandos abaixo:
* npm install
* npm start

Fora do prompt de comando, abra a pasta /frontEnd e a pagina index.html no browser desejado.
