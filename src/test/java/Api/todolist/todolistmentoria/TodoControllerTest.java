package Api.todolist.todolistmentoria;

import Api.todolist.todolistmentoria.model.Todo;
import Api.todolist.todolistmentoria.todocontroller.TodoController;
import Api.todolist.todolistmentoria.todoservice.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TodoController todoController;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TodoService todoService;

    @Test
    public void testCreateTodo() throws Exception {


        Todo newTodo = new Todo();

        when(todoService.createTodo(any(Todo.class))).thenReturn(newTodo);

        mockMvc.perform(post("/api/v1/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTodo)));
    }
//
//    @Test
//    public void testGetAllTodo() {
//        Pageable pageable = Pageable.ofSize(10);
//        List<Todo> todos = new ArrayList<>();
//        when(todoService.listAllTodo(pageable)).thenReturn((List<Todo>) Page.empty());
//
//        Page<Todo> result = todoController.List(pageable);
//
//        assertNotNull(result);
//        assertTrue(result.isEmoty());
//    }

    @Test
    public void testGetTodoById() throws Exception {
        Long todoId = 1L;
        Todo todo = new Todo();

        when(todoService.findTodoById(todoId)).thenReturn(ResponseEntity.ok(todo));

    }

//    @Test
//    public void testUpdateTodoById() throws Exception {
//        Long todoId = 1L;
//        Todo updatedTodo = new Todo();
//
//        when(todoService.updateTodoById(any(Todo.class), eq(todoId)))
//                .thenReturn(ResponseEntity
//                        .ok(updatedTodo));
//
//        mockMvc.perform((RequestBuilder) put("/api/v1/todos/{id}", todoId)
//                .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.valueOf(objectMapper
//                                .writeValueAsString(updatedTodo))))
//                .andExpect(status()
//                        .isOk());
//    }

    @Test
    public void testDeleteTodoById() throws Exception {
        Long todoId = 1L;

        when(todoService.deleteById(todoId)).thenReturn(ResponseEntity.noContent().build());

        mockMvc.perform(delete("/api/v1/todos/{id}", todoId))
                .andExpect(status().isNoContent());
    }



}

