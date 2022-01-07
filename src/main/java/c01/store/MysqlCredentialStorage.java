package c01.store;

public class MysqlCredentialStorage implements ICredentialStorage{
    private static final String CLASS_NAME= "com.mysql.jdbc.Driver";


    @Override
    public String getPasswordById(String appId) {
        return null;
    }
}
