package Api.todolist.todolistmentoria.todoservice;

import Api.todolist.todolistmentoria.dto.TodoDto;
import Api.todolist.todolistmentoria.model.Status;
import Api.todolist.todolistmentoria.todorepository.TodoRepopsitory;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Component
@AllArgsConstructor
public class TodoService {

    private TodoRepopsitory todoRepopsitory;

    public TodoDto createTodo(TodoDto todo){
        return todoRepopsitory.save(todo);
    }

    public List<TodoDto> listAllTodo(){
        return todoRepopsitory.findAll();
    }

    public ResponseEntity<TodoDto> findTodoById(Long id){
        return  todoRepopsitory.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TodoDto> updateTodoById(TodoDto todo, Long id) {
        return todoRepopsitory.findById(id)
                .map(todoToUpdate -> {
                    todoToUpdate.setNomeDoCliente(todo.getNomeDoCliente());
                    todoToUpdate.setDescricaoDaTarefa(todo.getDescricaoDaTarefa());

                    if (todo.getStatus() == Status.CONCLUIDO && todoToUpdate.getStatus() != Status.CONCLUIDO) {
                        todoToUpdate.setDataDaConclusao(LocalDateTime.now());
                    }

                    todoToUpdate.setConcluidoEm(todo.getConcluidoEm()); // Correção no nome da propriedade
                    todoToUpdate.setAtualizadoEm(todo.getAtualizadoEm());
                    todoToUpdate.setStatus(todo.getStatus());
                    todoToUpdate.setResponsavelPelaTarefa(todo.getResponsavelPelaTarefa());
                    todoToUpdate.setSolicitante(todo.getSolicitante());
                    todoToUpdate.setNomeDaTarefa(todo.getNomeDaTarefa());
                    TodoDto updated = todoRepopsitory.save(todoToUpdate);
                    return ResponseEntity.ok().body(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id){
        return todoRepopsitory.findById(id)
                .map(todoToDelete ->{
                    todoRepopsitory.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());

    }

}
