# JavaSE









































































## 🙀多态



**什么是多态?**

表示一个对象表现出的多种形态, 具体表现为父类引用指向子类对象

**多态的分类**

- 普通父类多态
- 抽象类多态
- 接口多态: 忽略子类的实现细节

**多态的利弊**

- 好处: 提高了程序的拓展性
- 弊端: 不能使用子类独有的方法

**多态的特点**

- 对象类型和引用类型之间具有继承\实现关系
- 引用变量发出的方法到底调用哪个类中的方法, 只有在程序运行期间才能确定
- 多态不能调用子类中独有的方法
- 如果子类重写方法, 调用子类的重写方法, 如果子类没有重写方法, 调用父类的方法

**多态的转型**

- 向上转型
- 向下转型: 首先要判断父类变量的引用是否指向子类对象





























## 🦁抽象类

**什么是抽象类?**

被abstract关键字修饰, 不能被实例化的类

**抽象类的特点**

- 有抽象方法的类一定是抽象类, 抽象类中可以有非抽象方法
- 抽象类的子类要么重写所有父类的抽象方法, 要么将子类定义为抽象类
- 抽象类的构造方法用于子类访问父类的数据初始化
- 抽象类主要用于代码复用, 强调所属关系



















## 🙊接口

**什么是接口?**

对类行为进行约束的一组规范

**接口的特点**

- 接口主要用于对类的行为进行约束
- 通过接口多态, 进行实例化
- 对于接口的实现类, 要么实现接口的所有抽象方法, 要么定义为抽象类
- 成员变量只能是常量, 默认修饰符public static final
- 成员方法只能是抽象方法 默认修饰符 public abstract
- 接口可以实现多继承





















## 👺反射



### 获取Class对象

- 通过具体类获得

  ```java
  Class clazz = User.clss
  ```

- 通过全类名获得

  ```java
  Class clazz = Class.forName("com.dong.entity.User")
  ```

- 通过具体对象获得

  ```java
  Class clazz = user.getClass
  ```

- 通过类加载器获得

  ```java
  Class clazz = ClassLoader.getSystemClassLoader().loaderClass("com.dong.entity.User")
  ```



### 创建对象实例

- 直接使用newInstance()方法,默认使用无参

  ```java
  User user = clazz.newInstance()
  ```

- 先获得构造器,使用构造器创建对象

  ```java
  Constructor constructor = clazz.getConstructor(String.class,Integer.class)
  User user = constructor.newInstance("大白",222)
  ```



### 获取方法

- 获取所有公共方法,包括继承的方法

  ```java
  Method[] methods = clazz.getMethods()
  ```

- 获取所有方法,但不包括继承的方法

  ```java
  Method[] methods = clazz.getDeclaredMethods()
  ```

- 获取特定的公共方法

  ```java
  Method method = clazz.getMethod(Name,ParameterType)
  ```

- 获取特定的非公共方法

  ```java 
  Method method = clazz.getDeclaredMethod(Name,ParameterType)
  ```



### 获取字段

- 获取所有公共字段

  ```java
  Field[] field = clazz.getFields()
  ```

- 获取所有字段

  ```java
  Field[] field = clazz.getDeclaredFields()
  ```

- 获取特定的公共字段

  ```java
  Field field = clazz.getField(Name)
  ```

- 获取特定的非公共字段

  ```java
  Field field = clazz.getDeclaredField(Name)
  ```

  



### 获取构造器

- 获取所有公共构造器

  ```java
  Constructor[] constructor = clazz.getConstructors()
  ```

- 获取所有构造器

  ```java
  Constructor[] constructor = clazz.getDeclaredConstructors()
  ```

- 获取特定的公共构造器

  ```java
  Constructor constructor = clazz.getConstructor(ParameterType)
  ```

- 获取特定的非公共构造器

  ```java
  Constructor constructor = clazz.getDeclaredConstructor(ParameterType)
  ```

  



### 调用方法

使用Method类的invoke()方法

methodName.invoke(Object,Object... args)

