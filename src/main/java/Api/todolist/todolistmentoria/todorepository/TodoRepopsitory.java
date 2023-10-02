package Api.todolist.todolistmentoria.todorepository;

import Api.todolist.todolistmentoria.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepopsitory extends JpaRepository<Todo, Long> {


}
