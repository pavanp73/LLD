package designpatterns.prototype;

public class IntelligentStudent extends Student {

    private int iq;

    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

    public IntelligentStudent() {

    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public IntelligentStudent clone() {
        return new IntelligentStudent(this);
    }
}
