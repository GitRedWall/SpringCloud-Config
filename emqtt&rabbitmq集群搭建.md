### rabbitmq�
�ο����£�https://blog.csdn.net/u013256816/article/details/53524766
1���޸�/etc/profile��������������
export PATH=$PATH:/data/erlang19.0/bin
export PATH=$PATH:$HOME/bin
export TMOUT=3600

2����ȡ����һ���ڵ��cookie, �����Ƶ������ڵ㣨�ڵ�֮��ͨ��cookieȷ���໥�Ƿ��ͨ�ţ��� 
cookie�����/var/lib/rabbitmq/.erlang.cookie����$HOME/.erlang.cookie��
3����������ڵ� /data/rabbitmq-server/sbin/rabbitmq-server -detached &
4��
5 ���ø��ڵ��hosts�ļ�( vim /etc/hosts) 
10.0.8.4 ils-mqtt-server1
10.0.8.5 ils-mqtt-server2
10.0.8.6 ils-mqtt-server3

6����ils-mqtt-server1Ϊ���ڵ㣬��ils-mqtt-server2�ϣ� 
rabbitmqctl stop_app 
rabbitmqctl reset 
rabbitmqctl join_cluster rabbit@ils-mqtt-server1 
rabbitmqctl start_app 
��ils-mqtt-server3���ظ�ils-mqtt-server2������

�����û�
/data/rabbitmq-server/sbin/rabbitmqctl add_user ilsadmin�û��� ilsadmin@2Ol8����
����Ϊ����Ա
/data/rabbitmq-server/sbin/rabbitmqctl set_user_tags ilsadmin administrator


### EMQTTD ��Ⱥ��װ�����������֤
���ӵ�ַ��http://www.mamicode.com/info-detail-1796540.html

1����3̨�ڵ��е�hosts�����ļ���������������
cat /etc/hosts

10.0.8.4 ils-mqtt-server1.emqtt.io
10.0.8.5 ils-mqtt-server2.emqtt.io
10.0.8.6 ils-mqtt-server3.emqtt.io

2���޸�vim /usr/local/emq/emqttd/etc/emq.conf �����ļ�
����node.name = emq@ils-mqtt-server1.emqtt.io
����2̨ͬ������
3�����뼯Ⱥ
��10.0.8.5 ils-mqtt-server2.emqtt.io ��������ִ��
./bin/emqttd_ctl cluster join emq@ils-mqtt-server1.emqtt.io
��10.0.8.6 ils-mqtt-server3.emqtt.io��������ִ��
./bin/emqttd_ctl cluster join emq@ils-mqtt-server1.emqtt.io


### Ubuntu 16.04 �°�װHAProxy 1.8.9 ��tcp���ؾ���
�ο����£�https://blog.csdn.net/wyqlxy/article/details/51861329
1.���� wget http://www.haproxy.org/download/1.8/src/haproxy-1.8.9.tar.gz
2. �����ѹĿ¼��cd /data/soft/haproxy-1.8.9
3. ��ѯ�ں˰汾�� uname -r ��ͨ��cat README ����֪������ƽ̨�İ汾�ţ��°汾��UbuntuΪlinux2628
4. Դ����룺sudo make TARGET=linux2628 PREFIX=/data/haproxy ע����Ǵ�Сд�����ĳ�Сд�����벻ͨ����û�б��뵽ָ��·����
5. ��װ��sudo make install PREFIX=/data/haproxy
6.�½�/data/haproxy/etc/ Ŀ¼
7.����/data/haproxy/etc/ Ŀ¼������haproxy.cfg �ļ�������haproxy����
8.����/data/haproxy/sbin/haproxy -f /data/haproxy/etc/haproxy.cfg
��������/data/haproxy/sbin/haproxy -f /data/haproxy/etc/haproxy.cfg -st 

