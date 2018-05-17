package first.example;

import java.io.Serializable;

public class Compte  implements Serializable {
    private String idCostumer;
    private Long numCompte;
    private String typeCompte;
    private String dateTransaction;
    private Long montantTransaction;


    public Compte() {// empty
         }

    public Compte(String idCostumer, Long numCompte, String typeCompte, String dateTransaction, Long montantTransaction) {
        this.idCostumer = idCostumer;
        this.numCompte = numCompte;
        this.typeCompte = typeCompte;
        this.dateTransaction = dateTransaction;
        this.montantTransaction = montantTransaction;
    }

    public String getIdCostumer() {
        return idCostumer;
    }

    public Long getNumCompte() {
        return numCompte;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public Long getMontantTransaction() {
        return montantTransaction;
    }
}
