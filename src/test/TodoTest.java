package test;

import domain.*;
import exception.InvalidTacheException;
import exception.InvalideDateException;
import metier.Todo;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Test (expected = InvalidTacheException.class)
    public void badTache() throws ParseException, InvalideDateException, InvalidTacheException {
        Todo lstTodo = new Todo();

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");

        Tache t = new RdvMedecin("mike", "test", dateD);
        Tache tError = new VisiteParent("error", "Il n'existe pas", dateD);

        lstTodo.addTache(t);

        lstTodo.annulerTache(tError);

    }

    @org.junit.Test
    public void annulerTache() throws ParseException, InvalideDateException, InvalidTacheException {
        Todo lstTodo = new Todo();

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");

        Tache t = new RdvMedecin("mike", "test", dateD);

        lstTodo.addTache(t);

        lstTodo.annulerTache(t);

        Assert.assertEquals(Statue.canceled, t.getStatue());

    }

    @org.junit.Test
    public void replanifierTache() throws ParseException, InvalideDateException, InvalidTacheException {
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

    @Test (expected = InvalideDateException.class)
    public void badDate() throws InvalideDateException, ParseException, InvalidTacheException {
        Todo lstTodo = new Todo();

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");

        Tache t = new RdvMedecin("mike", "test", dateD);

        lstTodo.addTache(t);
        Date dateD2 = dt1.parse("20191102");
        lstTodo.replanifierTache(t, dateD2);
    }

    @org.junit.Test
    public void consulterTache() throws InvalideDateException, ParseException {
        Todo lstTodo = new Todo();
        List<Tache> lstResult;

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");
        Date dateCheck = dt1.parse("20201203");

        Tache t = new RdvMedecin("mike", "test", dateD);
        Tache t2 = new VisiteParent("mike", "test", dateCheck);
        Tache t3 = new Controle634("mike", "test", dateCheck);

        lstTodo.addTache(t);
        lstTodo.addTache(t2);
        lstTodo.addTache(t3);

        lstResult = lstTodo.consulterTache(dateCheck);
        assertFalse(lstResult.contains(t));
        assertTrue(lstResult.contains(t2));
        assertTrue(lstResult.contains(t3));

    }

    @org.junit.Test
    public void testConsulterTache() throws InvalideDateException, ParseException {
        Todo lstTodo = new Todo();
        List<Tache> lstResult;

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");
        Date dateCheck = dt1.parse("20201203");

        Tache t = new RdvMedecin("mike", "test", dateD);
        Tache t2 = new VisiteParent("mike", "test", dateCheck);
        Tache t3 = new Controle634("mike", "test", dateCheck);

        t.setStatue(Statue.closed);

        lstTodo.addTache(t);
        lstTodo.addTache(t2);
        lstTodo.addTache(t3);

        lstResult = lstTodo.consulterTache(Statue.closed);
        assertTrue(lstResult.contains(t));
        assertFalse(lstResult.contains(t2));
        assertFalse(lstResult.contains(t3));
    }

    @org.junit.Test
    public void testConsulterTache1() throws InvalideDateException, ParseException  {
        Todo lstTodo = new Todo();
        List<Tache> lstResult;

        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        Date dateD = dt1.parse("20201102");
        Date dateCheck = dt1.parse("20201203");

        Tache t = new RdvMedecin("mike", "test", dateD);
        Tache t2 = new VisiteParent("mike", "test", dateCheck);
        Tache t3 = new Controle634("mike", "test", dateCheck);


        lstTodo.addTache(t);
        lstTodo.addTache(t2);
        lstTodo.addTache(t3);

        lstResult = lstTodo.consulterTache();
        assertTrue(lstResult.contains(t));
        assertTrue(lstResult.contains(t2));
        assertTrue(lstResult.contains(t3));
    }
}