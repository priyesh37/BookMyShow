package com.bookMyshow.Book.My.Show.service;

import com.bookMyshow.Book.My.Show.models.Screen;
import com.bookMyshow.Book.My.Show.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

        @Autowired
        ScreenRepository screenRepository;

        public void registerScreen(Screen screen){
            screenRepository.save(screen);
        }


}
