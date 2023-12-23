package service;

public class FunctionalInterfaceImpl implements  FunctionalInterface {
    @Override
    public void test() {
    System.out.println("Test from class");
    }
    //Overriding default method of an interface
    /*
        @Override
    public String helloDefault() {
        return "Hello from implementation class";
    }

     */

    // Calling Default method of interface
    @Override
    public String helloDefault() {
        return FunctionalInterface.super.helloDefault();
    }

    //Note: Same name as of interface method but can't use @Override
    public  static String hiStatic(){
        return "Hi from implementation class";
    }
}
