package metier;

import domain.*;
import exception.InvalidTacheException;
import exception.InvalideDateException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Todo {
    List<Tache> listDeTache;

    public Todo() {
        this.listDeTache = new ArrayList<>();
    }



    public void addTache(Tache tache){
        listDeTache.add(tache);
    }

    public void annulerTache(Tache tache) throws InvalidTacheException {
        Tache t = listDeTache.get(getIndex(tache));
        t.setStatue(Statue.canceled);
    }

    public void replanifierTache(Tache tache, Date d) throws InvalidTacheException, InvalideDateException {
        Tache t = listDeTache.get(getIndex(tache));
        t.setDatePlanifie(d);
    }

    public List<Tache> consulterTache(Statue statue){
        List<Tache> lst = new ArrayList<>();
        for (Tache t: listDeTache){
            if (t.getStatue().equals(statue)){
                lst.add(t);
            }
        }
        return lst;
    }

    public List<Tache> consulterTache(Date d){
        List<Tache> lst = new ArrayList<>();
        for (Tache t: listDeTache){
            if (t.getDatePlanifie().equals(d)){
                lst.add(t);
            }
        }
        return lst;
    }

    public List<Tache> consulterTache(){
        return listDeTache;
    }

    private int getIndex(Tache tache) throws InvalidTacheException {
        int index = listDeTache.indexOf(tache);
        if (index != -1){
            return index;
        }
        else {
            throw new InvalidTacheException();
        }
    }


}
