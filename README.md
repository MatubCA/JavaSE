# JavaSE

<!--目录-->

- [多态](# 多态)
- [🦁抽象类](#🦁抽象类)





// TODO





<!--目录-->







































































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





























## [🦁抽象类](#JavaSE)

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





## 🐛常用API

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
List asList(T...a)// 转化成List对象，注意返回的对象不是ArrayList或是Vector而是一个长度固定的List集合，只能使用相应包装类的的数组

String toString(Object[] arr)// 将数组转化成字符串打印
    
void fill(Object[] arr,int num)// 给数组赋相同的值num
void fill(Object[] arr,int index1,int index2,int num)// 对数组[index1,index2)区间给数组复制num
    
void sort(Object[] arr)// 对数组进行升序排序
void sort(Object[] arr,int index1,int index2)// 对数组[index1,index2)区间进行排序
    
boolean equals(Object[] arr1,Object[] arr2)// 判断数组arr1和arr2元素是否相同
    
int binarySearch(Object[] arr,int num)// 如果num在arr之中返回索引,不在返回负值 
```



### Date

用于表示时间

北京时间 = GMT+8h

GMT：世界标准时间

时间原点：1970，1，1，00.00.00

```java
Date()// 表示当前时间对象
Date(long time)// 从时间原点开始经历time毫秒后的时间对象
long getTime()// 获取当前时间对象的毫秒值
void setTime(long time)// 设置时间与带参构造一致,要不直接在创建Date对象的时候设置时间,要么在空参构造之后,使用setTime()设置时间
```



### SimpleDateFormat

用于格式化时间

```java
SimpleDateFormat()// 默认格式化时间
SimpleDateFormat("yyyy-MM-dd HH:mm:ss")// 指定格式化时间
String format(Date time)// 格式化时间
Date parse(String timeStr)// 解析时间
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

  

## 🦠集合框架

> 在实现方法时，选择不同的数据结构会导致其实现风格和性能有着巨大差异
>
> ​																																						Java核心技术 卷一（第8版）

### 概述

数组存在的弊端：

- 一旦声明之后，长度不可变
- 声明数组的类型决定了存储元素的类型
- 数组中存储的元素是有序的、可重复的、特点单一
- 没有定义属性及方法，操作不方便

使用集合的好处：

- 提供了存储数据的灵活性，可以存储不同数据类型的数据，还可以保存具有隐射关系的键值对

### 继承体系

![](https://raw.githubusercontent.com/MatubCA/Image/main/img2/202208072152941.gif)



### Collection接口

Collection接口是List、Set、Queue接口的父接口，其中定义的方法对于所有Collection的子类都有效。并且Collection接口实现了Iterator接口，所有Collection的子类都可以使用iteration和增强for循环。

Collection接口的方法：

```java
void add(Object obj)// 添加元素
    
void addAll(Collection coll)// 添加集合
    
int size()// 获取元素个数
    
void clear()// 清空集合
    
boolean isEmpty()// 判断是否是空集合
    
boolean contains(Object obj)// 是否包含某个元素
    
boolean containsAll(Collection coll)// 是否包含某个集合
    
boolean remove(Object obj)// 只会删除找到的第一个元素
    
boolean removeAll(Collection coll)// 取当前集合的差集
    
boolean removeIf(Object obj)// 根据条件删除，使用Lambda表达式
    
boolean retainAll(Collection coll)// 取交集,把交集的结果存入当前集合
    
boolean equals(Object obj)// 元素是否相等
    
Object[] toArray()// 转成对象数组
    
int hashCode()// 获取当前集合对象的哈希值
    
Iterator Iterator()// 获取迭代器,用于遍历集合
```

### Iterator接口

只有实现了Iterator接口的类才允许使用迭代器和增强for循环，而增强for循环底层调用了Iterator接口方法.

迭代器方法：

```java
/*
boolean hasNext() 检测指针是否有下一个元素,指针默认在第一个元素之前
Object Next() 指针下移,返回所指元素
remove() 删除元素
*/

@Test
public void test1() {
    List<String> list = new ArrayList<>();
    list.add("大白");
    list.add("小白");
    list.add("哈哈");
    // 先使用hashNext()判断是否还有下一个元素
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
        if (iterator.next().equals("大白")){
            iterator.remove();
            System.out.println(iterator.next());
        }
        System.out.println(iterator.next());
    }
}
```

迭代器遍历不受索引影响

```java
// 在我们想要删除所有b元素时候,如果两个元素在一起,删除一个,后面的数据将会向前移动,补充空缺索引,导致数据删除失败
@Test
public void test2(){
    ArrayList<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("b");
    list.add("c");
    list.add("d");
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equals("b")){
            list.remove(i);
        }
    }
    list.forEach(System.out::println);
}
```

使用增强for循环，遍历出的数据会装在一个额外变量中

```java
// 如果对s进行赋值,可以发现并没有改变集合中的数据
// s是一个额外变量,作用是存储集合中取出的元素
@Test
public void test2(){
    ArrayList<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    for (String s : list) {
        s = "Boss";
    }
    list.forEach(System.out::println);
}
```

一个迭代器对象只能进行一次遍历，指针移到尾部不能自动回到顶部

```java
```



### List接口

通常使用List取代数组

List中元素有序、可重复，每个元素都有对应的索引，可以根据索引存取数据



==***1）List接口方法***==

```java
void add(int index,Object obj)// 在指定位置插入元素

boolean addAll(int index,Collection coll)// 在指定位置,添加集合
    
Object get(int index)// 获得指定索引处的元素
   
int indexOf(Object obj)// 从头遍历,返回第一次发现元素的位置
    
int lastIndexOf(Object obj)// 从尾遍历,返回第一次发现元素的位置
    
Object remove(int index)// 删除指定位置的元素,并返回
    
Object set(int index,Object obj)// 将指定位置的元素进行替换，并返回该元素
    
List subList(int starIndex,int endIndex)// 返回两个索引之间的子集合
```



==***2）ArrayList***==

最常用的List接口实现类，基于动态数组实现，支持随机访问

在JDK8之前，一开始就创建一个长度为10的数组

在JDK8之后，一开始创建一个长度为0的数组，当添加第一个元素的时候，再创建一个初始容量为10的数组，容量满了之后，扩容1.5倍

```markdown
The array buffer into which the elements of the ArrayList are stored. The capacity of the ArrayList is the length of this array buffer. Any empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA will be expanded to DEFAULT_CAPACITY when the first element is added
(存储 ArrayList 元素的数组缓冲区。 ArrayList 的容量就是这个数组缓冲区的长度。当添加第一个元素时，任何具有 elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA 的空 ArrayList 都将扩展为 DEFAULT_CAPACITY)

```





==***3）LinkedList***==

基于双向链表实现，内部没有声明数组，而是定义了Node类型的first和last用于记录首末元素

可以快速的在链表中插入和删除元素，还可以用作栈、队列、双向队列

但一般项目中不使用LinkedList，使用LinkedList的场景都可以被ArrayList取代，并且性能更好

- prev变量记录了上一个元素的位置
- next变量记录了下一个变量的位置

![image-20220808143232797](https://raw.githubusercontent.com/MatubCA/Image/main/img2/202208081432890.png)

对于频繁的插入或删除的元素，建议使用LinkedList，效率较高

**LinkedList类方法：**

```java
void addFirst(Object obj)
void addLast(Object obj)
Object getFirst()
Object getLast()
Object removeFirst()
Object removeLast()
```



==***4）Vector***==

Vector在JDK1.0就有了，大多数操作与ArrayList相同，区别在于Vector是线程安全的

Vector总是比ArrayList慢，尽量避免使用Vector

**Vector类方法：**

```java
void addElement(Object obj)
void insertElementAt(Object obj,int index)
void setElementAt(Object obj,int index)
void removeElement(Object obj)
void removeAllElements()
```



### Set接口



Set接口没有提供额外的方法。Set集合中不允许有重复元素。

Set判断两个对象是否相等，必须equals方法和hashCode方法全部相等，因为在我们重写了这两个方法的情况下，equals代表着内容是否相同，hashCode代表着地址值是否相等。但是如果我们不去重写这两个方法，那么这两个方法默认继承自Object，而Object中的这两个方法equals比较的是地址值，hashCode方法比较的也是地址值

底层基于数组，初始容量为16，如果当利用率超过0.75（12），就会扩大容量到原来的两倍





- HashSet

  - HashSet的特点

    ```markdown
    1. 最常用的 Set 实现类，基于哈希表+数组+链表+红黑树实现
    2. 具有很好的存取、查找、删除元素性能，支持快速查找
    3. 底层几乎和 HashMap 相同
    4. 集合元素可以是null
    5. 判断两个元素相等的标准 : 通过 hashCode() 方法比较相等,通过 equals() 方法比较也相等
    ```

    

  - HashSet添加元素的过程

    ```markdown
    1. 通过对象的 hashCode() 获得哈希值
    2. 通过哈希值与数组长度,计算出该元素存储在数组上的位置
    3. 如果该位置没有元素直接添加,如果已经有元素,比较 equals() 方法,返回值为boolean类型
    4. 返回值为true表示两个元素相同,不添加,达到去重效果
    5. 返回值为false表示两个元素不相同,新添加元素进入数组位置,旧元素通过链表的方式,链接在新元素上
    ```

    

  - 添加的元素为 java 内置类对象

    ```java
    // 直接添加,一般Java内置类都会重写equals()和hashCode()方法
    
    public void test4() {
        HashSet<String> strings = new HashSet<>();
        strings.add("小黑");
        strings.add("小白");
        System.out.println(strings);
    }
    ```

    

  - 添加的元素为自定义类对象

    ```java
    // 需要重写hashCode()和equals()方法,可以通过快捷键生成默认模板
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User2 user2 = (User2) o;
        if (!Objects.equals(name, user2.name)) return false;
        return Objects.equals(age, user2.age);
    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return 100;
    }
    ```

    

  - 为什么要重写两个方法

    ```markdown
    1. 不重写hashCode()
      - Object的hashCode()是为堆上的对象产生独特值,在添加的时候不同对象的哈希值肯定就是不同的,如果两个对象的地址值不同,但是有着相同的属性	  值,按理来说,应该将其中一个去掉的,但是因为哈希值不同,却都存储在了数组上
    2. 不重写equals()
      - 好了,现在我们重写了hashCode()方法,不再根据地址值获得哈希值了,而是根据属性值来获得哈希值,如果两个对象的属性相同将会被存储在数组的相     同位置,现在应该比较equals()方法,但是我们没有重写equals()方法,默认使用Object中的方法,比较的还是地址值,两个对象地址值肯定不相同,所     以通过拉链法存储在了数组的同一个位置上
    ```

    

  - 重写两个方法的注意事项

    ```markdown
    1. 重写hashCode()方法的基本原则：
      - 在序运行时，同一个对象多次调用 hashCode() 方法应该返回相同的值
      - 当两个对象的 equals() 方法比较返回 true 时，这两个对象的 hashCode() 方法的返回值也应相等
      - 对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值
    2. 重写equals()方法的基本原则： 
      - 当一个类有自己特有的“逻辑相等”概念，当改写equals()的时候，总是要改写hashCode()，根据一个类的equals方法（改写后），两个截然不同的实例有可能在逻辑上是相等的，但是，根据Object.hashCode()方法，它们仅仅是两个对象，因此，违反了“相等的对象必须具有相等的散列码”
    ```

    

  - 名词解释

    ```markdown
    1. 散列函数
    2. 哈希冲突
    ```

    

- TreeSet

- LinkedHashSet

- 

==***1）HashSet***==



HashSet中添加元素的过程：

当向HashSet中添加元素时，HashSet会调用该对象的hashCode()方法，来得到该对象的hashCode值，然后根据hashCode值，利用某种散列函数决定该对象在HashSet底层数组中的存储位置；如果两个元素hashCode的值相等，会再继续调用equals方法，如果结果为true，添加失败，如果为false，那么会保存该元素，但是数组的位置上已经有元素了，这时会通过链表的方式进行链接，也就是拉链法来消除哈希冲突。如果两个元素的equals方法返回true，hashCode值不相等，HashSet会把它们存储在不同的位置

散列函数：散列函数会与底层数组长度相计算得到在数组中的下标，并且这种散列函数计算还能保证均匀存储元素，越是散列分布，散列函数设计的越好



***==2）LinkedHashSet==***

LinkedHashSet 是 HashSet 的子类

LinkedHashSet 根据元素的 hashCode 值来决定元素的存储位置， 具有HashSet的查找效率，同时使用双向链表保持元素插入顺序。

LinkedHashSet插入性能略低于 HashSet，但在迭代访问 Set 里的全部元素时有很好的性能



==***3）TreeSet***==

TreeSet 是 SortedSet 接口的实现类，TreeSet 可以确保集合元素处于排序状态

因为只有相同类的两个实例才会比较大小，所以向 TreeSet 中添加的应该是同 一个类的对象

TreeSet底层使用红黑树结构存储数据，支持有序性操作，查询速度比List快，但没有HashSet高。HashSet查找时间复杂度为O(1)，而TreeSet则是O(logN)



TreeSet类方法：

```java
Comparator comparator()
Object first()
Object last()
Object lower(Object obj)
Object higher(Object obj)
SortedSet subSet(fromElement,toElement)
SortedSet headSet(toElement)
SortedSet tailSet(fromElement)
```



要想在TreeSet中存储对象，因为TreeSet要确保元素处于排序状态，必须根据某种排序规则进行排序，然后TreeSet根据这种排序规则保持元素的排序状态

TreeSet 两种排序方法：自然排序和定制排序。默认情况下，TreeSet 采用自然排序

- 自然排序

  对于要在TreeSet中存储的元素，它所在的类必须实现Comparable接口，重写compareTo()方法，制定所在类对象的排序规则

  如果我们存储的元素所在类是Java内置类，一般内置类都会实现Comparable接口，重写compareTo()方法

  比如：BigDecimal、Character、Boolean、String、Date、Time...

  他们的排序规则是：

  - BigDecimal、BigInteger 以及所有的数值型对应的包装类：按它们对应的数值大小 进行比较
  - Character：按字符的 unicode值来进行比较
  - Boolean：true 对应的包装类实例大于 false 对应的包装类实例
  - String：按字符串中字符的 unicode 值进行比较
  - Date、Time：后边的时间、日期比前面的时间、日期大

  ```java 
  public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
      ...
      public int compareTo(String anotherString) {
      	int len1 = value.length;
      	int len2 = anotherString.value.length;
      	int lim = Math.min(len1, len2);
      	char v1[] = value;
      	char v2[] = anotherString.value;
      	int k = 0;
      	while (k < lim) {
          	char c1 = v1[k];
          	char c2 = v2[k];
          	if (c1 != c2) {
              	return c1 - c2;
          	}
          	k++;
      	}
      	return len1 - len2;
    	}
  }
  ```

  

  如果我们存储的元素所在类是自定义类，必须手动让所在类实现Comparable接口，重写compareTo()方法，制 定我们指定的排序规则

  ```java
  class User implements Comparable<User>{
      ...
      @Override
  	public int compareTo(User o) {
      	int result = this.age - o.age;
      	return result == 0 ? this.name.compareTo(o.name): result;
  	}
  }
  ```

  

  第一个添加进TreeSet中的元素不需要进行比，随后添加的元素调用compareTo方法进行比较

  若result小于0，代表当前对象小于第一个元素，将第二个元素排在第一个元素之前，若result大于0，将第二个元素排在第一个元素之后，若result等于0，可以进行元素对象其他属性的比较，排序规则自己制定

  对于 TreeSet 集合而言，它判断两个对象是否相等的***唯一标准***是：两个对象通 过 compareTo(Object obj) 方法比较返回值

  

  在上面的例子中我们使用String类的compareTo()方法比较name，在这里有一个需要注意的点：

  如果添加元素所在的类还需被HashMap存储，需要重写equals()方法，则必须保证equals()方法和compareTo()方法有一致的结果，比如：通过equals()方法得到true，那么compareTo()方法就应该返回0

  

- 定制排序（比较器排序）

  如果元素所在类没有实现Comparable接口，重写compareTo()方法，或是我们对原有类中的排序规则不满意，这时我们可以使用定制排序（比较器排序）

  我们在创建TreeSet的时候，需要将Comparable接口的实例作为形参传递给TreeSet的构造器，重写compareTo()方法，给当前TreeSet对象所在的类重新指定排序规则

  ```java
  TreeSet<User1> set = new TreeSet<>(new Comparator<User1>() {
      @Override
      public int compare(User1 o1, User1 o2) {
          int result = o1.getAge() - o2.getAge();
          return result == 0 ? o1.getName().compareTo(o2.getName()) : result;
      }
  });
  ```

  

  利用int compare(T o1,T o2)方法，比较o1和o2的大小：如果方法返回正整数，则表 示o1大于o2；如果返回0，表示相等；返回负整数，表示o1小于o2

  

  

### Queue接口

按特定的排队规则来确定先后顺序，存储的元素是有序的、可重复的

LinkedList

可以用来实现双向队列

PriorityQueue

基于堆结构，用来实现优先队列





### Map接口

用于保存具有映射关系的数据：key-value。Map 中的 key 和 value 都可以是任何引用类型的数据。 key 用Set来存放，不允许重复。



#### Map接口方法

```java
/*
	添加\删除\修改操作
*/
Object put(Object key,Object value)// 将键值对添加(修改)到当前map对象中
void putAll(Map m)// 将m中的所有键值对存放到当前map对象中
Object remove(Object key)// 移除指定key的键值对,返回value
void clear()// 清空当前map中的所有数据
/*
	元素查询操作
*/
Object get(Object key)// 获取指定key的value
boolean containsKey(Object key)// 是否包含指定的key
boolean containsValue(Object value)// 是否包含指定的value
int size()// 返回map中的键值对个数
boolean isEmpty()// 判断当前map是否为空
boolean equals(Object obj)// 判断当前map对象和参数obj是否相等
/*
	元视图操作
*/
Set keySet()// 返回所有key组成的Set集合
Collection values()// 返回所有value组成的Collection集合
Set entrySet()// 返回所有键值对组成的Set集合
```



#### HashMap

- HashMap的特点

  ```

- 



- HashMap

  - HashMap特点

    ```markdown
    1. HashMap是 Map 接口使用频率最高的实现类
    2. 允许使用null键和null值,null键只能有一个,不保证排列顺序
    3. 所有key组成的是Set集合,所有value组成的是Collection集合
    4. 一个key-value构成一个entry，所有的entry构成的集合是Set
    5. 判断两个key相等的标准是 : equals()比较为true,hashCode()值相等
    ```

    

  - JDK1.8之前的HashMap

    ![image-20220809112032652](https://raw.githubusercontent.com/MatubCA/Image/main/img2/202208091120735.png)

    ```markdown
    	JDK1.8之前底层基于哈希表(数组+链表),使用拉链法解决哈希冲突
    	当实例化一个HashMap时,会创建一个默认长度(Capacity)的entry数组.数组中存放元素的地方称为桶(bucket),每个桶中存放一个entry对象,每个entry对象都带有一个引用变量,用于指向下一个entry
    
    ```

    

    

  - JDK1.8之后

    ![image-20220809112057759](https://raw.githubusercontent.com/MatubCA/Image/main/img2/202208091120842.png)

    JDK1.8之后底层基于哈希表(数组+链表)+红黑树

  

- TreeMap

- LinkedHashMap

- Hashtable

- Properties

- 

==***1）Map接口方法***==

```java

```





JDK1.8前后HashMap的变化：

- JDK8之前

  **数据结构：**

  HashMap是数组+链表结构（拉链法）

  

  在这个数组中可以存放元素的位置我们称之为“桶”(bucket)，每个bucket都有自己的索引，系统可以根据索引快速的查找bucket中的元素。每个bucket中存储一个元素，即一个Entry对象，但每一个Entry对象可以带一个引用变量，用于指向下一个元素，因此，在一个桶中，就有可能生成一个Entry链。而且新添加的元素作为链表的head

  

  **HashMap添加元素的过程：**

  向HashMap中添加entry1(key，value)，需要首先计算entry1中key的哈希值(根据 key所在类的hashCode()计算得到)，此哈希值经过处理以后，得到在底层Entry[]数组中要存储的位置 i。如果位置 i上没有元素，则entry1直接添加成功。如果位置 i上 已经存在entry2(或还有链表存在的entry3，entry4)，则需要通过循环的方法，依次 比较entry1中key和其他的entry。如果彼此hash值不同，则直接添加成功。如果 hash值相同，继续比较二者是否equals。如果返回值为true，则使用entry1的value 去替换equals为true的entry的value。如果遍历一遍以后，发现所有的equals返回都为false，则entry1仍可添加成功。entry1指向原有的entry元素

  

  **HashMap的扩容机制：**

  当HashMap中的元素越来越多的时候，hash冲突的几率也就越来越高，因为数组的长度是固定的。所以为了提高查询的效率，就要对HashMap的数组进行扩容，而在 HashMap数组扩容之后，最消耗性能的点就出现了：原数组中的数据必须重新计算其在新数组中的位置，并放进去，这就是resize

  

  **扩容时机：**

  当HashMap中的元素个数超过数组大小(数组总大小length,不是数组中个数 size) * loadFactor 时 ， 就 会 进 行 数 组 扩 容 ， loadFactor 的 默 认 值 (DEFAULT_LOAD_FACTOR)为0.75，这是一个折中的取值。也就是说，默认情况 下，数组大小(DEFAULT_INITIAL_CAPACITY)为16，那么当HashMap中元素个数 超过16 * 0.75=12（这个值就是代码中的threshold值，也叫做临界值）的时候，就把数组的大小扩展为 2 * 16=32，即扩大一倍，然后重新计算每个元素在数组中的位置， 而这是一个非常消耗性能的操作，所以如果我们已经预知HashMap中元素的个数，那么预设元素的个数能够有效的提高HashMap的性能

- JDK8之后

  **数据结构：**

  HashMap是数组+链表+红黑树结构

  

  HashMap的内部存储结构其实是数组+链表+树的结合。当实例化一个 HashMap时，会初始化initialCapacity和loadFactor，在put第一对映射关系 时，系统会创建一个长度为initialCapacity的Node数组，这个长度在哈希表中被称为容量(Capacity)，在这个数组中可以存放元素的位置我们称之为 “桶”(bucket)，每个bucket都有自己的索引，系统可以根据索引快速的查找bucket中的元素。每个bucket中存储一个元素，即一个Node对象，但每一个Node对象可以带 一个引用变量next，用于指向下一个元素，因此，在一个桶中，就有可能生成一个Node链。也可能是一个一个TreeNode对象，每一个TreeNode对象 可以有两个叶子结点left和right，因此，在一个桶中，就有可能生成一个TreeNode树。而新添加的元素作为链表的last，或树的叶子结点

  

  **扩容机制：**

  当HashMap中的元素个数超过数组大小(数组总大小length,不是数组中个数 size) * loadFactor 时 ， 就会进行数组扩容 ， loadFactor 的默认值 (DEFAULT_LOAD_FACTOR)为0.75，这是一个折中的取值。也就是说，默认情况下，数组大小(DEFAULT_INITIAL_CAPACITY)为16，那么当HashMap中 元素个数超过16 * 0.75=12（这个值就是代码中的threshold值，也叫做临界值） 的时候，就把数组的大小扩展为 2 * 16=32，即扩大一倍，然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作，所以如果我们已经预知HashMap中元素的个数，那么预设元素的个数能够有效的提高HashMap的性能。当HashMap中的其中一个链的对象个数如果达到了8个，此时如果capacity没有达到64，那么HashMap会先扩容解决，如果已经达到了64，那么这个链会变成树，结点类型由Node变成TreeNode类型。当然，如果当映射关系被移除后，下次resize方法时判断树的结点个数低于6个，也会把树再转为链表

   loadFactor：加载因子。决定元素在数组的存放的疏密程度，趋近于1，元素越密集，会导致查找元素困难；趋近于0，元素越稀疏，会导致数组利用率不高，loadFactor默认值为0.75

JDK1.8前后区别总结：

- HashMap map = new HashMap();//默认情况下，先不创建长度为16的数组
- 当首次调用map.put()时，再创建长度为16的数组
- 数组为Node类型，在jdk7中称为Entry类型
- 形成链表结构时，新添加的key-value对在链表的尾部（七上八下）
- 当数组指定索引位置的链表长度>8时，且map中的数组的长度> 64时，此索引位置 上的所有key-value对使用红黑树进行存储



==***3)LinkedHashMap***==

LinkedHashMap 是 HashMap 的子类

在HashMap存储结构的基础上，使用了一对双向链表来记录添加 元素的顺序

与LinkedHashSet类似，LinkedHashMap 可以维护 Map 的迭代 顺序：迭代顺序与 Key-Value 对的插入顺序一致



==***4)TreeMap***==

TreeSet底层使用红黑树结构存储数据

只对key进行排序

TreeMap存储 Key-Value 对时，需要根据 key-value 对进行排序。 TreeMap 可以保证所有的 Key-Value 对处于有序状态

TreeMap 的 Key 的排序：

- 自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有 的 Key 应该是同一个类的对象，否则将会抛出 ClasssCastException
- 定制排序：创建 TreeMap 时，传入一个 Comparator 对象，该对象负责对 TreeMap 中的所有 key 进行排序。此时不需要 Map 的 Key 实现
  Comparable 接口

TreeMap判断两个key相等的标准：两个key通过compareTo()方法或 者compare()方法返回0



==***5)Hashtable***==

JDK1.0就存在了，线程安全

Hashtable实现原理和HashMap相同，功能相同。底层都使用哈希表结构，查询 速度快，很多情况下可以互用

与HashMap不同，Hashtable 不允许使用 null 作为 key 和 value

与HashMap一样，Hashtable 也不能保证其中 Key-Value 对的顺序

Hashtable判断两个key相等、两个value相等的标准，与HashMap一致



==***6)Properties***==

Properties 类是 Hashtable 的子类，该对象用于处理小配置文件

由于属性文件里的 key、value 都是字符串类型，所以 Properties 里的 key 和 value 都是字符串类型

存取数据时，建议使用setProperty(String key,String value)方法和 getProperty(String key)方法



### Collections

Collections 是一个操作 Set、List 和 Map 等集合的工具类

Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作， 还提供了对集合对象设置不可变、对集合对象实现同步控制等方法



**常用方法：**

```java
/*
	排序操作
*/
reverse(List)// 反转list中元素的顺序
shuffle(List)// 对list中元素进行随机排序
sort(List)// 根据元素的自然顺序,对指定list集合元素进行升序排序
sort(List,Comparator)// 根据指定的Comparator产生的顺序对list元素进行排序
swap(List,int ,int)// 将指定list集合中的i处元素和j处元素进行互换
/*
	查找\替换
*/
Object max(Collection)// 根据元素的自然顺序,返回给定集合的最大元素
Object max(Collection,Comparator)// 根据Comparator指定的顺序,返回给定元素的最大值
Object min(Collection)
Object min(Collection,Comparator)
int frequency(Collection,Object)// 返回指定集合中指定元素出现的次数
void copy(List dest,List src)// 将src中的内容复制到dest中
boolean replaceAll(List list,Object oldVal,Object newVal)// 使用新值替换list集合中的所有旧值

```

Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集 合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题



### 源码

- ArrayList的内存分配与扩容机制

  ```java
  public class ArrayList<E> extends AbstractList<E>
      // 实现RandomAccess,可以快速随机访问
      // 实现了Clonable接口,覆盖了clone()方法,可以被克隆
      // 实现了java.io.Serializable,表明ArrayList支持序列化
          implements List<E>, RandomAccess, Cloneable, java.io.Serializable
      
  ...
      // 空参构造
  	public ArrayList() {
      	this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
      }
  ...
      // 初始数组为空数组
      private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
  ...
      // 第一次添加数组
      public boolean add(E e) {
      // 首先调用ensureCapacityInternal方法
      	ensureCapacityInternal(size + 1);
      // ArrayList添加元素底层是数组复制
      	elementData[size++] = e;
      	return true;
  	}
  ...
      private void ensureCapacityInternal(int minCapacity) {
      // 调用下面的两个方法
      	ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
  	}
  ...
      private static int calculateCapacity(Object[] elementData, int minCapacity) {
      // 判断数组是否是空数组,也就是第一次添加
      	if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
              // 返回初始容量(10)和当前容量的最大值
          	return Math.max(DEFAULT_CAPACITY, minCapacity);
     	 	}
      // 如果数组已经满了,size+1>10
      // 返回当前容量
      	return minCapacity;
  	}
  ...
      private void ensureExplicitCapacity(int minCapacity) {
      	modCount++;
      // 现在minCapacity是11
      	if (minCapacity - elementData.length > 0)
              // ArrayList扩容的核心方法
          	grow(minCapacity);
  	}
  ...
      private void grow(int minCapacity) {
     	 	int oldCapacity = elementData.length;
      // 当前数组容右移一位,相当于除二,新数组容量变成老数组的1.5倍
      	int newCapacity = oldCapacity + (oldCapacity >> 1);
      // 两个if代表两种特殊情况,小于最小容量,大于最大容量
      	if (newCapacity - minCapacity < 0)
          	newCapacity = minCapacity;
      	if (newCapacity - MAX_ARRAY_SIZE > 0)
          	newCapacity = hugeCapacity(minCapacity);
      // 调用Arrays.copyof方法,申请一个长度为newCapacity的数组,将elementData中的数组进行拷贝,并返回数组
      	elementData = Arrays.copyOf(elementData, newCapacity);
  	}
      
  ```





### 细节

==***ArrayList和LinkedList的异同：***==

1. 两者都是不同步的，也就是线程不安全，但都相对于Vector执行效率更高
2. ArrayList底层基于Object数组，LinkedList底层基于双向链表
3. 对于在头尾添加元素，ArrayList和LinkedList效率都很高，时间复杂度近似O(1)，然而对指定位置 i 的插入和删除 ，ArrayList的时间复杂度为O(n-i)，因为需要向前/向后移动元素，LinkedList的时间复杂度近似为O(n)，因为需要先找到指定位置
4. ArrayList支持快速随机访问，而LinkedList不支持
5. ArrayList的空间浪费主要是要在List列表后面预留一定的空间，而LinkedList的空间浪费主要是存储每个元素的空间要比ArrayList大，因为要存储前驱、后继和数据



==***三种获取长度的方法***==

1. length属性是针对数组，获取数组长度
2. length()方法是针对字符串，获取字符串长度
3. size()方法是针对集合，获取集合元素的个数



==***ArrayList和Vector的异同：***==

1. Vector和ArrayList几乎完全相同
2. Vector是同步类（synchronized），属于强同步，所以开销比ArrayList大，访问要慢。又因为同步完全可以由程序员控制，所以基本上不使用Vector



==***HashMap和Hashtable的区别：***==

1. HashMap是线程安全的，Hashtable非线程安全
2. 因为线程安全的问题，hashMap比hashtable效率高，现在hashtable基本上已经被淘汰了
3. hashMap允许存储null为key和value，但null的key只能有一个，而hashtable不允许存储null为key或value
4. hashMap初始容量为16，每次扩容为原来的2倍，hashtable初始容量为11，每次扩容为原来的2n+1
5. 如果给了初始容量，hashtable会直接使用给的容量，hashMap会将其扩充为2的幂次方大小



==***HashMap和HashSet的区别：***==

- HashSet底层使用HashMap实现





==***hashCode和equals的规定：***==

1. 两个相等的对象，hashCode一定相同，equals的结果一定为true
2. 两个对象有相等的hashCode值，两个对象也不一定相等
3. 重写equals方法则必须重写hashCode，使两者保持不出现相悖的结果





==*** ==和equals的区别：***==

1. 对于基本数据类型，==比较的是值是否相等
2. 对于引用数据类型，==比较的是地址值，如果equals没有被重写，对比的是他们地址值是否相等（底层使用 ==比较），如果equals被重写，则比较的是地址里的内容



## 🦄泛型







## 👺IO&NIO







## 🤡网络编程







## 🧠多线程







## 🦀注解













































# 资料

https://www.cnblogs.com/dolphin0520/p/3811445.html

https://www.cnblogs.com/haixiang/p/11029639.html

https://www.cnblogs.com/Qian123/p/5715402.html















