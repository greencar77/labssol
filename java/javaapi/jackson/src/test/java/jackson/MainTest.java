package jackson;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MainTest {

	@Test
	public void testObjectToJson() throws IOException {
		//http://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/

		Staff staff = createDummyObject();

		ObjectMapper mapper = new ObjectMapper();

		// Convert object to JSON string and save into a file directly
		mapper.writeValue(new File("src/main/resources/staff.json"), staff);

		// Convert object to JSON string
		String jsonInString = mapper.writeValueAsString(staff);
		System.out.println(jsonInString);

		// Convert object to JSON string and pretty print
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
		System.out.println(jsonInString);
	}

	private Staff createDummyObject() {

		Staff staff = new Staff();

		staff.setName("mkyong");
		staff.setAge(33);
		staff.setPosition("Developer");
		staff.setSalary(new BigDecimal("7500"));

		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("python");

		staff.setSkills(skills);

		return staff;
	}

	@Test
	public void testTreeToJson() {

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode root = mapper.createObjectNode();
		root.put("aaa", "bbb");

		ObjectNode node = mapper.createObjectNode();
		node.put("ddd", "eee");
		root.put("xxx", node);

		try {
			String json = mapper.writeValueAsString(root);
			System.out.println(json);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJsonToObject() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		// Convert JSON string from file to Object
		Staff staff = mapper.readValue(new File("src/main/resources/staff.json"), Staff.class);
		System.out.println(staff);

		// Convert JSON string to Object
		String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
		Staff staff1 = mapper.readValue(jsonInString, Staff.class);
		System.out.println(staff1);

		//Pretty print
		String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
		System.out.println(prettyStaff1);
	}

	@Test
	public void testJsonToObject_whenNonsenseInInput() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		mapper.readValue("aaaaa", Staff.class);
	}

	@Test
	public void testJsonToObjectTree() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		// Convert JSON string from file to Object
		//			Staff staff = mapper.readValue(new File("staff.json"), Staff.class);
		//			System.out.println(staff);

		// Convert JSON string to Object
		String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
		JsonNode node = mapper.readTree(jsonInString);
		System.out.println(node.toString());

		//for (Map.Entry<String,JsonNode> entry: node.fields()) {
		Iterator<String> it = node.fieldNames();
		while (it.hasNext()) {
			String fieldName = it.next();
			System.out.println(fieldName);
		}
	}

	@Test
	public void testJsonToObject_whenNoDefaultConstructor() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		mapper.readValue(new File("src/main/resources/address.json"), Address.class);
		//exception MismatchedInputException.txt
	}

	@Test
	public void testJsonToObject_whenExtraTag() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		mapper.readValue(new File("src/main/resources/address_extra_field.json"), BusinessAddress.class);
		//exception
	}

	@Test
	public void testJsonToObject_whenExtraTagAndNoFail() throws IOException {
		ObjectMapper mapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		BusinessAddress object = mapper.readValue(new File("src/main/resources/address_extra_field.json"), BusinessAddress.class);
	}
}