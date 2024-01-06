package org.example.designpatterns.builder;

public class Student {
    String name;
    int age;
    String univName;
    int gradYear;
    double psp;
    String batchName;
    String companyName;

    public Student(Builder builder) {
        //validations start
        if (builder.getGradYear() > 2022) {
           throw new IllegalArgumentException("Grad Year can't be greater than 2022");
        }
        //validations end
        this.name=builder.name;
        this.age= builder.age;
        this.companyName= builder.companyName;
        this.gradYear= builder.gradYear;

    }

    public String getName() {
        return name;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
