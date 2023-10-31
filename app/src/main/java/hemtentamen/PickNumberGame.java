package hemtentamen;

public class PickNumberGame {
    public static void main(String[] args) {
      int[] list = {4, 1, 3, 2};
      System.out.println("Optimal move is: " + calculateOptimalMove(list, 0, list.length - 1, true));
    }

    private static int calculateOptimalMove(int[] list, int first, int last, boolean isMyTurn) {

        if (first > last) {
            return 0;
        }

        if (isMyTurn) {
            int scoreIfPickFirstNumber = list[first] - calculateOptimalMove(list, first + 1, last, false);
            int scoreIfPickLastNumber = list[last] - calculateOptimalMove(list, first, last - 1, false);

            if (scoreIfPickFirstNumber < scoreIfPickLastNumber) {
                return list[first];
            } else {
                return list[last];
            }



        } else {
            int scoreIfPickFirstNumber = list[first] - calculateOptimalMove(list, first + 1, last, true);
            int scoreIfPickLastNumber = list[last] - calculateOptimalMove(list, first, last - 1, true);

            return Math.max(scoreIfPickFirstNumber, scoreIfPickLastNumber);
        }
    }
}
