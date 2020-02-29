package domain;

import exception.InvalideDateException;

import java.util.Date;

public class VisiteParent extends Tache {
    public VisiteParent(String createur, String desctription, Date datePlanifie) throws InvalideDateException {
        super(createur, desctription, datePlanifie);
    }
}
