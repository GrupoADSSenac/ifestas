# Aplicação Ichurras

## Necessário instalação: 
* Java 11 ou superior
* Maven
* Banco de Dados MYSQL 8.0.32

## Passos para subir a aplicação
* Abrir prompt de comando e executar os comandos abaixo:
* mysql -u root -p
* Entrar com a senha do usuário ROOT da máquina
* Isto fará com que o usuário ROOT se conecte ao banco de dados MYSQL

### No prompt de comandos do mysql, execute como segue abaixo: 

#### mysql> create database db_ichurras;

#### mysql> create user 'ichurrasapp'@'%' identified by 'ichurrasapp';

#### mysql> grant all on db_ichurras.* to  'ichurrasapp'@'%';



O comando [create database] criará o banco de dados da aplicação chamado db_ichurras.

O comando [create user] irá criar o usuário ichurras utilizado na aplicação back-end.

o comando [grant all] irá conceder acesso ao usuário [root] a todas as operações no banco de dados db_ichurras.



## Subindo a aplicação

No prompt de comando, vá até a pasta ichurras. Nela, execute o comando maven abaixo:
./mvnw spring-boot:run
isto irá executar a aplicação que subirá na porta 8080 do localhost.

