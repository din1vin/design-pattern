package c01.auth;

import c01.auth.ApiRequest;

public interface ApiAuthenticator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
