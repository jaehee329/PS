a=list(input())
for i in range(len(a)):
    if a[i].isupper():
        if ord(a[i])+13>90:
            a[i]=chr(ord(a[i])+13-26)
        else:
            a[i]=chr(ord(a[i])+13)
    if a[i].islower():
        if ord(a[i])+13>122:
            a[i]=chr(ord(a[i])+13-26)
        else:
            a[i]=chr(ord(a[i])+13)
print(''.join(a))