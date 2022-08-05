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



接口抽象方法

```java
/* 无参无返回 */
@FunctionalInterface
public interface NoReturnNoParam {
    void method();
}
```

测试

```java
/*
    测试无参无返回值的接口方法
 */
@Test
public void test1(){
    NoReturnNoParam noReturnNoParam = () -> {
        System.out.println("hello");
    };
    noReturnNoParam.method();
}
```



### 语法简化

- 简化类型参数,可以不写参数类型,必须所有参数类型都不写
- 简化参数小括号,如果只有一个参数,可与不写小括号
- 简化大括号,如果方法体只有一条语句可以省略大括号
  - 如果一条语句是return语句,return可以忽略



### Lambda表达式常用示例

- 引用方法

  > 有时我们不必亲自重写匿名内部类的方法,可以利用Lambda表达式指向已经实现的接口方法
  >
  > 语法: 方法归属者::方法 静态方法归属类;普通方法归属对象
  >
  > ```java
  > public class Exe1 {
  > 
  >     public static void main(String[] args) {
  >         ReturnOneParam returnOneParam1 = num -> method1(num);
  >         System.out.println(returnOneParam1.method(99));
  > 
  >         ReturnOneParam returnOneParam2 = Exe1::method1;
  >         System.out.println(returnOneParam2.method(99));
  > 
  >         Exe1 exe1 = new Exe1();
  >         ReturnMultiParam returnMultiParam2 = exe1::method2;
  >         System.out.println(returnMultiParam2.method(99, 1));
  >     }
  > 
  >     /*
  >         接口的实现方法,返回值与参数与接口方法一致
  >      */
  >     public static int method1(int num){
  >         return num+1;
  >     }
  > 
  >     public int method2(int arg1, int arg2){
  >         return arg1+arg2;
  >     }
  > }
  > ```

- 引用构造方法

  > 需要创建接口,将该接口作为对象的生成器
  >
  > 语法: 类名::new 实例化对象,调用方法返回对象
  >
  > ```java
  > public class Exe2 {
  >     public static void main(String[] args) {
  >         NoParamConstructor create = () -> new User();
  >         User user = create.getUser();
  >         System.out.println(user);
  > 
  >         NoParamConstructor create1 = User::new;
  >         User user1 = create1.getUser();
  >         System.out.println(user1);
  > 
  >         ParamConstructor create3 = User::new;
  >         User user2 = create3.getUser("张三", 22);
  >         System.out.println(user2);
  >     }
  > }
  > 
  > interface NoParamConstructor{
  >     User getUser();
  > }
  > 
  > interface ParamConstructor{
  >     User getUser(String name,int age);
  > }
  > ```

- 创建线程

  > 通过创建Thread对象,然后通过匿名内部类重写run()方法,可以使用Lambda表达式简化这一过程
  >
  > ```java
  > Thread t = new Thread(() -> {
  >     
  >     for (int i = 0; i < 10; i++) {
  >         System.out.println(2 + ":" + i);
  >         }
  > });
  > t.start();
  > ```

- 遍历集合

  > 调用集合的``public void forEach(Consumer<? super E> action)`` Consumer是JDK为我们提供的函数式接口
  >
  > ```java
  > public class ListDemo {
  >     public static void main(String[] args) {
  >         List<String> list = new ArrayList<>();
  >         list.add("大白");
  >         list.add("小白");
  > 
  >         list.forEach(System.out::println);
  > 
  >         list.forEach(str -> {
  >             if (str.equals("大白")){
  >                 System.out.println(true);
  >             }
  >         });
  >     }
  > }
  > ```

- 删除集中的元素

  > 调用集合的``public boolean removeIf(Predicate<? super E> filter)`` Predicate也是JDK提供的函数式接口
  >
  > ```java
  > public class ListDemo2 {
  >     public static void main(String[] args) {
  >         List<String> list = new ArrayList<String>();
  >         list.add("大白");
  >         list.add("小白");
  > 
  >         list.removeIf(str -> str.equals("大白"));
  > 
  >         list.forEach(System.out::println);
  >     }
  > }
  > ```

- 集合元素的排序

  > 以前我们为集合元素排序,调用sort方法,传入比较器匿名内部类,重写Comparator方法
  >
  > ```java
  > public class ListDemo3 {
  >     public static void main(String[] args) {
  >         List<Integer> list = new ArrayList<Integer>();
  >         list.add(13);
  >         list.add(14);
  >         list.add(89);
  >         list.add(5);
  > 
  >         /*list.sort(new Comparator<Integer>() {
  > 
  >             @Override
  >             public int compare(Integer o1, Integer o2) {
  >                 return o1 - o2;
  >             }
  >         });*/
  > 
  >         list.sort((o1,o2) -> o1 - o2);
  > 
  >         list.forEach(System.out::println);
  >     }
  > }
  > ```





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

  















































































# 资料

https://www.cnblogs.com/dolphin0520/p/3811445.html

https://www.cnblogs.com/haixiang/p/11029639.html















