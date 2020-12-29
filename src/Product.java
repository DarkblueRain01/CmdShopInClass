public class Product {
   private String PID;
   private String Pname;
   private String Price;
   private String intro;

   public String getPID() {
      return PID;
   }

   public void setPID(String PID) {
      this.PID = PID;
   }

   public String getPname() {
      return Pname;
   }

   public void setPname(String pname) {
      Pname = pname;
   }

   public String getPrice() {
      return Price;
   }

   public void setPrice(String price) {
      Price = price;
   }

   public String getIntro() {
      return intro;
   }

   public void setIntro(String intro) {
      this.intro = intro;
   }
}
