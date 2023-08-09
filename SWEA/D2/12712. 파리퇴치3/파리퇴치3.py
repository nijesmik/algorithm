r = range
def spray1(x,y,m,n):
    s = -b[x][y]
    for i in r(x-m+1,x+m): s += b[i][y] if 0<=i<n else 0
    for i in r(y-m+1,y+m): s += b[x][i] if 0<=i<n else 0
    return s

def spray2(x,y,m,n):
    s = -b[x][y]
    for i,j in zip(r(x-m+1,x+m),r(y-m+1,y+m)):
        s += b[i][j] if 0<=i<n and 0<=j<n else 0
    for i,j in zip(r(x-m+1,x+m),r(y+m-1,y-m,-1)):
        s += b[i][j] if 0<=i<n and 0<=j<n else 0
    return s

f = lambda : map(int,input().split())
for t in r(int(input())):
    n,m = f()
    s = 0
    b = [[*f()] for _ in r(n)]
    for i in r(n):
        for j in r(n):
            s = max(spray1(i,j,m,n), spray2(i,j,m,n), s)
    print(f'#{t+1}',s)