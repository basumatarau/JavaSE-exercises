package com.testProject.ReflectionAPI.NullObject;

public class Client {
    public static void main(String[] args) {
        Staff staff = new Staff(
                "President", "CTO", "CEO",
                "Marketing Manager", "Product Manager",
                "Project Lead", "Software Tester",
                "Software Engineer", "Software Engineer",
                "Software Engineer", "Test Engineer",
                "Technical Writer"
        );

        staff.fillPosition("President", new Person("Me", "Last", "The top, lonely at"));
        staff.fillPosition("Project Lead", new Person("Jannt", "Planner", "The Burbs"));

        if(staff.positionAvailable("Software Engineer")){
            staff.fillPosition("Software Engineer", new Person("Bob", "Coder", "Bright Light City"));
        }

        System.out.println(staff);
    }
}
