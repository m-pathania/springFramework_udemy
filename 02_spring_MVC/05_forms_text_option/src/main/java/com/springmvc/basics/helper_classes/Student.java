package com.springmvc.basics.helper_classes;

import java.util.LinkedHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String state;
    private LinkedHashMap<String, LinkedHashMap<String, String>> stateData;

    public Student(){
        stateData = new LinkedHashMap<>();
        stateData.put("IN", new LinkedHashMap<>());
        stateData.get("IN").put("A", "a");
        stateData.get("IN").put("B", "b");
        stateData.get("IN").put("C", "c");
        stateData.get("IN").put("D", "d");
        stateData.put("US", new LinkedHashMap<>());
        stateData.get("US").put("A", "e");
        stateData.get("US").put("B", "f");
        stateData.get("US").put("C", "g");
        stateData.get("US").put("D", "h");
        stateData.put("Germany", new LinkedHashMap<>());
        stateData.get("Germany").put("A", "i");
        stateData.get("Germany").put("B", "j");
        stateData.get("Germany").put("C", "k");
        stateData.get("Germany").put("D", "l");
        stateData.put("Japan", new LinkedHashMap<>());
        stateData.get("Japan").put("A", "m");
        stateData.get("Japan").put("B", "n");
        stateData.get("Japan").put("C", "o");
        stateData.get("Japan").put("D", "p");
        this.country = "Japan";
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getCountry(){
        return this.country;
    }
    public String getState(){
        return this.state;
    }
    public LinkedHashMap<String, String> getStateData(){
        // do not work because cannot know which option is selected unless submitted
        return stateData.get(this.country);
    }
}
