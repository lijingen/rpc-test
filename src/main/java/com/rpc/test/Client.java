package com.rpc.test;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingen on 2016/6/9.
 */
public class Client {
    public  static void main(String args[]) throws Exception{
        XmlRpcClientConfigImpl xmlRpcClientConfig=new XmlRpcClientConfigImpl();
        xmlRpcClientConfig.setServerURL(new URL("http://localhost:8005/xmlrpc"));
        XmlRpcClient xmlRpcClient=new XmlRpcClient();
        xmlRpcClient.setConfig(xmlRpcClientConfig);
        List list =new ArrayList();
        list.add("lijingen");
        list.add("hello");
        String result=(String)xmlRpcClient.execute("helloHandler.sayHello",list);
        System.out.println("结果" + result);
    }
}
