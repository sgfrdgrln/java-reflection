import java.util.*;
import java.lang.reflect.*;  // we use this package for the reflection

public class JavaReflection {

    public static void main(String[] args) throws Exception{

        Person person = new Person("Pororo", 1);

        // Let's say I want to change the name and age of the Person.
        
        // This is not allowed, since the variable is private.
        // person.age = 15;
        // person.name = "Bob";
        // And we don't have a setter method to change the value of our name and age
        
        // In this case we will use reflection

        Field[] personField = person.getClass().getDeclaredFields(); // we create a field object

        
        for(Field field : personField) {

            // You can check the available fields on class Person:
            // System.out.println(field.getName()); 

            // There are two available fields, a private final String name, and a private int age.
            
            // Now I want to modify those fields, set the name to Steve and age to 25.

            
            if(field.getName().equals("name")) {

                // Since it is private, we have to set the accessibility to true
                field.setAccessible(true);
                // Now we can change the value of name
                field.set(person, "Steve");

            }
            if(field.getName().equals("age")) {

                 // Since it is private, we have to set the accessibility to true
                 field.setAccessible(true);
                 // Now we can change the value of age
                 field.set(person, 25);

            }
        }

        // Now we can check if the name and age value changed.
        System.out.println();
        System.out.println("Person name: "+person.getPersonName());
        System.out.println("Person age: "+person.getPersonAge());
        
        // How about a method? How do I access a private method?

        Method[] personMethod = person.getClass().getDeclaredMethods(); // we create a method object

        for(Method method: personMethod) {

            // You can check the available fields on class Person:
            // System.out.println(method.getName()); 

            // Now, let's try to call out a private method!

            if(method.getName().equals("greet")) {

                // Since it is private, we have to set the accessibility to true
                method.setAccessible(true);
                // We use the invoke method to call the function inside our class Person
                method.invoke(person);
            }
            


        }

        


        for(Method method2 : personMethod) {

            if(method2.getName().equals("test")) {

                // Since it is private, we have to set the accessibility to true
                method2.setAccessible(true);
                 /*  We use the invoke method to call the function, since it is static
                     we do not have to put the name of our class object, we can just set it null. */
                method2.invoke(null);
            }

        }

        

    }


}

class Person {

    private final String name;
    private int age;

    public Person(String personName, int personAge) {
        this.name = personName;
        this.age = personAge;
    }

    public String getPersonName() {
        return name;
    }
    public int getPersonAge() {
        return age;
    }
    private void greet() {
        System.out.println("Message: Hello");
    }
    private static void test() {
        System.out.println("Message: Test!");
    }


}
