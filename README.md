Java Reflection
Java reflection is a feature in Java that allows you to inspect and modify classes, interfaces, fields, and methods at runtime. It enables you to analyze and manipulate classes and objects dynamically, even if you don't have compile-time knowledge of their structure.

How it Works
In this example, we demonstrate Java reflection by modifying the fields and invoking private methods of a Person class.

Modifying Fields
We use reflection to modify private fields (name and age) of the Person class. By setting the accessibility of these fields to true, we can change their values dynamically.

Invoking Private Methods
Similarly, we use reflection to invoke private methods (greet() and test()) of the Person class. By setting the accessibility of these methods to true, we can call them dynamically.

Running the Example
Compile the JavaReflection.java file: javac JavaReflection.java
Run the compiled class file: java JavaReflection
Key Points
Reflection provides a way to inspect and modify classes, fields, and methods dynamically at runtime.
It allows you to bypass access restrictions, such as private access modifiers, to access and modify private members of a class.
While reflection is a powerful tool, it should be used judiciously due to its potential for complexity and performance overhead.
