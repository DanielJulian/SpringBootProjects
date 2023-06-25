package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.person.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // To use the actual database instead of the in-memory one
class PersonJdbcTemplateRepositoryTest {

    private JdbcTemplate jdbcTemplate;
    private PersonJdbcTemplateRepository repository;

    @Autowired
    public PersonJdbcTemplateRepositoryTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.repository = new PersonJdbcTemplateRepository(jdbcTemplate);
    }

    @Test
    void getAllPerson() {
        List<Person> personList = repository.getAllPerson();
        assertEquals(1, personList.size());
    }

}