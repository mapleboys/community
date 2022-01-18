package com.example.communication.service;

import com.example.communication.dto.PaginationDto;
import com.example.communication.dto.QuestionDto;
import com.example.communication.dto.QuestionQueryByIdDto;
import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.exception.CustomizeErrorCode;
import com.example.communication.exception.CustomizeErrorException;
import com.example.communication.mapper.QuestionMapper;
import com.example.communication.mapper.UserMapper;
import com.example.communication.model.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDtoService {
    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    UserMapper userMapper;

    public PaginationDto list(Integer currentPage, Integer offset) {
        QuestionQueryDto questionQueryDto = new QuestionQueryDto();
        PaginationDto paginationDto = new PaginationDto();

        //计算总问题数
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andIdIsNotNull();
        int size = questionMapper.selectByExample(questionExample).size();
        Integer totalPage;
        if(size%offset == 0) {
            totalPage = size/offset;
        }else {
            totalPage = (size/offset + 1);
        }
        if(currentPage < 1) {
            currentPage = 1;
        }
        if(currentPage >= totalPage){
            currentPage = totalPage;
        }
        // 查询问题列表
        List<Question> questions = questionMapper.
                selectByExampleWithRowbounds(null,
                        new RowBounds((currentPage - 1)*offset, offset));
        ArrayList<QuestionDto> questionDtos = new ArrayList<>();
        for(Question question:questions) {
            Long creator = question.getCreator();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(creator);
            List<User> users1 = userMapper.selectByExample(userExample);
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(users1.get(0));
            questionDtos.add(questionDto);
        }
        paginationDto.setQuestionList(questionDtos);

        paginationDto.setPagination(size, currentPage, offset);
        return paginationDto;
    }

    public PaginationDto list(Long id, Integer currentPage, Integer offset) {
        PaginationDto paginationDto = new PaginationDto();

        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(id);
        int size = questionMapper.selectByExample(questionExample).size();

        Integer totalPage;
        if(size%offset == 0) {
            totalPage = size/offset;
        }else {
            totalPage = (size/offset + 1);
        }
        if(currentPage < 1) {
            currentPage = 1;
        }
        if(totalPage != 0 && currentPage >= totalPage){
            currentPage = totalPage;
        }
        // 查询问题列表
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(questionExample,
                new RowBounds((currentPage - 1)*offset, offset));
        ArrayList<QuestionDto> questionDtos = new ArrayList<>();
        for(Question question:questions) {
            User user = userMapper.selectByPrimaryKey(id);
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        paginationDto.setQuestionList(questionDtos);
        paginationDto.setPagination(size, currentPage, offset);
        return paginationDto;
    }

    public QuestionDto selectById(Long id) {
        QuestionDto questionDto = new QuestionDto();
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question != null) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setUser(user);
        }
        return questionDto;
    }

    public void createOrUpdate(Question question) {
        QuestionDto questionDto = selectById(question.getId());
        if (questionDto == null || questionDto.getId() == null) {
            // 表中不存在此数据，创建
            questionMapper.insertSelective(question);
        } else {
            // 表中存在此数据，更新
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.updateByPrimaryKey(question);
        }
    }
}
