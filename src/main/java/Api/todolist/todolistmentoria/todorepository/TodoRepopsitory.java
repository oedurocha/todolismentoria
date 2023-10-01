package Api.todolist.todolistmentoria.todorepository;

import Api.todolist.todolistmentoria.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepopsitory extends JpaRepository<Todo, Long> {


}
