package app.example.springBootHibernate.controller;

import app.example.springBootHibernate.Person;
import app.example.springBootHibernate.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    // Конструктор для инжекции PersonRepository
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Метод-обработчик GET-запроса с маппингом на /persons/by-city
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        // Передаем city в репозиторий для фильтрации
        return personRepository.getPersonsByCity(city);
    }
}



