package Api.endpoints;

public enum EndpointsGET {
    GET_USER("/user/"+getUserName());

    private static String userName;

    private final String endpoint;


    EndpointsGET(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getValue() {
        return endpoint;
    }

    public static String getUserName() {
        return userName;
    }
}
