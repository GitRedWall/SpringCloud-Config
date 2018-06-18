### rabbitmq搭建
参考文章：https://blog.csdn.net/u013256816/article/details/53524766
1、修改/etc/profile，增加如下配置
export PATH=$PATH:/data/erlang19.0/bin
export PATH=$PATH:$HOME/bin
export TMOUT=3600

2、读取其中一个节点的cookie, 并复制到其他节点（节点之间通过cookie确定相互是否可通信）。 
cookie存放在/var/lib/rabbitmq/.erlang.cookie或者$HOME/.erlang.cookie中
3、逐个启动节点 /data/rabbitmq-server/sbin/rabbitmq-server -detached &
4、
5 配置各节点的hosts文件( vim /etc/hosts) 
10.0.8.4 ils-mqtt-server1
10.0.8.5 ils-mqtt-server2
10.0.8.6 ils-mqtt-server3

6、以ils-mqtt-server1为主节点，在ils-mqtt-server2上： 
rabbitmqctl stop_app 
rabbitmqctl reset 
rabbitmqctl join_cluster rabbit@ils-mqtt-server1 
rabbitmqctl start_app 
再ils-mqtt-server3中重复ils-mqtt-server2的命令

创建用户
/data/rabbitmq-server/sbin/rabbitmqctl add_user ilsadmin用户名 ilsadmin@2Ol8密码
设置为管理员
/data/rabbitmq-server/sbin/rabbitmqctl set_user_tags ilsadmin administrator


### EMQTTD 集群安装配置与测试验证
链接地址：http://www.mamicode.com/info-detail-1796540.html

1、在3台节点中的hosts配置文件都加入以下配置
cat /etc/hosts

10.0.8.4 ils-mqtt-server1.emqtt.io
10.0.8.5 ils-mqtt-server2.emqtt.io
10.0.8.6 ils-mqtt-server3.emqtt.io

2、修改vim /usr/local/emq/emqttd/etc/emq.conf 配置文件
更改node.name = emq@ils-mqtt-server1.emqtt.io
其他2台同类配置
3、加入集群
在10.0.8.5 ils-mqtt-server2.emqtt.io 服务器中执行
./bin/emqttd_ctl cluster join emq@ils-mqtt-server1.emqtt.io
在10.0.8.6 ils-mqtt-server3.emqtt.io服务器中执行
./bin/emqttd_ctl cluster join emq@ils-mqtt-server1.emqtt.io


### Ubuntu 16.04 下安装HAProxy 1.8.9 做tcp负载均衡
参考文章：https://blog.csdn.net/wyqlxy/article/details/51861329
1.下载 wget http://www.haproxy.org/download/1.8/src/haproxy-1.8.9.tar.gz
2. 进入解压目录：cd /data/soft/haproxy-1.8.9
3. 查询内核版本： uname -r ，通过cat README 可以知道编译平台的版本号，新版本的Ubuntu为linux2628
4. 源码编译：sudo make TARGET=linux2628 PREFIX=/data/haproxy 注意的是大小写，若改成小写，编译不通过或没有编译到指定路径下
5. 安装：sudo make install PREFIX=/data/haproxy
6.新建/data/haproxy/etc/ 目录
7.进入/data/haproxy/etc/ 目录，创建haproxy.cfg 文件，进行haproxy配置
8.运行/data/haproxy/sbin/haproxy -f /data/haproxy/etc/haproxy.cfg
重启服务/data/haproxy/sbin/haproxy -f /data/haproxy/etc/haproxy.cfg -st 

