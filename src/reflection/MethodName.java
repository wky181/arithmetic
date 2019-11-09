package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 武凯焱
 * @date 2019/4/15 14:03
 * @Description:
 */
/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 *      public MethodName[] getMethods():获取所有”公有方法”；（包含了父类的方法也包含Object类）
 *      public MethodName[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 *      public MethodName getMethod(String name,Class<?>… parameterTypes):
 *                  参数：
 *                      name : 方法名；
 *                      Class … : 形参的Class类型对象
 *      public MethodName getDeclaredMethod(String name,Class<?>… parameterTypes)
 *
 *   调用方法：
 *      MethodName –> public Object invoke(Object obj,Object… args):
 *                  参数说明：
 *                  obj : 要调用方法的对象；
 *                  args:调用方式时所传递的实参；

):
 */
public class MethodName {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class stu  = Class.forName("reflection.Student");
        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有私有“方法*******************");
        Method[] methodArray = stu.getDeclaredMethods();
        for (Method method: methodArray) {
            System.out.println(method.getName());
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method method = stu.getMethod("show1", String.class);
        Object object = stu.newInstance();
        method.invoke(object,"刘德华");
        System.out.println("***************获取私有的show4()方法******************");
        method = stu.getDeclaredMethod("show4", int.class);
        method.setAccessible(true);
        Object o =  method.invoke(object,12);
        System.out.println(o);
    }
}
