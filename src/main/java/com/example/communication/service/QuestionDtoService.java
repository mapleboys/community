package com.example.communication.service;

import com.example.communication.dao.QuestionDao;
import com.example.communication.dao.UserDao;
import com.example.communication.dto.QuestionDto;
import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.model.Question;
import com.example.communication.model.User;
import com.example.communication.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDtoService {
    public List<QuestionDto> list(Integer currentPage, Integer offset) {
        QuestionQueryDto questionQueryDto = new QuestionQueryDto();
        SqlSession sqlSession = MybatisUtils.getSqlseesion();
        QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        questionQueryDto.setOffset(offset);
        questionQueryDto.setRows((currentPage - 1)*offset);
        System.out.println(questionQueryDto);
        List<Question> questions = questionDao.queryQuestionByPage(questionQueryDto);
        ArrayList<QuestionDto> questionDtos = new ArrayList<>();
        for(Question question:questions) {
            Integer creator = question.getCreator();
            User user = userDao.queryUserById(creator);
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }
}
