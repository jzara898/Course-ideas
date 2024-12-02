package com.teamtreehouse.courses;


import com.teamtreehouse.courses.model.CourseIdeaDAO;
import com.teamtreehouse.courses.model.SimpleCourseIdeaDAO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {

        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        //could switch the simpleDAO for database later
        //simple DAO is for prototyping only -- not to be run live
        //will not survive a server restart.  must switch out for database version

        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
                return new ModelAndView(model, "index.hbs");
    }, new HandlebarsTemplateEngine());
        post("/sign-in", (request, response) ->
        { Map<String, String> model = new HashMap<>();
            String username = request.queryParams("username");
            response.cookie("username", username);
            model.put("username", username);
            return new ModelAndView(model,"sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
/* lambda (functional interface for route object) takes 2 parameters:
its passed request and response.  And returns Hello World.
 */
/* (assumed port is 80, or we can specify the port here:
http://localhost:4567/hello */

/* after adding the 2nd function, re-run the web app but with a slash only
after the host instead of "hello".  Server is constantly running, waiting for requests.
 */
