## QuestionnaireDemo

### 项目概述

该项目为仿问卷星的企业专利管理状况评估平台，分为Springboot服务端、Vue全家桶后台管理页面、Uni-App跨平台微信小程序端用户三部分。该Repository包含服务端及后台管理页面，请在IDEA中运行，并配合QuestionnaireServer食用

### 项目技术栈

* 服务端基于Spring Boot，使用EasyCode插件生成entity、dao、service、controller层，路由及业务逻辑在controller层实现，数据库操作封装在service层及dao实现，entity层对应数据库表
* 数据库使用MySQL，基于MyBatis + Hikari进行数据操作
* 使用json-lib从接口向前端返回JSON格式的数据
* 使用Lombok代替实体类Getter及Setter方法
* 后台管理页面基于Vue.js编写，利用了Element-UI组件，使用axios请求数据

### 项目运行

克隆本项目并更新您的Maven依赖以运行。若您使用IDEA等IDE，请保证Lombok插件已正确安装。
