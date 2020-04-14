package maven.p01;
import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        if(sha255hex(args[1]).equals("12345")&&args[0].equals("123456")){
        System.out.println("username:"+sha255hex(args[1]));
        System.out.println("password:"+sha256hex(args[0]));
        }else	 System.out.println("failed!");
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
    public static String sha255hex(String input) {
        return input;
    }
}
