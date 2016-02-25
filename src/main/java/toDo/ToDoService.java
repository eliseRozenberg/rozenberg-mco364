package toDo;

import retrofit2.http.GET;
import java.util.List;
import retrofit2.Call;

public interface ToDoService {
	
	@GET("/todos")
	Call<List<ToDo>> listTodos();

}
