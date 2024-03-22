public class SingletonTest {
    public static void main(String[] args){

        LoggerSingleton s1 = LoggerSingleton.getInstance();
        System.out.println(s1);

        LoggerSingleton s2 = LoggerSingleton.getInstance();
        System.out.println(s2);

        System.out.println(s1.equals(s2));

    }
}
