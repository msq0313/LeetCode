package Basic.Final;

class Person {
    public final void say() {
        System.out.println("说....");
    }
    public void eat() {
        System.out.println("吃...");
    }
}
class Teacher extends Person {
    //1. final修饰的方法不能被重写，但此方法仍然被继承
    /*@Override
    public void say() {
        System.out.println("老师在一本正经的说...");
    }*/

    @Override
    public void eat() {
        System.out.println("老师在大口大口的吃...");
    }
}

class Demo02 {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.say();
    }
}