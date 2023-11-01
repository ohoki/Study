package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("engine") class Engine {} // <bean id="engine" class="com.fastcampus.ch3.Engine"/>
@Component class SuperEngine extends Engine {}
@Component class TurboEngine extends Engine {}
@Component class Door {}
@Component
class Car {
    @Value("red") String color;
    @Value("100") int oil;
    @Autowired Engine engine; //@Autowired의 경우 타입으로 먼저 검색, 여러개면 이름으로 검색.
    @Autowired Door[] doors;

    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}

public class SpringDiTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config1.xml");
        Car car = (Car)ac.getBean("car"); //byName
//        Car car2 = (Car)ac.getBean(Car.class); //byType
//        Car car3 = ac.getBean("car", Car.class); //형변환 생략
//
//        Engine engine = (Engine)ac.getBean("superEngine"); //byName
//        // Engine engine = (Engine)ac.getBean(Engine.class); //byType -> 같은 타입이 여러값을 가지는 경우 에러
//        Door door = (Door)ac.getBean("door");
        
        //setter로 값을 직접 넣어주는 방법 대신에 config.xml에서 property를 설정할 수 있음
       /* car.setColor("red");
        car.setOil(100);
        car.setEngine(engine);
        car.setDoors(new Door[] {ac.getBean("door", Door.class), ac.getBean("door", Door.class)});*/
        
        System.out.println("car = " + car);
      /*  System.out.println("engine = " + engine);*/
    }
}
