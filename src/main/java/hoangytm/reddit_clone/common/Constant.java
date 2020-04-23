package hoangytm.reddit_clone.common;

/**
 * @author PhanHoang
 * 4/20/2020
 */
public class Constant {
    public static final String ACTIVATION_EMAIL = "http://localhost:8080/api/auth/accountVerification";
    public static final String JWT_SECRET = "hoangytm";
    public static final long JWT_EXPIRATION = 604800000L;
    public static final String SIGN_UP_URL= "http://localhost:8080/api/auth/signup";
    public static final String LOG_IN_URL= "http://localhost:8080/api/auth/login";
}
