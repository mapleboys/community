package com.example.communication.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class TagWeightDto implements Comparable{
    private String tagName;
    private Integer tagScore;

    @Override
    public int compareTo(@NotNull Object o) {
        return this.getTagScore() - ((TagWeightDto)o).getTagScore();
    }
}
