public class drone {
    private long id;
    private String name;
    private int speed;
    private float roll;
    private float pitch;
    private float yaw;
    private float yCoord;
    private float xCoord;
    private int batteryCharge;
    private String lastActiveDate;
    private boolean status;

    public drone(){

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
    public float getRoll(){
        return roll;
    }
    public void setRoll(float roll){
        this.roll = roll;
    }
    public float getPitch(){
        return pitch;
    }
    public void setPitch(float pitch){
        this.pitch = pitch;
    }
    public float getYaw(){
        return yaw;
    }
    public void setYaw(float yaw){
        this.yaw = yaw;
    }
    public float getYCoord(){
        return yCoord;
    }
    public void setYCoord(float yCoord){
        this.yCoord = yCoord;
    }
    public float getXCoord(){
        return xCoord;
    }
    public void setXCoord(float xCoord){
        this.xCoord = xCoord;
    }
    public int getBatteryCharge(){
        return batteryCharge;
    }
}
