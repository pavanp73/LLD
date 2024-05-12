package designpatterns.builder;

/*
    Builder design pattern
    Creational design pattern
 */
public class Student {

    private String name;
    private int age;
    private String universityName;
    private double psp;
    private String batch;
    private int gradYear;
    private String phoneNumber;

    private Student(Builder builder) {

        this.name = builder.getName();
        this.age = builder.getAge();
        this.gradYear = builder.getGradYear();
        this.psp = builder.getPsp();
        this.batch = builder.getBatch();
        this.phoneNumber = builder.getPhoneNumber();
        this.universityName = builder.getUniversityName();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public int getAge() {
        return age;
    }

    public String getBatch() {
        return batch;
    }

    public int getGradYear() {
        return gradYear;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getPsp() {
        return psp;
    }

    public String getUniversityName() {
        return universityName;
    }

    // Builder class
    public static class Builder {
        private String name;
        private int age;
        private String universityName;
        private double psp;
        private String batch;
        private int gradYear;
        private String phoneNumber;

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public Builder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public Student build() {
            // validations starts

            if (this.getAge() < 20) {
                throw new RuntimeException("Age shouldn't be less than 20");
            }

            if (this.getGradYear() > 2023) {
                throw new RuntimeException("Grad year shouldn't be more than 2023");
            }
            // validations end
            return new Student(this);
        }
    }
}
