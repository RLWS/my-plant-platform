package com.rlws.plant.web.api.controller;

import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.domain.Category;
import com.rlws.plant.domain.Question;
import com.rlws.plant.domain.User;
import com.rlws.plant.web.api.service.CategoryService;
import com.rlws.plant.web.api.service.QuestionService;
import com.rlws.plant.web.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "${web.rest.url}")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    //注册用户提交信息判断用户邮箱是否已经注册ajax
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public BaseResult selectByPrimaryKey(String email) {
        System.out.println(email);
        User user1 = userService.selectByPrimaryKey(email);
        if (user1 != null){
            return BaseResult.success(user1);
        }
        return BaseResult.fail();
    }

    //默认进入的页面
    @RequestMapping(value = "",method = RequestMethod.GET)
    public BaseResult main() {
        return BaseResult.success("API服务器启动成功");
    }

    //httpClientUtils测试
    @RequestMapping(value = "rlws",method = RequestMethod.POST)
    public BaseResult myTest(String email){
        System.out.println("来了老铁!");
        User user1 = userService.selectByPrimaryKey(email);
        if (user1 != null){
            return BaseResult.success("POST请求获取成功啦,哇咔咔",user1);
        }
        return BaseResult.fail();
    }

    //首页初始化问题列表
    @RequestMapping(value = {"index", ""}, method = RequestMethod.GET)
    public BaseResult index(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        //定义全局作用域的申请值
        ServletContext application = request.getSession().getServletContext();
        if (application.getAttribute("BestAnswerCount") == null)
            application.setAttribute("BestAnswerCount", 99);
        List<Question> questionDetails = questionService.selectNewTitle(6);
        List<Question> questions = questionService.selectOneWeekLimitTitle(6);
        List<Category> categories = categoryService.selectAllCategory(null);
        //30tian
        List<Question> questionsUrgent = questionService.selectUrgentQuestion(90);
        map.put("questionsUrgent", questionsUrgent);
        map.put("categories", categories);
        map.put("questionDetails", questionDetails);
        map.put("questions", questions);
        System.out.println("test:::"+questionDetails);
        return BaseResult.success("POST请求获取成功啦,哇咔咔",map);
    }

}
