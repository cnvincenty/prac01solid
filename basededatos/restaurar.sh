PGPASSWORD=123qwe dropdb -h localhost -p 5432 -U postgres prac01solidbd
PGPASSWORD=123qwe createdb -h localhost -p 5432 -U postgres prac01solidbd
PGPASSWORD=123qwe psql -h localhost -p 5432 -U postgres -d prac01solidbd -f tablas.sql
PGPASSWORD=123qwe psql -h localhost -p 5432 -U postgres -d prac01solidbd -f datos.sql
