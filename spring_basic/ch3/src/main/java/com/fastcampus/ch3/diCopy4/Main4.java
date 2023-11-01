package com.fastcampus.ch3.diCopy4;

import com.google.common.reflect.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component class Car {
    //byName
    @Resource Engine engine;

    //byType
    @Autowired Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}
@Component class SportCar extends Car {}
@Component class Truck extends Car {}
@Component class Engine {}
@Component class Door {}

class AppContext {
    Map map; //객체 저장소

    AppContext() {
        map = new HashMap();
        doComponentScan();
        doAutowired();
        doResource();
    }

    private void doResource() {
        //map에 저장된 객체의 iv중에 @Resource가 붙어 있으면
        //map에서 iv의 타입에 맞는 객체를 찾아서 연결 ( 객체의 주소를 iv에 저장)
        try {
            for(Object bean : map.values()) {
                for(Field fld : bean.getClass().getDeclaredFields()) {
                    if(fld.getAnnotation(Resource.class) != null) {
                        fld.set(bean, getBean(fld.getName())); //car.engine = obj;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doAutowired() {
        //map에 저장된 객체의 iv중에 @Autowired가 붙어 있으면
        //map에서 iv의 타입에 맞는 객체를 찾아서 연결 ( 객체의 주소를 iv에 저장)
        try {
            for(Object bean : map.values()) {
                for(Field fld : bean.getClass().getDeclaredFields()) {
                    if(fld.getAnnotation(Autowired.class) != null) {
                        fld.set(bean, getBean(fld.getType())); //car.engine = obj;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doComponentScan() {
        try {
            ClassLoader classLoader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            // 패키지내의 클래스 목록을 가져온다.
            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fastcampus.ch3.diCopy4");

            // 반복문으로 클래스를 하나씩 읽어와서 @Component 애너테이션이 붙어 있는지 확인
            for(ClassPath.ClassInfo classInfo : set) {
                Class clazz = classInfo.load();
                Component component = (Component)clazz.getAnnotation(Component.class);

                // @Component가 붙어있으면 객체를 생성해서 map에 저장
                if(component != null) {
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    map.put(id, clazz.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //byName
    Object getBean(String key) {
        return map.get(key);
    }

    //byType
    Object getBean(Class clazz) {
        for(Object obj : map.values()) {
            if(clazz.isInstance(obj)) {
                return obj;
            }
        }
        return null;
    }
}

public class Main4 {
    public static void main(String[] args) throws Exception{
        AppContext ac = new AppContext();

        //byName
        Car car = (Car)ac.getBean("car");
        Engine engine = (Engine)ac.getBean("engine");
        Door door = (Door)ac.getBean("door");

        // car.engine = engine;
        // car.door = door;

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("engine = " + door);
    }
}
