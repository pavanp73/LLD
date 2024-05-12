package designpatterns.prototype;

public class Client {

    private static void fillRegistry(StudentRegistry studentRegistry) {
        Student mar24LLDEvePrototype = new Student();
        mar24LLDEvePrototype.setBatch("Mar24 Evening LLD Batch");
        mar24LLDEvePrototype.setAvgBatchPsp(80.0);
        studentRegistry.register("Mar24Eve", mar24LLDEvePrototype);

        Student feb24LLDEvePrototype = new Student();
        feb24LLDEvePrototype.setBatch("Feb24 Evening LLD Batch");
        feb24LLDEvePrototype.setAvgBatchPsp(75.0);
        studentRegistry.register("Feb24Eve", feb24LLDEvePrototype);

        IntelligentStudent mar24LLDEveISPrototype = new IntelligentStudent();
        mar24LLDEveISPrototype.setBatch("Mar24 Evening LLD Batch");
        mar24LLDEveISPrototype.setAvgBatchPsp(80.0);
        mar24LLDEveISPrototype.setIq(100);
        studentRegistry.register("Mar24EveIS", mar24LLDEveISPrototype);

    }

    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        Student pavan = studentRegistry.get("Mar24Eve").clone();
        pavan.setName("Pavan");
        pavan.setAge(33);
        pavan.setPsp(75.0);

        Student kiranIStudent = studentRegistry.get("Mar24EveIS").clone();
        kiranIStudent.setName("Kiran");
        kiranIStudent.setAge(33);
        kiranIStudent.setPsp(80.0);

        System.out.println("DEBUG");
    }
}
