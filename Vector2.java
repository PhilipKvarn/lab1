public class Vector2 {
    public double x;
    public double y;

    Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    static public Vector2 zero(){
        return new Vector2(0, 0);
    }

    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void rotateByDeg(double rotation){
        double convert = Math.PI/180.00;
        double radian = rotation*convert;
        double cos = Math.cos(radian);
        double sin = Math.sin(radian);
        double nextX = x*cos - y*sin;
        this.y = x*sin + y*cos;
        this.x = nextX;
    }
}
