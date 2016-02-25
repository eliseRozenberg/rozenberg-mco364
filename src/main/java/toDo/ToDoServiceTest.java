package toDo;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ToDoServiceTest {

	@Test
	public void testListToDos() throws IOException {
		// verify that you downloaded 200 toDo items
		//retrofit needs a converter to work with json
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://jsonplaceholder.typicode.com")
				.addConverterFactory(GsonConverterFactory.create()).build();
			//converts it to gson
		
		ToDoService service = retrofit.create(ToDoService.class);
		//Interface we created
		Call<List<ToDo>> call = service.listTodos();
		//service send back a call of a list that contains todos 
		Response<List<ToDo>> response = call.execute();
		//gets the responce from the call
		List<ToDo> list = response.body();
		//The response wich is the list is returned to the list of todos 
		Assert.assertEquals(200,list.size());
		//Check that its the correct length
	}

}
