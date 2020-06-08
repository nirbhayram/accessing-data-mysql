package com.nirbhayram.org.accessingdatamysql.requestmapping;

public class MedicineRequest {

    private String medicineName;

    private String discription;

    private String reason;

    public MedicineRequest() {
    }

    public MedicineRequest(String medicineName, String discription, String reason) {
        this.medicineName = medicineName;
        this.discription = discription;
        this.reason = reason;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
