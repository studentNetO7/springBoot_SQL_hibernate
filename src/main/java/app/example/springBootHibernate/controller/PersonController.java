package app.example.springBootHibernate.controller;

import app.example.springBootHibernate.Person;
import app.example.springBootHibernate.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    // Конструктор для инжекции PersonRepository
    public PersonController(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

//    // Метод-обработчик GET-запроса с маппингом на /persons/by-city
//    @GetMapping("/persons/by-city")
//    public List<Person> getPersonsByCity(@RequestParam String city) {
//        // Передаем city в репозиторий для фильтрации
//        return personRepository.getPersonsByCity(city);
//    }
// Метод для получения людей по городу
@GetMapping("/persons/by-city")
public List<Person> getPersonsByCity(@RequestParam String city) {
    return personRepository.findByCityOfLiving(city);
}
    // Метод для получения людей по возрасту, меньше заданного возраста, отсортированных по возрастанию
    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam Integer age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    // Метод для получения человека по имени и фамилии
    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}



