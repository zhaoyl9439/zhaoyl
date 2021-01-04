package com.example.demo.study.object;

/**
 *  1。理解多态性：可以理解为一个事物的多种形态。
 *  2. 何为多态性：运行时行为 动态绑定
 *       对象的多态性：父类的引用指向子类的对象（或子类的队象赋给父类的引用）
 *  3. 多态性的使用，虚拟方法调用
 *      有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法
 * 总结：编译，看左边；运行，看右边。
 *  4. 多态性的使用前提：①类的继承关系 ②方法的重写
 *  5. 多态的使用只适用于方法不适用于属性
 *
 *  明确：虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建了一个对象，即为new子类对象
 *
 *      若子类重写了父类方法，就意味着类里定义的的方法彻底覆盖了父类的同名方法，
 *  系统将不可能把父类的方法转移到子类中；编译看左边，运行看右边。
 *      对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，
 *  这个实例变量依然不可能覆盖父类中的实例变量，编译运行都看左边。
 *
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.eat();

        Man man = new Man();
        man.eat();
        man.age = 25;
        man.earnMoney();

        // 对象的多态性，父类的引用指向子类的对象
        Person p2 = new Man();
        // 多态的使用，当调用子父类同名参数的方法时，实际执行的是子类重写父类的方法---虚拟方法的使用
        p2.eat();
        p2.walk();

        // 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法，但是由于变量声明为父类类型，导致
        // 编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。
        // 使用强制类型转换（向上转换：多态）即可调用子类特有的属性和方法
        Man man1 = (Man) p2;
        man1.earnMoney();
        man1.isSomking = true;

        // 使用墙转时，可能出现java.lang.ClassCastException异常
        // 用instanceof
        if (p2 instanceof Woman){
            Woman woman = (Woman) p2;
            woman.goShopping();
            System.out.println("------Woman-------");
        }

        if (p2 instanceof Man){
            Man man2 = (Man) p2;
            man2.earnMoney();
            System.out.println("======Man========");
        }

        if (p2 instanceof Person){
            System.out.println("~~~~~~~Person~~~~~~~");
        }
        if (p2 instanceof Object){
            System.out.println("+++++++++Object+++++++++++");
        }

        // 编译时通过，运行时不通过
        Person p4 = new Person();
        Man man2 = (Man) p4;

        // 编译运行都通过
        Object obj = new Woman();
        Person p = (Person) obj;

    }
}

class Person {

    String name;
    int age;

    public void eat(){
        System.out.println("人：吃饭");
    }

    public void walk(){
        System.out.println("人：走路");
    }
}

class Man extends Person {

    boolean isSomking;

    public void earnMoney(){
        System.out.println("男人负责挣钱养家");
    }

    @Override
    public void eat() {
        System.out.println("男人，吃窝窝头");
    }

    @Override
    public void walk() {
        System.out.println("男人，走路扶墙根");
    }
}

class Woman extends Person{

    boolean isBeauty;

    public void goShopping(){
        System.out.println("女人，喜欢购物");
    }

    @Override
    public void eat() {
        System.out.println("女人，吃肉");
    }

    @Override
    public void walk() {
        System.out.println("女人，走路霸气侧漏");
    }

    public boolean isBeauty() {
        return isBeauty;
    }

    public void setBeauty(boolean beauty) {
        isBeauty = beauty;
    }
}

