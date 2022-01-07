package c01.store;

import java.util.HashMap;
import java.util.Map;

/**
 * 内存账密存储 模仿按Key查PassWord
 */
public class OnMemoryCredentialStorage implements ICredentialStorage {
    private static Map<String, String> keyChain;

    static {
        keyChain = new HashMap<>();
        keyChain.put("my_app", "hello");
    }


    @Override
    public String getPasswordById(String appId) {
        return keyChain.get(appId);
    }
}
