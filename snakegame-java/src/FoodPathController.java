import java.util.LinkedList;

public class FoodPathController {

    private SnakeNode curretnFood;

    private LinkedList<SnakeNode> pathToCurrentFood;

    public SnakeNode getCurretnFood() {
        return curretnFood;
    }

    public void setCurretnFood(SnakeNode curretnFood) {
        this.curretnFood = curretnFood;
    }

    public LinkedList<SnakeNode> getPathToCurrentFood() {
        return pathToCurrentFood;
    }

    public void setPathToCurrentFood(LinkedList<SnakeNode> pathToCurrentFood) {
        this.pathToCurrentFood = pathToCurrentFood;
    }



}