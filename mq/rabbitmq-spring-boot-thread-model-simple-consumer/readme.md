
# rabbitmq-spring-boot-thread-model-simple-consumer
* 这里演示了为不同的消费者设置不同的消费配置，也就是如何定制@RabbitListener中的containerFactory，包括消费者数量、消费端消息的阻塞队列
* 如何为每个消费者容器设置重试机制