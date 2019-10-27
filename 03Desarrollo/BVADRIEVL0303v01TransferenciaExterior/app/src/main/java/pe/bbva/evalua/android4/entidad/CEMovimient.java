package pe.bbva.evalua.android4.entidad;

import java.io.Serializable;

public class CEMovimient implements Serializable {

    //First level
    private String idTransfer;
    private String dateMovimient;
    private String stateMovimient;
    private String amountEquivalent;

    //Second level
    private String beneficiary;
    private String numberAccountBeneficiary;
    private String referenceBeneficiary;
    private String typeRace;
    private String amountComision;
    private String amountTransfer;


    public String getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(String idTransfer) {
        this.idTransfer = idTransfer;
    }

    public String getDateMovimient() {
        return dateMovimient;
    }

    public void setDateMovimient(String dateMovimient) {
        this.dateMovimient = dateMovimient;
    }

    public String getStateMovimient() {
        return stateMovimient;
    }

    public void setStateMovimient(String stateMovimient) {
        this.stateMovimient = stateMovimient;
    }

    public String getAmountEquivalent() {
        return amountEquivalent;
    }

    public void setAmountEquivalent(String amountEquivalent) {
        this.amountEquivalent = amountEquivalent;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getNumberAccountBeneficiary() {
        return numberAccountBeneficiary;
    }

    public void setNumberAccountBeneficiary(String numberAccountBeneficiary) {
        this.numberAccountBeneficiary = numberAccountBeneficiary;
    }

    public String getReferenceBeneficiary() {
        return referenceBeneficiary;
    }

    public void setReferenceBeneficiary(String referenceBeneficiary) {
        this.referenceBeneficiary = referenceBeneficiary;
    }

    public String getTypeRace() {
        return typeRace;
    }

    public void setTypeRace(String typeRace) {
        this.typeRace = typeRace;
    }

    public String getAmountComision() {
        return amountComision;
    }

    public void setAmountComision(String amountComision) {
        this.amountComision = amountComision;
    }

    public String getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(String amountTransfer) {
        this.amountTransfer = amountTransfer;
    }
}
