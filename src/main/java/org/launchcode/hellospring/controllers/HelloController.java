package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

//    //Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
//
//    //Handles requests of the form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello " + name + "!";
//    }

//    @GetMapping("form")
//    public String helloForm() {
//        String html =
//                "<html>" +
//                        "<body>" +
//                        "<form method = 'post' action = '/hello'>" +
//                        "<input type = 'text' name = 'name' />" +
//                        "<input type = 'submit' value = 'Greet Me!' />" +
//                        "</form>" +
//                        "</body>" +
//                        "</html>";
//        return html;
//    }

    @GetMapping("languageform")
    public String languageForm() {
        String html =
                "<html> " +
                        "<body>" +
                        "<form method = 'get' action = 'hello'>" +
                        "<input type = 'text' name = 'name' />" +
                            "<select name = 'language'>" +
                            "<option value = 'english'>English</option>" +
                            "<option value = 'french'>French</option>" +
                            "<option value = 'italian'>Italian</option>" +
                            "<option value = 'spanish'>Spanish</option>" +
                            "<option value = 'german'>German</option>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    //handle requests of the form /hello/languageform
    @RequestMapping(method = RequestMethod.GET)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "world";
        }
        return createMessage(name,language);
    }

    public static String createMessage(String n, String l){
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + " " + n;
    }




}
