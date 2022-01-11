package com.example.communication.service;

import com.example.communication.dao.QuestionDao;
import com.example.communication.dao.UserDao;
import com.example.communication.dto.PaginationDto;
import com.example.communication.dto.QuestionDto;
import com.example.communication.dto.QuestionQueryByIdDto;
import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.model.Question;
import com.example.communication.model.User;
import com.example.communication.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDtoService {
//    @Autowired
//    QuestionQueryDto questionQueryDto;
    public PaginationDto list(Integer currentPage, Integer offset) {
        QuestionQueryDto questionQueryDto = new QuestionQueryDto();
        PaginationDto paginationDto = new PaginationDto();

        SqlSession sqlSession = MybatisUtils.getSqlseesion();
        QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int size = questionDao.queryQuestionAll().size();
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
        questionQueryDto.setOffset(offset);
        questionQueryDto.setRows((currentPage - 1)*offset);
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
        paginationDto.setQuestionList(questionDtos);
        paginationDto.setPagination(size, currentPage, offset);
        return paginationDto;
    }

    public PaginationDto list(Integer id, Integer currentPage, Integer offset) {
        QuestionQueryDto questionQueryDto = new QuestionQueryDto();
        PaginationDto paginationDto = new PaginationDto();
        QuestionQueryByIdDto questionQueryByIdDto = new QuestionQueryByIdDto();
        questionQueryByIdDto.setCreator(id);
        questionQueryByIdDto.setOffset(offset);
        questionQueryByIdDto.setRows((currentPage - 1)*offset);

        SqlSession sqlSession = MybatisUtils.getSqlseesion();
        QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int size = questionDao.queryQuestionByCreator(id).size();
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
        List<Question> questions = questionDao.queryQuestionByID(questionQueryByIdDto);
        ArrayList<QuestionDto> questionDtos = new ArrayList<>();
        for(Question question:questions) {
            Integer creator = question.getCreator();
            User user = userDao.queryUserById(creator);
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        paginationDto.setQuestionList(questionDtos);
        paginationDto.setPagination(size, currentPage, offset);
        return paginationDto;
    }
}
