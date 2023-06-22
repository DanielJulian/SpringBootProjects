package dev.danvega.contentcalendar.controller;

import dev.danvega.contentcalendar.model.person.Person;
import dev.danvega.contentcalendar.repository.PersonJdbcTemplateRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonJdbcTemplateRepository repository;

    public PersonController(PersonJdbcTemplateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> findAll() {
        return repository.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Integer id) {
        return repository.getPerson(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody Person person) {
        repository.createPerson(person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Person person, @PathVariable Integer id) {
        if (repository.getPerson(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found.");
        }
        repository.updatePerson(id, person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deletePerson(id);
    }

    @GetMapping("/filter/age/{age}")
    public List<Person> filterByAge(@PathVariable Integer age) {
        return repository.getPersonByAge(age);
    }
}
