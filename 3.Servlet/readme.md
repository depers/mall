# Servlet

> 2022年9月9日 陕西西安

## 介绍

这个项目是关于Java Servlet知识的学习项目。

## 项目组成

| 序号 | 项目名称                     | 描述                                                         |
| ---- | ---------------------------- | ------------------------------------------------------------ |
| 1    | Servlet-demo                 | Java Servlet的一个基础项目，关于Servlet的大部分知识点都包含  |
| 2    | forward-sendRedirect-example | 这个项目是关于Java Servlet中`forward()`和`SendRedirect()`方法的实验项目，用来探究这两个方式的区别 |
| 3    | ServletJNDI                  | Tomcat DataSource JNDI的实验项目，Application范围，用来探究修改单个app的context.xml来实现数据源的配置 |
| 4    | ServletJNDIServer            | Tomcat DataSource JNDI的实验项目，Server范围，通过配置Server的context.xml文件，实现多个应用程序共享一个数据源。但是这样会消耗所有数据库服务器资源并损害应用程序性能 |
| 5    | ServletJNDIServerContext     | Tomcat DataSource JNDI的实验项目，Server范围，通过配置Server的server.xml，在Server或是应用程序配置context.xml文件，是实现多个应用程序共享一个数据源的首要选择 |
| 6    | SpringSecurityApp            | Spring Security项目的实验项目                                |
| 7    | ServletDBLog4jExample        | Servlet，JDBC和Log4j的一个实验项目                           |
| 8    | web-fragment-demo            | 探究web-fragment的实现                                       |

