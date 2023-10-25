package Api.todolist.todolistmentoria.todorepository;

import Api.todolist.todolistmentoria.dto.TodoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepopsitory extends JpaRepository<TodoDto, Long> {


}
