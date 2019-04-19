package com.itunion.zkboot.web.controller;
/**
 * Created by lin on 2018年06月05日14:23:36
 */
@RestController
public class RestZkController {

    @RequestMapping(value = "/zkGet",method = RequestMethod.GET)
    public String zkGet(){
        Watcher watcher= new Watcher(){
            public void process(WatchedEvent event) {
                System.out.println("receive event："+event);
            }
        };

        String value = null;
        try {
            final ZooKeeper zookeeper = new ZooKeeper("47.98.132.196:2181", 999999, watcher);
            final byte[] data = zookeeper.getData("/node_1", watcher, null);
            value = new String(data);
            zookeeper.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return "获取 node_1 节点值为 [" + value + "]";
    }
}