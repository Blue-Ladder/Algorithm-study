import java.util.*;

class Solution {
    HashSet<Integer> NumSet = new HashSet<>();
    
    public int solution(String numbers) {
        int N = numbers.length();
        int[] map = new int[N];
        boolean[] visited = new boolean[N];
        int answer = 0;
        
        for(int i=0; i < N; i++){
            map[i] = numbers.charAt(i) - '0';
        }
        dfs(0,map,visited);
            
        for(int n : NumSet) if(isPrime(n)) answer++;
        
        return answer;
        
    }
    public void dfs(int cur, int[] map, boolean[] visited){
        if(cur > 0) NumSet.add(cur);
        
        for (int i = 0; i < map.length; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(cur*10 + map[i], map, visited);
                visited[i] = false;
            } 
        }
    }
    
    public boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0) return false;

        for(int i = 3; i*i <= num ; i+=2){
            if(num % i == 0) return false;
        }
        return true;

    }
    
}
        
