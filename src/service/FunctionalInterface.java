package service;

@java.lang.FunctionalInterface
public interface FunctionalInterface {

     void test();

     default String helloDefault(){
         return "Hello from interface";
     }

     static String hiStatic(){
         return "Hi from interface";
     }

}
