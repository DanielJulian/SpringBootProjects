package dev.danvega.contentcalendar.model.content;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

// This class is also called an Entity, because its used to map a Java object to a DB Table
public record Content(
        @Id
        Integer id,
        String title,
        @Column(value = "description")
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
