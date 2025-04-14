package hello.core.singleton;

public class SingletonService {

    private final static SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void login(){
        System.out.println("싱글톤 객 로직 호출");
    }
}
