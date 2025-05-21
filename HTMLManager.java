import java.util.*;

public class HTMLManager {
   private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> html) {
      if(html == null) {
         throw new IllegalArgumentException("HTML queue annot be empty null");
      }
      
      Queue<HTMLTag> tags = new LinkedList<>();
      while(!html.isEmpty()) {
         tags.add(html.remove());
      }
   }
   
   public Queue<HTMLTag> getTags() {
      return tags;
   }
   
}