```
User user = clazz.newInstance()

Method setName = clazz.getMethod("setName",String.class)
Method getName = clazz.getMethod("getName")

setName.invoke(user,"小白")
Object result = getName.invoke(user)
```









## 🐓内部类

可以将一个类定义在另一个类或方法中,这样的类称为内部类



### 成员内部类

将类定义在另一个类中成员的位置

```java
public class Inner {
    // 定义在类内部
    class Demo{
        public void say(){
            System.out.println("hello!");
        }
    }
}
```

成员内部类可以无条件访问外部类的所有成员属性和成员方法(包括private成员和静态成员)

成员内部类依赖于外部类, 要创建内部类的对象, 先要创建外部类的对象

```java
public class Inner {
    private static final String name ="张三";
    public static void say(){
        System.out.println("我是外部类方法!");
    }

    class Demo{
        public void go(){
            // 调用外部类方法及变量
            System.out.println(name);
            Inner.say();
        }
    }
}

/*
	测试
*/
@Test
public void test1(){
    // 先创建外部类实例
    Inner.Demo demo = new Inner().new Demo();
    demo.go();
}
```

外部类访问内部类时,必须要先实例化内部类的对象

```java
public class Inner {

    public void go(){
        // 实例化内部类
        new Demo().say();
    }

    class Demo{
        private final String name = "李四";
        public void say(){
            System.out.println("我是内部类方法!");
        }
    }
}
```

成员内部类可以拥有如成员方法般的多种修饰符

```java
public class Inner {
    // public
    public class Demo{}
    // private
    private class Demo2{}
    // protected
    protected class Demo3{}
    // default
    class Demo4{}
}
```

当外部类和内部类拥有同名的成员变量和方法时,会发生隐藏现象,默认调用内部类的成员

使用外部类.this.变量 和 外部类.this.方法,指定使用外部类变量及方法

```java
public class Inner {
    private String name = "张三";
    public void say(){
        System.out.println("外部类方法!");
    }

    class Demo{
        private String name = "李四";
        public void say(){
            System.out.println("内部类方法!");
        }
        public void go(){
            System.out.println(Inner.this.name);
            Inner.this.say();
        }
    }
}
```



### 局部内部类

将内定义在另一个类的方法中

```java
public class Inner {
    public void method() {
        class Demo {
            public void say() {
                System.out.println("hello");
            }
        }
        // 在方法内部调用内部类
        new Demo().say();
    }
}

/*
	测试
*/
@Test
public void test1(){
    Inner inner = new Inner();
    inner.method();
}
```

局部内部类的访问权限仅限于方法内或者该作用域内

局部内部类和局部变量一样,不能有public, private, protected以及static修饰符



### 匿名内部类

使用内部类能够在实现父类或者接口方法的同时, 产生一个对象

```java
// 接口
public interface Demo{
    void say();
}

/*
	测试
*/

// 产生对象直接调用
@Test
public void test1(){
    Demo demo = new Demo() {
        @Override
        public void say() {
            System.out.println("匿名内部类!");
        }
    };
    demo.say();
}
```

匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。匿名内部类在编译的时候由系统自动起名为Outter$1.class。一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。

```java
public class Inner {
    // 需要接口类型的参数
    public void go(Demo demo){
        demo.say();
    }
}

interface Demo{
    void say();
}

/*
	测试
*/
@Test
public void test1(){
    Inner inner = new Inner();
    // 匿名内部类
    inner.go(new Demo() {
        @Override
        public void say() {
            System.out.println("匿名内部类!");
        }
    });
}
```



### 静态内部类

和成员内部类的区别是, 静态内部类不依赖于外部类, 但是静态内部类不能调用外部类的非static成员变量或方法

```java
public class Inner{
    private static final String name = "张三";
    // 无法调用非static方法
    private Integer age = 22;
    public static void say(){
        System.out.println("外部类方法!");
    }

    static class Demo{
        public void say(){
            System.out.println(name);
            Inner.say();
        }
    }
}

/*
	测试
*/
@Test
public void test1(){
    // 无依赖于外部类
    Inner.Demo demo = new Inner.Demo();
    demo.say();
}
```



