package com.liz.designPattern.construct7.Proxy.staticProxy;

import com.liz.designPattern.construct7.Proxy.IMath;

/**
 * 静态代理场景类
 *
 * http://www.cnblogs.com/best/p/5679656.html
 *
 *
 * 5、小结

 通过静态代理，是否完全解决了上述的4个问题：

 已解决：

 5.1、解决了“开闭原则（OCP）”的问题，因为并没有修改Math类，而扩展出了MathProxy类。

 5.2、解决了“依赖倒转（DIP）”的问题，通过引入接口。

 5.3、解决了“单一职责（SRP）”的问题，Math类不再需要去计算耗时与延时操作，但从某些方面讲MathProxy还是存在该问题。

 未解决：

 5.4、如果项目中有多个类，则需要编写多个代理类，工作量大，不好修改，不好维护，不能应对变化。

 如果要解决上面的问题，可以使用动态代理。

 *
 *
 * Created by Administrator on 2017/3/22 0022.
 */
public class ClientMain {
    public static void main(String[] args){
        IMath math = new MathProxy();
        int a = 5 ,b = 2;
        math.add(a,b);
        math.sub(a,b);
        math.mut(a,b);
        math.div(a,b);
    }
}
