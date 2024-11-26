package com.teamtreehouse.courses;


import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {

        get("/", (req, res) -> {
                return new ModelAndView(null, "index.hbs");
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
