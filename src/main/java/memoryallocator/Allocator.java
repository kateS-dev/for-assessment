package memoryallocator;

class Allocator {
    private int[] memory;


    public Allocator(int n) {
        memory = new int[n];
    }

    public int allocate(int size, int mID) {
        for(int i = 0; i <= memory.length-size; i++) {
           if (memory[i] == 0) {
               // check available
               boolean hasSpace = true;
               for(int j = 0; j < size; j++) {
                   if (memory[i+j] != 0) {
                       hasSpace = false;
                       break;
                   }
               }

               if (hasSpace) {
                   for (int k = 0; k < size; k++) {
                       memory[i+k] = mID;
                   }

                   // return start index
                   return i;
               }
           }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int total = 0;
        for(int i = 0; i < memory.length; i++) {
            if(memory[i] == mID) {
                memory[i] = 0;
                total++;
            }
        }
        return total;
    }
}

