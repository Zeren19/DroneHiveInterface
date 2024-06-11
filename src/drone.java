public class drone {
    private long id;
    private String name;
    private int speed;
    private String roll;
    private String pitch;
    private String yaw;
    private String yCoord;
    private String xCoord;
    private int batteryCharge;
    private String lastActiveDate;
    private boolean status;

    public drone(long id, String name, int speed, String roll, String pitch, String yaw, String yCoord, String xCoord, int batteryCharge, String lastActiveDate, boolean status) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.yCoord = yCoord;
        this.xCoord = xCoord;
        this.batteryCharge = batteryCharge;
        this.lastActiveDate = lastActiveDate;
        this.status = status;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public String getRoll(){
        return roll;
    }
    public void setRoll(String roll){
        this.roll = roll;
    }
    public String getPitch(){
        return pitch;
    }
    public void setPitch(String pitch){
        this.pitch = pitch;
    }
    public String getYaw(){
        return yaw;
    }
    public void setYaw(String yaw){
        this.yaw = yaw;
    }
    public String getYCoord(){
        return yCoord;
    }
    public void setYCoord(String yCoord){
        this.yCoord = yCoord;
    }
    public String getXCoord(){
        return xCoord;
    }
    public void setXCoord(String xCoord){
        this.xCoord = xCoord;
    }
    public int getBatteryCharge(){
        return batteryCharge;
    }
}
