package domain;

import exception.InvalideDateException;

import java.util.Date;

public class RdvMedecin extends Tache {
    public RdvMedecin(String createur, String desctription, Date datePlanifie) throws InvalideDateException {
        super(createur, desctription, datePlanifie);
    }
}
