package candycrush;

/* takeways:
 1. Math.abs when marking — using -Math.abs(x) always produces negative regardless of current sign, so marking is idempotent
  (won't un-negate already-marked cells)
 2. Gravity scan direction — must go bottom-to-top within each column to preserve relative order of survivors. Column order
  doesn't matter since columns are independent.
 3. Why -val works — val = Math.abs(board[i][j]) so -val is always the negated absolute value, even if the cell was already
  negative.


The common thread: always think about what happens when a cell is already in a modified state (already negative, already zero).
That's usually where these subtle bugs hide.
*/

class Solution {
    // Steps 1 & 2: scan board and mark candies to crush by negating their value.
    // Returns true if any candies were marked.
    private boolean scanCandy(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean crushed = false;

        // scan horizontal: check every run of 3 in a row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int val = Math.abs(board[i][j]); // get the absolute value here
                if (val != 0 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                    board[i][j]     = -val;
                    board[i][j + 1] = -val;
                    board[i][j + 2] = -val;
                    crushed = true;
                }
            }
        }

        // scan vertical: check every run of 3 in a column
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows - 2; i++) {
                int val = Math.abs(board[i][j]); // get the absolute value here
                if (val != 0 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                    board[i][j]     = -val;
                    board[i + 1][j] = -val;
                    board[i + 2][j] = -val;
                    crushed = true;
                }
            }
        }

        return crushed;
    }

    // Step 3: zero out all marked (negative) cells
    private void crush(int[][] board) {
        for (int[] row : board) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] < 0) row[j] = 0;
            }
        }
    }

    // Step 4: gravity — in each column, slide non-zero values to the bottom
    private void gravity(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int j = 0; j < cols; j++) {
            int bottom = rows - 1;
            for (int i = rows - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[bottom][j] = board[i][j];
                    if (bottom != i) board[i][j] = 0; // handle drop function
                    bottom--;
                }
            }
            // fill the top with zeros
            while (bottom >= 0) {
                board[bottom--][j] = 0;
            }
        }
    }

    public int[][] candyCrush(int[][] board) {
        // Step 5: repeat steps 1-4 until the board is stable
        boolean hasMore = true;
        while (hasMore) {
            hasMore = scanCandy(board); // steps 1 & 2: scan and mark
            if (hasMore) {
                crush(board);           // step 3: remove marked candies
                gravity(board);         // step 4: drop candies down
            }
        }
        return board;
    }
}