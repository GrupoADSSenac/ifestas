create database db_ichurrasapp;
create user 'ichurrasapp'@'%' identified by 'ichurrasapp';
grant all on db_ichurrasapp.* to  'ichurrasapp'@'%';