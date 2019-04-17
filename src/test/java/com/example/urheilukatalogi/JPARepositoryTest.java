package com.example.urheilukatalogi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.urheilukatalogi.domain.CategoryRepository;
import com.example.urheilukatalogi.domain.SportRepository;
import com.example.urheilukatalogi.domain.UserRepository;
import com.example.urheilukatalogi.model.Sport;
import com.example.urheilukatalogi.model.SportCategory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPARepositoryTest {
    @Autowired
    private CategoryRepository cRepository;
    
    @Autowired
    private SportRepository sRepository;
    
    @Autowired
    private UserRepository uRepository;

    @Test
    public void NewSportAndCategory(){
    	//creating new sport category
        SportCategory Laji = new SportCategory("TestCat");
        cRepository.save(Laji);
    
        //inserting new category
        Sport sport = new Sport("Tiimi kukkahattu", "France", "1", "3", Laji);
        sRepository.save(sport);
        
        //Checking for nulls and that test team is equal to
        assertThat(sport.getId()).isNotNull();
        assertThat(sport.getTeam()).isEqualTo("Tiimi kukkahattu");
    }
    
    @Test
    public void deleteAndFindSport(){
        SportCategory Laji = new SportCategory("TestCat");
        cRepository.save(Laji);
        //delete the new sport that we just added
        Sport sport = new Sport("Team", "Ruotsi", "1", "1", Laji);
        sRepository.save(sport);
        List<Sport> sports = sRepository.findByid((long) 0);
        sRepository.delete(sports.get(0));

        List<Sport> sportTest = sRepository.findByid((long) 0);

        assertThat(sportTest).hasSize(0);

    }
}