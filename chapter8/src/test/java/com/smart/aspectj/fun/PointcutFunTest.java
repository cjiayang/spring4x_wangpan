package com.smart.aspectj.fun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.smart.NaughtyWaiter;
import com.smart.Waiter;

public class PointcutFunTest {

    @Test
    public void pointcut() {
        String configPath = "com/smart/aspectj/fun/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        System.out.println("----------------------------");
        naiveWaiter.greetTo("John");
        System.out.println("----------------------------");
        naiveWaiter.serveTo("John");
        System.out.println("----------------------------");
        naughtyWaiter.greetTo("Tom");
        System.out.println("----------------------------");
        naughtyWaiter.serveTo("Tom");
        System.out.println("----------------------------");



        //((NaughtyWaiter) naughtyWaiter).joke("Tom", 1);


        //-----@args test------//
        //		WaiterManager wm = (WaiterManager)ctx.getBean("waiterManager");		
        //		NaiveWaiter waiter3 = new NaiveWaiter();
        //		NaiveWaiter waiter4 = (NaiveWaiter) ctx.getBean("naiveWaiter");
        //		NaiveWaiter waiter5 = new NaiveChildWaiter();
        //		wm.addNaiveWaiter(waiter3);
        //		wm.addWaiter(waiter4);
        //		wm.addNaiveWaiter(waiter5);

        //---------@within()------------//
        //		naughtyWaiter.greetTo("Tom");
        //		((NaughtyWaiter)naughtyWaiter).joke("Tom", 1);
        //		naiveWaiter.greetTo("John");
        //		((NaiveWaiter)naiveWaiter).smile("John",2);

        //--------在引入Seller接口增强时，使用this() --------//
        //		naiveWaiter.greetTo("John");
        //		naiveWaiter.serveTo("John");
        //		((Seller)naiveWaiter).sell("Beer", "John");

    }
}
