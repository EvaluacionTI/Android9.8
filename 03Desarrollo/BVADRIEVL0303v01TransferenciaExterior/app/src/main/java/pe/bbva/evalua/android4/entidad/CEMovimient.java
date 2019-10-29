package pe.bbva.evalua.android4.entidad;

import java.io.Serializable;
import java.math.BigDecimal;

public class CEMovimient implements Serializable {

    //First level
    private String idTransfer;
    private String dateMovimient;
    private String stateMovimient;
    private BigDecimal amountEquivalent;

    //Second level
    private String beneficiary;
    private String numberAccountBeneficiary;
    private String referenceBeneficiary;
    private String currencyBeneficiary;
    private BigDecimal typeRace;
    private BigDecimal amountComision;
    private BigDecimal amountTransfer;
    private String currencyCode;


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

    public BigDecimal getAmountEquivalent() {
        return amountEquivalent;
    }

    public void setAmountEquivalent(BigDecimal amountEquivalent) {
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

    public String getCurrencyBeneficiary() {
        return currencyBeneficiary;
    }

    public void setCurrencyBeneficiary(String currencyBeneficiary) {
        this.currencyBeneficiary = currencyBeneficiary;
    }

    public BigDecimal getTypeRace() {
        return typeRace;
    }

    public void setTypeRace(BigDecimal typeRace) {
        this.typeRace = typeRace;
    }

    public BigDecimal getAmountComision() {
        return amountComision;
    }

    public void setAmountComision(BigDecimal amountComision) {
        this.amountComision = amountComision;
    }

    public BigDecimal getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(BigDecimal amountTransfer) {
        this.amountTransfer = amountTransfer;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CEMovimient{");
        sb.append("idTransfer='").append(getIdTransfer()).append('\'');
        sb.append(", dateMovimient='").append(getDateMovimient()).append('\'');
        sb.append(", stateMovimient='").append(getStateMovimient()).append('\'');
        sb.append(", amountEquivalent=").append(getAmountEquivalent());
        sb.append(", beneficiary='").append(getBeneficiary()).append('\'');
        sb.append(", numberAccountBeneficiary='").append(getNumberAccountBeneficiary()).append('\'');
        sb.append(", referenceBeneficiary='").append(getReferenceBeneficiary()).append('\'');
        sb.append(", currencyBeneficiary='").append(getCurrencyBeneficiary()).append('\'');
        sb.append(", typeRace=").append(getTypeRace());
        sb.append(", amountComision=").append(getAmountComision());
        sb.append(", amountTransfer=").append(getAmountTransfer());
        sb.append(", currencyCode='").append(getCurrencyCode()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
