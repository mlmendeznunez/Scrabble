import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Scrabble {
  public static void main(String[] args) {
    String layout = "templates/scrabblePage.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
     // String theWord = request.queryParams("theWord");
     // int thatScore = isScrabble(firstSWord);


      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/scorePage", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           model.put("template", "templates/scorePage.vtl");
           String theWord = request.queryParams("theWord");
           int score = isScrabble(theWord);

           model.put("score", score);
           return new ModelAndView(model, layout);

    }, new VelocityTemplateEngine());

    //get("/detector", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/detector.vtl");
    //
    //   String year = request.queryParams("year");
    //   Integer integerYear = Integer.parseInt(year);
    //   Boolean isLeapYear = isLeapYear(integerYear);
    //
    //   model.put("isLeapYear", isLeapYear);
    //   model.put("year", request.queryParams("year"));
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }

  // public static Boolean isLeapYear(Integer year) {
  //   if ( year % 400 == 0 ) {
  //     return true;
  //   } else if ( year % 100 == 0 ) {
  //     return false;
  //   } else {
  //     return year % 4 == 0;
  //   }
  // }
  public static int isScrabble(String theWord) {
          //int lengthOfWord = theWord.length;

          //Integer theScore =  0;
          String[] firstSWord = theWord.split("");

          String onePoint = "aeioulnearst";
          String twoPoint = "dg";
          String threePoint = "bcmp";
          String fourPoint = "fhvwy";
          String fivePoint = "k";
          String eightPoint = "jx";
          String tenPoint = "qz";

          int theScore = 0;
          for (String letter:firstSWord){
              if (onePoint.contains(letter)){
                  theScore += 1;
              }
              else if (twoPoint.contains(letter)) {
                  theScore += 2;
              }
              else if (threePoint.contains(letter)) {
                  theScore += 3;
              }
              else if (fourPoint.contains(letter)) {
                  theScore +=4;
              }
              else if (fivePoint.contains(letter)) {
                  theScore += 5;
              }
              else if (eightPoint.contains(letter)) {
                  theScore += 8;
              }
              else {
                  theScore += 10;
              }

          }
          return theScore;
      }

}


///////OLD
// public class  Scrabble {
//     public static void main(String[] args) {
//         String firstSWord = "Scrabbke";
//         int thatScore = isScrabble(firstSWord);
//     }
//
//     public static int isScrabble(String theWord) {
//         //int lengthOfWord = theWord.length;
//
//         //Integer theScore =  0;
//         String[] firstSWord = theWord.split("");
//
//         String onePoint = "aeioulnearst";
//         String twoPoint = "dg";
//         String threePoint = "bcmp";
//         String fourPoint = "fhvwy";
//         String fivePoint = "k";
//         String eightPoint = "jx";
//         String tenPoint = "qz";
//
//         int theScore = 0;
//         for (String letter:firstSWord){
//             if (onePoint.contains(letter)){
//                 theScore += 1;
//             }
//             else if (twoPoint.contains(letter)) {
//                 theScore += 2;
//             }
//             else if (threePoint.contains(letter)) {
//                 theScore += 3;
//             }
//             else if (fourPoint.contains(letter)) {
//                 theScore +=4;
//             }
//             else if (fivePoint.contains(letter)) {
//                 theScore += 5;
//             }
//             else if (eightPoint.contains(letter)) {
//                 theScore += 8;
//             }
//             else {
//                 theScore += 10;
//             }
//
//         }
//         return theScore;
//     }
// }
