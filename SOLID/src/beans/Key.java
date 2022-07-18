package beans;

public class Key {

    String secretKey;
    String password;

    Integer algNum;

    public Key() {

    }

    public Key(String secretKey, String password, Integer algNum) {
        this.secretKey = secretKey;
        this.password = password;
        this.algNum = algNum;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAlgNum(Integer algNum) {
        this.algNum = algNum;
    }

    public Integer getAlgNum() {
        return algNum;
    }
}
