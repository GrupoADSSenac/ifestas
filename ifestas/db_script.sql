create database db_ifestasapp;
create user 'ifestasapp'@'%' identified by 'ifestasapp';
grant all on db_ifestasapp.* to  'ifestasapp'@'%';