package designpatterns.prototype;

public class Student implements Prototype<Student> {

    private String name;
    private int age;
    private String batch;
    private double avgBatchPsp;
    private double psp;

    public Student() {
    }

    public Student(Student student) {
        this.age = student.age;
        this.avgBatchPsp = student.avgBatchPsp;
        this.batch = student.batch;
        this.name = student.name;
        this.psp = student.psp;
    }

    /*public int getAge() {
        return age;
    }*/

    public void setAge(int age) {
        this.age = age;
    }

    /*public double getAvgBatchPsp() {
        return avgBatchPsp;
    }*/

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    /*public String getBatch() {
        return batch;
    }*/

    public void setBatch(String batch) {
        this.batch = batch;
    }

    /*public String getName() {
        return name;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    /*public double getPsp() {
        return psp;
    }*/

    public void setPsp(double psp) {
        this.psp = psp;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }
}
