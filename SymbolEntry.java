public class SymbolEntry extends Object{

   public static final int NONE = 0;
   public static final int CONST = 1;
   public static final int PARAM = 2;
   public static final int PROC = 3;
   public static final int TYPE = 4;
   public static final int VAR = 5;

   private String name;

   public SymbolEntry(String id){
      name = id;
   }

   public String toString(int role_flag)
   {
         return "Name: " + name + "\n";
   }

}