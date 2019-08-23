package com.example.test.module.nodes.impl;

import com.example.test.module.entity.Car;
import com.example.test.module.nodes.AbstractNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Wash extends AbstractNode {
    @Override
    public void handle(Car car) throws Exception {
        System.out.println(car.getId() + ":————洗车————");
        try {
            Thread.sleep(2000L);
        }catch (Exception e){
            System.out.println(car.getId() + ":————任务取消————");
        }
        if(next != null){
            next.handle(car);
        }else {
            System.out.println(car.getId() + ":————完成维护————");
        }
    }
}
