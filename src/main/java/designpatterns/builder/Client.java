package designpatterns.builder;

public class Client {

    public static void main(String[] args) {
        /*Builder builder = new Builder();
        builder.setName("Pavan");
        builder.setAge(33);
        builder.setBatch("MWF Evening");
        builder.setPsp(90.0);
        builder.setGradYear(2012);
        builder.setPhoneNumber("1234567890");

        Student student = new Student(builder);*/

        Student student = Student.getBuilder()
                        .setName("Pavan")
                        .setAge(33)
                        .setBatch("MWF Evening")
                        .setPhoneNumber("1234567890")
                        .setPsp(90.0)
                        .setGradYear(2012)
                        .setUniversityName("VTU").build();

        System.out.println("DEBUG");
    }
}
