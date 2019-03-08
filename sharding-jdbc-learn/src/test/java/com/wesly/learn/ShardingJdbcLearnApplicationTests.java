package com.wesly.learn;

import com.wesly.learn.mapper.ConfigMapper;
import com.wesly.learn.mapper.MessageRecordMapper;
import com.wesly.learn.mapper.OrderMapper;
import com.wesly.learn.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcLearnApplicationTests {

    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private MessageRecordMapper messageRecordMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testInsert() {
        Config config = new Config();
        config.setId(1L);
        config.setValue("test config");
        configMapper.insertSelective(config);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setAppId(0L);
        messageRecord.setPhone(0L);
        messageRecord.setPlatform("platform");
        messageRecord.setCode("code");
        messageRecord.setMessage("message");
        messageRecord.setSerialNum("serialNum");
        messageRecord.setBusinessId("business id");
        messageRecordMapper.insertSelective(messageRecord);

        Order order = new Order();
        order.setAppId(1L);
        order.setPhone(1L);
        orderMapper.insertSelective(order);
    }

    @Test
    public void testDelete() {
        configMapper.deleteByPrimaryKey(1L);

        MessageRecordExample messageRecordExample = new MessageRecordExample();
        messageRecordExample.createCriteria()
                .andAppIdEqualTo(0L)
                .andPhoneEqualTo(0L);
        messageRecordMapper.deleteByExample(messageRecordExample);

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria()
                .andAppIdEqualTo(1L)
                .andPhoneEqualTo(1L);
        orderMapper.deleteByExample(orderExample);
    }

    @Test
    public void testSelect() {
        MessageRecordExample messageRecordExample = new MessageRecordExample();
        messageRecordExample.createCriteria()
                .andAppIdEqualTo(0L)
                .andPhoneEqualTo(0L);
        messageRecordMapper.selectByExample(messageRecordExample);

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria()
                .andAppIdEqualTo(1L)
                .andPhoneEqualTo(1L);
        orderMapper.selectByExample(orderExample);
    }

}
