package memoryallocator;

class Main {
    public static void main() {
        // Test input as arrays

//        Explanation
//        Allocator loc = new Allocator(10); // Initialize a memory array of size 10. All memory units are initially free.
//        loc.allocate(1, 1); // The leftmost block's first index is 0. The memory array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
//        loc.allocate(1, 2); // The leftmost block's first index is 1. The memory array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
//        loc.allocate(1, 3); // The leftmost block's first index is 2. The memory array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
//        loc.freeMemory(2); // Free all memory units with mID 2. The memory array becomes [1,_, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
//        loc.allocate(3, 4); // The leftmost block's first index is 3. The memory array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
//        loc.allocate(1, 1); // The leftmost block's first index is 1. The memory array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
//        loc.allocate(1, 1); // The leftmost block's first index is 6. The memory array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
//        loc.freeMemory(1); // Free all memory units with mID 1. The memory array becomes [_,_,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
//        loc.allocate(10, 2); // We can not find any free block with 10 consecutive free memory units, so we return -1.
//        loc.freeMemory(7); // Free all memory units with mID 7. The memory array remains the same since there is no memory unit with mID 7. We return 0.


        String[] commands = {"Allocator", "allocate", "allocate", "allocate", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "allocate", "freeMemory"};

        int[][] arguments = {{10}, {1, 1}, {1, 2}, {1, 3}, {2}, {3, 4}, {1, 1}, {1, 1}, {1}, {10, 2}, {7}};

        Integer[] expectedOutput = {null, 0, 1, 2, 1, 3, 1, 6, 3, -1, 0};
    }
}
