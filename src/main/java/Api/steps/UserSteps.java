package Api.steps;

import Api.config.BaseRequestSpecification;
import Api.config.BaseResponseSpecification;
import Api.config.Request;
import Api.dto.UserBuilder;
import Api.endpoints.EndpointsGET;
import Api.endpoints.EndpointsPOST;
import io.restassured.response.ValidatableResponse;

import static Api.utils.Utils.toJson;

public class UserSteps extends Request {
    BaseRequestSpecification baseRequest= new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    public ValidatableResponse createUser(UserBuilder user){
        return post(baseRequest.request(), toJson(user), EndpointsPOST.CREATE_USER.getValue(), baseResponse.OK());
    }
    public ValidatableResponse getUser(UserBuilder user,String username){
        return get(baseRequest.request(), toJson(user), EndpointsGET.GET_USER.getValue(),baseResponse.OK());
    }
}
