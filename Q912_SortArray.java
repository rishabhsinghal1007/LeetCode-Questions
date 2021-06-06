// By QuickSort.........

class Solution {
    public Random rand = new Random();

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int segregate(int[] arr, int pivotIdx, int sp, int ep) {
        swap(arr, pivotIdx, ep);

        int itr = sp;
        int p = sp - 1;

        while (itr <= ep) {
            if (arr[itr] <= arr[ep]) {
                swap(arr, ++p, itr);
            }
            itr++;
        }
        return p;
    }

    public void quickSort(int[] arr, int si, int ei) {
        if (si > ei)
            return;

        // int pivotIdx = (si + ei) / 2;
        int pivotIdx = rand.nextInt(ei - si + 1) + si;
        pivotIdx = segregate(arr, pivotIdx, si, ei);

        boolean flag = true;
        for (int i = si + 1; i <= ei; i++)
            if (arr[i - 1] > arr[i]) {
                flag = false;
                break;
            }

        if (flag)
            return;

        quickSort(arr, si, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, ei);

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}