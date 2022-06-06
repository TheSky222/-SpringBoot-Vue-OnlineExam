# 在线考试系统

* ## 系统介绍

     该项目是一个前后端分离，后端使用 SpringBoot，前端使用 VUE 和 Element-UI 组件库配合完成开发。
# 实验报告

## 1. 简介

本次大作业本组选择了基于教考分离的考试系统设计与开发，该项目是一个前后端分离，后端使用 SpringBoot，前端使用 VUE 和 Element-UI 组件库配合完成开发。考试系统包含完整的考试流程管理功能：建立题库、组卷、考试、考试结果统计等；用户管理包括管理员、教师、学生；考试管理模块可以查看未开始、进行中、已结束的所有考试，以列表形式呈现；统计分析模块，对考试系统运行的整体情况进行综合分析，让管理者能够更加清晰和直观的掌握考试相关数据。

## 2. 项目总体结构介绍

![image-20220607011517140](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607011517140.png)

前端部分：exam

后端部分：springboot

数据库部分：sql

img：模块展示图片

## 3.0 后端介绍

![image-20220607011751717](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607011751717.png)

后端主要代码上图所示：

controller：接口层，接收前端发送的请求，根据url调用相应的后端接口

entity：实体层，定义数据model（MVC），和数据库中的数据定义关联

mapper：对数据库进行操作，sql语句

service：业务逻辑层，定义抽象接口

serviceimpl：将抽象接口实体化

util：工具类，这里其实只写了一个用于统一数据传输格式

vo：定义一些数据类型，用于数据传输

### 3.1controller层

![image-20220607013532427](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607013532427.png)

以AdminController为例

![image-20220607013633338](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607013633338.png)

设置url对应的功能，例如增删改查

### 3.2 entity层

![image-20220607013839785](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607013839785.png)

以Admin为例：

![image-20220607013903561](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607013903561.png)

定义管理员在数据库中的字段，adminId（管理员id）、adminName（管理员姓名）、sex（性别）、tel（电话）、email（邮箱）、pwd（密码）、cardId（身份证号）、role（权限），已经相应的get和set方法

### 3.3 mapper层



![image-20220607014049717](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607014049717.png)

以AdminMapper为例：

![image-20220607015000925](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607015000925.png)

增删改查sql语句

### 3.4 service层

![image-20220607015030100](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607015030100.png)

以AdminService为例：

![image-20220607015244358](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607015244358.png)

定义抽象的功能函数，没有返回值

### 3.5 serviceimpl层

![image-20220607015325799](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607015325799.png)

以AdminServiceImpl为例

![image-20220607015519943](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607015519943.png)

具体实现类，函数有返回值

### 3.6 util层

![image-20220607015553136](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607015553136.png)

![image-20220607015602171](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607015602171.png)

同一前后端数据传输格式

将数据内容统一封装到Data中，然后增加Code和Message这两个返回参数，便于判断请求是否成功

## 4 前端介绍

![image-20220607020753285](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607020753285.png)

assets：用于存放一些资源比如图片

compontes：组件库，vue里面万物皆为组件，相比于传统网页html+css+js，vue三合一成为一个组件，一个组件或者多个组件组成一个月免

router：路由，url导航

vuex：Vuex 是一个专为 Vue.js 应用程序开发的**状态管理模式 + 库**。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化。这是官方描述，实际上没啥用这里。

这边主要介绍一下组件components里的内容

![image-20220607021256068](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607021256068.png)

### 4.1 admin管理员模块

![image-20220607021318743](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607021318743.png)

管理员初始页面和独属于管理员的一些操作，比如添加教师和教师管理

![image-20220607021557757](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607021557757.png)

![image-20220607021512817](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607021512817.png)

![image-20220607021524305](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607021524305.png)

### 4.2 charts/common通用模块

![image-20220607021702876](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607021702876.png)

这两个放在一块讲是因为，这些都是通用组件，比如一些图表、顶部新西兰队、顶部导航栏、左侧导航栏、内部导航栏之类的组件，他们会成为其他页面的一部分，这也是vue万物皆为组件的优点，可重复利用行高，传统html+css+js的写法，还得一个个分开去找相应代码，vue里面直接import调用组件即可

### 4.3 student学生模块

![image-20220607022139485](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607022139485.png)

这里面功能最多最复杂，毕竟这是个考试系统，主体考试功能都是学生专属，相比之下管理员和老师只是个无情的增删改查机器罢了，大致展现一些页面，具体功能建议实际操作体验

![image-20220607022458111](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607022458111.png)

![image-20220607022511942](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607022511942.png)

![image-20220607023240650](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023240650.png)

### 4.4teacher教师模块

![image-20220607023614762](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023614762.png)

除了对学生的管理增删改查以外，还有对考试的管理操作，增删改查以及组卷功能等

![image-20220607023826623](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023826623.png)

![image-20220607023835004](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023835004.png)

![image-20220607023843687](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023843687.png)

![image-20220607023853897](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023853897.png)

![](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023902892.png)

![image-20220607023911144](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023911144.png)

![image-20220607023927524](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023927524.png)

![image-20220607023938114](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023938114.png)

![image-20220607023947754](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607023947754.png)

## 5数据库介绍

![image-20220607024038911](/Users/luhaotian/Library/Application%20Support/typora-user-images/image-20220607024038911.png)

一些数据表单