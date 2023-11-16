# coffeemachine
Тестовое задание для компании AISA

## Формулировка
Написать web-приложение для управления кофеваркой.
Использовать Spring framework (Spring Boot).
В качестве базы данных использовать PostgeSQL.
В качестве интерфейса использовать SwaggerUI.

# Решение
## Функциональность
- Получение всех кофеварок
- Создание, получение, удаление кофеварки по id
- Включение, выключение кофеварки
- Пополнение ресурсов кофеварки (вода, молотый кофе)
- Варка кофе
- Выливание сваренного кофе

## Использованные технологии
- Spring Boot, MVC, Data JPA
- PostgreSQL, Liquibase
- Modelmapper, Lombok
- Junit5, Hamcrest
- Springdoc
- Docker compose

## Локальный запуск
1. Клонировать репозиторий
```shell
git clone https://github.com/TurboGoose/coffee-machine.git
```

2. Переместиться в папку с приложением
```shell
cd coffee-machine
```

3. Запустить Docker compose
```shell
docker compose up
```

Приложение запустится по адресу http://localhost:8080/swagger-ui