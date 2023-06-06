package org.example;

public class RepositoryFactory {
    public static Repository createRepository(String type) {
        if (type.equalsIgnoreCase("XML")) {
            return new XmlRepository();
        } else if (type.equalsIgnoreCase("JSON")) {
            return new JsonRepository();
        } else {
            throw new IllegalArgumentException("Invalid repository type: " + type);
        }
    }
}