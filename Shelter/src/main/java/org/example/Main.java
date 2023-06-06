package org.example;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;

import java.sql.*;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//          UnitOfWork
//        try (UnitOfWork unitOfWork = new UnitOfWork()) {
//            // Получите подключение к базе данных из контекста
//            Connection connection = unitOfWork.getConnection();
//
//            // Выполните необходимые операции с базой данных
//
//            // Если все операции прошли успешно, подтвердите изменения
//            unitOfWork.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //  JSON
        // Сериализация объекта в JSON
//        User user = new User("Zakhar", "Lenina 92", "40", "8-983-150-59-10");
//        String json = JsonFileUtils.serialize(user);
//        System.out.println(json); // Вывод JSON-строки
//
//        // Десериализация JSON в объект
//        json = "{\"name\":\"Zakhar\",\"address\":\"Lenina 92\",\"salary\":\"40\",\"phone\":\"8-983-150-59-10\"}";
//
//        User deserializedUser = JsonFileUtils.deserialize(json, User.class);
//        if (deserializedUser != null) {
//            System.out.println(deserializedUser.getName());
//            System.out.println(deserializedUser.getAddress());
//            System.out.println(deserializedUser.getSalary());
//            System.out.println(deserializedUser.getPhone());
//        }
            //API
         SpringApplication.run(Main.class, args);

         //  Фабрика репозиториев
        String repositoryType = "XML"; // Здесь можно указать "XML" или "JSON"

        Repository repository = RepositoryFactory.createRepository(repositoryType);

        // Используем репозиторий для сохранения или получения данных
        repository.save(new TestClassXml(/* Данные для сохранения */));
        TestClassXml data = repository.get(/* Ключ или условие для получения данных */);

        // Продолжаем работу с данными...
    }
}