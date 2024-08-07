package cn.bravedawn.aspect;


import cn.bravedawn.annotation.CheckIdempotent;
import cn.bravedawn.constant.MallConstant;
import cn.bravedawn.enums.ExceptionEnum;
import cn.bravedawn.enums.RedisKeyEnum;
import cn.bravedawn.exception.BaseRunTimeException;
import cn.bravedawn.utils.HttpUtils;
import cn.bravedawn.utils.RedisOperator;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ServiceLogAspect {


    @Autowired
    private RedisOperator redisOperator;

    /**
     * AOP通知：
     * 1. 前置通知：在方法调用之前执行
     * 2. 后置通知：在方法正常调用之后执行
     * 3. 环绕通知：在方法调用之前和之后，都分别可以执行的通知
     * 4. 异常通知：如果在方法调用过程中发生异常，则通知
     * 5. 最终通知：在方法调用之后执行
     */

    /**
     * 切面表达式：
     * execution 代表所要执行的表达式主体
     * 第一处 * 代表方法返回类型 *代表所有类型
     * 第二处 包名代表aop监控的类所在的包
     * 第三处 .. 代表该包以及其子包下的所有类方法
     * 第四处 * 代表类名，*代表所有类
     * 第五处 *(..) *代表类中的方法名，(..)表示方法中的任何参数
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* cn.bravedawn.controller..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("====== 开始执行 {}.{} ======",
                        joinPoint.getTarget().getClass(),
                        joinPoint.getSignature().getName());

        // 记录开始时间
        long begin = System.currentTimeMillis();

        // 幂等性校验
        CheckIdempotent(joinPoint);

        // 执行目标 service
        Object result = joinPoint.proceed();

        // 记录结束时间
        long end = System.currentTimeMillis();
        long takeTime = end - begin;

        if (takeTime > 3000) {
            log.error("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else if (takeTime > 2000) {
            log.warn("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else {
            log.info("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        }

        return result;
    }


    /**
     * 幂等性校验
     * @param joinPoint
     */
    private void CheckIdempotent(ProceedingJoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        CheckIdempotent checkidempotent = ms.getMethod().getAnnotation(CheckIdempotent.class);
        if (checkidempotent == null) {
            return;
        }

        String headerName = checkidempotent.value();
        if (StringUtils.isEmpty(headerName)) {
            throw new IllegalArgumentException("CheckIdempotent value is empty.");
        }

        String headerValue = HttpUtils.getHttpHeaderValue(headerName);
        String key = String.format(RedisKeyEnum.IDEMPOTENT_TOKEN_KEY.getKey(), headerValue);
        String value = redisOperator.get(key);
        if (StringUtils.isNotEmpty(value)) {
            throw new BaseRunTimeException(ExceptionEnum.IDEMPOTENT_EXCEPTION);
        } else {
            redisOperator.set(key, MallConstant.NONE_MEAN_REDIS_VALUE, RedisKeyEnum.IDEMPOTENT_TOKEN_KEY.getExpireTime());
        }

    }

}
