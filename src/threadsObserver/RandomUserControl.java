package threadsObserver;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends Thread {

    RandomUser random;
    List<IObserver> creeps = new ArrayList();


    public void addCreep(IObserver creep) {
        this.creeps.add(creep);
    }

    @Override
    public void run() {
        random = fetchRandomUser();
        for (IObserver creep : creeps) {
            creep.dataReader(random);
        }
    }
    
    
    public RandomUser fetchRandomUser() {
        RandomUser user = null;
        try {
            user = RandomUserGenerator.getRandomUser();
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
