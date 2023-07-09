
##  🚀项目介绍
<a target="_blank" href="">
  <img alt="Star" src="https://gitee.com/fxz-cloud/art/badge/star.svg?theme=dark">
</a>
<a target="_blank" href="">
  <img alt="Fork" src="https://gitee.com/fxz-cloud/art/badge/fork.svg?theme=dark">
</a>
<a target="_blank" href="">
  <img alt="Spring Boot " src="https://img.shields.io/static/v1?label=Spring Boot &message=2.7.12&color=blue">
</a>
<a target="_blank" href="">
  <img alt="Spring Cloud" src="https://img.shields.io/static/v1?label=Spring Cloud&message=2021.0.6 &color=blue">
</a>
<a target="_blank" href="">
  <img alt="Spring Cloud Alibaba" src="https://img.shields.io/static/v1?label=Spring Cloud Alibaba &message=2021.0.4.0&color=blue">
</a>
<a target="_blank" href="">
  <img alt="OAuth 2.1" src="https://img.shields.io/static/v1?label=OAuth 2.1&message=0.4.2&color=blue">
</a>
<a target="_blank" href="">
  <img alt="JDK" src="https://img.shields.io/badge/JDK-8-blue.svg"/>
</a>
<a target="_blank" href="">
<img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-%20"/>
</a>
<br/>
Art 全端代码开源，支持RBAC 动态权限、SaaS多租户、数据权限等功能，持续更新。

##  🍎 分支说明
| 分支              | 说明                                                                |
|-----------------|-------------------------------------------------------------------|
| master          | java8 + springboot 2.7 + springcloud 2021 + spring cloud alibaba                        |
| next            | java17 + springboot 3.0 + springcloud 2022 + spring cloud alibaba |

## 📖系统简介

项目中使用的是阿里的规范（详细可看https://github.com/alibaba/p3c 这里面的[Java开发手册（黄山版）.pdf](https://github.com/alibaba/p3c/blob/master/Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C(%E9%BB%84%E5%B1%B1%E7%89%88).pdf)），同时使用插件进行规约扫描。

![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/07/09/MYYu0t.jpg)
![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/07/09/RBL2FZ.jpg)

- 开放 API 层：可直接封装 Service 接口暴露成 RPC 接口；通过 Web 封装成 http 接口；网关控制层等。
- 终端显示层：各个端的模板渲染并执行显示的层。
- Web 层：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
- Service 层：相对具体的业务逻辑服务层。
- Manager 层：通用业务处理层，它有如下特征：
    -  1） 对第三方平台封装的层，预处理返回结果及转化异常信息，适配上层接口。
    -  2） 对 Service 层通用能力的下沉，如缓存方案、中间件通用处理。
    -  3） 与 DAO 层交互，对多个 DAO 的组合复用。
- DAO 层：数据访问层，与底层 MySQL、Oracle、Hbase、OB 等进行数据交互。
- 第三方服务：包括其它部门 RPC 服务接口，基础平台，其它公司的 HTTP 接口，如淘宝开放平台、支 付宝付款服务、高德地图服务等。
- 外部数据接口：外部（应用）数据存储服务提供的接口，多见于数据迁移场景中。

## 💻系统应用

| RBAC&数据权限                | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/Dt08vc.png) | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/WB6Hc9.png) |
|--------------------------| ------------------------------------------------------------ | ------------------------------------------------------------ |
| OAuth2.1,支持三方登录。可自定义进行拓展 | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/7WXTzw.png) | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/OXk0bF.png) |
| 多租户                      | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/YnXioC.png) | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/YzBZ6p.png) |
| 动态网关&字典管理                | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/zVpMJr.png) | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/xKK55D.png) |
| 动态数据源&代码生成,              | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/2BXWuL.png) | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/WpUDes.png) |
| 强退用户&审计日志                | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/i2pZEe.png) | ![](https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/05/06/XS0250.png) |

## 快速启动
[✈️️快速启动微服务](https://fxzcloud.gitee.io/docs/docs/theme-reco/started.html)

## 🔍项目说明
功能可按需引入。<br/>
低耦合，秒上手，稳得很！
## ❓其他功能
过于先进，不便展示。欢迎下载源码研究🧐欢迎star
## 🍓依赖版本

| 依赖                         | 版本         |
|----------------------------|------------|
| Spring Boot                | 2.7.12     |
| Spring Cloud               | 2021.0.6   |
| Spring Cloud Alibaba       | 2021.0.4.0 |
| Spring Authorization Serve | 0.4.2      |
| Mybatis Plus               | 3.5.3.1    |
| Hutool                     | 5.8.18     |



## 🍺加入我们
### 扫码进入官方微信群
<table>
    <tr>
      <td>扫码邀请入群</td>
      <td><img src="https://cdn.staticaly.com/gh/fxzbiz/img@url/2022/11/19/O69mHa.png" width="120"/></td>
      <td><img src="https://cdn.staticaly.com/gh/fxzbiz/img@url/2023/07/09/LqNzoU.jpg" width="120"/></td>
    </tr>
</table>

 


## 🍬配套文档
[🍓🍓🍓配套文档 fxzcloud.gitee.io/docs](https://fxzcloud.gitee.io/docs/)

## 🤝鸣谢
感谢 [![jetbrains](https://cdn.staticaly.com/gh/fxzbiz/img@url/2022/12/01/DGnop3.png)](https://www.jetbrains.com/)提供的免费License