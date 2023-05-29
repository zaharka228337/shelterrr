package org.example;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class HibernateDataStorage extends DataStorage {

    // Метод сохранения объекта
    public void saveObject(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    // Метод обновления объекта
    public void updateObject(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    // Метод удаления объекта
    public void deleteObject(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

    // Метод получения объекта по идентификатору
    public Object getObjectById(Class<?> clazz, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object object = session.get(clazz, id);
        session.close();
        return object;
    }


    // Метод выполнения произвольного запроса
    public List<Object> executeQuery(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object> objects = session.createQuery(query).getResultList();
        session.close();
        return objects;
    }
}
