public class Candle {
	
   private int height;
   private int width;
   private float price;
   private boolean isLitorNot;

public Candle(int height, int width, float price) {
       this.height = height;
       this.width = width;
       this.price = price;
       this.isLitorNot = false;
   }

   public int getHeight() {
       return height;
   }

   public void setHeight(int height) {
       this.height = height;
   }

   public int getWidth() {
       return width;
   }

   public void setWidth(int width) {
       this.width = width;
   }

   public float getPrice() {
       return price;
   }

   public void setPrice(float price) {
       this.price = price;
   }

   public boolean isLit() {
       return isLitorNot;
   }

   public void setLit(boolean isLitorNot) {
       this.isLitorNot = isLitorNot;
   }

   public String toString() {
       return this.height + "," + this.width + "," + this.price ;
   }

}
