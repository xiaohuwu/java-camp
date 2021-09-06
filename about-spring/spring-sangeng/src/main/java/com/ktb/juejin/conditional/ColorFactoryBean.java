package com.ktb.juejin.conditional;

import com.ktb.model.Color;
import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        return  new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }
}
