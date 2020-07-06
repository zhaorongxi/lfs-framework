## 框架简介

1.  bc-framework是基于springboot为底层的框架,框架目前一共有八个模块,bc-base,bc-annotation,bc-cache,bc-dao,bc-dto,bc-elasticsearch,bc-mongo,bc-http,其中base为主要模块,
包含了所有公共的异常处理类,公共的dto实体,公共的枚举定义,工具类等.框架中整合了大部分项目中常用的开发工具模块如mysql,redis,mongodb,http,mq,elasticsearch,目的是为了让大家在使用框架后,
可以快速的基于框架的基础进行开发,不再费时间去找寻各种工具的依赖,以及编写调用的工具类.

2.  bc-base通过切面与注解的方式对Service接口中的所有请求参数,返回参数进行统一日志打印处理,并提供了接口统一返回对象,统一异常返回类,业务异常类,全局异常处理,自定义业务统一异常,无需捕获处理的异常,
这些异常类用来针对业务中不同的场景使用 
  
