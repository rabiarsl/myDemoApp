package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean arrayOperation(ArrayList<Integer> first,char operator,ArrayList<Integer> second,ArrayList<Integer> result) {
      if (first==null || second==null || result==null)
        return false;
      if (operator!='+' && operator!='-' && operator!='*' && operator!='/')
        return false;
      if (first.size()!=second.size() || first.size()!=result.size())
        return false;
      for (int i=0;i<first.size();i++){
        if (operator=='+'){
          if (first.get(i)+second.get(i)!=result.get(i))
            return false;
        }
        else if (operator=='-'){
          if (first.get(i)-second.get(i)!=result.get(i))
            return false;
        }
        else if (operator=='*'){
          if (first.get(i)*second.get(i)!=result.get(i))
            return false;
        }
        else if (operator=='/'){
          if (second.get(i)==0)
            return false;
          if (first.get(i)/second.get(i)!=result.get(i))
            return false;
        }
      }
      return true;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
          String input1 = req.queryParams("input1");  
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> first = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            first.add(value);
          }
          
          String input2 = req.queryParams("input2").replaceAll("\\s","");
          char operator = input2.charAt(0);

          String input3 = req.queryParams("input3");  
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> second = new java.util.ArrayList<>();
          while (sc3.hasNext())
          {
            int value = Integer.parseInt(sc3.next().replaceAll("\\s",""));
            second.add(value);
          }

          String input4 = req.queryParams("input4");  
          java.util.Scanner sc4 = new java.util.Scanner(input4);
          sc4.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> third = new java.util.ArrayList<>();
          while (sc4.hasNext())
          {
            int value = Integer.parseInt(sc4.next().replaceAll("\\s",""));
            third.add(value);
          }

          boolean result = App.arrayOperation(first,operator,second,third);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
