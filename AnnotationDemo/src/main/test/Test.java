import java.lang.reflect.Method;

public class Test {
    @Demo(msg = "aaaa")
    public void doSomething(){
        //the function you want to add your custom annotation
    }

    public static void main(String[] args) throws  Exception {


        Class<Test> clazz = Test.class;
        //根据反射得到方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("doSomething")) {
                System.out.println(method.getAnnotations().length);
                Demo annotation = method.getAnnotation(Demo.class);
                System.out.println(annotation.msg());
            }
        }


    }
}
