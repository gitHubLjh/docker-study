package io.vertx.blueprint.todolist.entity;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class Person {

    private int id;
    private String name;
    private Integer age;

    public Person() {
    }

    /**
     * codeGen要求有入参为jsonObject的构造函数，才能成功生成转换器
     * @param json
     */
    public Person(JsonObject json) {
        PersonConverter.fromJson(json, this);
    }

    public Person(String jsonStr) {
        PersonConverter.fromJson(new JsonObject(jsonStr), this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        PersonConverter.toJson(this, json);
        return json;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
