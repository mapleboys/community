package com.example.communication.dto;

import java.util.List;

public class PaginationDto {
    private List<QuestionDto> questionList;
    private boolean showPreviousPage;   // 前一页
    private boolean showNextPage;   //后一页
    private boolean showEndPage;    // 最后一页
    private boolean showFirstPage;  //第一页
    private List<String> pageList; //显示的所有页码
    private Integer currentPage;    //当前页码
}
