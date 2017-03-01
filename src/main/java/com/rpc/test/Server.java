package com.rpc.test;

import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.WebServer;

/**
 * Created by lijingen on 2016/6/9.
 */
public class Server {
    private static final int port=8005;
    public static void main(String args[]) throws Exception{
    WebServer webServer=new WebServer(port);
        XmlRpcServer xmlRpcServer=webServer.getXmlRpcServer();
        PropertyHandlerMapping propertyHandlerMapping=new PropertyHandlerMapping();
        propertyHandlerMapping.addHandler("helloHandler",HelloHandler.class);
        xmlRpcServer.setHandlerMapping(propertyHandlerMapping);
        XmlRpcServerConfigImpl xmlRpcServerConfig=(XmlRpcServerConfigImpl)xmlRpcServer.getConfig();
        xmlRpcServerConfig.setEnabledForExceptions(true);
        xmlRpcServerConfig.setContentLengthOptional(false);
        webServer.start();
        System.out.println("启动...");
    }
}
