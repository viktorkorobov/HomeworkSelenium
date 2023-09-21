package Api.endpoints;

public enum EndpointsPOST {
    CREATE_USER("/user");
    private final String endpoint;


    EndpointsPOST(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getValue() {
        return endpoint;
    }

}