### 细节

- 为什么成员内部类可以无条件访问外部类?

  ```markdown
  编译器会默认为成员内部类添加一个指向外部类对象的引用
  虽然成员内部类的构造函数是空参的,但编译器仍会默认添加一个参数,类型是内部类指向外部类对象的引用类型,从而达到将引用传入的效果
  ```

- JDK8之前, 使用局部内部类和匿名内部类访问的变量只能是final类型

  为什么使用final修饰

  ```java
  会出现外部方法已经结束,而局部内部类还没有结束的情况,如果局部内部类需要外部方法的传参,而方法已经结束了,就会出现错误
  所以编译器采用复制的方法,在编译期间变量字面值确定的情况下,在匿名内部类或局部方法的常量池中添加一个内容相同的字面量或直接键相应的字节码嵌入到执行字节码中,这样就可以和方法中局部变量分隔开
  但是,如果修改方法中的局部变量,又该怎么办呢,所有要求局部内部类访问的变量只能是final类型,使字面量无法修改
  ```

- 为什么使用内部类

  ```markdown
  1. 每个类都能独立继承一个父类,不管外部类是否继承了父类,使用多继承的解决方案变得完整
  2. 方便将存在一定逻辑的类组织在一起,又实现对外的隐藏
  3. 方便编写事件驱动
  4. 方便编写线程代码
  5. 简化代码,利于维护
  ```

  

  

## 🐠Lambda表达式

lambda作为就Java8的新特性,可以取代大部分匿名内部类,达到简化代码的作用



### 对接口的要求

虽然Lambda表达式可以对接口进行简单的实现,但并不是所有接口都可以使用Lambda表达式,Lambda规定接口中只能有一个需要被实现的方法,并不是说接口中只能有一个方法!(比如说default修饰的方法,会有默认实现)



### @FunctionInterface

修饰函数式接口,要求接口中只能有一个抽象方法



### 基础语法

无参无返回值

```java
/* 无参无返回 */
@FunctionalInterface
public interface NoReturnNoParam {
    void method();
}

/*
	测试
*/
@Test
public void test1(){
    NoReturnNoParam noReturnNoParam = () -> {
        System.out.println("hello");
    };
    noReturnNoParam.method();
}
```

一个参数无返回值

```java
/* 一个参数无返回 */
@FunctionalInterface
public interface NoReturnOneParam {
    void method(Integer num);
}

/*
	测试
*/
@Test
public void test2(){
    NoReturnOneParam noReturnoneParam = (a) -> {
        a += 1;
        System.out.println(a);
    };
    noReturnoneParam.method(9);
}
```

多个参数无返回值

```java
/* 多参数无返回 */
@FunctionalInterface
public interface NoReturnMultiParam {
    void method(int x,int y);
}

/*
	测试
*/
@Test
public void test3(){
    NoReturnMultiParam noReturnmultiParam = (x,y) -> {
        System.out.println(x+y);
    };
    noReturnmultiParam.method(1,2);
}
```

无参有返回值

```java
/* 无参有返回值 */
@FunctionalInterface
public interface ReturnNoParam {
    int method();
}

/*
	测试
*/
@Test
public void test5(){
    ReturnNoParam ReturnNoParam = () -> {
        return 11;
    };
    System.out.println(ReturnNoParam.method());
}
```

一个参数有返回值

```java
/* 一个参数有返回值 */
@FunctionalInterface
public interface ReturnOneParam {
    int method(int num);
}

/*
	测试
*/
@Test
public void test4(){
    ReturnOneParam ReturnOneParam = (a) -> {
        return a + 1;
    };
    System.out.println(ReturnOneParam.method(99));
}
```

多个参数有返回值

```java
/* 多个参数有返回值 */
@FunctionalInterface
public interface ReturnMultiParam {
    int method(int arg1, int arg2);
}

/*
	测试
*/
@Test
public void test6(){
    ReturnMultiParam ReturnMultiParam = (x,y) -> {
        System.out.println(x+y);
        return x+y;
    };
    ReturnMultiParam.method(99,1);
}
```



