package Api.Test;

import Api.dto.UserBuilder;
import Api.steps.UserSteps;
import org.testng.annotations.Test;

import java.io.IOException;


public class UserTest {
    UserSteps userSteps = new UserSteps();

    private final UserBuilder user = UserBuilder.builder()
            .id(3)
            .username("user3")
            .build();
    private final UserBuilder user2 = UserBuilder.builder()
            .build();

    @Test
    void shouldBeCreatedUser() throws IOException {
    var response = userSteps.createUser(user).extract();
    var get = userSteps.getUser(user2, String.valueOf(response)).extract().path("username");
        System.out.println(get);

            /*У меня коректно получилось сделать GET только этим способом*/
//        URL urlObj = new URL("https://petstore.swagger.io/v2/user/user2");
//        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
//        connection.setRequestMethod("GET");
//        int responseCode = connection.getResponseCode();
//
//        if (responseCode == HttpsURLConnection.HTTP_OK) {
//            StringBuilder sn =new StringBuilder();
//            Scanner scanner = new Scanner(connection.getInputStream());
//            while (scanner.hasNext()){
//                sn.append(scanner.nextLine());
//            }
//            System.out.println(sn);
////            ObjectMapper objectMapper = new ObjectMapper();
////            UserBuilder[] user= objectMapper.readValue(String.valueOf(sn), new TypeReference<UserBuilder[]>(){});
////            System.out.println(user[0].toString());
//        } else{
//            System.out.println("Error Get request");
//        }

    }
}
