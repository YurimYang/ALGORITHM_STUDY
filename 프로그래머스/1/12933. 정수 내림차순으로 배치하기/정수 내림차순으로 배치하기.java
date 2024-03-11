class Solution {
    public void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    //버블정렬
    public long solution(long n) {
        String answer = "";
        String number = Long.toString(n);
        int[] arr = new int[number.length()];
        for(int i = 0; i< arr.length; i++){
            arr[i] = number.charAt(i) - '0';
        }
        for(int i = 0; i<arr.length -1; i++){
            for(int j = 0; j<arr.length - i - 1; j++){
                if(arr[j] < arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
        for(int i = 0; i<arr.length; i++){
            answer += arr[i];
        }
        return Long.parseLong(answer);
    }
}

    
  