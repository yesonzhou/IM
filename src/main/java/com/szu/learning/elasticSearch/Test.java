package com.szu.learning.elasticSearch;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.NamedXContentRegistry;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//            GetResponse response = client.prepareGet("user", "buddies", "1").execute().actionGet();


            JSONObject json = new JSONObject();
            json.put("test_k","v");
            Map data = JSONObject.parseObject(json.toString(), Map.class);
            XContentParser xContentParser = XContentFactory.xContent(XContentType.JSON)
                    .createParser(NamedXContentRegistry.EMPTY,json.toString());


            //在这里创建我们要索引的对象
            IndexResponse response = client.prepareIndex("index", "type")
                    //必须为对象单独指定ID
                    .setId("test_id2")
                    .setSource(data) // 新版需要传入Map类型
                    .execute()
                    .actionGet();
            //多次index这个版本号会变
            System.out.println("response.version():"+response.getVersion());
            client.close();



            //输出结果
//            System.out.println(response.getSourceAsString());
            //关闭client
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
