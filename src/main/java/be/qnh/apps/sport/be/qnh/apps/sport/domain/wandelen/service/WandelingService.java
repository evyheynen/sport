package be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.service;

import be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.repository.WandelingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
public class WandelingService {

    @Autowired
    private WandelingRepository repo;

    @PostConstruct
    public void init() {

        Wandeling wandeling1 = new Wandeling();
        wandeling1.setPlaats("Ardennen");
        wandeling1.setKledij("wandelschoenen");

        Wandeling wandeling2 = new Wandeling();
        wandeling2.setPlaats("Eifel");
        wandeling2.setKledij("Winterjas");

        Wandeling wandeling3 = new Wandeling();
        wandeling3.setPlaats("Strand");
        wandeling3.setKledij("Slippers");

        //wandelingen.addAll(Arrays.asList(wandeling1, wandeling2, wandeling3));
        this.repo.saveAll(Arrays.asList(wandeling1, wandeling2, wandeling3));
    }

    public Iterable<Wandeling> getAll() {
        Iterable<Wandeling> wandelingen = this.repo.findAll();
        return wandelingen;
    }

    public Wandeling findById(long id) {
        Optional<Wandeling> optionalResult = this.repo.findById(id);

        if(optionalResult.isPresent()){
            return optionalResult.get();
        }
        else {
            return null;
        }
    }

    public void deleteById(long id){
        this.repo.deleteById(id);
    }

    public Wandeling createWandeling(Wandeling wandeling){
        return this.repo.save(wandeling);
    }

    public Wandeling updateWandeling(long id, Wandeling wandeling){
        Optional<Wandeling> victem = this.repo.findById(id);
        if(victem.isPresent()){

            //wandeling w= victem.get();

            victem.get().setPlaats(wandeling.getPlaats());
            victem.get().setKledij(wandeling.getKledij());
            return this.repo.save(victem.get());
        }
        else {
            return null;
        }
    }
}
