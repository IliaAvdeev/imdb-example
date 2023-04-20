package org.imdb.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.imdb.impl.repository.UserRepository;
import org.imdb.model.domain.User;
import org.imdb.model.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private UserRepository userRepository;

    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        UUID id = UUID.randomUUID();
        User user = new User(id, "test@test.com", "nickName");
        userDto = new UserDto(id, "test@test.com", "nickName");

        doReturn(user).when(userRepository).save(any());
    }

    @Test
    public void testCreateUser() throws Exception {
        mvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDto)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}