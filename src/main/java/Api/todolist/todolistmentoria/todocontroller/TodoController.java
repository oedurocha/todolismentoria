package Api.todolist.todolistmentoria.todocontroller;

import Api.todolist.todolistmentoria.model.Todo;
import Api.todolist.todolistmentoria.todoservice.TodoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TodoController {

    TodoService todoService;

    @ApiOperation(value = "Criando uma nova tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 201, message = "Tarefa criada com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar a tarefa.")

    })

    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        log.info("Criando uma nova tarefa com as informações [{}]", todo);
        return todoService.createTodo(todo);
    }



    @ApiOperation(value = "Listando todas as tarefas")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefas listadas com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao listar as tarefas")

    })
    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodo() {
        log.info("Listando todas as tarefas cadastradas");
        return todoService.listAllTodo();
    }

    @ApiOperation(value = "Buscando uma tarefa pelo id")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefa encontrada com sucesso"),
            @ApiResponse(code = 404, message = "Não foi encontrada nenhuma tarefa com esse id")

    })
    @GetMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Todo> getTodoById(@PathVariable (value = "id") Long id) {
        log.info("Buscando tarefa com o id [{}]", id);
        return todoService.findTodoById(id);
    }

    @ApiOperation(value = "Atualizando uma tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefa atualizada com sucesso"),
            @ApiResponse(code = 404, message = "Nao foi possivel atualizar a tarefa - tarefa nao encontrada")

    })
    @PutMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Todo> updateTodoById(@PathVariable(value = "id") Long id, @RequestBody Todo todo) {
        log.info("Atualizando a tarefa com id [{}] as novas informações são : [{}]",id, todo);

        return todoService.updateTodoById(todo, id);
    }


    @ApiOperation(value = "Excluindo uma tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 204, message = "Tarefa excluida com sucesso"),
            @ApiResponse(code = 404, message = "Nao foi possivel excluir a tarefa - tarefa nao encontrada")

    })
    @DeleteMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTodoById(@PathVariable (value = "id") Long id) {
        log.info("Excluindo tarefas com o id [{}]", id);
        return todoService.deleteById(id);
    }


}


