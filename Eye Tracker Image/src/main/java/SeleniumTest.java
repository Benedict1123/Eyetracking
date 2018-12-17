import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SeleniumTest {

    static int color_index = 0;
    static List<String> color_list = new ArrayList<String>();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chenz\\IdeaProjects\\Eye Tracker Image\\res\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        ChromeDriver driver = new ChromeDriver(options);
        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;
        color_list.add("red");
        color_list.add("SandyBrown");
        color_list.add("Yellow");
        color_list.add("SpringGreen");
        color_list.add("RoyalBlue");
        color_list.add("Plum");
        color_list.add("Orchid");
        //Maximize the window
//        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.get("https://home.bt.com/"); //target URL
//        driver.get("http://localhost/btPage/"); //target URL
        List<WebElement> tag_list = driver.findElements(By.tagName("h1"));
        WebElement target_text = tag_list.get(2);  //get a certain Web Element
        js.executeScript("arguments[0].setAttribute('style', 'border:5px solid red')",target_text);
        String target_text_str = target_text.getText();
//        String target_css = target_text.getCssValue("border");
        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('cookie-ui__cookieUI___3fxp1')[0].style.display = 'none'");
//        ((JavascriptExecutor)driver).executeScript("document.body.innerHTML += (\"<span style = 'height:25px;width:25px;background-color:#bbb;border-radius:50%;display:inline-block;position:absolute;left:0px;top:0px;text-align:center'>A</span>\")");
        /**
        new_content = document.createElement('span');
        new_content.style = "height:25px;width:25px;background-color:#bbb;border-radius:50%;display:inline-block;position:absolute;left:0px;top:0px"
        document.body.append(new_content)
       */
//        ((JavascriptExecutor)driver).executeScript("document.getElementsByTagName('h1')[0].style.border = '5px solid red'");
// document.getElementsByTagName('h1')[0].style.border = "5px solid red"
        //添加点，添加在原来页面位置上
//        document.body.innerHTML += ("<span style = 'height:25px;width:25px;background-color:#bbb;border-radius:50%;display:inline-block;position:absolute;left:0px;top:0px'></span>")
        //With WebDriver Method
        //get a list of elements by Class Name
//        List<WebElement> a = driver.findElements(By.className("HomepageHero-4e260ad0868664f6"));
        //Get location of an element (@deprecated)
//        Point pt = a.getLocation();
//        System.out.println(pt.getX());
//        System.out.println(pt.getY());
        int index_number = 0;
//        for (WebElement each_one: a){
            index_number++;
//            System.out.println(each_one.getRect().x + " " + each_one.getRect().y);
//            System.out.println(each_one.getRect().width);
//            System.out.println(each_one.getRect().height);
//            System.out.println("\n");
//            RectBlock target_block = new RectBlock(
//                    each_one.getRect().width,
//                    each_one.getRect().height,
//                    each_one.getRect().x,
//                    each_one.getRect().y,
//                    String.valueOf(index_number)
//                    );
//            System.out.println(target_block);
//        }
        System.out.println("Target Area: " + target_text_str);
        System.out.println( "target textarea top left corner: \n" + "x: " + target_text.getRect().x + "\ny: " + target_text.getRect().y);
            System.out.println("target textarea width: " + target_text.getRect().width);
            System.out.println("target textarea height: " +target_text.getRect().height);
            System.out.println("\n");
            RectBlock target_block = new RectBlock(
                    target_text.getRect().width,
                    target_text.getRect().height,
                    target_text.getRect().x,
                    target_text.getRect().y,
                    String.valueOf(index_number)
                    );
        System.out.println("Current Page tile is： "+ driver.getTitle());

        // points A (760,300)  B(820,330)  C(1300,280)
        if(target_block.isInside(760,300)){
            System.out.println("Point 1 (760,300) is in the area");
        }else {
            System.out.println("Point 1 (760,300) is not in the area");
        }
        if(target_block.isInside(820,330)){
            System.out.println("Point 2 (820,330) is in the area");
        }else {
            System.out.println("Point 2 (820,330) is not in the area");
        }
        if(target_block.isInside(1300,280)){
            System.out.println("Point 3 (1300,280) is in the area");
        }else {
            System.out.println("Point 3 (1300,280) is not in the area");
        }
        if(target_block.isInside(220,300)){
            System.out.println("Point 4 (220,300) is in the area");
        }else {
            System.out.println("Point 4 (220,300) is not in the area");
        }
        Thread.sleep(3000);
        //Put Point A (red,1,760,300)
        ((JavascriptExecutor)driver).executeScript(combine_js(1,760,300));
//        ((JavascriptExecutor)driver).executeScript("var new_content = document.createElement('span');" +
//                "new_content.style = \"height:25px;width:25px;background-color:red;border-radius:50%;display:inline-block;position:absolute;left:760px;top:300px;text-align:center\";" +
//                "new_content.innerHTML = \"A\";" +
//                "document.body.appendChild(new_content)");
        Thread.sleep(3000);
        //Put Point B (yellow,2,820,330)
        ((JavascriptExecutor)driver).executeScript(combine_js(2,820,330));
//        ((JavascriptExecutor)driver).executeScript("var new_content = document.createElement('span');" +
//                "new_content.style = \"height:25px;width:25px;background-color:yellow;border-radius:50%;display:inline-block;position:absolute;left:820px;top:330px;text-align:center\";" +
//                "new_content.innerHTML = \"B\";" +
//                "document.body.appendChild(new_content)");

        Thread.sleep(3000);
        //Put Point C (green,3,1300,280)
        ((JavascriptExecutor)driver).executeScript(combine_js(3,1300,280));
//        ((JavascriptExecutor)driver).executeScript("var new_content = document.createElement('span');" +
//                "new_content.style = \"height:25px;width:25px;background-color:green;border-radius:50%;display:inline-block;position:absolute;left:1300px;top:280px;text-align:center\";" +
//                "new_content.innerHTML = \"C\";" +
//                "document.body.appendChild(new_content)");

        Thread.sleep(3000);
        //Put Point D  (blue,4,220,300)
        ((JavascriptExecutor)driver).executeScript(combine_js(4,220,300));
//        ((JavascriptExecutor)driver).executeScript("var new_content = document.createElement('span');" +
//                "new_content.style = \"height:25px;width:25px;background-color:blue;border-radius:50%;display:inline-block;position:absolute;left:220px;top:300px;text-align:center\";" +
//                "new_content.innerHTML = \"D\";" +
//                "document.body.appendChild(new_content)");
//        driver.quit();
    }

     static String combine_js(int number, int x_value, int y_value){
        StringBuffer exe_js = new StringBuffer("var new_content = document.createElement('span');");
        exe_js.append("new_content.style = \"height:25px;width:25px;background-color:" +
                getColorName() +
                ";border-radius:50%;display:inline-block;position:absolute;left:" +
                x_value +
                "px;top:" +
                y_value +
                "px;text-align:center\";")
                .append("new_content.innerHTML = \"" +
                        number +
                        "\";")
                .append("document.body.appendChild(new_content)");
        return String.valueOf(exe_js);
    }

    private static String getColorName() {
        String current_colour = color_list.get(color_index);
        color_index++;
        if (color_index == 7) {
            color_index = 0;
        }
        return current_colour;
    }
}
