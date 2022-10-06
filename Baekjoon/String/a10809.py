s=input()
a=[-1]*26
for i in range(len(s)):
    if(a[ord(s[i])-97]==-1):
        a[ord(s[i])-97]=i
for i in a:
    print(i, end=" ")