import java.util.*;
class Solution{
public List<Integer> rightSideView(TreeNode root){
List<Integer> r=new ArrayList<>();
if(root==null)return r;
Queue<TreeNode> q=new LinkedList<>();
q.offer(root);
while(!q.isEmpty()){
int s=q.size();
for(int i=0;i<s;i++){
TreeNode n=q.poll();
if(i==s-1)r.add(n.val);
if(n.left!=null)q.offer(n.left);
if(n.right!=null)q.offer(n.right);
}
}
return r;
}
}