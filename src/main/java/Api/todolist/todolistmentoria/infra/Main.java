package Api.todolist.todolistmentoria.infra;

import Api.todolist.todolistmentoria.model.Todo;



import javax.validation.*;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Todo todo = new Todo();

        todo.setSolicitante(null);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        try {
            Set<ConstraintViolation<Todo>> violations = validator.validate(todo);
            if (!violations.isEmpty()) {
                for (ConstraintViolation<Todo> violation : violations) {
                    System.out.println("Campo: " + violation.getPropertyPath());
                    System.out.println("Mensagem: " + violation.getMessage());
                }
            }
        } catch (ConstraintViolationException e) {
            System.out.println("Erro de Validação: " + e.getMessage());
        }
    }
}