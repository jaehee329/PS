import sys

while True:
    l = sys.stdin.readline().rstrip("\n")
    ans=[0]*4
    if not l:
        break
    for i in l:
        if i.islower():
            ans[0] += 1
        elif i.isupper():
            ans[1] += 1
        elif i.isdigit():
            ans[2] += 1
        elif i.isspace():
            ans[3] += 1
    sys.stdout.write("{} {} {} {}\n".format(ans[0],ans[1],ans[2],ans[3]))


