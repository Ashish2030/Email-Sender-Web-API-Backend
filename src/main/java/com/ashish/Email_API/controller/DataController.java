package com.ashish.Email_API.controller;

import com.ashish.Email_API.model.Data;
import com.ashish.Email_API.model.DataResponse;
import com.ashish.Email_API.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DataController
{
    @Autowired
    private DataService dataservice;
    @PostMapping("/data")
    public ResponseEntity<?> sendEmail(@RequestBody Data data)
    {
        boolean result=this.dataservice.emailSender(data.getSubject(),data.getMessage(),data.getTo(),data.getFrom(),data.getPassword());
        if(result)
        {
          return ResponseEntity.ok(new DataResponse("Email is Sent Successfully"));
        }
        else
            {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DataResponse("Email not Sent"));
        }
    }

}
