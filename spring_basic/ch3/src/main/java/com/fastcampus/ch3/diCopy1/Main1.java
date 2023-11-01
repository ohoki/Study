package com.fastcampus.ch3.diCopy1;

import java.io.FileReader;
import java.util.Properties;

class Car {}
class SportCar extends Car {}
class Truck extends Car {}
class Engine {}

public class Main1 {
    public static void main(String[] args) throws Exception{
        Car car = getCar();
        System.out.println("car = " + car);

        Car car2 = (Car)getObject("car");
        Engine engine = (Engine)getObject("engine");
        System.out.println("car2 = " + car2);
        System.out.println("engine = " + engine);
    }

    // config.txt 파일의 value 값만 변경해주면 코드 변경 없이 수정이 가능!!
    static Car getCar() throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car"));

        return (Car)clazz.newInstance();
    }
    
    // config.txt의 key를 여러개 주고 다양하게 활용 가능함
    static Object getObject(String key) throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return clazz.newInstance();
    }
}
