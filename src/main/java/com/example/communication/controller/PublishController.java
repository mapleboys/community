package com.example.communication.controller;

import com.example.communication.dao.QuestionDao;
import com.example.communication.dao.UserDao;
import com.example.communication.model.Question;
import com.example.communication.model.User;
import com.example.communication.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model) {
        System.out.println("调用pulish的post请求");
        SqlSession sqlSession = MybatisUtils.getSqlseesion();
        QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);


        Cookie[] cookies = request.getCookies();
        User user = null;
        // 判断是否存在token，存在则直接返回用户信息，否则进入登录界面
        System.out.println("开始判断是否存在token");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("token") ){
                    String token = cookie.getValue();
                    UserDao userdao = sqlSession.getMapper(UserDao.class);
                    user = userdao.queryUserByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                }
            }
        }
        // 返回错误信息
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        System.out.println("开始插入数据");
        // 插入question数据
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());

        questionDao.insertQuestion(question);
        sqlSession.commit();

        return "redirect:/";
    }
}
