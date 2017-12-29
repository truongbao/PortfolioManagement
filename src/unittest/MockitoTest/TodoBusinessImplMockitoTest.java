package unittest.MockitoTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import unittest.fakeBusiness.TodoBusinessImpl;
import unittest.fakeinterface.TodoService;

// ta thực hiện run unittest ở dây
// run as-> Junit Test
public class TodoBusinessImplMockitoTest {
	@Test
	public void usingMockito() {
		// khai báo 1 mock theo dõi interface TodoService
		TodoService todoService = mock(TodoService.class);
		// tạo 1 fake data thông tin dữ liệu trả về từ dao
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		// mock sẽ theo dõi đối tượng interface todoService
		// bất kì khi nào nó gọi pt retrieveTodos(String) thì
		// giá trị trả về của pt trên sẽ được làm giả là giá trị của list
		// allTodos
		when(todoService.retrieveTodos("Spring")).thenReturn(allTodos);

		// tạo đối tượng cần test ,và đối tượng trên gọi interface TodoService
		// để lấy dữ liệu
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		// đối tượng cần test gọi phương thức với dữ liệu trả về từ interface
		// todoService
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		// kiểm tra list thu về có phải nhận dc 2 phần tử hay không ->True
		assertEquals(2, todos.size());
		// kiểm tra giá trị thu về có phải Learn Spring MVC->true
		assertEquals("Learn Spring MVC", todos.get(0).toString());
		// kiểm tra giá trị thu về có phải PhanTLTPhanTLT->cảnh báo
		assertEquals("PhanTLT", todos.get(1).toString());
	}

	// cú pháp tương tự
	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		// given
		given(todoService.retrieveTodos("Spring")).willReturn(allTodos);

		// when
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");

		// then
		assertThat(todos.size(), is(2));
	}

	// test với hành động xóa
	@Test
	public void letsTestDeleteNow() {

		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Spring")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Spring");

		// verify( đối tượng theo dõi, số lần gọi phương thức).tên phương thức
		// (đối số nếu có)

		// kiểm tra và bắt buộc hàm todoService phải gọi phương thức deleteTodo
		// và xóa "Learn to Dance"
		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast

	}
}
