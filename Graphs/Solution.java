//Solution for Rotten Oranges in java
import java.util.*;
class Solution {
    record State(int x, int y, int time){}
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
       Queue<State> q=new LinkedList<>();
       boolean vis[][]=new boolean[m][n];
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==2){
                q.add(new State(i,j,0));
                vis[i][j]=true;
            }
        }
       }
        
       
       while(!q.isEmpty()){
        State curr=q.remove();
        int i=curr.x();
        int j=curr.y();
        int val=curr.time();
        ans=Math.max(ans,val);
        //up
        if(i-1>=0 && !vis[i-1][j] && grid[i-1][j]==1){
            vis[i-1][j]=true;
            grid[i-1][j]=2;
            q.add(new State(i-1,j,val+1));
        }
        //right
        if(j+1<n && !vis[i][j+1] && grid[i][j+1]==1){
            vis[i][j+1]=true;
            grid[i][j+1]=2;
            q.add(new State(i,j+1,val+1));
        }
        //down
        if(i+1<m && !vis[i+1][j] && grid[i+1][j]==1){
            vis[i+1][j]=true;
            grid[i+1][j]=2;
            q.add(new State(i+1,j,val+1));
        }
        //left
        if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]==1){
            vis[i][j-1]=true;
            grid[i][j-1]=2;
            q.add(new State(1,j-1,val+1));
        }

       }
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                return -1;
            }
        }

       }
        
       
       return ans;

    }
    
}
