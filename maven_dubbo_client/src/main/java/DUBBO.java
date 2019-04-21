import com.dalaoyang.dubbo.HelloService;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @创建人 anjie
 * @创建时间 2019/4/21
 * @描述
 */
public class DUBBO extends AbstractJavaSamplerClient{
    public  SampleResult runTest(JavaSamplerContext args) {
        SampleResult sampleResult=new SampleResult();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"applicationProvider.xml"});
        sampleResult.sampleStart();
        context.start();
        HelloService helloService= (HelloService) context.getBean("helloService");
        sampleResult.setResponseData(helloService.SayHello("dddddddddddddd"),null);
        sampleResult.setDataType(SampleResult.TEXT);
        sampleResult.setSuccessful(true);
        return sampleResult;
    }
}
