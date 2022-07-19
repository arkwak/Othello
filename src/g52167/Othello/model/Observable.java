
package g52167.Othello.model;



/**
 *
 * @author Laurent
 */
public interface Observable {

   public void registerObservers(Observer obs);
   
   public void removeObserver(Observer obs);
   
   public void notifyObservers();

   
   
   
}
