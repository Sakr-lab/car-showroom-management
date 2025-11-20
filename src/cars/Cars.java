package cars;

public class Cars {

    private String name,color;
    private int releaseDate,price,maxSpeed,engineCapacity,id;
    private float discount,final_price;
    private static int ID=0;

    public Cars(String n,String c,int r,int p,int ms,int ec){
        this.name=n;this.color=c;
        this.releaseDate=r;this.price=p;this.maxSpeed=ms;
        this.engineCapacity=ec;this.id=ID++;
    }

    public Cars(Cars obj,float discount){
        this.name=obj.name;this.color=obj.color;
        this.releaseDate=obj.releaseDate;this.price=obj.price;this.maxSpeed=obj.maxSpeed;
        this.engineCapacity=obj.engineCapacity;this.id=obj.id;
        this.discount=discount;
        this.final_price=this.price*(1f-(this.discount/100f));
    }

    public float getFinal_price() {
        return final_price;
    }

    public float getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toStringCars() {
        return "Name : '" + name + System.lineSeparator() +
                ", Release Date : " + releaseDate + System.lineSeparator() +
                ", Color : '" + color + System.lineSeparator() +
                ", engineCapacity : " + engineCapacity + System.lineSeparator() +
                ", maxSpeed : " + maxSpeed + System.lineSeparator() +
                ", price : " + price + System.lineSeparator() +
                ", id : " + id ;
    }
    public String toStringSellCars() {
        return "Name : '" + this.name + System.lineSeparator() +
                " Release Date : " + this.releaseDate + System.lineSeparator() +
                " Color : '" + this.color + System.lineSeparator() +
                " Engine Capacity : " + this.engineCapacity + System.lineSeparator() +
                " Max Speed : " + this.maxSpeed + System.lineSeparator() +
                " Price : " + this.price + System.lineSeparator() +
                " Discount : "+ this.discount+ System.lineSeparator() +
                " Final Price : "+ this.final_price+ System.lineSeparator()+
                " Id : " + this.id ;
    }
}
