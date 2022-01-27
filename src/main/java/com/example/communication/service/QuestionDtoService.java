package com.example.communication.service;

import com.example.communication.dto.PaginationDto;
import com.example.communication.dto.QuestionDto;
import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.dto.TagDto;
import com.example.communication.mapper.QuestionExtMapper;
import com.example.communication.mapper.QuestionMapper;
import com.example.communication.mapper.UserMapper;
import com.example.communication.model.Question;
import com.example.communication.model.QuestionExample;
import com.example.communication.model.User;
import com.example.communication.model.UserExample;
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
    QuestionExtMapper questionExtMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDto list(Integer currentPage, Integer limit, String search) {
        QuestionQueryDto questionQueryDto = new QuestionQueryDto();
        PaginationDto paginationDto = new PaginationDto();
        // 处理字符串
        String regexpSearch = regexpStr(search);
        //计算总问题数
        questionQueryDto.setSearch(regexpSearch);
        int size = questionExtMapper.countBySearch(questionQueryDto);

        Integer totalPage;
        if(size%limit == 0) {
            totalPage = size/limit;
        }else {
            totalPage = (size/limit + 1);
        }
        if(currentPage < 1) {
            currentPage = 1;
        }
        if(currentPage >= totalPage){
            currentPage = totalPage;
        }
        // 查询问题列表
        questionQueryDto.setOffset((currentPage - 1)*limit);
        questionQueryDto.setLimit(limit);
        List<Question> questions = questionExtMapper.queryBySearch(questionQueryDto);
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

        paginationDto.setPagination(size, currentPage, limit);
        return paginationDto;
    }

    // 字符串用竖线分割
    private String regexpStr(String search) {
        String a1 = "";
        String a2 = null;
        if (search != null) {
            for(String a:search.split("\\s+")){
                a1 = a1 + a + "|";
            }
            if (a1.substring(a1.length() - 1).equals("|")) {
                a2 = a1.substring(0,a1.length()-1);
            }
        }
        return a2;
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

    // 查询相关问题
    public List<Question> queryRelativeQuestion(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        String tag = question.getTag();
        ArrayList<QuestionDto> questionDtos = new ArrayList<>();
        String tagAfter = tag.replace(',', '|');
        question.setTag(tagAfter);
        List<Question> questions = questionExtMapper.queryRelativeQuestion(question);
        return questions;
    }
}
