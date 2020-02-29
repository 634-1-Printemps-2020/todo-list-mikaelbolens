package domain;

import exception.InvalideDateException;

import java.util.Date;
import java.util.Objects;

public abstract class Tache {
    private String createur;
    private String desctription;
    private Date datePlanifie;
    private Statue statue;
    private Resolution resolution;

    public Tache(String createur, String desctription, Date datePlanifie) throws InvalideDateException {
        checkDate(datePlanifie);
        this.createur = createur;
        this.desctription = desctription;
        this.datePlanifie = datePlanifie;
        this.statue = Statue.open;
    }


    public void setDatePlanifie(Date datePlanifie) throws InvalideDateException {
        checkDate(datePlanifie);
        this.datePlanifie = datePlanifie;

    }

    private void checkDate(Date date) throws InvalideDateException {
        Date ajd = new Date();
        if (date.compareTo(ajd) < 0){
            throw new InvalideDateException();
        }
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public void setStatue(Statue statue) {
        this.statue = statue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tache tache = (Tache) o;
        return Objects.equals(createur, tache.createur) &&
                Objects.equals(desctription, tache.desctription) &&
                Objects.equals(datePlanifie, tache.datePlanifie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createur, desctription, datePlanifie);
    }

    public Date getDatePlanifie() {
        return datePlanifie;
    }

    public Statue getStatue() {
        return statue;
    }
}
