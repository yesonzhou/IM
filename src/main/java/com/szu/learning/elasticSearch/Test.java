package com.szu.learning.elasticSearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.List;

/**
 * Created by y_s on 2019/3/22 4:46 PM
 * https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/transport-client.html
 */

public class Test {
    public static void main(String[] args) {
        try {

            //设置集群名称
//            Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
            //创建client
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("129.204.75.206"), 9300));

            List<DiscoveryNode> test = client.listedNodes();
            System.out.println(test.get(0).toString());
            //搜索数据
            GetResponse response = client.prepareGet("user", "buddies", "1").execute().actionGet();
            //输出结果
            System.out.println(response.getSourceAsString());
            //关闭client
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
