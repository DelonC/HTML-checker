import java.util.*;

public class HTMLManager {
   private Queue<HTMLTag> tags;
  //Constructor and checks if the queue is empty or not.
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
   //Changes our tags into a string that can be printed out
   public String toString() {
      String html = "";
      int size = tags.size();
      for(int i = 0; i < size; i++) {
         HTMLTag element = tags.remove();
         html += element.toString().trim();
         tags.add(element);
      }
      return html;
   }
   
   public void fixHTML() {
      Stack<HTMLTag> stack = new Stack<>();
      int size = tags.size();
      //Checking each tag to see if it's opening or closing and adding it to stacks or to the back of our queue
      for(int i = 0; i < size; i++) {
      
         HTMLTag currentTag = tags.remove();
         
         if(currentTag.isOpening()) {
            stack.push(currentTag);
            tags.add(currentTag);
         }
         
         else if (currentTag.isSelfClosing()) {
            tags.add(currentTag);
         }
         else if(stack.isEmpty()) {
            //Checks if the stack is empty.
         }
         //Checks if the current tag is closing and if it matches the opening tag
         else if(currentTag.isClosing() && currentTag.matches(stack.peek()) ) {
            tags.add(currentTag);
            stack.pop();
         }
         else if (currentTag.isClosing() && !currentTag.matches(stack.peek())) {
            tags.add(stack.pop().getMatching());
         }
      }
      while(!stack.isEmpty()) {
         tags.add(stack.pop().getMatching());
      }
   }
   
}
