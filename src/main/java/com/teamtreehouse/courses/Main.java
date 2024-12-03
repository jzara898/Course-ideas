package com.teamtreehouse.courses;


import com.teamtreehouse.courses.model.CourseIdea;
import com.teamtreehouse.courses.model.CourseIdeaDAO;
import com.teamtreehouse.courses.model.SimpleCourseIdeaDAO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
staticFileLocation("/public");
        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        before((request, response) ->  {
            if (request.cookie("username") != null) {
                request.attribute("username", request.cookie("username"));

            }
                }


                );

        before("/ideas", ((request, response) -> {
    // TODO: jcz - Send message re: redirect.
    if (request.attribute("username") == null) {
        response.redirect("/");
        halt();
    }
}));
        //*should switch the simpleDAO for database later
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
    get("/ideas", (request, response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("ideas", dao.findAll());
        return new ModelAndView(model, "ideas.hbs");
    }, new HandlebarsTemplateEngine());

    post("/ideas", ((request, response) -> {
        String title = request.queryParams("title");

        CourseIdea courseIdea = new CourseIdea(request.attribute("username"), title);
        dao.add(courseIdea);
        response.redirect("ideas");
        return null;
    }));

//list only exists in memory at this time
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
