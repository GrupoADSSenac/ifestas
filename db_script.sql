create database db_ichurras;
create user 'ichurrasapp'@'%' identified by 'ichurrasapp';
grant all on db_ichurras.* to  'ichurrasapp'@'%';