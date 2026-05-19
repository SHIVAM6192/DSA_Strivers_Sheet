class Student{
    String name;
    int age;

    Student(){ }
    // Copy Constructor
    Student(Student s2){
        this.name = s2.name;
        this.age = s2.age;
    }
    public void printName(){
        System.out.println("Name: " + this.name);
    }
}

public class CopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Shivam";
        s1.age = 23;

        Student s2 = new Student(s1);
        s2.printName();
    }
}
