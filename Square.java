public class Square implements Measurable, Comparable<Square>{
    private int side;
    public Square(int side){
        this.side = side;
    }
    @Override
    public double getPerimeter(){
        return 4 *side;
    }
    @Override
    public double getArea(){
        return Math.pow(side, 2);
    }
    @Override
    public int compareTo(Square other){
        return Integer.compare(this.side, other.side);
    }
}