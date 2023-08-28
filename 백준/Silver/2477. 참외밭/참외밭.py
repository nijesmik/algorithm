t=['31314231314','42423142423','23231423231','14142314142']
k,*l,=map(int,open(0).read().split())
x=l[0::2]; y=l[1::2]
for i in range(4):
  if ''.join(map(str,x)) in t[i]:
    ind=x.index(i+1)
    if x[ind]==x[ind+2]:
      s=y[ind]*y[ind+1]
    else:
      s=y[-1]*y[(ind==0)*4]
b=max(y[0::2])*max(y[1::2])
print((b-s)*k)