### 语法简化

- 简化类型参数,可以不写参数类型,必须所有参数类型都不写
- 简化参数小括号,如果只有一个参数,可与不写小括号
- 简化大括号,如果方法体只有一条语句可以省略大括号
  - 如果一条语句是return语句,return可以忽略

```java
/* 一个参数有返回值 */
@FunctionalInterface
public interface ReturnOneParam {
    int method(int num);
}

/*
	测试
*/
@Test
public void test4(){
    ReturnOneParam ReturnOneParam = a -> a + 1;
    System.out.println(ReturnOneParam.method(99));
}
```



### Lambda表达式常用示例

***1. 引用方法***

有时我们不必亲自重写匿名内部类的方法,可以利用Lambda表达式指向已经实现的接口方法

语法: 方法归属者::方法 静态方法归属类;普通方法归属对象

```java
public class Exe1 {

 public static void main(String[] args) {
     // Lambda普通形式
     ReturnOneParam returnOneParam1 = num -> method1(num);
     System.out.println(returnOneParam1.method(99));

     // Lambda简化形式
     // 静态方法归属类
     ReturnOneParam returnOneParam2 = Exe1::method1;
     System.out.println(returnOneParam2.method(99));

     // 普通方法归属对象
     Exe1 exe1 = new Exe1();
     ReturnMultiParam returnMultiParam2 = exe1::method2;
     System.out.println(returnMultiParam2.method(99, 1));
 }

 /*
     接口的实现方法,返回值与参数与接口方法一致
  */
 public static int method1(int num){
     return num+1;
 }

 public int method2(int arg1, int arg2){
     return arg1+arg2;
 }
}
```



***2. 引用构造方法***

需要创建接口,将该接口作为对象的生成器

需要创建接口,将该接口作为对象的生成器

```java
public class Exe2 {
 public static void main(String[] args) {
     NoParamConstructor create = () -> new User();
     User user = create.getUser();
     System.out.println(user);

     NoParamConstructor create1 = User::new;
     User user1 = create1.getUser();
     System.out.println(user1);

     ParamConstructor create3 = User::new;
     User user2 = create3.getUser("张三", 22);
     System.out.println(user2);
 }
}

interface NoParamConstructor{
 User getUser();
}

interface ParamConstructor{
 User getUser(String name,int age);
}
```



***3. 创建线程***

通过创建Thread对象,然后通过匿名内部类重写run()方法,可以使用Lambda表达式简化这一过程

```java
Thread t = new Thread(() -> {

 for (int i = 0; i < 10; i++) {
     System.out.println(2 + ":" + i);
     }
});
t.start();
```



***4. 遍历集合***

调用集合的``public void forEach(Consumer<? super E> action)`` Consumer是JDK为我们提供的函数式接口

```java
public class ListDemo {
 public static void main(String[] args) {
     List<String> list = new ArrayList<>();
     list.add("大白");
     list.add("小白");

     list.forEach(System.out::println);

     list.forEach(str -> {
         if (str.equals("大白")){
             System.out.println(true);
         }
     });
 }
}
```



***5. 删除集中的元素***

调用集合的``public boolean removeIf(Predicate<? super E> filter)`` Predicate也是JDK提供的函数式接口

```java
public class ListDemo2 {
 public static void main(String[] args) {
     List<String> list = new ArrayList<String>();
     list.add("大白");
     list.add("小白");

     list.removeIf(str -> str.equals("大白"));

     list.forEach(System.out::println);
 }
}
```



***6. 集合元素的排序***

以前我们为集合元素排序,调用sort方法,传入比较器匿名内部类,重写Comparator方法

```java
public class ListDemo3 {
 public static void main(String[] args) {
     List<Integer> list = new ArrayList<Integer>();
     list.add(13);
     list.add(14);
     list.add(89);
     list.add(5);

     /*list.sort(new Comparator<Integer>() {

         @Override
         public int compare(Integer o1, Integer o2) {
             return o1 - o2;
         }
     });*/

     list.sort((o1,o2) -> o1 - o2);

     list.forEach(System.out::println);
 }
}
```



