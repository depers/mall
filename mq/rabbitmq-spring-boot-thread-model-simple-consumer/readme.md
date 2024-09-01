
# rabbitmq-spring-boot-thread-model-simple-consumer
* 这里演示了Simple线程模型的配置方式
  * 第一种：单独声明`SimpleMessageListenerContainer`Bean监听多个队列。
  * 第二种：直接在配置文件中对listener进行配置。
  * 第三种：单独声明`SimpleRabbitListenerContainerFactory`Bean，并使用`@RabbitListener`注解中的`containerFactory`属性声明该工厂类。
* 如何为每个消费者容器设置重试机制