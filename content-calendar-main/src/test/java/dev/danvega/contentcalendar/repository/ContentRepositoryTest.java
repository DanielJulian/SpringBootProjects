package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.content.Content;
import dev.danvega.contentcalendar.model.content.Status;
import dev.danvega.contentcalendar.model.content.Type;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ContentRepositoryTest {

    @Autowired
    private ContentRepository contentRepository;

    @Test
    void findAllByContentType() {
        Content content = new Content(null, "Title", "Description", Status.IN_PROGRESS, Type.ARTICLE,
                LocalDateTime.now(), null, "www.google.com");

        contentRepository.deleteAll();
        contentRepository.save(content);

        List<Content> contents = contentRepository.findAllByContentType(content.contentType().name());

        Assertions.assertThat(contents.size()).isEqualTo(1);
        Assertions.assertThat(contents.get(0).id()).isGreaterThanOrEqualTo(0);
    }
}