package com.liz.ocjpJava6.base;

/**
 * Created by Frank on 2017/2/18
 * 与++相关的面试题汇总
 */
public class PlusPlus {
    public static void main(String[] args) {
        int a = 1;
        System.out.println("a=" + a + " ,++a = " + (++a) + "  ,a=" + a + "  ,结论是：前加加 ++a 先自增,再赋值");
        System.out.println(" ++a : 先把 a 自己增加值 ，然后a的值作为 a++ 表达式的值（前加加、前面就加）");

        a = 1;
        System.out.println("a=" + a + " ,a++ = " + (a++) + "  ,a=" + a + "  ,结论是：后加加 a++ 先赋值,再自增");
        System.out.println(" a++ : 先把a的值作为 a++ 表达式的值，然后 a 自己增加值（后加加、后面才加）");
        System.out.println(" ++ 里有两层含义：自增 和 赋值 ，它在变量的前后位置不同，有不同的含义");

        a = 1;
        System.out.println(a++ + ++a);//4

//        a = 1;
//        System.out.println(a++);//a++ 这个表达式的值是1，但是a的值是2
//        System.out.println(++a);//前++之后，a先+1 ，++a的表达式值是3，a的值也是3

        a = 5;
        System.out.println(a-- - --a);//2

        System.out.println("========================================================================================================================================================================");

//        1.
        int count1 = 0;
        count1 = count1 + count1++;
        System.out.println(count1);
//        第一个问题： 要明白count = count + count++的结果，首先要知道两个问题：
//        第一个是这个运算的运算顺序，第二个是count++操作做了什么事，对于运算顺序，肯定是先运算等式右边的
//        再赋值给左边的变量，右边的运算是从左到右算的，明白了这两个问题再来看题就不复杂了. count = count +
//                count++;先运算右边，右边从左到右算， 我们要是知道count++的结果就知道了右边的结果了，
//        count在跟左边的count运算之前，会先进行一个复制，将原来的值复制一份，然后它本身的原值会自增，
//        需要注意的是原值的自增跟复制后的数据是没有关系的，自增后，原值变成1了， 这时候进行count +
//                count++进行运算，但是count++参与运算的是复制出来的那份值而不是自增后的结果，
//        由于等式右边的左边的count是在count++运算前就有值的，所以它是0,而count++的结果是0，所以 就是 0 + 0，
//        然后将结果赋给了等式左边的count，结果打印就是0

//        2.
        int count2 = 0;
        count2 = count2++ + count2;
        System.out.println(count2);
//        第二个问题： 原理其实跟第一个问题差不多，但结果肯定是不一样的，因为等式右边的运算是要从左到右的，count++ + count，
//        count先复制一份数据也就是0出来，然后进行自增这时候原值变为1了，而count++参与运算用的是复制出来的0参与
//        运算的，所以count++ + count实际上就是 0 + 1，为什么这里是0+1而不是0+0呢，因为count++运算虽然用的是复制出来
//        的那份数据，但是它本身的值已经自增到了1，而count++右边的那个count拿的是自增后的原值也就是1， 所以这个打印结果是1


//        3.
        int count3 = 0;
        for (int i = 0; i < 100; i++) {
            count3 = count3 + count3++;
        }
        System.out.println(count3);

//        第三个问题： 如果你第一第二个问题已经看懂了，我相信第三个问题已经不言自明了，count = count + count++;打印的结果
//                其实就相当于count = count + count;虽然两者底层运算有点差异，但结果是一样的， 所以这个for循环不管有多少次
//                结果都是0 = 0 + 0，结果都打印为0


//        4.
        int count4 = 1;
        for (int i = 0; i < 100; i++) {
            count4 = count4 + count4++;
//            System.out.println("count4=" + count4);
        }
        System.out.println(count4);

//        第四个问题： 原理也是一样的因为count = count + count++的结果就相当于count = count + count;
//        所以再来看第四个问题的结果就不为怪了，但是第四个问题有些人可能会感到奇怪，因为结果是0，如果我们自己算也会感到奇怪，
//        count首先等于1，for循环第一次1 = 1 + 1++结果为2(不解释了吧)，再运算的数据会越来越大为什么会为0呢？
//        我也感到纳闷，但我知道一旦这个count有一次结构为0，后面的所有for循环计算出的结果都为0了，
//        所以我们找到为0的时候for循环中的i等于多少，
//        经测算i为31的时候，结果为0，而i为30的时候count等于-2147483648，二进制为
//        10000000000000000000000000000000，这时候count + count++， 就相当于count *2
//        了(两个相同的数据相加相当于乘以2， 这个不用解释吧)，乘以2就相当于左移1位，结果为0，所以就出现了这样的结果了

    }
}
