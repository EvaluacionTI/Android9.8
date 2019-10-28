package pe.bbva.evalua.android4.entidad;

import java.io.Serializable;

public class CEConfirm implements Serializable {

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
    private String referenceBeneficiary;

    private double typeRates;
    private double amountFee;
    private double amountEquivalent;

    private String idTransferBeneficiary;
    private String stateTransfer;


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

    public String getReferenceBeneficiary() {
        return referenceBeneficiary;
    }

    public void setReferenceBeneficiary(String referenceBeneficiary) {
        this.referenceBeneficiary = referenceBeneficiary;
    }

    public double getTypeRates() {
        return typeRates;
    }

    public void setTypeRates(double typeRates) {
        this.typeRates = typeRates;
    }

    public double getAmountFee() {
        return amountFee;
    }

    public void setAmountFee(double amountFee) {
        this.amountFee = amountFee;
    }

    public double getAmountEquivalent() {
        return amountEquivalent;
    }

    public void setAmountEquivalent(double amountEquivalent) {
        this.amountEquivalent = amountEquivalent;
    }

    public String getIdTransferBeneficiary() {
        return idTransferBeneficiary;
    }

    public void setIdTransferBeneficiary(String idTransferBeneficiary) {
        this.idTransferBeneficiary = idTransferBeneficiary;
    }

    public String getStateTransfer() {
        return stateTransfer;
    }

    public void setStateTransfer(String stateTransfer) {
        this.stateTransfer = stateTransfer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CEConfirm{");
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
        sb.append(", referenceBeneficiary='").append(referenceBeneficiary).append('\'');
        sb.append(", typeRates=").append(typeRates);
        sb.append(", amountFee=").append(amountFee);
        sb.append(", amountEquivalent=").append(amountEquivalent);
        sb.append(", idTransferBeneficiary='").append(idTransferBeneficiary).append('\'');
        sb.append(", stateTransfer='").append(stateTransfer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
