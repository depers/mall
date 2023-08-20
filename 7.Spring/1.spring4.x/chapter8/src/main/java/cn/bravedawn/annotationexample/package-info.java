/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/10 15:53
 */
package cn.bravedawn.annotationexample;


/**
 * 这里演示了@Aspect前置增强的简单使用，有两中方法，
 * 第一是通过AspectJProxyFactory生成代理类，这块使用的逻辑在测试类cn/bravedawn/annotationexample/AspectJProxyTest.java进行说明。
 * 第二种是通过Spring的aop命名空间进行配置，让spring来帮我们生成代理，这块使用的逻辑在测试类cn/bravedawn/annotationexample/AspectConfigTest.java进行说明。
 *
 * 这个包中一共有五个子包文件，分别演示了@Aspect提供的五种增强注解：
 * after：@After前置增强
 * afterreturning：@AfterReturning后置增强
 * afterthrowing：@AfterThrowing只有抛出增强才会起作用
 * around：@Around环绕增强
 * before：@Before后置增强
 * introductioninterceptor：@DeclareParents引介增强
 */