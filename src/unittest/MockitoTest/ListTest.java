package unittest.MockitoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

// class này không liên quan
// giới thiệu về multipe return values

public class ListTest {
	@Test
	public void letsMockListSize() {
		// theo dõi list kiểu List
		List list = mock(List.class);
		// tương tự gọi size sẽ trả về 19
		Mockito.when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List list = mock(List.class);
		// gọi lần 1 trả về 10, lần 2 trả về 29
		Mockito.when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", list.get(0));
		// lưu ý so sánh với NULL nhé
		assertNull(list.get(1));
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		// Mockito.anyInt() để đảm bảo tất cả các đối tượng đều có gt trả về
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("in28Minutes");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("in28Minutes", list.get(0));
		assertEquals("in28Minutes", list.get(1));
	}
}
