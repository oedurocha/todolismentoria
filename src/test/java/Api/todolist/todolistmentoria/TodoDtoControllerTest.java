package Api.todolist.todolistmentoria;

import Api.todolist.todolistmentoria.dto.TodoDto;
import Api.todolist.todolistmentoria.todocontroller.TodoController;
import Api.todolist.todolistmentoria.todoservice.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoDtoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoController todoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTodo() throws Exception {
        TodoDto newTodo = new TodoDto();

        when(todoService.createTodo(any(TodoDto.class))).thenReturn(newTodo);

        mockMvc.perform(post("/api/v1/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTodo)))
                .andReturn();
    }

    @Test
    public void testGetAllTodo() {
        List<TodoDto> todos = new ArrayList<>();
        todos.add(new TodoDto());
        todos.add(new TodoDto());

        Mockito.when(todoService.listAllTodo()).thenReturn(todos);
        List<TodoDto> result = todoController.getAllTodo();

        verify(todoService).listAllTodo();
        assertEquals(todos, result);
    }

    @Test
    public void testGetTodoById() {
        TodoDto todo = new TodoDto();
        Long todoId = 1L;
        Mockito.when(todoService.findTodoById(todoId)).thenReturn(ResponseEntity.ok(todo));
        ResponseEntity<TodoDto> result = todoController.getTodoById(todoId);

        verify(todoService).findTodoById(todoId);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(todo, result.getBody());
    }

    @Test
    public void testUpdateTodoById() {
        Long todoId = 1L;
        TodoDto updatedTodo = new TodoDto();
        Mockito.when(todoService.updateTodoById(updatedTodo, todoId)).thenReturn(ResponseEntity.ok(updatedTodo));
        ResponseEntity<TodoDto> result = todoController.updateTodoById(todoId, updatedTodo);

        verify(todoService).updateTodoById(updatedTodo, todoId);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(updatedTodo, result.getBody());
    }

    @Test
    public void testDeleteTodoById() {
        Long todoId = 1L;
        Mockito.when(todoService.deleteById(todoId)).thenReturn(ResponseEntity.noContent().build());
        ResponseEntity<Object> result = todoController.deleteTodoById(todoId);

        verify(todoService).deleteById(todoId);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

}

