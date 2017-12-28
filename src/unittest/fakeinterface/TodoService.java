package unittest.fakeinterface;

import java.util.List;

//interface định nghĩa phương thức tương tác dữ liệu với database
public interface TodoService {
	// xư lý sau đó nhận chuổi trả về
	public List<String> retrieveTodos(String key);

	// thực hiện hành động xóa
	public int deleteTodo(String key);
}