### 与匿名内部类的区别

- 所需类型不同

  - 匿名内部类: 可以是接口\抽象类\具体类
  - Lambda: 只能是接口
- 使用限制不同

  - 匿名内部类: 接口中可以有多个非默认抽象方法
  - Lambda: 接口中有一个需要实现的抽象方法
- 使用原理不同

  - 匿名内部类: 编译生成匿名类字节码
  - Lambda: 在运行期间动态生成字节码






## 🐛API

### MAth

```java
static int abs(int a)// 绝对值
    
static double floor(double a)// 向下取整
    
static double ceil(double a)// 向上取整
    
static int round(float a)// 四舍五入
    
static int max(int a,int b)// 取最大值
    
static int min(int a,int b)// 取最小值
    
static double pow(double a,double b)// a的b次幂
    
static double random()// [0.0-1.0) double随机数
```



### System

```java
static void exit(int status)// 终止当前运行JVM,非零表示异常终止
    
static long currentTimeMillis()// 返回当前时间(以毫秒)

// src1 : 原数组  src1starte : 原数组起始索引  length : 拷贝长度
static void arrayCopy(Object[] src1,int src1Starte, Object[] src2, int src2Starte, int length )
```



### Object

所有子类中都有这些方法

```java
native Object clone()// 创建并返回一个对象的拷贝,x.clone() != x 并且 x.clone().getClass() == x.getClass
    
boolean equals(Object obj)// 默认比较两个对象地址值是否相等,内部用"=="进行比较,如果进行重写可以比较属性
    
void finalize()// 当GC确定不存在该对象的引用时,由对象的GC调用该方法
    
Class<?> getClass()// 获取运行时对象的Class对象
    
int hashCode()// 获取对象的hash值
    
void notify()// 唤醒在该对象上等待的某个线程
    
void notifyAll()// 唤醒在该对象上等待的全部线程
    
String toString()// 输出类的全类名@实例的哈希吗的16进制的字符串形式
    
void wait()// 让当前线程进入等待状态
    
void wait(long timeout)// 让当前线程进入等待状态,知道其他线程调用notify()\notifyAll()或者超过等待时间
    
void wait(long timeout,int nanos)// nanos表示超时时间,等待时间需要加上超时时间
```



### Objects

```java
int compare(T,T,comparator<? super T>)// 如果参数相同,则返回0,不相同,返回c.compare(a,b)
boolean deepEquals(Object,Object)// 检查两个对象是否相等,如果两个参数都相同,则返回true
boolean equals(Object,Object)// 
int hash(Object...)
int hashCode(Object)
boolean isNull(Object)
boolean nonNull(Object)
T requireNonNull(T)
T requireNonNull(T,String)
T requireNonNull(T,Supplier<String>)
String toString(Object)
String toString(Object,String)
```



### BigDecimal

使用IEEE 754数值导致小数运算不精确

需要精准的计算结果使用BigDecimal类中提供的方法, 构造方法的参数使用字符串

```java
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bd1 = new  BigDecimal("0.1");
        BigDecimal bd2 = new  BigDecimal("0.2");

        // 加法
        BigDecimal add = bd1.add(bd2);
        System.out.println(add);

        // 减法
        BigDecimal subtract = bd1.subtract(bd2);
        System.out.println(subtract);

        // 乘法
        BigDecimal multiply = bd1.multiply(bd2);
        System.out.println(multiply);

        // 除法
        BigDecimal divide = bd1.divide(bd2);
        System.out.println(divide);
    }
}
```

如果10除3 不会得到精准结果, 直接报错, 解决办法是传入额外参数(保留小数点位数, 舍入模式)

