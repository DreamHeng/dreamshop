package com.dreamshop.config;

import com.dreamshop.service.OrderService;
import com.dreamshop.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * function:定时任务配置
 *
 * @author DreamHeng
 * @date 2020/2/10
 */
@Component
public class OrderJob {
    @Autowired
    private OrderService orderService;
// TODO 该种定时方式存在弊端，待整改
    @Scheduled(cron = "0/3 * * * * ?")
    public void autoCloseOrder(){
        orderService.closeOrder();
        System.out.println("执行定时任务，当前时间为："
                + DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
