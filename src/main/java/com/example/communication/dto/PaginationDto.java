package com.example.communication.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDto {
    private List<QuestionDto> questionList; //问题列表
    private boolean showPreviousPage;   // 前一页
    private boolean showNextPage;   //后一页
    private boolean showEndPage;    // 最后一页
    private boolean showFirstPage;  //第一页
    private List<Integer> pageList; //显示的所有页码
    private Integer currentPage;    //当前页码
    private Integer totalPage;

    public void setPagination(Integer size, Integer currentPage, Integer offset) {

        // 总页数
        Integer totalPage;
        if(size != 0 && size%offset == 0) {
            totalPage = size/offset;
        }else {
            totalPage = size/offset + 1;
        }
        this.setTotalPage(totalPage);

        this.setCurrentPage(currentPage);

        // 页面展示的页码列表
        ArrayList<Integer> integers = new ArrayList<>();
        // 没有数据的情况
        if (size == 0) {
            integers.add(1);
            this.setPageList(integers);
            this.setCurrentPage(1);
            this.setShowEndPage(false);
            this.setShowFirstPage(false);
            this.setShowNextPage(false);
            this.setShowPreviousPage(false);
            return;
        }
        integers.add(currentPage);
        for(int i = 1; i < 3; i++) {
            if (currentPage - i > 0) {
                integers.add(0, currentPage - i);
            }
            if (currentPage + i <= totalPage) {
                integers.add(currentPage + i);
            }
        }
        this.setPageList(integers);
        // 判断是否显示前一页
        if(currentPage == 1 || size == 0) {
            this.setShowPreviousPage(false);
        } else {
            this.setShowPreviousPage(true);
        }
        // 判断是否显示后一页
        if(currentPage == totalPage) {
            this.setShowNextPage(false);
        } else {
            this.setShowNextPage(true);
        }
        // 判断是否显示跳转第一页
        if (this.pageList.contains(1) || size == 0) {
            this.setShowFirstPage(false);
        } else {
            this.setShowFirstPage(true);
        }
        // 判断是否显示跳转最后一页
        if (this.pageList.contains(totalPage)) {
            this.setShowEndPage(false);
        } else {
            this.setShowEndPage(true);
        }
    }
}
