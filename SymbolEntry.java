public class SymbolEntry extends Object{

   public static final int NONE = 0;
   public static final int PARAM = 1;
   public static final int TYPE = 2;
   public static final int VAR = 3;

   private String name;
   public int role;

   public SymbolEntry(String id){
      name = id;
      role = NONE;
   }

   public String toString(int role_flag)
   {
         return "Name: " + name + "\n" + "Role: " + roleToString();
   }

   private String roleToString(){
      String s = "";
      switch (role){
         case NONE:  s = "None";      break;
         case PARAM: s = "PARAMETER"; break;
         case TYPE:  s = "TYPE";      break;
         case VAR:   s = "VARIABLE";  break;
         default:    s = "None";
      }
      return s;
   }

}