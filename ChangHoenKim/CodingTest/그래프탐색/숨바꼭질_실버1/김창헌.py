from collections import deque


def bfs(s):
  q = deque()
  q.append(s)
  arr[s] = 0
  while q:
    x = q.popleft()
    if x == k:
      return arr[x]

    for nx in (x + 1, x - 1, x * 2):
      if 0 <= nx < 100001 and arr[nx] == -1:
        arr[nx] = arr[x] + 1
        q.append(nx)


n, k = map(int, input().split())
arr = [-1] * 100001
print(bfs(n))
