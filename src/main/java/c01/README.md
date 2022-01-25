# 接口鉴权设计

## 需求
为了保证接口调用的安全性，我们希望设计实现一个接口调用鉴权功能，只有经过认证之后的系统才能调用我们的接口，没有认证过的系统调用我们的接口会被拒绝。

## 思路
每个微服务有唯一的APIkey和password,存储在数据库中(mysql or 其他数据库),为了防止重放攻击,借用Oauth的思路,将API加密生成token,再把token拼入请求中,
服务器接收到请求后取出token和参数后采用同样的方法也生成一个token,如果相同则鉴权通过,否则拒绝.


## 功能点划分
功能点划分要求每个功能尽量地小,单一职责:
1. 把 URL、AppID、密码、时间戳拼接为一个字符串；
2. 对字符串通过加密算法加密生成 token；
3. 将 token、AppID、时间戳拼接到 URL 中，形成新的 URL；
4. 解析 URL，得到 token、AppID、时间戳等信息；
5. 从存储中取出 AppID 和对应的密码；
6. 根据时间戳判断 token 是否过期失效；
7. 验证两个 token 是否匹配；