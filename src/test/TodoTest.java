package test;

import domain.*;
import exception.InvalideDateException;
import metier.Todo;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TodoTest {

    @org.junit.Test
    public void addTache() throws InvalideDateException, ParseException {
        Todo lstTodo = new Todo();

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");

        Tache t = new RdvMedecin("mike", "test", dateD);
        Tache t2 = new VisiteParent("mike", "test", dateD);
        Tache t3 = new Controle634("mike", "test", dateD);

        lstTodo.addTache(t);
        lstTodo.addTache(t2);
        lstTodo.addTache(t3);

    }

    @org.junit.Test
    public void annulerTache() throws ParseException, InvalideDateException {
        Todo lstTodo = new Todo();

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");

        Tache t = new RdvMedecin("mike", "test", dateD);

        lstTodo.addTache(t);

        lstTodo.annulerTache(t);

        Assert.assertEquals(Statue.canceled, t.getStatue());

    }

    @org.junit.Test
    public void replanifierTache() throws ParseException, InvalideDateException {
        Todo lstTodo = new Todo();

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");

        Tache t = new RdvMedecin("mike", "test", dateD);

        lstTodo.addTache(t);

        SimpleDateFormat dt2 = new SimpleDateFormat("yyyyMMdd");
        Date dateD2 = dt1.parse("20211102");

        lstTodo.replanifierTache(t, dateD2);

        Assert.assertEquals(dateD2, t.getDatePlanifie());

    }

    @Test
    public void badDate() throws InvalideDateException {
        Todo lstTodo = new Todo();

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = null;
        Date dateD2 = null;
        try {
            dateD = dt1.parse("20201102");
            dateD2 = dt1.parse("20191102");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Tache t = new RdvMedecin("mike", "test", dateD);

        lstTodo.addTache(t);

        lstTodo.replanifierTache(t, dateD2);
    }

    @org.junit.Test
    public void consulterTache() {
    }

    @org.junit.Test
    public void testConsulterTache() {
    }

    @org.junit.Test
    public void testConsulterTache1() {
    }
}