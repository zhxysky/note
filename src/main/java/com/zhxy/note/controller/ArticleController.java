package com.zhxy.note.controller;

import com.zhxy.note.entities.Article;
import com.zhxy.note.repositories.ArticleRepository;
import org.apache.catalina.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by zhxy on 2016/9/2.
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        modelMap.put("articleList", articleRepository.findAllOrderByIdDesc());
        return "index";
    }


    @RequestMapping("/article/{id}")
    public String article(@PathVariable String id,ModelMap modelMap) {
        Article article = articleRepository.findOne(Long.parseLong(id));
        modelMap.addAttribute("article", article);
        return "article";
    }

    @RequestMapping("/article/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/article/publish")
    public String publish(Article article) throws ParseException, IOException {
        article.setCreateTime(new Date());

        Reader reader = new StringReader(article.getContent());
        Writer writer = new StringWriter();

        Markdown mk = new Markdown();
        mk.transform(reader,writer);
        String htmlContent = writer.toString();

        reader.close();
        writer.close();

        System.out.println();
        article.setHtmlContent(htmlContent);
        article = articleRepository.save(article);
        System.out.println(article.toString());
        return "redirect:/article/"+article.getId();
    }

    @RequestMapping("/article/modify/{id}")
    public String toedit(@PathVariable String id,ModelMap modelMap) {
        Article article = articleRepository.findOne(Long.parseLong(id));
        modelMap.put("article", article);
        return "modify";
    }

    @RequestMapping("/article/update")
    public String update(Article article) throws ParseException, IOException {
        Reader reader = new StringReader(article.getContent());
        Writer writer = new StringWriter();

        Markdown mk = new Markdown();
        mk.transform(reader,writer);
        String htmlContent = writer.toString();

        reader.close();
        writer.close();

        System.out.println();
        article.setHtmlContent(htmlContent);
        article.setCreateTime(articleRepository.findOne(article.getId()).getCreateTime());
        article = articleRepository.save(article);
        System.out.println(article.toString());
        return "redirect:/article/"+article.getId();
    }

    @RequestMapping(value = "/article/search")
    public String search(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
        String keyWord = request.getParameter("keyWord");
        List<Article> list = articleRepository.findByTitleAndContent(keyWord);
        modelMap.put("articleList", list);
        return "index";
    }

}
