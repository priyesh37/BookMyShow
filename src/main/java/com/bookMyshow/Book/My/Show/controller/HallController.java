package com.bookMyshow.Book.My.Show.controller;

import com.bookMyshow.Book.My.Show.Exception.ResourceNotExistException;
import com.bookMyshow.Book.My.Show.Exception.UnAuthorized;
import com.bookMyshow.Book.My.Show.dto.request.AddScreenDTO;
import com.bookMyshow.Book.My.Show.dto.request.HallOwnerSignUpDTO;
import com.bookMyshow.Book.My.Show.dto.request.MovieOwnerSignUpDTO;
import com.bookMyshow.Book.My.Show.dto.response.GeneralMessageDTO;
import com.bookMyshow.Book.My.Show.models.ApplicationUser;
import com.bookMyshow.Book.My.Show.service.HallService;
import com.bookMyshow.Book.My.Show.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookMyshow.Book.My.Show.Exception.userNotFoundException;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    HallService hallService;
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody HallOwnerSignUpDTO hallOwnerSignUpDTO){

        ApplicationUser user = hallService.signUp(hallOwnerSignUpDTO);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @PostMapping("/addScreen")
    public ResponseEntity addScreen(@RequestBody AddScreenDTO addScreenDTO , @RequestParam String email){
        try{
            hallService.addScreens(addScreenDTO,email);
        }
        catch (userNotFoundException e){
                return new ResponseEntity(new GeneralMessageDTO(e.getMessage()), HttpStatus.NOT_FOUND); //404
        }
        catch (UnAuthorized e){
            return  new ResponseEntity(new GeneralMessageDTO(e.getMessage()) , HttpStatus.UNAUTHORIZED);//401
        }
        catch (ResourceNotExistException e){
            return new ResponseEntity(new GeneralMessageDTO(e.getMessage()) , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new GeneralMessageDTO("Screens added Successfully") ,HttpStatus.CREATED);//201
    }
}
