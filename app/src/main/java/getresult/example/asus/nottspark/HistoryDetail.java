package getresult.example.asus.nottspark;



/**
 * Created by ASUS on 10/12/2016.
 */

public class HistoryDetail {

    private String carPlate;
    private String imgID;
    private String time;
    private String date;

    public HistoryDetail() {
    }

    public HistoryDetail(String carPlate, String date, String imgID, String time) {
        this.carPlate = carPlate;
        this.date = date;
        this.imgID = imgID;
        this.time = time;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getimgID() {
        return imgID;
    }

    public void setimgID(String imgID) {
        this.imgID = imgID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
