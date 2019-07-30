package clase3;
public class GymWalker {
    private Gym gym;

    public GymWalker(Gym gym){
        this.gym = gym;
    }

    public boolean traverse(int row, int col){
        boolean result = false;
        if(gym.validPosition(row,col)){
            gym.tryPosition(row, col);
            if(row == gym.getRows()-1 && col == gym.getcolumns() - 1){
                result = true;
                gym.markPath(row,col);
                return result;
            }
            if(traverse(row - 1, col)){
                result = true;
            }
            if(traverse(row, col - 1)){
                result = true;
            }
            if(traverse(row + 1, col)){
                result = true;
            }
            if(traverse(row, col + 1)){
                result = true;
            }
            if(result){
                gym.markPath(row, col);
            }

        }
        return result;
    }

    public boolean traverseIterative(int row, int col){
        //TODO: Complete me!
        return false;

    }

}
