package pe.bbva.evalua.android4.entidad;

import android.widget.EditText;

public class CETransfer {

    private String targetNumberTransfer;
    private String targetDateTransfer;
    private String targetHourTransfer;
    private String targetMoneyTransfer;



    private String targetAmountTransfer;
    private String targetReferenceTransfer;

    public String getTargetNumberTransfer() {
        return targetNumberTransfer;
    }

    public void setTargetNumberTransfer(String targetNumberTransfer) {
        this.targetNumberTransfer = targetNumberTransfer;
    }

    public String getTargetDateTransfer() {
        return targetDateTransfer;
    }

    public void setTargetDateTransfer(String targetDateTransfer) {
        this.targetDateTransfer = targetDateTransfer;
    }

    public String getTargetHourTransfer() {
        return targetHourTransfer;
    }

    public void setTargetHourTransfer(String targetHourTransfer) {
        this.targetHourTransfer = targetHourTransfer;
    }

    public String getTargetMoneyTransfer() {
        return targetMoneyTransfer;
    }

    public void setTargetMoneyTransfer(String targetMoneyTransfer) {
        this.targetMoneyTransfer = targetMoneyTransfer;
    }

    public String getTargetAmountTransfer() {
        return targetAmountTransfer;
    }

    public void setTargetAmountTransfer(String targetAmountTransfer) {
        this.targetAmountTransfer = targetAmountTransfer;
    }

    public String getTargetReferenceTransfer() {
        return targetReferenceTransfer;
    }

    public void setTargetReferenceTransfer(String targetReferenceTransfer) {
        this.targetReferenceTransfer = targetReferenceTransfer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CETransfer{");
        sb.append("targetNumberTransfer='").append(targetNumberTransfer).append('\'');
        sb.append(", targetDateTransfer='").append(targetDateTransfer).append('\'');
        sb.append(", targetHourTransfer='").append(targetHourTransfer).append('\'');
        sb.append(", targetMoneyTransfer='").append(targetMoneyTransfer).append('\'');
        sb.append(", targetAmountTransfer='").append(targetAmountTransfer).append('\'');
        sb.append(", targetReferenceTransfer='").append(targetReferenceTransfer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
