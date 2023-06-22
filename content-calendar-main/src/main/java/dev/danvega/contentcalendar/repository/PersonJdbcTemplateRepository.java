package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.person.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public PersonJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("address"),
                rs.getString("nick_name"));
    }

    public List<Person> getAllPerson() {
        String sql = "SELECT * FROM Person_Info";
        return jdbcTemplate.query(sql, PersonJdbcTemplateRepository::mapRow);
    }

    public void createPerson(Person person) {
        String sql = "INSERT INTO Person_Info (name, age, address, nick_name) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, person.name(), person.age(), person.address(), person.nickName());
    }

    public void updatePerson(int id, Person person) {
        String sql = "UPDATE Person_Info SET name=?, age=?, address=?, nick_name=? WHERE id=?";
        jdbcTemplate.update(sql, person.name(), person.age(), person.address(), person.nickName(), id);
    }

    public void deletePerson(int id) {
        String sql = "DELETE FROM Person_Info WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Person getPerson(int id) {
        String sql = "SELECT * FROM Person_Info WHERE id=?";
        return jdbcTemplate.queryForObject(sql, PersonJdbcTemplateRepository::mapRow, id);
    }

    public List<Person> getPersonByAge(int age) {
        String sql = "SELECT * FROM Person_Info WHERE age=?";
        return jdbcTemplate.query(sql, PersonJdbcTemplateRepository::mapRow, age);
    }

    @PostConstruct
    private void initTableWithSomeDataProgramatically() {
        Person content = new Person(null,
                "Danny Julian",
                28,
                "False Street 123",
                "Dano");

        if (getAllPerson().stream().filter(p -> p.name().equals("Danny Julian")).findFirst().isEmpty()) {
            createPerson(content);
        }

    }
}
