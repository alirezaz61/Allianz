package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    CityHallService cityHallService;

    @Autowired
    DistrictService districtService;

    @Autowired
    SensorService sensorService;

    @Autowired
    SensorDataService sensorDataService;

    //String logoutLink = "<div><a href=\"\\logout\">Logout</a></div>";
    String logoutLink = "";

    @RequestMapping(value="/receiver/{id}/{level}/{time}", method = RequestMethod.GET)
    public String sensorREST(Model model,
                             @PathVariable(name="id") long id,
                             @PathVariable(name="level") int level,
                             @PathVariable(name="time") String timeStamp
    ){

        String loggedInUser = GetCurrentUser();
        Sensor sensor = sensorService.Find(id);

        if(!sensor.getUsername().equals(loggedInUser))
            return "Wrong Sensor Authentication";

        String resp = "saved";

        Instant instant = Instant.parse(timeStamp);

        SensorData sensorData = new SensorData(sensor, level, instant);
        resp += "<div>" + sensorData.getLevel() + " - " + sensorData.getReadTimeStamp().toString() + "</div>";
        sensorDataService.Save(sensorData);

        return resp;
    }


    @RequestMapping("/cityhalls")
    public String ShowCityHall(Model model){
        String str = logoutLink;
        List<CityHall> cityHalls = cityHallService.FindAll();
        for (CityHall cityHall: cityHalls             ) {
            if(cityHall.getUsername().equals(GetCurrentUser()))
                str += "<div><a href=\"cityhall\\"+cityHall.getId()+"\">"+cityHall.getName()+"</a></div>";
        }
        return str;
    }

    @RequestMapping("/cityhall/{id}")
    public String ShowCityHall(Model model,
                           @PathVariable(name="id", required = false) long cityhall_id){

        String loggedInUser = GetCurrentUser();
        CityHall cityHall = cityHallService.Find(cityhall_id);

        if(!cityHall.getUsername().equals(loggedInUser))
            return logoutLink+"error return to City Halls List";

        List<District> districts = districtService.Find(cityHall);

        String resp = logoutLink;
        resp += "Districts in " + cityHall.getName();
        for (District district : districts) {
            resp+="<div><a href=\"/district/"+district.getId()+"\">"+district.getName()+"</a></div>";
        }
        return resp;
    }

    @RequestMapping("/district/{id}")
    public String ShowData(Model model,
                           @PathVariable(name="id", required = false) long district_id){

        String loggedInUser = GetCurrentUser();
        District district = districtService.Find(district_id);

        if(!district.getCityHall().getUsername().equals(loggedInUser))
            return logoutLink+"error return to City Halls List";


        List<SensorData> data = sensorDataService.Find(district.getSensor());

        String resp = logoutLink;
        resp += "CO2 Sensors Data : " +district.getName()+" in "+district.getCityHall().getName();

        for (SensorData sd:data) {
            resp+="<div>"+sd.getId()+" - "+sd.getLevel()+" - "+sd.getReadTimeStamp().toString()+"</div>";
        }

        return resp;
    }

    public String GetCurrentUser()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Object principal = auth.getPrincipal();
        String username = "";
        if (principal instanceof UserDetails)
            username = ((UserDetails)principal).getUsername();
        else
            username = principal.toString();

        return username;
    }




}
