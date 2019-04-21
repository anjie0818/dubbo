package org.apache.jmeter.samplers;

import com.dalaoyang.dubbo.HelloService;
import com.lhx.service.SayHelloToClient;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @创建人 anjie
 * @创建时间 2019/4/21
 * @描述
 */
public class DubboTest implements JavaSamplerClient {
    private static final ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[] { "applicationProvider.xml" });

    private static  HelloService helloService;
    private static final String NAME="name:";
    private static final String DEFAULT_NAME="http://www.baidu.com";
    private String inputNAME;
    private String resultData="自定义采样器结果";
    public Arguments getDefaultParameters() {
        System.out.println("hello getDefaultParameters!!!");
        Arguments arguments=new Arguments();
        arguments.addArgument(NAME,DEFAULT_NAME);
        return arguments;
    }
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("hello setupTest!!!");
        inputNAME = javaSamplerContext.getParameter(NAME, DEFAULT_NAME);
        helloService= (HelloService) context.getBean("helloService");
        System.out.println("用户输入的Name："+inputNAME);
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        System.out.println("hello runTest!!!");
        SampleResult result=new SampleResult();

        //标记开始事务

        result.sampleStart();
        String dubboResult = helloService.SayHello(inputNAME);

        result.setResponseData(dubboResult,null);
        result.setDataType(SampleResult.TEXT);

        result.sampleEnd();
        if (DEFAULT_NAME.equals(inputNAME)){
            result.setSuccessful(true);
            System.out.println("========yes");
        }else {
            System.out.println("========no");
            result.setSuccessful(false);
        }
        return result;
    }

    public void teardownTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("hello teardownTest!!!");

    }


}
