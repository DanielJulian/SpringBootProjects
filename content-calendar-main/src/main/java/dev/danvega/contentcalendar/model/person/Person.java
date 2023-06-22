package dev.danvega.contentcalendar.model.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Person_Info") // Since the table name is different from the java class name, we use this annotation.
public record Person(
        @Id // We specify what is the primary key which will be used by the Repository
        Integer id,
        String name,
        Integer age,
        String address,
        String nickName
) {
}
