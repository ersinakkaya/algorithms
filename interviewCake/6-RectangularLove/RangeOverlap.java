package com.pramp.interviews;

public class Rectangle {

    // coordinates of bottom left corner
    Integer leftX;
    Integer bottomY;

    // dimensions
    Integer width;
    Integer height;

    public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width  = width;
        this.height = height;
    }
    
    public Rectangle(){
        this.leftX = 0;
        this.bottomY = 0;
        this.width = 0;
        this.height = 0;
    }
    
    public class RangeOverlap {

        Integer startPoint;
        Integer length;

        public RangeOverlap(Integer startPoint, Integer length) {
            this.startPoint = startPoint;
            this.length = length;
        }
    }
    
    public RangeOverlap findRangeOverlap(int point1, int length1, int point2, int length2) {

        int highestStartPoint = Math.max(point1, point2);
        int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

        // return null overlap if there is no overlap
        if (highestStartPoint >= lowestEndPoint) {
            return new RangeOverlap(null, null);
        }

        // compute the overlap length
        int overlapLength = lowestEndPoint - highestStartPoint;

        return new RangeOverlap(highestStartPoint, overlapLength);
    }
    
    
    public Rectangle findRectangularOverlap(Rectangle r1, Rectangle r2) {

        // get the x and y overlap points and lengths
        RangeOverlap xOverlap = findRangeOverlap(r1.leftX, r1.width, r2.leftX, r2.width);
        RangeOverlap yOverlap = findRangeOverlap(r1.bottomY, r1.height, r2.bottomY, r2.height);

        // return null rectangle if there is no overlap
        if (xOverlap.length == null || yOverlap.length == null) {
            return new Rectangle();
        }

        return new Rectangle(
            xOverlap.startPoint,
            yOverlap.startPoint,
            xOverlap.length,
            yOverlap.length
        );
    }
    

    public String toString() {
        return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
    }
    
    public static void main(String[] args){
        Rectangle r1 = new Rectangle(0, 0, 8, 4);
        Rectangle r2 = new Rectangle(6, 2, 4, 8);
        Rectangle resp = r1.findRectangularOverlap(r1, r2);
        System.out.println(resp.toString());
    }
}

//Runtime Complexity O(1)
//Space Complexity O(1)