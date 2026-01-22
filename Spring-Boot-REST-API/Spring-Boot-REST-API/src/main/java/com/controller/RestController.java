package com.controller;
import com.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private BusinessLogic serivice;

    @GetMapping("/welcome")
    public String welcomeMessage(){
        return serivice.getWelcomeMessage();
    }

    @GetMapping("/add")
    public String add(@RequestParam("a") int a, @RequestParam int b,@RequestParam("c") int c){
        return serivice.add(a,b,c);
    }

    @GetMapping("/evenodd/{a}")
    public String evenodd(@PathVariable int a){
        return serivice.getEvenOdd(a);
    }

    @GetMapping("/age/{a}")
    public String age(@PathVariable int a){
        return serivice.getAgg(a);
    }
    @GetMapping("/grade/{a}")
    public String grade(@PathVariable int a) {
        return serivice.getGrade(a);
    }
    @GetMapping("/ctof/{a}")
    public String celsiusToFahrenheit(@PathVariable double a) {
        return serivice.celsiusToFahrenheit(a);
    }


    @GetMapping("/max")
    public String max(@RequestParam("a") int a, @RequestParam int b,@RequestParam("c") int c){
        return serivice.max(a,b,c);
    }
    @GetMapping("/reverse/{a}")
    public String reverse(@PathVariable String a) {
        return serivice.reverse(a);
    }
    @GetMapping("/palindrome/{a}" )
    public String palindrome(@PathVariable String a) {
        return serivice.palindrome(a);
    }
    @GetMapping("/factorial/{a}")
    public long factorial(@PathVariable int a) {
        return serivice.factorial(a);
    }
    @GetMapping("/prime/{a}")
    public String prime(@PathVariable long a) {
        return serivice.prime(a);
    }
    @GetMapping("/discount/{price}/{discount}" )
    public long discount(@PathVariable double price, @PathVariable double discount) {
        return serivice.discount(price, discount);
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        return serivice.login(username, password);
    }
    @GetMapping("/sip/{p}/{r}/{t}")
    public int sip(@PathVariable int p, @PathVariable int r, @PathVariable int t){
        return serivice.sip(p,r,t);
    }
    @PostMapping("/word")
    public int word(@RequestParam String word){
        return serivice.word(word);
    }
}
