package org.example;

public interface Repository {
    void save(TestClassXml data);
    TestClassXml get(String key);
}
