package com.example.communication.cache;

import com.example.communication.dto.TagWeightDto;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

@Slf4j
public class TopNTagCache {
    public static List<String> topNTags;
    public static void update(HashMap tagWeightMap) {
        ArrayList<String> tags = new ArrayList<>();
        Integer max = 3;
        PriorityQueue<TagWeightDto> tagWeightDtos = new PriorityQueue<>(max);
        tagWeightMap.forEach((tag, score)->{
            TagWeightDto tagWeightDto = new TagWeightDto();
            tagWeightDto.setTagName((String) tag);
            tagWeightDto.setTagScore((Integer) score);
            if (tagWeightDtos.size() <= max) {
                tagWeightDtos.add(tagWeightDto);
            } else {
                TagWeightDto minHot = tagWeightDtos.peek();
                if(minHot.compareTo(tagWeightDto) < 0) {
                    tagWeightDtos.poll();
                    tagWeightDtos.add(tagWeightDto);
                }
            }
        });
        log.info("最热队列：" + tagWeightDtos.toString());
        TagWeightDto poll = tagWeightDtos.poll();
        while (poll != null) {
            tags.add(0, poll.getTagName());
            poll = tagWeightDtos.poll();
        }
        topNTags = tags;
        log.info("最热list:" + tags.toString());
    }
}
