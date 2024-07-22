package quizSolutions.java.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}

    private static class SingletonHelper{
        @SuppressWarnings("InstantiationOfUtilityClass")
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
