# ThreadLocal是什么

        早在JDK 1.2的版本中就提供Java.lang.ThreadLocal，ThreadLocal为解决多线程程序的并发问题提供了一种新的思路。使用这个工具类可以很简洁地编写出优美的多线程程序。
    ThreadLocal很容易让人望文生义，想当然地认为是一个“本地线程”。其实，ThreadLocal并不是一个Thread，而是Thread的局部变量，也许把它命名为ThreadLocalVariable更容易让人理解一些。
    当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
    从线程的角度看，目标变量就象是线程的本地变量，这也是类名中“Local”所要表达的意思。
    
    
    线程局部变量并不是Java的新发明，很多语言（如IBM IBM XL FORTRAN）在语法层面就提供线程局部变量。在Java中没有提供在语言级支持，而是变相地通过ThreadLocal的类提供支持。
    所以，在Java中编写线程局部变量的代码相对来说要笨拙一些，因此造成线程局部变量没有在Java开发者中得到很好的普及。

# ThreadLocal的接口方法

    ThreadLocal类接口很简单，只有4个方法，我们先来了解一下：
    
        void set(Object value)
        设置当前线程的线程局部变量的值。
    
        public Object get()
        该方法返回当前线程所对应的线程局部变量。
    
        public void remove()
        将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK 5.0新增的方法。需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
    
        protected Object initialValue()
        返回该线程局部变量的初始值，该方法是一个protected的方法，显然是为了让子类覆盖而设计的。这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次。ThreadLocal中的缺省实现直接返回一个null。
    
# ThreadLocal  支持泛型

    值得一提的是，在JDK5.0中，ThreadLocal已经支持泛型，该类的类名已经变为ThreadLocal<T>。API方法也相应进行了调整，新版本的API方法分别是void set(T value)、T get()以及T initialValue()。
    ThreadLocal是如何做到为每一个线程维护变量的副本的呢？其实实现的思路很简单：在ThreadLocal类中有一个Map，用于存储每一个线程的变量副本，Map中元素的键为线程对象，而值对应线程的变量副本
    
    
# ThreadLocal 与 Thread同步机制的比较
    
    ThreadLocal和线程同步机制相比有什么优势呢？ThreadLocal和线程同步机制都是为了解决多线程中相同变量的访问冲突问题。
    
    在同步机制中，通过对象的锁机制保证同一时间只有一个线程访问变量。这时该变量是多个线程共享的，使用同步机制要求程序慎密地分析什么时候对变量进行读写，什么时候需要锁定某个对象，什么时候释放对象锁等繁杂的问题，程序设计和编写难度相对较大。
    而ThreadLocal则从另一个角度来解决多线程的并发访问。ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突。
    因为每一个线程都拥有自己的变量副本，从而也就没有必要对该变量进行同步了。
    ThreadLocal提供了线程安全的共享对象，在编写多线程代码时，可以把不安全的变量封装进ThreadLocal。
    
    由于ThreadLocal中可以持有任何类型的对象，低版本JDK所提供的get()返回的是Object对象，需要强制类型转换。但JDK 5.0通过泛型很好的解决了这个问题，在一定程度地简化ThreadLocal的使用。
    
    概括起来说，对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换时间”的方式。前者仅提供一份变量，让不同的线程排队访问，而后者为每一个线程都提供了一份变量，因此可以同时访问而互不影响。
    

# ThreadLocal 一些使用场景
 
    首先说明ThreadLocal存放的值是线程内共享的，线程间互斥的，主要用于线程内共享一些数据，避免通过参数来传递，这样处理后，能够优雅的解决一些实际问题。
    比如hibernate中的OpenSessionInView，就是使用ThreadLocal保存Session对象，还有我们经常用ThreadLocal存放Connection
    
    
# 为什么要用 ThreadLocal    
    
    首先要能清楚为什么要使用ThreadLocal，如果没有ThreadLocal，能不能解决问题。
    
    没有ThreadLocal的话，每个Thread中都有输入自己的一个本地变量，但是在整个Thread的生命中，如果要穿梭很多class的很多method来使用这个本地变量的话，就要一直一直向下传送这个变量，显然很麻烦。
    那么怎么才能在这个Thread的生命中，在任何地方都能够方便的访问到这个变量呢，这时候ThreadLocal就诞生了。
    
    ThreadLocal就是这么个作用，除此之外和通常使用的本地变量没有任何区别。
