package io.vertx.blueprint.todolist;

import io.vertx.blueprint.todolist.entity.Person;
import io.vertx.blueprint.todolist.entity.Todo;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * @author:liujh
 * @date:2017/10/27 14:24
 * @project:vertx-blueprint-todo-backend
 * @ide:IntelliJ IDEA
 */
@RunWith(VertxUnitRunner.class)
public class PersonConverTest {

    @Test
    public void testJson2Person(){
        JsonObject json = new JsonObject();
        json.put("id",1);
        json.put("name","张三丰");
        json.put("age",89);
        Person person = new Person(json);
        System.out.println(person.toString());
    }

    @Test
    public void testPerson2Json(){
        Person person = new Person();
        person.setId(1);
        person.setName("liujh");
        person.setAge(50);
        JsonObject json = person.toJson();
//        System.out.println(json.encodePrettily());
        System.out.println(Json.encodePrettily(new Todo(24, "Something to do...", false, 1, "todo/ex")));

        //Spliterator:可分割迭代器(splitable iterator)，该迭代器能并行遍历元素，jdk8中的集合结构都实现了该接口
        //StreamSupport:将集合转变为stream，并行stream，串行stream，并行流就是把内容切割成多个数据块，并使用多个线程分别处理每个数据块的内容。
        //Stream api中声明可以通过parallel()与sequential()在并行流和串行流之间进行切换。
        //jdk1.8的并行stream使用的是fork/join框架进行并行操作。
        List<Person> list = new ArrayList<>();
        StreamSupport.stream(list.spliterator(), false);
    }
}
