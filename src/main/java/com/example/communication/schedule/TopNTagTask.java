package com.example.communication.schedule;

import com.example.communication.cache.TopNTagCache;
import com.example.communication.mapper.QuestionMapper;
import com.example.communication.model.Question;
import com.example.communication.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Slf4j
@Component
public class TopNTagTask {
    @Autowired
    QuestionMapper questionMapper;

    @Scheduled(fixedRate  = 1000*60*60*60)
    public void topNTagTask() throws InterruptedException {
        log.info("开始执行topN话题计算任务，Thread Name : "
                + Thread.currentThread().getName()
                + "  i am a topNTagTask : date ->  "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Integer limit = 20;
        Integer offset = 0;

        List<Question> list = new ArrayList<>();
        HashMap tagWeightMap = new HashMap<String, Integer>();
        while (offset == 0 || list.size() == limit) {
            // 为了防止将所有问题加载到内存中，按照分页来处理问题
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {
                String[] tags = question.getTag().split(",");
                for (String tag : tags) {
                    Integer weight = 0;
                    Object o = tagWeightMap.get(tag);
                    if (o != null) {
                        weight = (Integer) o;
                    }
                    Integer commentAccount = question.getCommentAccount();
                    Integer viewAccount = question.getViewAccount();
                    tagWeightMap.put(tag, weight + commentAccount*5 + viewAccount);
                }
            }

            offset += limit;
        }
        // 排序，并将最热话题存储在缓存中
        TopNTagCache.update(tagWeightMap);
    }
//
//    /**
//     * 下轮任务在本轮任务开始2秒后执行. 执行时间可忽略不计
//     */
//    @Scheduled(fixedRate = 2000)
//    public void task2() {
//        log.info("Thread Name : "
//                + Thread.currentThread().getName()
//                + "  i am a task2 : date ->  "
//                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//    }
//
}
