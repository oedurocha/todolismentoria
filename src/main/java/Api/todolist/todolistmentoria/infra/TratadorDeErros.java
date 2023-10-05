package Api.todolist.todolistmentoria.infra;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroHandle> ErroMetodo(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrorList =
                exception.getBindingResult()
                        .getFieldErrors();

        List<ErroHandle> list = new ArrayList<>();
        fieldErrorList.forEach(error ->
                list.add(new ErroHandle(error.getField(),
                        error.getDefaultMessage())));
        return list;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErroHandle handle(ConstraintViolationException exception) {
        ErroHandle fielErrorList = new ErroHandle("", "");

        return fielErrorList;

    }

}
