package org.example.learn.jetty.hello;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.example.learn.jetty.hello.constant.ServerConstants;
import org.example.learn.jetty.hello.servlet.HelloServlet;
import org.junit.Test;

public class Test01 {

    @Test
    public void test0() throws Exception {
        // 创建 Jetty Server实例监听端口
        Server server = new Server(ServerConstants.PORT);

        // 创建 Servlet 上下文处理器
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath(ServerConstants.CONTEXT_PATH);
        // 添加一个简单的 Servlet
        handler.addServlet(HelloServlet.class, "/hello");

        server.setHandler(handler);

        // 启动服务器
        server.start();
        server.join();
    }
}
