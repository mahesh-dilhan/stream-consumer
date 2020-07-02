# Cloud Stream Kafka
Eventual Consistency


# Kafka Consumer
Examples in this repo:

 * Kafka Message Consumer


## Setup & build

OpenJDK 13 (let jenv to manage multiple JDKs )

setup `zookeeper` and `kafka` in hardway. (Easy way is to use confluent binary). 
I used hardway for this setup to get hands on experience. 

### Start Zookeeper
```
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties
```

### Start Kafka
```
kafka-server-start /usr/local/etc/kafka/server.properties
```

Run `mvn package` to build a single executable JAR file.

```
    .   ____          _            __ _ _
  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
 ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
   '  |____| .__|_| |_|_| |_\__, | / / / /
  =========|_|==============|___/=/_/_/_/
  :: Spring Boot ::        (v2.3.1.RELEASE)
 
 2020-07-02 20:56:44.413  INFO 59674 --- [           main] c.r.r.ReactiveStreamConsumerApplication  : Starting ReactiveStreamConsumerApplication on Maheshs-MBP with PID 59674 (/Users/mahesh/play/stream/reactive-stream-consumer/target/classes started by mahesh in /Users/mahesh/play/stream/reactive-stream-consumer)
 2020-07-02 20:56:44.414  INFO 59674 --- [           main] c.r.r.ReactiveStreamConsumerApplication  : No active profile set, falling back to default profiles: default
 2020-07-02 20:56:44.985  INFO 59674 --- [           main] faultConfiguringBeanFactoryPostProcessor : No bean named 'errorChannel' has been explicitly defined. Therefore, a default PublishSubscribeChannel will be created.
 2020-07-02 20:56:44.989  INFO 59674 --- [           main] faultConfiguringBeanFactoryPostProcessor : No bean named 'taskScheduler' has been explicitly defined. Therefore, a default ThreadPoolTaskScheduler will be created.
 2020-07-02 20:56:44.992  INFO 59674 --- [           main] faultConfiguringBeanFactoryPostProcessor : No bean named 'integrationHeaderChannelRegistry' has been explicitly defined. Therefore, a default DefaultHeaderChannelRegistry will be created.
 2020-07-02 20:56:45.031  INFO 59674 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'integrationChannelResolver' of type [org.springframework.integration.support.channel.BeanFactoryChannelResolver] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
 2020-07-02 20:56:45.034  INFO 59674 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'integrationDisposableAutoCreatedBeans' of type [org.springframework.integration.config.annotation.Disposables] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
 2020-07-02 20:56:45.043  INFO 59674 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.integration.config.IntegrationManagementConfiguration' of type [org.springframework.integration.config.IntegrationManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
 2020-07-02 20:56:45.585  INFO 59674 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Initializing ExecutorService 'taskScheduler'
 2020-07-02 20:56:45.600  INFO 59674 --- [           main] onConfiguration$FunctionBindingRegistrar : Functional binding is disabled due to the presense of @EnableBinding annotation in your configuration
 2020-07-02 20:56:45.734  INFO 59674 --- [           main] o.s.c.s.m.DirectWithAttributesChannel    : Channel 'application.input' has 1 subscriber(s).
 2020-07-02 20:56:45.737  INFO 59674 --- [           main] o.s.i.endpoint.EventDrivenConsumer       : Adding {logging-channel-adapter:_org.springframework.integration.errorLogger} as a subscriber to the 'errorChannel' channel
 2020-07-02 20:56:45.737  INFO 59674 --- [           main] o.s.i.channel.PublishSubscribeChannel    : Channel 'application.errorChannel' has 1 subscriber(s).
 2020-07-02 20:56:45.737  INFO 59674 --- [           main] o.s.i.endpoint.EventDrivenConsumer       : started bean '_org.springframework.integration.errorLogger'
 2020-07-02 20:56:45.738  INFO 59674 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Creating binder: kafka
 2020-07-02 20:56:45.919  INFO 59674 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Caching the binder: kafka
 2020-07-02 20:56:45.919  INFO 59674 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Retrieving cached binder: kafka
 2020-07-02 20:56:46.017  INFO 59674 --- [           main] o.a.k.clients.admin.AdminClientConfig    : AdminClientConfig values: 
 	bootstrap.servers = [localhost:9092]
 	client.dns.lookup = default
 	client.id = 
 	connections.max.idle.ms = 300000
 	default.api.timeout.ms = 60000
 	metadata.max.age.ms = 300000
 	metric.reporters = []
 	metrics.num.samples = 2
 	metrics.recording.level = INFO
 	metrics.sample.window.ms = 30000
 	receive.buffer.bytes = 65536
 	reconnect.backoff.max.ms = 1000
 	reconnect.backoff.ms = 50
 	request.timeout.ms = 30000
 	retries = 2147483647
 	retry.backoff.ms = 100
 	sasl.client.callback.handler.class = null
 	sasl.jaas.config = null
 	sasl.kerberos.kinit.cmd = /usr/bin/kinit
 	sasl.kerberos.min.time.before.relogin = 60000
 	sasl.kerberos.service.name = null
 	sasl.kerberos.ticket.renew.jitter = 0.05
 	sasl.kerberos.ticket.renew.window.factor = 0.8
 	sasl.login.callback.handler.class = null
 	sasl.login.class = null
 	sasl.login.refresh.buffer.seconds = 300
 	sasl.login.refresh.min.period.seconds = 60
 	sasl.login.refresh.window.factor = 0.8
 	sasl.login.refresh.window.jitter = 0.05
 	sasl.mechanism = GSSAPI
 	security.protocol = PLAINTEXT
 	security.providers = null
 	send.buffer.bytes = 131072
 	ssl.cipher.suites = null
 	ssl.enabled.protocols = [TLSv1.2]
 	ssl.endpoint.identification.algorithm = https
 	ssl.key.password = null
 	ssl.keymanager.algorithm = SunX509
 	ssl.keystore.location = null
 	ssl.keystore.password = null
 	ssl.keystore.type = JKS
 	ssl.protocol = TLSv1.2
 	ssl.provider = null
 	ssl.secure.random.implementation = null
 	ssl.trustmanager.algorithm = PKIX
 	ssl.truststore.location = null
 	ssl.truststore.password = null
 	ssl.truststore.type = JKS
 
 2020-07-02 20:56:46.163  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 2.5.0
 2020-07-02 20:56:46.164  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 66563e712b0b9f84
 2020-07-02 20:56:46.164  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1593694606161
 2020-07-02 20:56:46.465  INFO 59674 --- [           main] o.a.k.clients.consumer.ConsumerConfig    : ConsumerConfig values: 
 	allow.auto.create.topics = true
 	auto.commit.interval.ms = 100
 	auto.offset.reset = earliest
 	bootstrap.servers = [localhost:9092]
 	check.crcs = true
 	client.dns.lookup = default
 	client.id = 
 	client.rack = 
 	connections.max.idle.ms = 540000
 	default.api.timeout.ms = 60000
 	enable.auto.commit = false
 	exclude.internal.topics = true
 	fetch.max.bytes = 52428800
 	fetch.max.wait.ms = 500
 	fetch.min.bytes = 1
 	group.id = input-group-1
 	group.instance.id = null
 	heartbeat.interval.ms = 3000
 	interceptor.classes = []
 	internal.leave.group.on.close = true
 	isolation.level = read_uncommitted
 	key.deserializer = class org.apache.kafka.common.serialization.ByteArrayDeserializer
 	max.partition.fetch.bytes = 1048576
 	max.poll.interval.ms = 300000
 	max.poll.records = 500
 	metadata.max.age.ms = 300000
 	metric.reporters = []
 	metrics.num.samples = 2
 	metrics.recording.level = INFO
 	metrics.sample.window.ms = 30000
 	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
 	receive.buffer.bytes = 65536
 	reconnect.backoff.max.ms = 1000
 	reconnect.backoff.ms = 50
 	request.timeout.ms = 30000
 	retry.backoff.ms = 100
 	sasl.client.callback.handler.class = null
 	sasl.jaas.config = null
 	sasl.kerberos.kinit.cmd = /usr/bin/kinit
 	sasl.kerberos.min.time.before.relogin = 60000
 	sasl.kerberos.service.name = null
 	sasl.kerberos.ticket.renew.jitter = 0.05
 	sasl.kerberos.ticket.renew.window.factor = 0.8
 	sasl.login.callback.handler.class = null
 	sasl.login.class = null
 	sasl.login.refresh.buffer.seconds = 300
 	sasl.login.refresh.min.period.seconds = 60
 	sasl.login.refresh.window.factor = 0.8
 	sasl.login.refresh.window.jitter = 0.05
 	sasl.mechanism = GSSAPI
 	security.protocol = PLAINTEXT
 	security.providers = null
 	send.buffer.bytes = 131072
 	session.timeout.ms = 10000
 	ssl.cipher.suites = null
 	ssl.enabled.protocols = [TLSv1.2]
 	ssl.endpoint.identification.algorithm = https
 	ssl.key.password = null
 	ssl.keymanager.algorithm = SunX509
 	ssl.keystore.location = null
 	ssl.keystore.password = null
 	ssl.keystore.type = JKS
 	ssl.protocol = TLSv1.2
 	ssl.provider = null
 	ssl.secure.random.implementation = null
 	ssl.trustmanager.algorithm = PKIX
 	ssl.truststore.location = null
 	ssl.truststore.password = null
 	ssl.truststore.type = JKS
 	value.deserializer = class org.apache.kafka.common.serialization.ByteArrayDeserializer
 
 2020-07-02 20:56:46.509  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 2.5.0
 2020-07-02 20:56:46.509  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 66563e712b0b9f84
 2020-07-02 20:56:46.509  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1593694606509
 2020-07-02 20:56:46.516  INFO 59674 --- [           main] org.apache.kafka.clients.Metadata        : [Consumer clientId=consumer-input-group-1-1, groupId=input-group-1] Cluster ID: MehXd5CVQeOtxXQR6yCaWg
 2020-07-02 20:56:46.536  INFO 59674 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'ktopic.input-group-1.errors' has 1 subscriber(s).
 2020-07-02 20:56:46.536  INFO 59674 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'ktopic.input-group-1.errors' has 0 subscriber(s).
 2020-07-02 20:56:46.536  INFO 59674 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'ktopic.input-group-1.errors' has 1 subscriber(s).
 2020-07-02 20:56:46.536  INFO 59674 --- [           main] o.s.c.stream.binder.BinderErrorChannel   : Channel 'ktopic.input-group-1.errors' has 2 subscriber(s).
 2020-07-02 20:56:46.547  INFO 59674 --- [           main] o.a.k.clients.consumer.ConsumerConfig    : ConsumerConfig values: 
 	allow.auto.create.topics = true
 	auto.commit.interval.ms = 100
 	auto.offset.reset = earliest
 	bootstrap.servers = [localhost:9092]
 	check.crcs = true
 	client.dns.lookup = default
 	client.id = 
 	client.rack = 
 	connections.max.idle.ms = 540000
 	default.api.timeout.ms = 60000
 	enable.auto.commit = false
 	exclude.internal.topics = true
 	fetch.max.bytes = 52428800
 	fetch.max.wait.ms = 500
 	fetch.min.bytes = 1
 	group.id = input-group-1
 	group.instance.id = null
 	heartbeat.interval.ms = 3000
 	interceptor.classes = []
 	internal.leave.group.on.close = true
 	isolation.level = read_uncommitted
 	key.deserializer = class org.apache.kafka.common.serialization.ByteArrayDeserializer
 	max.partition.fetch.bytes = 1048576
 	max.poll.interval.ms = 300000
 	max.poll.records = 500
 	metadata.max.age.ms = 300000
 	metric.reporters = []
 	metrics.num.samples = 2
 	metrics.recording.level = INFO
 	metrics.sample.window.ms = 30000
 	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
 	receive.buffer.bytes = 65536
 	reconnect.backoff.max.ms = 1000
 	reconnect.backoff.ms = 50
 	request.timeout.ms = 30000
 	retry.backoff.ms = 100
 	sasl.client.callback.handler.class = null
 	sasl.jaas.config = null
 	sasl.kerberos.kinit.cmd = /usr/bin/kinit
 	sasl.kerberos.min.time.before.relogin = 60000
 	sasl.kerberos.service.name = null
 	sasl.kerberos.ticket.renew.jitter = 0.05
 	sasl.kerberos.ticket.renew.window.factor = 0.8
 	sasl.login.callback.handler.class = null
 	sasl.login.class = null
 	sasl.login.refresh.buffer.seconds = 300
 	sasl.login.refresh.min.period.seconds = 60
 	sasl.login.refresh.window.factor = 0.8
 	sasl.login.refresh.window.jitter = 0.05
 	sasl.mechanism = GSSAPI
 	security.protocol = PLAINTEXT
 	security.providers = null
 	send.buffer.bytes = 131072
 	session.timeout.ms = 10000
 	ssl.cipher.suites = null
 	ssl.enabled.protocols = [TLSv1.2]
 	ssl.endpoint.identification.algorithm = https
 	ssl.key.password = null
 	ssl.keymanager.algorithm = SunX509
 	ssl.keystore.location = null
 	ssl.keystore.password = null
 	ssl.keystore.type = JKS
 	ssl.protocol = TLSv1.2
 	ssl.provider = null
 	ssl.secure.random.implementation = null
 	ssl.trustmanager.algorithm = PKIX
 	ssl.truststore.location = null
 	ssl.truststore.password = null
 	ssl.truststore.type = JKS
 	value.deserializer = class org.apache.kafka.common.serialization.ByteArrayDeserializer
 
 2020-07-02 20:56:46.552  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 2.5.0
 2020-07-02 20:56:46.552  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 66563e712b0b9f84
 2020-07-02 20:56:46.552  INFO 59674 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1593694606552
 2020-07-02 20:56:46.553  INFO 59674 --- [           main] o.a.k.clients.consumer.KafkaConsumer     : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Subscribed to topic(s): ktopic
 2020-07-02 20:56:46.554  INFO 59674 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Initializing ExecutorService
 2020-07-02 20:56:46.558  INFO 59674 --- [           main] s.i.k.i.KafkaMessageDrivenChannelAdapter : started org.springframework.integration.kafka.inbound.KafkaMessageDrivenChannelAdapter@7c20cdd0
 2020-07-02 20:56:46.567  INFO 59674 --- [container-0-C-1] org.apache.kafka.clients.Metadata        : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Cluster ID: MehXd5CVQeOtxXQR6yCaWg
 2020-07-02 20:56:46.568  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Discovered group coordinator maheshs-mbp:9092 (id: 2147483647 rack: null)
 2020-07-02 20:56:46.569  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] (Re-)joining group
 2020-07-02 20:56:46.578  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Join group failed with org.apache.kafka.common.errors.MemberIdRequiredException: The group member needs to have a valid member id before actually entering a consumer group
 2020-07-02 20:56:46.578  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] (Re-)joining group
 2020-07-02 20:56:46.581  INFO 59674 --- [           main] c.r.r.ReactiveStreamConsumerApplication  : Started ReactiveStreamConsumerApplication in 2.509 seconds (JVM running for 2.953)
 2020-07-02 20:56:46.584  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Finished assignment for group at generation 15: {consumer-input-group-1-2-d3cdf29a-f3dc-4b01-8e1f-bd0b423f76a0=Assignment(partitions=[ktopic-0])}
 2020-07-02 20:56:46.588  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.AbstractCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Successfully joined group with generation 15
 2020-07-02 20:56:46.591  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Adding newly assigned partitions: ktopic-0
 2020-07-02 20:56:46.598  INFO 59674 --- [container-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-input-group-1-2, groupId=input-group-1] Setting offset for partition ktopic-0 to the committed offset FetchPosition{offset=11, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[maheshs-mbp:9092 (id: 0 rack: null)], epoch=0}}
 2020-07-02 20:56:46.599  INFO 59674 --- [container-0-C-1] o.s.c.s.b.k.KafkaMessageChannelBinder$1  : input-group-1: partitions assigned: [ktopic-0]

```

### Define Kafka Topic in yml file
```yaml
spring:
  cloud:
    stream:
      default-binder: kafka
      kafka:
        binder:
          brokers:
            - localhost:9092
      bindings:
        input:
          binder: kafka
          destination: ktopic
          content-type: application/json
          group: input-group-1
```

Please setup stream kafka producer and post JSON to endpoint

Console output 
```
2020-07-02 20:58:02.087  INFO 59674 --- [container-0-C-1] c.r.r.ReactiveStreamConsumerApplication  : {}Person(name=Shawn)
2020-07-02 20:58:10.406  INFO 59674 --- [container-0-C-1] c.r.r.ReactiveStreamConsumerApplication  : {}Person(name=Mahesh)
2020-07-02 20:58:20.096  INFO 59674 --- [container-0-C-1] c.r.r.ReactiveStreamConsumerApplication  : {}Person(name=Xiaoyuan)
```
