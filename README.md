## "白痴" bc框架简介

取名叫"白痴"框架的初衷只是觉得框架就是为了让使用的人更方便,快捷,易上手,就像傻瓜相机一样,你只需要按下快门,相片就拍好了. 框架也应如此,你只需要使用框架中提供的各种封装后的api来实现你的需求
框架中集成了较多的模块,大多数都是项目中经常使用到的工具,版本的话也都是采用的相对稳定的版本

1.  bc-framework是基于springboot为底层的框架,框架目前一共有八个模块,bc-base,bc-annotation,bc-cache,bc-dao,bc-dto,bc-elasticsearch,bc-mongo,bc-http,其中base为主要模块,
    包含了所有公共的异常处理类,公共的dto实体,公共的枚举定义,工具类等.框架中整合了大部分项目中常用的开发工具模块如mysql,redis,mongodb,http,mq,elasticsearch,目的是为了让大家在使用框架后,
    可以快速的基于框架的基础进行开发,不再费时间去找寻各种工具的依赖,以及编写调用的工具类.

2.  bc-base通过切面与注解的方式对Service接口中的所有请求参数,返回参数进行统一日志打印处理,并提供了接口统一返回对象,统一异常返回类,业务异常类,全局异常处理,自定义业务统一异常,无需捕获处理的异常,
    这些异常类用来针对业务中不同的场景使用. base模块还提供了常用的枚举类,统一的错误码枚举,系统返回码枚举,常用的工具类,CollectionUtil集合工具类,Assert断言工具类,SpringUtil工具类等

3.  bc-cache提供了缓存服务的处理,对redis的操作进行封装,并提供了CommonCache,StringCache,SetCache,MapCache,ListCache几种数据类型的操作满足项目日常操作需要. 针对分布式操作也提供了Redisson分布式事务锁的封装,只需调用RedissonClient即可

4.  bc-elasticsearch模块提供了针对elasticsearch的增删改查操作处理,不管是用logstash还是用canal都可以同步数据到es中,对于数据量庞大的表结构查询效率非常好,
    建议采用canal同步数据,实时性比较好,如果用logstash同步会有10-30秒左右的延迟,要求实时性高的话不太适合

