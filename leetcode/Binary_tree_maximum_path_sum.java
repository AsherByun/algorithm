/*
 * 1.right left�� ���� ���� �κп��� ����
 * 2. �����带 �θ����� �������� �ʴ´ٸ� left,right�� �������θ� ���ߵ�
 * 3. left, right�� ���� �� ���� ������ �� ū���� (�Ѵ� ������� ���Ⱑ ������ ���) ���� ����� ���� ���� ���� ����
 * 4. ���� ��带 �θ����� �����ϸ� left, right �����ʴ� Ž���� �� �������� ���� ������ max���� ��
 * 
 * ���������߸��ؼ� 5��Ʋ��..
 */

class Solution {
    static int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        int temp=0;
        int ltemp=0;
        int rtemp=0;
        if(root.left!=null){
            ltemp=dfs(root.left);
            if(ltemp>0)temp+=ltemp;
        }
        if(root.right!=null){
            rtemp=dfs(root.right);
            if(rtemp>0)temp+=rtemp;
        }
        
        temp+=root.val;
        max=Math.max(max,temp);
        
        return max;
    }
    static int dfs(TreeNode trn){
        int now=0;
        int rnow=0;
        int lnow=0;
        int tnow=trn.val;
        if(trn.left!=null){
            lnow=dfs(trn.left);
            if(lnow<0)lnow=0;
            else tnow+=lnow;
        }
        if(trn.right!=null){
            rnow=dfs(trn.right);
            if(rnow<0)rnow=0;
            else tnow+=rnow;
        }
        now+=trn.val+Math.max(lnow,rnow);
        max=Math.max(tnow,max);
        
        return now;
    }
}

