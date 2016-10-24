package com.pramp.interviews;

class LargestSmaller {
   
   public static int largestSmaller(TreeNode root, int x){
      int result = 0;

      while(root != null){
         if(root.value < x){
            result = root.value;
            root = root.right;
         }
         else{
            root = root.left;
         }
      }
      
      return result;
   }

   class TreeNode{
      int value;
      TreeNode left;
      TreeNode right;

      public TreeNode(int data){
         this.value = data;
         this.left = null;
         this.right = null;
      }
   }
   
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      //{2, 3, 4, 7, 17, 19, 21, 35, 89}
      System.out.println(pramp);
   }
}

//Runtime O(log n) if the is balanced
//Runtime O(n)
//Space complexity O(1)