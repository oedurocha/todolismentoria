package Api.todolist.todolistmentoria;

import Api.todolist.todolistmentoria.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

public class TodoTodoTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidTodo() {
        Todo todo = new Todo();
        todo.setNomeDoCliente("Cliente");
        todo.setNomeDaTarefa("Tarefa");
        todo.setDescricaoDaTarefa("Descrição");
        todo.setDataDaConclusao(LocalDateTime.now());
        todo.setStatus("Em Progresso");
        todo.setResponsavelPelaTarefa("Responsável");
        todo.setSolicitante("Solicitante");
        Set<ConstraintViolation<Todo>> violations = validator.validate(todo);
        assert(violations.isEmpty());
    }

    @Test
    public void testInvalidTodo() {
        Todo todo = new Todo();
        Set<ConstraintViolation<Todo>> violations = validator.validate(todo);
            assert(violations.size() == 7);
    }
}