```java
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bd1 = new  BigDecimal("11");
        BigDecimal bd2 = new  BigDecimal("3");

        // 11 / 3 = 3.666666666666667
        // 进一
        BigDecimal divide = bd1.divide(bd2, 2, BigDecimal.ROUND_UP);
        // 去尾
        BigDecimal divide1 = bd1.divide(bd2, 2, BigDecimal.ROUND_FLOOR);
        // 四舍五入
        BigDecimal divide2 = bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_DOWN);

        System.out.println(divide);// 3.67
        System.out.println(divide1);// 3.66
        System.out.println(divide2);// 3.67
    }
}
```



### Arrays

Arrays类用来操作数组

```java
List asList(T...a)// 转化成List对象

String toString(Object[] arr)// 将数组转化成字符串打印
    
void fill(Object[] arr,int num)// 给数组赋相同的值num
void fill(Object[] arr,int index1,int index2,int num)// 对数组[index1,index2)区间给数组复制num
    
void sort(Object[] arr)// 对数组进行升序排序
void sort(Object[] arr,int index1,int index2)// 对数组[index1,index2)区间进行排序
    
boolean equals(Object[] arr1,Object[] arr2)// 判断数组arr1和arr2元素是否相同
    
int binarySearch(Object[] arr,int num)// 如果num在arr之中返回索引,不在返回负值 
```





## 🦔异常

> 发现错误的理想时机是在编译阶段，也就是在运行程序之前。然而编译期间并不能找到所有的错误，余下的问题必须在运行期间解决。这就需要错误源能够通过某种方式，把适当的信息传递给某个接受者——该接受者知道如何正确处理这个问题。
>
> ​																																										Java编程思想（第四版）



### 概念

异常指不期而至的各种状况，如除0操作、用户输入不合法、内存溢出、读取文件不存在等等情况。

Java异常是一个描述在代码段中发生异常的对象，当发生异常时，一个代表该异常的对象被创建并且在导致该异常的方法中被抛出，而该方法可以选择自己处理或者传递该异常。

使用异常不仅降低了处理错误代码的复杂度，并且使代码变得更加健壮。



### 异常的体系结构

Java把异常当作对象来处理，并定义一个基类`java.lang.Throwable`作为所有异常的超类。

Java异常层次结构图：

