## 资料
[依赖]https://spring.io/guides/gs/serving-web-content/

[授权登录参考资料]https://docs.github.com/cn/developers/apps/building-oauth-apps/authorizing-oauth-apps

[授权登录参考资料补充]http://www.manongjc.com/detail/14-ggniaodrxjgdctw.html

[项目地址]https://github.com/mapleboys/community

[fastJason参考资料]https://www.cjavapy.com/article/133/

[okHttp参考资料]https://square.github.io/okhttp/

[session和cookie类比]session:银行账户 cookie:银行卡 浏览器：你 服务器：银行

[Mysql数据库基本知识]https://www.runoob.com/mysql/mysql-tutorial.html

[dbeaver链接h2数据库]https://www.cnblogs.com/wang-liang-blogs/p/12123626.html

[myBatis实战]https://www.cnblogs.com/diffx/p/10611082.html

[myBatis官网]https://mybatis.org/mybatis-3/zh/getting-started.html

[lombok官网]https://projectlombok.org/features/all 需要安装插件和引入依赖来使用

[模板完整]https://elasticsearch.cn/category-18

[devtools热部署工具]https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools配合live Reload

[解决flyway命令报错]https://blog.csdn.net/lejustdoit/article/details/107574971

[thymeleaf]https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

[jquery]https://code.jquery.com/jquery-3.6.0.min.js

[spring MVC]https://docs.spring.io/spring-framework/docs/current/reference/html/web.html

[mybatis generator]http://mybatis.org/generator/configreference/table.html

[spring文档]https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#howto-customize-the-whitelabel-error-page

[sql正则表达式]https://www.runoob.com/mysql/mysql-regexp.html

[ucloud对象存储api]https://github.com/ucloud/ufile-sdk-java

[markdown editor]https://github.com/pandao/editor.md

[springboot定时任务]https://spring.io/guides/gs/scheduling-tasks/

[调整日志为debug级别]
1. 配置所有包下日志为DEBUG级别
1.1 properties配置
logging.level.root=DEBUG

2. 配置固定的包
2.1 properties配置
logging.level.你的包名.你的包名.你的包名=DEBUG
例如你的包名是 com.baidu , 就要写为
logging.level.com.baidu=DEBUG

## 注意事项
```text
redirect 跳转到路径地址
Spring 的定时任务默认是单线程执行
```

## 错误解决
[降低flyway版本]org.flywaydb.core.api.FlywayException: No database found to handle jdbc:mysql

[设置spring.flyway.baselineOnMigrate=true并清空数据库表]Found non-empty schema(s) `community` without schem a history table! Use bas

[删除重复]
```text
错误提示：java.lang.IllegalArgumentException: Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
原因：main中的标注@MapperScan("com.example.communication.mapper")和application.yml
中mybatis:mapper-locations: classpath:mapper/*.xml重复
处理办法：删除main中的标注
参考：https://blog.csdn.net/lv_dw962464/article/details/84891078
```


[全局exception拦截]
```text
CustomExceptionController参考的是BasicErrorController
```

[mybatis报错]
```text
错误：Springboot +Mybatis整合常见错误 报错：Property ‘sqlSessionFactory‘ or ‘sqlSessionTemplate‘ are required
解决：https://www.jianshu.com/p/d96a53b77713
```
## 工具
[git工具]http://git-scm.com/

[register快捷键]shift+ctrl+alt+?

[bootcss前端工具]https://v3.bootcss.com/css/


# 命令
1.生成 Model 等 MyBatis 配置文件的命令
```bash
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```

2.运行数据库脚本，创建本地数据库
```bash
mvn flyway:migrate
```
3. 运行打包命令，生成可执行 jar 文件
```sh
mvn package -DskipTests
```
4. 运行项目  
```sh
nohup java -jar target/communication-0.0.1-SNAPSHOT.jar >./logs/my.log  2>&1 &
```
如果是线上部署，可以增加配置文件(production.properties)，同时运行命令修改如下
```sh
java -jar -Dspring.profiles.active=production target/community-0.0.1-SNAPSHOT.jar
```
5. 访问项目
```
http://localhost:8887
```
6. git远程分支覆盖本地分支
```shell script
git fetch --all
git reset --hard origin/master (这里master要修改为对应的分支名)
git pull
```
7. nginx启停命令
```text
systemctl status nginx
systemctl start nginx
systemctl stop nginx
systemctl restart nginx
```