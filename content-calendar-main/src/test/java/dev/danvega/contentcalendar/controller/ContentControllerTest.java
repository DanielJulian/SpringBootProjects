package dev.danvega.contentcalendar.controller;

import dev.danvega.contentcalendar.model.content.Content;
import dev.danvega.contentcalendar.model.content.Status;
import dev.danvega.contentcalendar.model.content.Type;
import dev.danvega.contentcalendar.repository.ContentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ContentController.class)
class ContentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContentRepository repository;

    @Test
    void findAll() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/content");
        Content content = new Content(1, "Title", "Description", Status.IN_PROGRESS, Type.ARTICLE,
                null, null, "www.google.com");
        List<Content> response = List.of(content);

        when(repository.findAll()).thenReturn(response);
        mvc.perform(request).andExpect(status().isOk());
    }

}