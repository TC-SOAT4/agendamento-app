
- Criação do banco de dados

```
$ docker run --detach --name mariadb-agendamento-db -p 3306:3306 --env MARIADB_DATABASE=agendamentodb --env  MARIADB_USER=mariadb --env MARIADB_PASSWORD=root --env MARIADB_ROOT_PASSWORD=root mariadb:latest
```



