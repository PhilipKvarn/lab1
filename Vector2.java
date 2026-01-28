public class Vector2 {
    public double x;
    public double y;

    Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    /***
     * Static method which returns the zero-vector
     * @return returns a Vector2 object of the zero-vector
     */
    static public Vector2 zero(){
        return new Vector2(0, 0);
    }

    /***
     * Adds two doubles onto the vector, one for the x-axis and one for the y-axis
     * @param x Value to be added to the x-axis of this vector
     * @param y Value to be added to the y-axis of this vector
    */
    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    /**
     * Rotates this vector by a angle in degrees.
     * @param rotation the angle, in degrees, which the vector will rotate to.
     */
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
