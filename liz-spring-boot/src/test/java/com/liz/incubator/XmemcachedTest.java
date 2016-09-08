package com.liz.incubator;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lizhou on 2016/9/8.
 */
public class XmemcachedTest {

    private MemcachedClient memcachedClient;

    @Before
    public void setup() {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder( AddrUtil.getAddresses("localhost:11211") );
        try {
            memcachedClient = builder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testString() {
        if( null == memcachedClient){
            System.out.println("memcachedClient实例获取失败!");
        }
        for(int i = 1 ;i <= 100000; i++){
            try {
                memcachedClient.set("hello", 0, "Hello,xmemcached");
                String value = memcachedClient.get("hello");
                System.out.println("hello=" + value);

                memcachedClient.delete("hello");
                value = memcachedClient.get("hello");
                System.out.println("hello=" + value);

            } catch (MemcachedException e) {
                System.err.println("MemcachedClient operation fail");
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.err.println("MemcachedClient operation timeout");
                e.printStackTrace();
            } catch (InterruptedException e) {
                // ignore
            }
        }
        try {
            //close memcached client
            memcachedClient.shutdown();
        } catch (IOException e) {
            System.err.println("Shutdown MemcachedClient fail");
            e.printStackTrace();
        }
    }
}
