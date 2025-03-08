package app.example.springBootHibernate.repository;

import app.example.springBootHibernate.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String>{
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<Person> getPersonsByCity(String city) {
//        // Получаем всех пользователей из базы данных
//        List<Person> allPersons = entityManager.createQuery("SELECT p FROM Person p", Person.class)
//                .getResultList();
//
//        // Фильтруем пользователей по городу
//        allPersons.removeIf(person -> !person.getCityOfLiving().equalsIgnoreCase(city));
//
//        return allPersons;
//    }
// Метод для поиска всех людей по городу
List<Person> findByCityOfLiving(String city);

    // Метод для поиска людей по возрасту, сортированных по возрастанию
    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    // Метод для поиска людей по имени и фамилии (Optional)
    Optional<Person> findByNameAndSurname(String name, String surname);

}


