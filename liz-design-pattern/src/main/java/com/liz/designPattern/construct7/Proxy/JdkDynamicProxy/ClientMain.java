package com.liz.designPattern.construct7.Proxy.JdkDynamicProxy;

import com.liz.designPattern.construct7.Proxy.IMath;
import com.liz.designPattern.construct7.Proxy.Math;
/**
 *
 * JDK提供的动态代理 场景类
 * http://www.cnblogs.com/best/p/5679656.html
 *
小结：

 JDK内置的Proxy动态代理可以在运行时动态生成字节码，而没必要针对每个类编写代理类。中间主要使用到了一个接口InvocationHandler与Proxy.newProxyInstance静态方法，参数说明如下：

 使用内置的Proxy实现动态代理有一个问题：被代理的类必须实现接口，未实现接口则没办法完成动态代理。

 如果项目中有些类没有实现接口，则不应该为了实现动态代理而刻意去抽出一些没有实例意义的接口，通过cglib可以解决该问题。

 * Created by Administrator on 2017/3/22 0022.
 */
public class ClientMain {
    public static void main(String[] args) {

//        实例化一个MathProxy代理对象
        //通过getProxyObject方法获得被代理后的对象
        IMath math = (IMath) new DynamicProxy().getProxyObject(new Math());
        int a = 100 ,b = 5 ;
        math.add(a,b);
        math.sub(a,b);
        math.mut(a,b);
        math.div(a,b);
    }
}
