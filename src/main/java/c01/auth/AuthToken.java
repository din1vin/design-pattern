package c01.auth;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class AuthToken {
    public static final long DEFAULT_EXPIRE_INTERVAL = 60 * 1000; //1分钟
    private String token;
    private long createTime;
    private long expireInterval = DEFAULT_EXPIRE_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expireInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expireInterval = expireInterval;
    }

    public static AuthToken generate(String baseUrl, long createTime, Map<String, String> params) {
        TreeMap<String, String> sortedMap = new TreeMap<>(params);
        //将参数按key排列后拼接
        String paramStr = sortedMap.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
        String fullStr = baseUrl + "?time=" + createTime + "&" + paramStr;
        return new AuthToken(hmac_sha(fullStr, "no_bb"), createTime);
    }

    private static String hmac_sha(String value, String key) {
        try {
            // Get a hmac_sha1 key from the raw key bytes
            byte[] keyBytes = key.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

            // Get a hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(value.getBytes());

            byte[] result = Base64.getEncoder().encode(rawHmac);

            //  Covert array of Hex bytes to a String
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > createTime + expireInterval;
    }

    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }

}
