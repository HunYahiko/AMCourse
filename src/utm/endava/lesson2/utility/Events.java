package utm.endava.lesson2.utility;

import utm.endava.lesson2.Model.GameEvent;
import utm.endava.lesson2.Model.Goal;
import utm.endava.lesson2.Model.Possession;

import java.util.function.Supplier;

public enum Events {
    GOAL(0) {
        @Override
        public GameEvent createInstance() {
            return new Goal();
        }
    }, POSSESSION(1) {
        @Override
        public GameEvent createInstance() {
            return new Possession();
        }
    };
    
    private int id;
    
    private Events(int id) {
        this.id = id;
    }
    
    public static Events getById(int id) {
        for (Events event : values()) {
            if (event.id == id) return event;
        }
        return GOAL;
    }
    
    public abstract GameEvent createInstance();
}
