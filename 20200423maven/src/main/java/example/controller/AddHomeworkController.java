package example.controller;

import example.dao.Mario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class AddHomeworkController {
    //添加作业
    @RequestMapping(value="/addHomework")
    public ModelAndView addHomework(@RequestParam("homeworkTitle") String homeworkTitle,@RequestParam("homeworkContent") String homeworkContent) throws SQLException {

        ApplicationContext app=new ClassPathXmlApplicationContext("bean.xml");
        Mario mario=(Mario)app.getBean("mario");
        //Mario mario=new Mario();
        String sql="insert into homework values(null,'"+homeworkTitle+"','"+homeworkContent+"')";//定义查询语句
        int i=mario.executeUpdate(sql);//执行sql语句
        mario.closeConnection();

        ModelAndView model = new ModelAndView("addHomeworkSuccess");
        return model;

    }
}
