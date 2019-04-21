import com.alibaba.dubbo.config.annotation.Reference;
import com.dalaoyang.dubbo.HelloService;
import com.lhx.service.SayHelloToClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @创建人 anjie
 * @创建时间 2019/4/21
 * @描述
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"applicationProvider.xml"});
        context.start();
//        SayHelloToClient sayHelloToClient= (SayHelloToClient) context.getBean("demoService");
//        System.out.println(sayHelloToClient.sayHello("ddsdsd"));
        HelloService helloService= (HelloService) context.getBean("helloService");
        System.out.println(helloService.SayHello("dddddddddddddddd1111ddddddddddddddddddddddddddddddddddd"));
    }
}
