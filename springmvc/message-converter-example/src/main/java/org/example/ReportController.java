package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {


    private List<Report> reports = new ArrayList<>();

    @RequestMapping(value = "/reports",
            method = RequestMethod.POST,
            consumes = "text/report")
    @ResponseBody
    public String handleRequest(@RequestBody Report report) {
        report.setId(reports.size() + 1);
        reports.add(report);
        return "report saved: " + report;
    }

    @RequestMapping(
            value = "/reports/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public Report reportById(@PathVariable("id") int reportId) {
        if (reportId > reports.size()) {
            throw new RuntimeException("No found for the id :" + reportId);
        }
        return reports.get(reportId - 1);
    }


    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET)
    public Customer getById(@PathVariable("id") int reportId) {
        return new Customer(1,"gege");
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public Map<String, String> doGet() {
        Map<String, String> map = new HashMap<>();
        map.put("foo", "foo");
        map.put("bar", "bar");
        return map;
    }



}
