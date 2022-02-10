package com.example.communication.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

@Slf4j
@Component
public class TopNTagTask {
    @Scheduled(fixedDelay  = 5000)
    public void topNTagTask() throws InterruptedException {
        log.info("Thread Name : "
                + Thread.currentThread().getName()
                + "  i am a topNTagTask : date ->  "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Thread.sleep(6000);
    }

    /**
     * 下轮任务在本轮任务开始2秒后执行. 执行时间可忽略不计
     */
    @Scheduled(fixedRate = 2000)
    public void task2() {
        log.info("Thread Name : "
                + Thread.currentThread().getName()
                + "  i am a task2 : date ->  "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public static void main(String[] args) {
        new PriorityQueue<Integer>();
    }
}
