package Api.todolist.todolistmentoria;

import Api.todolist.todolistmentoria.dto.Status;
import Api.todolist.todolistmentoria.dto.TodoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

public class TodoTodoTestDto {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidTodo() {
        TodoDto todo = new TodoDto();
        todo.setNomeDoCliente("Cliente");
        todo.setNomeDaTarefa("Tarefa");
        todo.setDescricaoDaTarefa("Descrição");
        todo.setDataDaConclusao(LocalDateTime.now());
        todo.setStatus(Status.Em_Andamento);
        todo.setStatus(Status.Pendente);
        todo.setStatus(Status.Concluida);
        todo.setResponsavelPelaTarefa("Responsável");
        todo.setSolicitante("Solicitante");
        Set<ConstraintViolation<TodoDto>> violations = validator.validate(todo);
        assert(violations.isEmpty());
    }

    @Test
    public void testInvalidTodo() {
        TodoDto todo = new TodoDto();
        Set<ConstraintViolation<TodoDto>> violations = validator.validate(todo);
            assert(violations.size() == 7);
    }
}

