package pkb.xdemo;

import org.junit.jupiter.api.Test;

import com.something.CompTypeWithSeq;
import com.something.UserRequest;
import com.something.UserResponse;
import com.something.WarningsType;

public class MainTest {

	@Test
	public void test() {
		UserRequest userRequest = new UserRequest();
		userRequest.setName("John");

		UserResponse userResponse = new UserResponse();
		CompTypeWithSeq comp = new CompTypeWithSeq();
		WarningsType warnings = new WarningsType();
		warnings.setMessage("Error 55");
		comp.getWarningsAndErrors().add(warnings);
		userResponse.setCompSeq(comp);
	}
}