![](https://raw.githubusercontent.com/MatubCA/Image/main/img2/202208061135300.png)

在Java API中已经定义了许多异常类，这些异常类分为两大类，**错误`Error`和异常`Exception`**。

- Error

  Java虚拟机无法解决的严重问题，如：JVM内部错误，资源耗尽等情况。一般不编写针对性的代码进行处理。

- Exception

  因为其他编程错误或偶然的外在因素导致的一般性问题，如：控制针访问、视图读取不存在的文件、网络连接中断、数组索引越界等情况。可以编写针对性的代码进行处理。

遇到这些异常情况有两种解决办法：一种时抛出异常，一种是捕获异常。

如果我们遇见异常，解决是最好的，不能解决交由上层环境，如果上层环境还是不能解决，继续向上抛，直到main()方法将异常抛给JVM，JVM将使用默认的异常处理程序：终止程序，打印异常信息

捕获异常的最佳时机是在编译期间，但有些异常是在运行期间才会发生的，如：除0操作、数组索引越界

所以，Exception又分为

- 编译时异常（受检异常）

  是指编译器要求必须处理的异常，是程序在运行期间由于外界因素导致的一般性错误。如果不进行处理，可能导致意想不到的结果。一般编译器会进行提示。如：IOException、SQLException、ClassException

- 运行时异常

  编译不要求强制处理的异常，一般是在编程过程中的逻辑错误，可以不做处理。因为这类异常非常普遍，如进行全局处理，会影响程序的可读性以及运行效率。程序员应该积极避免这类异常。对于这类异常，或者叫Bug进行try...catch处理是毫无意义的。java规定，运行时异常将由运行时系统自动抛出，允许应用程序忽略运行时异常

除了RuntimeException和Error其余都是受检异常，会在编译期间检测异常



### 常见异常

- ArrayIndexOutOfBoundsException

  ```java 
  int[] array = {1,2,3,4,5};
  for (int i = 0; i < 6; i++) {
      System.out.println(array[i] + "");
  }
  ```
  
- NUllPointException

  ```java
  int[] array = {1,2,3};
  array = null;
  for (int i = 0; i < array.length; i++) {
      System.out.println(array[1]);
  }
  ```

- ArithmeticException

  ```java
  int x = 0;
  int y = 3 / x;
  System.out.println(y);
  ```

- ClassCastException

  ```java
  Object date = new Date();
  CommonException exception = new CommonException();
  exception = (CommonException) date;
  ```



### 异常处理机制

***1）抛出异常***

对于在当前环境中没办法获得更多信息去处理这个异常，或者在当前环境中处理异常没有意义的时候，我们需要把这个异常抛出这个环境，交由上层方法调用者去处理。

抛出异常后，会有几件事情发生：

1. 使用new在堆上创建一个异常对象。
2. 终止当前的执行路径，并且在当前环境中弹出对异常对象的引用，只要异常被捕获，根据这个异常对象的引用，就能控制程序的指向。
3. 异常处理机制接管程序，并寻找一个恰当的地方（异常处理程序或异常处理器），继续执行程序，它的任务是将程序从错误状态中恢复，使程序要么换种方法运行，要么继续运行下去。



***2）捕获异常***

在方法抛出异常后，系统转而寻找合适的异常处理器。潜在的异常处理器是异常发生时依次存留在调用栈中的方法的集合。当方法抛出的异常类型和异常处理器所能处理的异常类型相符，或是异常处理器处理异常类型的子类时，达到匹配。运行时系统从发生异常的方法开始，依次回查调用栈中的方法，直到找到含有合适异常处理器的方法执行，当运行时系统遍历调用栈而未找到合适的异常处理器的时候，则运行时系统终止，即Java程序终止



### 异常处理语法

 ***1）try...catch***

try代码块中的区域是监控区域，当try代码块中的代码出现异常的时候，自动抛出异常，创建异常对象

catch代码块用于捕获异常，执行异常程序，catch中的代码将保证程序正常运行下去

一个语句中产生多种异常时，这时需要多重catch语句，排列规则是：先小后大，先子类再父类，否则捕获底层异常的catch子句会被屏蔽

try语句可以被嵌套，如果内层try中产生异常，会先匹配内层catch语句，不匹配再和外层catch语句进行匹配

对于一些资源来说，并不属于Java资源你，不由JVM进行管理，所以我们在打开后需要自己手动关闭，可以使用try开启资源自动管理功能，执行完语句, 资源自动关闭，交由JVM进行管理

```java
// 语法
try(打开资源){
    
}
```

```java
public void indexExp() {
    /*
     * Description: 对IndexOutOfBoundsException捕获,执行PlanB
     * @author: 苏无及
     * @date: 2022/8/6 19:56
     * @param:[]
     * @return:void
     */
    int[] array = {1, 2, 3, 4, 5};
    try {
        for (int i = 0; i < 6; i++) {
            System.out.println(array[i] + "");
        }
    } catch (IndexOutOfBoundsException e) {
        System.out.println("IndexOutOfBoundsException");
    }
}

/*
	测试
*/
@Test
public void test1(){
    CatchException exception = new CatchException();
    exception.indexExp();
}
```



 ***2）throw***

用于抛出异常，手动创建异常对象，不需要JVM创建对象

程序执行完throw之后立即停止执行，throw之后的语句不会执行，最邻近的try块检测自己是否有与异常对象相匹配的catchh语句,如果发现匹配的块，控制转向该语句，没有发现则使次包围的try进行检查，如果一直没有发现，程序将执行结束

所有的java内置的运行时异常创建对象，有两个构造函数，一个空参，一个带有一个字符串参数，参数用于指定异常的描述，可以通过print直接打印对象，或者使用getMessage()方法从而得到字符串

```java
public void throwIndexExp() {
    /*
     * Description: throw抛出异常
     * @author: 苏无及
     * @date: 2022/8/7 20:43
     * @param:[]
     * @return:void
     */
    int[] array = {1, 2, 3, 4, 5};
    for (int i = 0; i < 6; i++) {
        if (i == 5){
            throw new IndexOutOfBoundsException("数组索引越界!");
        }
        System.out.println(array[i] + "");
    }
}

/*
	测试
*/
@Test
public void test2(){
    CatchException exception = new CatchException();
    try {
        exception.throwIndexExp();
    } catch (IndexOutOfBoundsException e) {
        System.out.println("数组索引越界");
    }
}
```



 ***3）throws***

用于在方法签名中，声明该方法可能抛出的异常类型，告知方法调用者

```java
public void throwsIndexExp() throws IndexOutOfBoundsException{
    /*
     * Description: 使用throws声明异常类型
     * @author: 苏无及
     * @date: 2022/8/7 20:53
     * @param:[]
     * @return:void
     */
    int[] array = {1, 2, 3, 4, 5};
    for (int i = 0; i < 6; i++) {
        System.out.println(array[i] + "");
    }
}

/*
	测试
*/
@Test
public void test3(){
    CatchException exception = new CatchException();
    try {
        exception.throwsIndexExp();
    } catch (IndexOutOfBoundsException e) {
        System.out.println("数组索引越界!");
    }
}
```



 ***4）finally***

finally语句块总会被执行，不管catch中的语句是否执行。主要用于回收在try里打开的资源。

```java
public void finallyExp(){
    /*
     * Description: 使用finally
     * @author: 苏无及
     * @date: 2022/8/7 20:59
     * @param:[]
     * @return:void
     */
    int[] array = {1, 2, 3, 4, 5};
    try {
        for (int i = 0; i < 6; i++) {
            System.out.println(array[i] + "");
        }
    } catch (IndexOutOfBoundsException e) {
        System.out.println("数组索引越界!");
    } finally {
        System.out.println("finally");
    }
}

/*
	测试
*/
@Test
public void test4(){
    CatchException exception = new CatchException();
    exception.finallyExp();
}
```



### 执行顺序

对于try、catch、finally的执行顺序：

- 如果try中没有异常，try-->finally
- 如果try中有异常，try-->catch-->finally
- 当try、catch中有return时，也会执行finally，注意return的时候注意是否受finally的影响
- finally中有return的时候，会直接在finally中退出，导致try、catch中的return失效



### throw和throws的区别

- trow出现在函数体中，throws出现在方法签名中
- throws表示可能出现的异常类型，throw则一定抛出某个异常对象
- 两者都是抛出异常，交由上次环境进行处理，如果还是不处理，JVM默认处理
- throws可以表示抛出多个异常类型，用逗号分隔



### 自定义异常

- 创建异常类（见名知意）
- 继承内置异常类
- 提供有参无参构造

```java
// 自定义年龄越界异常类
public class AgeOutOfBoundsException extends RuntimeException {
    
    public AgeOutOfBoundsException() {
    }

    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}
```



### Throwable的成员方法

- **String getMessage()**

  返回此throwable的详细消息字符串

  返回的是在创建异常对象时，当作参数传入的字符串

  ```java
  throw new IndexOutOfBoundsException("数组索引越界!");
  ...
  java.lang.IndexOutOfBoundsException: 数组索引越界!
  ```

- **String toString()**

  返回此可抛出的简短描述

  ```java
  java.lang.ArrayIndexOutOfBoundsException: 5
  ```

- **void printStackTrace**

  把异常的错误信息输出在控制台

  ```java
  java.lang.ArrayIndexOutOfBoundsException: 5
  	at com.dong.exceptionDemo.CommonException.indexOutExp(CommonException.java:25)
  	at com.dong.exceptionDemo.CommonExceptionTest.test1(CommonExceptionTest.java:20)
  ```

  







































































# 资料

https://www.cnblogs.com/dolphin0520/p/3811445.html

https://www.cnblogs.com/haixiang/p/11029639.html

https://www.cnblogs.com/Qian123/p/5715402.html















