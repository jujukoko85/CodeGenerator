package top.howard85.code.generator.generation;
import top.howard85.code.generator.generation.Man;

import java.io.Serializable;

import java.lang.Integer;
import top.howard85.code.generator.generation.Person;



/**
 * 这个是注释
 * @author zhuzhaohua
 */
public class Student extends Man implements Serializable {

    // 年龄
    private Integer age;
    //
    private Person persons;

    public Integer getAge() {
        return this.age;
    }

    public Student setAge(Integer Age) {
        this.age = age;
        return this;
    }
    public Person getPersons() {
        return this.persons;
    }

    public Student setPersons(Person Persons) {
        this.persons = persons;
        return this;
    }
}
// blank line
