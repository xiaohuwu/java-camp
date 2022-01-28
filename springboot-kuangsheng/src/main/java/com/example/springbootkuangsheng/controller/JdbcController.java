package com.example.springbootkuangsheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

  @Autowired
  JdbcTemplate jdbcTemplate;

    @RequestMapping("/insert")
    public int insert(){
      return jdbcTemplate.update(
              "INSERT INTO tb_user VALUES (?, ?, ?)", 4, "Bill", "Gates");
    }

  @RequestMapping("/deleteById/{id}")
  public int deleteById(@PathVariable String id){
    return jdbcTemplate.update(
            "delete  from tb_user where id = ?", id);
  }

  @GetMapping("/list")
  public List<Map<String, Object>> userList(){
    String sql = "select * from tb_user";
    List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
    return maps;
  }


  @RequestMapping("/update")
  public int update(){
    return jdbcTemplate.update(
            "update tb_user set name = ? where id = ?",  "Gates1234",1);
  }


}
