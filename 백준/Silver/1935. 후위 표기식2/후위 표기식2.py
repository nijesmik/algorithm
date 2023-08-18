def f(s, x):
    a = s.pop()
    b = s.pop()
    return eval(f'b{x}a')

k,l,*n = open(0)
s = []
for c in l[:-1]: s.append(int(n[ord(c)-65]) if c.isalpha() else f(s,c))
print(f'{s[0]:0.2f}')