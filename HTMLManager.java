import java.util.*;

public class HTMLManager {
   private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> html) {
      if(html == null) {
         throw new IllegalArgumentException("HTML queue annot be empty null");
      }
      
      tags = new LinkedList<>();
      while(!html.isEmpty()) {
         tags.add(html.remove());
      }
   }
   
   public Queue<HTMLTag> getTags() {
      return tags;
   }
   
   public String toString() {
      String html = "";
      int size = tags.size();
      for(int i = 0; i < size; i++) {
         HTMLTag element = tags.remove();
         html += element.toString();
         tags.add(element);
      }
      return html;
   }
   
}
