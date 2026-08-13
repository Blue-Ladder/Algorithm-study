class Solution {
    // 최대 노드 수 설정 (전화번호 최대 100만 개 * 길이 20)
    // 실제로는 접두어가 겹치기 때문에 200만 ~ 500만 정도면 충분합니다.
    // 메모리 제한에 맞춰 조절 가능합니다.
    static final int MAX_NODES = 2000000; 
    
    // nxt[현재 노드 번호][다음 숫자(0~9)] = 다음 노드 번호
    static int[][] nxt = new int[MAX_NODES][10];
    static boolean[] end = new boolean[MAX_NODES];
    static boolean[] visited = new boolean[MAX_NODES];
    
    public boolean solution(String[] phone_book) {
        int unused = 1; // 0번은 루트로 사용하므로, 새 노드는 1번부터 할당
        
        for (String phone : phone_book) {
            int cur = 0; // 항상 루트(0번 노드)에서 시작
            
            for (int i = 0; i < phone.length(); i++) {
                int num = phone.charAt(i) - '0';
                
                // 1. 해당 노드가 비었으면 새로 생성 (새 인덱스 할당)
                if (nxt[cur][num] == 0) {
                    nxt[cur][num] = unused++;
                }
                
                // 2. 내가 방문할 노드가 누군가의 끝 노드면 false
                if (end[nxt[cur][num]]) {
                    return false;
                }
                
                // 3. 현재 노드를 방문 상태로 변경하고, 다음 노드로 이동
                visited[cur] = true;
                cur = nxt[cur][num];
            }
            
            // 4. 반복문이 끝나고 나의 가장 마지막 노드가 누군가 지나갔던 노드면 false
            if (visited[cur]) {
                return false;
            }
            
            // 5. 현재 노드가 내 번호의 끝임을 표시
            end[cur] = true;
        }
        
        return true;
    }
}
