package qa.guru;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import qa.guru.model.UserModel;

import java.io.File;

public class ReadJsonFileTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonTest() throws Exception {

        File file = new File("src/test/resources/user.json");
        UserModel user = objectMapper.readValue(file, UserModel.class);

        Assertions.assertEquals(12345, user.getId());
        Assertions.assertEquals("John Doe", user.getName());
        Assertions.assertEquals(30, user.getAge());
        Assertions.assertEquals("johndoe@example.com", user.getEmail());
        Assertions.assertEquals("123 Main St", user.getAddress().getStreet());
        Assertions.assertEquals("New York", user.getAddress().getCity());
        Assertions.assertEquals("NY", user.getAddress().getState());
        Assertions.assertEquals("10001", user.getAddress().getZipcode());
        Assertions.assertEquals("reading", user.getHobbies().get(0));
        Assertions.assertEquals("painting", user.getHobbies().get(1));
        Assertions.assertEquals("hiking", user.getHobbies().get(2));
        Assertions.assertEquals(true, user.isActive());




    }
}
