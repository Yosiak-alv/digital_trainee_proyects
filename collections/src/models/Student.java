package models;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private Integer qualification;

    public Student(){}
    public Student(String name, Integer qualification) {
        this.name = name;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", qualification=" + qualification +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.name == null){
            return 0;
        }
        return this.name.compareTo(o.getName());
        /*if(this.qualification == o.qualification){
            return 0;
        }
        if(this.qualification > o.qualification){
            return 1;
        }
        else{
            return -1;
        }

        if(this.qualification == null){
            return 0;
        }

        return this.qualification.compareTo(o.getQualification());*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(qualification, student.qualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, qualification);
    }
}
