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









































