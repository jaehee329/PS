import sys
a=input()
b=[]
for i in range(len(a)):
    b.append(a[i:])
b.sort()
for i in b:
    sys.stdout.write("%s\n"%i)
