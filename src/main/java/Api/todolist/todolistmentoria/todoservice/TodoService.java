package Api.todolist.todolistmentoria.todoservice;

import Api.todolist.todolistmentoria.model.Todo;
import Api.todolist.todolistmentoria.todorepository.TodoRepopsitory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepopsitory todoRepopsitory;

    public Todo createTodo (Todo todo){
        return todoRepopsitory.save(todo);
    }

    public List<Todo> listAllTodo(){
        return todoRepopsitory.findAll();
    }

    public ResponseEntity<Todo> findTodoById(Long id){
        return  todoRepopsitory.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Todo> updateTodoById(Todo todo, Long id){
        return todoRepopsitory.findById(id)
                .map(todoToUpdate ->{
                    todoToUpdate.setNomeDoTarefa(todo.getNomeDoTarefa());
                    todoToUpdate.setDescricaoDaTarefa(todo.getDescricaoDaTarefa());
                    todoToUpdate.setAtualizadoEm(todo.getAtualizadoEm());
                    todoToUpdate.setStatus(todo.getStatus());
                    todoToUpdate.setResponsavelPelaTarefa(todo.getResponsavelPelaTarefa());
                    todoToUpdate.setSolicitante(todo.getSolicitante());
                    Todo updated = todoRepopsitory.save(todoToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id){
        return todoRepopsitory.findById(id)
                .map(taskToDelete ->{
                    todoRepopsitory.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());

    }

}
