import java.util.*;

public class SymbolTable extends Object{

   private int level;
   private Stack<Map<String, SymbolEntry>> stack;
   private static final SymbolEntry EMPTY_SYMBOL = new SymbolEntry("");

   public SymbolTable(){
      reset();
   }

   public void reset(){
      level = -1;
      stack = new Stack<Map<String, SymbolEntry>>();
   }

   public void enterScope(){
      stack.push(new HashMap<String, SymbolEntry>());
      level++;
   }

   public void exitScope(){
      Map<String, SymbolEntry> table = stack.pop();
      level--;
   }

   public class IdentifierDeclaredException extends Exception 
   {
      public IdentifierDeclaredException(String message)
      {
        super(message);
      }
   }

   public class UndeclaredIdentifierException extends Exception 
   {
      public UndeclaredIdentifierException(String message)
      {
        super(message);
      }
   }

   public void enterSymbol(String id){
      Map<String, SymbolEntry> table = stack.peek();

      try
      {
         if (table.containsKey(id))
         {
            throw new IdentifierDeclaredException("identifier already declared in this block");
         }
      }

      catch(IdentifierDeclaredException ex)
      {
         System.out.println(ex.getMessage());
      }

      SymbolEntry s = new SymbolEntry(id);
      table.put(id, s);
   }

   public SymbolEntry findSymbol(String id){
      for (int i = stack.size() - 1; i >= 0; i--)
      {
         Map<String, SymbolEntry> table = stack.get(i);
         SymbolEntry s = table.get(id);
         if (s != null)
             return s;
      }
      try
      {
         throw new UndeclaredIdentifierException("undeclared identifier");
      }
      catch(UndeclaredIdentifierException ex)
      {
         System.out.println(ex.getMessage());
      }
      return EMPTY_SYMBOL;
   }

}