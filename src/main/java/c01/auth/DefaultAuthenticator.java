package c01.auth;

import c01.store.ICredentialStorage;
import c01.store.OnMemoryCredentialStorage;

import java.util.HashMap;
import java.util.Map;

public class DefaultAuthenticator implements ApiAuthenticator {
    private ICredentialStorage credentialStorage;

    public DefaultAuthenticator(ICredentialStorage credentialStorage) {
        this.credentialStorage = new OnMemoryCredentialStorage();
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appID = apiRequest.getAppID();
        long createAt = apiRequest.getTimestamp();
        String token = apiRequest.getToken();
        String baseUrl = apiRequest.getBaseUrl();
        String password = credentialStorage.getPasswordById(appID);
        AuthToken authToken = new AuthToken(token, createAt);

        if (authToken.isExpired()) {
            throw new RuntimeException("Token is expired ");
        }
        Map<String, String> params = new HashMap<>();
        params.put("app_id", appID);
        params.put("password", password);
        AuthToken serverToken = AuthToken.generate(baseUrl, createAt, params);
        if (!authToken.match(serverToken)) {
            throw new RuntimeException("Token verified failed");
        }
    }
}
