package pe.bbva.evalua.android4.entidad;

import android.text.Editable;

import java.io.Serializable;

public class CESimulation implements Serializable {
    //Simulacion
    private Long idTransfer;
    private String nameOrigin;
    private String numberAccountOrigin;
    private String moneyAccountOrigin;
    private double amountOrigin;
    private String dateCurrent;

    private String referenceOrigin;

    private String nameBeneficiary;
    private String numberAccountBeneficiary;
    private String moneyAccountBeneficiary;


    public Long getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(Long idTransfer) {
        this.idTransfer = idTransfer;
    }

    public String getNameOrigin() {
        return nameOrigin;
    }

    public void setNameOrigin(String nameOrigin) {
        this.nameOrigin = nameOrigin;
    }

    public String getNumberAccountOrigin() {
        return numberAccountOrigin;
    }

    public void setNumberAccountOrigin(String numberAccountOrigin) {
        this.numberAccountOrigin = numberAccountOrigin;
    }

    public String getMoneyAccountOrigin() {
        return moneyAccountOrigin;
    }

    public void setMoneyAccountOrigin(String moneyAccountOrigin) {
        this.moneyAccountOrigin = moneyAccountOrigin;
    }

    public double getAmountOrigin() {
        return amountOrigin;
    }

    public void setAmountOrigin(double amountOrigin) {
        this.amountOrigin = amountOrigin;
    }

    public String getDateCurrent() {
        return dateCurrent;
    }

    public void setDateCurrent(String dateCurrent) {
        this.dateCurrent = dateCurrent;
    }

    public String getReferenceOrigin() {
        return referenceOrigin;
    }

    public void setReferenceOrigin(String referenceOrigin) {
        this.referenceOrigin = referenceOrigin;
    }

    public String getNameBeneficiary() {
        return nameBeneficiary;
    }

    public void setNameBeneficiary(String nameBeneficiary) {
        this.nameBeneficiary = nameBeneficiary;
    }

    public String getNumberAccountBeneficiary() {
        return numberAccountBeneficiary;
    }

    public void setNumberAccountBeneficiary(String numberAccountBeneficiary) {
        this.numberAccountBeneficiary = numberAccountBeneficiary;
    }

    public String getMoneyAccountBeneficiary() {
        return moneyAccountBeneficiary;
    }

    public void setMoneyAccountBeneficiary(String moneyAccountBeneficiary) {
        this.moneyAccountBeneficiary = moneyAccountBeneficiary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CESimulation{");
        sb.append("idTransfer=").append(idTransfer);
        sb.append(", nameOrigin='").append(nameOrigin).append('\'');
        sb.append(", numberAccountOrigin='").append(numberAccountOrigin).append('\'');
        sb.append(", moneyAccountOrigin='").append(moneyAccountOrigin).append('\'');
        sb.append(", amountOrigin=").append(amountOrigin);
        sb.append(", dateCurrent='").append(dateCurrent).append('\'');
        sb.append(", referenceOrigin='").append(referenceOrigin).append('\'');
        sb.append(", nameBeneficiary='").append(nameBeneficiary).append('\'');
        sb.append(", numberAccountBeneficiary='").append(numberAccountBeneficiary).append('\'');
        sb.append(", moneyAccountBeneficiary='").append(moneyAccountBeneficiary).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
