# 软件工程小学期
# 准备
1 下载压缩包并解压。

2 用IEDA打开项目，找到/src/lib目录的jar包并右键jar包选择  add as library

3 打开数据库管理工具，创建数据库并执行MySql_init里的代码

![image](https://user-images.githubusercontent.com/69297333/178645862-a7ba34d2-15ce-454b-9c1f-66372b6492b5.png)


如图，我新建一个名为"info" 数据库并执行MySql_init里的代码,此时生成了3个表

4 找到/src/util目录下的DBUtil打开，将14行的 "info" 替换为你的数据库名，并将16，18行替换为你的数据库账号和密码

5 尝试运行
# 功能预览
1.  基础数据维护

主界面主要分为三个功能：1登陆  2.注册(只能是普通用户)  3.退出

​                               ![1](https://github.com/Pillarzx/eleme/blob/master/images/1.png)

1.1 登陆功能

实现登陆功能,即用户需要输入用户名及密码，验证是否成功，如果用户名错误会提示”用户名错误”,如果登陆成功，会根据返回值进入店家界面、普通用户界面

 ![2](https://github.com/Pillarzx/eleme/blob/master/images/2.png)

 

 ![3](https://github.com/Pillarzx/eleme/blob/master/images/3.png)

![4](https://github.com/Pillarzx/eleme/blob/master/images/4.png)

1.2 用户注册

实现对用户的添加，即用户需要输入用户名字、密码、电话，用户名不能与已有用户名重复、密码必须是8-16位、电话号必须是11位，否则提示错误信息

 ![5](https://github.com/Pillarzx/eleme/blob/master/images/5.png)

 

 ![6](https://github.com/Pillarzx/eleme/blob/master/images/6.png)

 ![7](https://github.com/Pillarzx/eleme/blob/master/images/7.png)

![8](https://github.com/Pillarzx/eleme/blob/master/images/8.png)

1.3 退出系统

实现退出系统

\2.  店家管理

店家登陆成功后：实现对菜品及订单的信息维护，查看菜品信息、录入菜品、修改菜品、查询顾客订单、删除菜品、配送菜品等功能

 ![9](https://github.com/Pillarzx/eleme/blob/master/images/9.png)

2.1 查看菜单

显示当前店面所有的菜品信息

 ![10](https://github.com/Pillarzx/eleme/blob/master/images/10.png)



2.2 录入菜品

实现对菜品的录入，即输入菜品名字、单价，菜品名字不能与已有菜品重复

 ![11](https://github.com/Pillarzx/eleme/blob/master/images/11.png)

2.3 修改菜品

实现对当前所有菜品是否处理热销或是下架状态的修改

 ![12](https://github.com/Pillarzx/eleme/blob/master/images/12.png)

 ![13](https://github.com/Pillarzx/eleme/blob/master/images/13.png)

 

 

2.4 查看订单

店家可以查看当前所有的订单信息

 ![14](https://github.com/Pillarzx/eleme/blob/master/images/14.png)

2.5 删除菜品

实现对菜品删除,即店家需要输入菜品编号，编号正确方可删除

 ![15](https://github.com/Pillarzx/eleme/blob/master/images/15.png)

 ![16](https://github.com/Pillarzx/eleme/blob/master/images/16.png)

2.6 配送菜品

实现配送用户已点的菜品，即显示待处理订单信息(订单未完成)，修改订单的状态

 ![17](https://github.com/Pillarzx/eleme/blob/master/images/17.png)

 ![18](https://github.com/Pillarzx/eleme/blob/master/images/18.png)

2.7 返回上一级

 实现返回上一级菜单即主菜单

\3.  普通用户管理

实现普通用户对菜品及订单信息的维护，即查看菜品信息、订餐、查看订单（当前用户订单）、签收订单（已配送中）、取消订单（未配送）、点赞、充值。返回上一级等功能

 ![19](https://github.com/Pillarzx/eleme/blob/master/images/19.png)

3.1 查看菜品信息

显示当前店面所有的菜品信息

 ![20](https://github.com/Pillarzx/eleme/blob/master/images/20.png)

3.2 订餐

实现订餐功能，即用户在热销菜品中选择要购买的菜品编号、数量、如果用户卡内余额大于菜品总价，则购买成功，否则购买失败。

3.3 查看订单

实现查看自己的订单

 ![23](https://github.com/Pillarzx/eleme/blob/master/images/23.png)

3.4 签收订单

实现订单签收功能，只能签收配送中的订单

 ![24](https://github.com/Pillarzx/eleme/blob/master/images/24.png)

 ![25](https://github.com/Pillarzx/eleme/blob/master/images/25.png)

3.5 取消订单

实现订单取消功能，只能取消为配送的订单

 ![26](https://github.com/Pillarzx/eleme/blob/master/images/26.png)

3.6 点赞

实现对菜品的点赞功能，每次只能点赞一次

 ![27](https://github.com/Pillarzx/eleme/blob/master/images/27.png)

 ![28](https://github.com/Pillarzx/eleme/blob/master/images/28.png)

3.7 充值

实现用户充值功能，但是只能输入20、50、100，否则充值失败

 ![29](https://github.com/Pillarzx/eleme/blob/master/images/29.png)

 ![30](https://github.com/Pillarzx/eleme/blob/master/images/30.png)

3.8 返回上一级

返回上一级，即主菜单

\4.  数据字典

用户表：

| 字段名字 | 字段描述 | 数据类型      | 约束             | 备注                  |
| -------- | -------- | ------------- | ---------------- | --------------------- |
| u_no     | 用户编号 | NUMBER(4)     | 主键             | 通过序列产生          |
| u_name   | 用户名字 | VARCHAR2 (30) | 唯一、不能为null |                       |
| u_pwd    | 用户密码 | VARCHAR2 (16) | 在8~16位         |                       |
| u_tell   | 用户电话 | NUMBER(11)    | 11位             |                       |
| u_money  | 用户余额 | NUMBER(10,2)  |                  |                       |
| u_role   | 用户权限 | NUMBER (1)    | 只能是0,1        | 0：管理员 1：普通用户 |

菜品表：



| 字段名字   | 字段描述 | 数据类型      | 约束             | 备注             |
| ---------- | -------- | ------------- | ---------------- | ---------------- |
| g_no       | 菜品编号 | NUMBER (4)    | 主键             | 通过序列产生     |
| g_name     | 菜品名字 | VARCHAR2 (30) | 唯一、不能为null |                  |
| g_price    | 菜品价格 | NUMBER(4,2)   | 在1~100之间      |                  |
| g_like_num | 点赞数   | NUMBER(6)     |                  |                  |
| g_state    | 菜品状态 | NUMBER(1)     | 只能是0,1        | 0:热销中 1：下架 |



  订单表：

| 字段名字  | 字段描述 | 数据类型      | 约束        | 备注                          |
| --------- | -------- | ------------- | ----------- | ----------------------------- |
| o_no      | 订单编号 | NUMBER (4)    | 主键        |                               |
| u_no      | 用户编号 | NUMBER (4)    | 外键        |                               |
| g_no      | 菜品编号 | NUMBER (4)    | 外键        |                               |
| o_num     | 菜品数量 | NUMBER (4)    |             |                               |
| o_time    | 送餐时间 | VARCHAR2 (20) | 不能为null  |                               |
| o_address | 送餐地址 | VARCHAR2 (40) | 不能为null  |                               |
| o_statte  | 订单状态 | NUMBER(1)     | 只能是0,1,2 | 0：已接单 1：配送中 2：已完成 |
