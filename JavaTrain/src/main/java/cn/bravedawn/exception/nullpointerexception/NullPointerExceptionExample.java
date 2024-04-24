package cn.bravedawn.exception.nullpointerexception;

public class NullPointerExceptionExample {

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.address.city.toLowerCase());
    }

    /**
     * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toLowerCase()" because "p.address.city" is null
     * 	at cn.bravedawn.exception.nullpointerexception.NullPointerExceptionExample.main(NullPointerExceptionExample.java:7)
     */


}

class Person {
    String[] name = new String[2];
    Address address = new Address();
}

class Address {
    String city;
    String street;
    String zipcode;
}
