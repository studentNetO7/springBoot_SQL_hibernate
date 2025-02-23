package app.example.springBootHibernate.repository;

import app.example.springBootHibernate.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        // Получаем всех пользователей из базы данных
        List<Person> allPersons = entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();

        // Фильтруем пользователей по городу
        allPersons.removeIf(person -> !person.getCityOfLiving().equalsIgnoreCase(city));

        return allPersons;
    }


}


