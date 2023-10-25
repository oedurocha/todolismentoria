package Api.todolist.todolistmentoria.infra;

import Api.todolist.todolistmentoria.dto.TodoDto;



import javax.validation.*;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        TodoDto todo = new TodoDto();

        todo.setSolicitante(null);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        try {
            Set<ConstraintViolation<TodoDto>> violations = validator.validate(todo);
            if (!violations.isEmpty()) {
                for (ConstraintViolation<TodoDto> violation : violations) {
                    System.out.println("Campo: " + violation.getPropertyPath());
                    System.out.println("Mensagem: " + violation.getMessage());
                }
            }
        } catch (ConstraintViolationException e) {
            System.out.println("Erro de Validação: " + e.getMessage());
        }
    }
}