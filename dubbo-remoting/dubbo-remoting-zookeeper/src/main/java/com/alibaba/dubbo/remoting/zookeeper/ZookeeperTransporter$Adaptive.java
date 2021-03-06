package com.alibaba.dubbo.remoting.zookeeper;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class ZookeeperTransporter$Adaptive implements com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter {
    public com.alibaba.dubbo.remoting.zookeeper.ZookeeperClient connect(com.alibaba.dubbo.common.URL urlParam) {
        if (urlParam == null) throw new IllegalArgumentException("url == null");
        com.alibaba.dubbo.common.URL url = urlParam;
        String extName = url.getParameter("client", url.getParameter("transporter", "zkclient"));
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter) name from url(" + url.toString() + ") use keys([client, transporter])");
        com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter extension = (com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter) ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter.class).getExtension(extName);
        return extension.connect(urlParam);
    }
}