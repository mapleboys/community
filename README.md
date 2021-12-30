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
redirect 跳转到路径地址


## 工具
[git工具]http://git-scm.com/

[bootcss前端工具]https://v3.bootcss.com/css/

## 脚本
```sql
CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  account_id varchar(100) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  token char(36) DEFAULT NULL,
  gmt_create bigint DEFAULT NULL,
  gmt_modified bigint DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='登录人员信息表'
```
